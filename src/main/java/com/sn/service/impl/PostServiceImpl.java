package com.sn.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.common.WebContextHolder;
import com.sn.common.utils.DateTimeUtils;
import com.sn.constants.ApplicationConstants;
import com.sn.constants.ResponseStatus;
import com.sn.dao.CommentDAO;
import com.sn.dao.LikeDAO;
import com.sn.dao.PostDAO;
import com.sn.dao.impl.PostDAOImpl;
import com.sn.entity.Class;
import com.sn.entity.ClassSubjectTeacher;
import com.sn.entity.Comment;
import com.sn.entity.Like;
import com.sn.entity.Post;
import com.sn.quartz.JobScheduler;
import com.sn.service.PostService;
import com.sn.utils.JSONUtils;
import com.sn.vo.CommentsVO;
import com.sn.vo.UserProfileVO;

@Component("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	PostDAO postDAO;
	@Autowired
	CommentDAO commentDAO;
	@Autowired
	JobScheduler jobScheduler;
	@Autowired
	private LikeDAO likeDAO;
	@Override
	public String submitUpdate(String postText, Integer classId, String type) {
		String response = "";
		boolean isSuccess = false;
		try{
			Post post = buildPost(classId, type);
			post.setMessage(postText);
			post.setPostDate(Calendar.getInstance());
			isSuccess = postDAO.insertPost(post);
		}
		catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		if(isSuccess){
			//EmailUtils.sendEmail()
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;
	}

	private Post buildPost(Integer classId, String type) {
		Post post = new Post();
		//		post.setMessage(postText);
		post.setCommentCount(0);
		post.setCreatedDate(Calendar.getInstance());
		post.setLikeCount(0);
		post.setStudent(true);
		post.setTeacher(true);
		post.setParent(true);
		post.setType(type);
		post.setClassId(classId);
		post.setIsScheduled(false);
		//			User createdByUser = new User();
		//			createdByUser.setUid(1);
		post.setUsersByCreatedBy(WebContextHolder.get().getLoggedInUser());
		//			com.sn.entity.Class classes = new Class();
		//			classes.setId(classId);
		//			PostClass postClass = new PostClass();
		//			postClass.setPosts(post);
		//			postClass.setClasses(getClassById(classId));
		//			Set<PostClass> postClasses = new HashSet<>();
		//			postClasses.add(postClass);
		//			post.setPostClasses(postClasses);
		//		if("event".equals(type)){
		//			//todo
		//		}
		//		else if("update".equals(type)){
		//			post.setMessage(postText);
		//		}
		return post;
	}

	private Class getClassById(Integer classId) {
		Class class1 = null;
		List<ClassSubjectTeacher> classSubjectTeachers = WebContextHolder.get().getLoggedInUserProfile().getClasses();
		if(CollectionUtils.isNotEmpty(classSubjectTeachers)){
			for(ClassSubjectTeacher classSubjectTeacher : classSubjectTeachers){
				if(classSubjectTeacher.getClassesByClassId().getId().intValue() == classId.intValue()){
					class1 = classSubjectTeacher.getClassesByClassId();
					break;
				}
			}
		}
		return class1;
	}

	@Override
	public List<Post> getPostsForStudentOrParent(Integer classId) {
		return postDAO.getPostsByClass(classId);
	}

	@Override
	public List<Post> getPostsForTeacher(Integer teacherId, List<Integer> classIds,String postFor) {
		List<Post> posts = null;
		switch(postFor){
		
		case ApplicationConstants.POSTS_FOR_HOME_PAGE : posts =  postDAO.getPostsByUserAndClass(teacherId, classIds);
		break;

		case ApplicationConstants.POSTS_FOR_EVENT_PAGE : posts = postDAO.getEventsByUserAndClass(teacherId, classIds);
		break;
		
		}
		return posts;
	}


	@Override
	public String addLike(Integer postId, Integer likeCount, Integer uid) {
		String response = "";
		Like like = new Like();
		like.setPostId(postId);
		like.setUsersByCreatedBy(WebContextHolder.get().getLoggedInUser());
		like.setCreatedDate(Calendar.getInstance());
		Post post = new Post();
		post.setId(postId);
		post.setLikeCount(likeCount+1);
		if(postId!=uid){
			if(likeDAO.addLike(like) &&	postDAO.updateLikeCount(post))
			{
				response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
			}
			else{
				response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode()+""+"You already appriciated");
			}
			}else{
				response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
			}
		return response;
	}

	@Override
	public String submitComment(Integer postId, String commentText, Integer commentCount, Integer userId) {
		String response = "";
		Comment comment = new Comment();
		comment.setComment(commentText);
		comment.setPostId(postId);
		//		User user = new User();
		//		user.setUid(userId);
		comment.setUsersByCreatedBy(WebContextHolder.get().getLoggedInUser());
		comment.setCreatedDate(Calendar.getInstance());
		Post post = new Post();
		post.setId(postId);
		post.setCommentCount(commentCount+1);
		if(commentDAO.insertComment(comment) &&	postDAO.updateCommentCount(post))
		{
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;
	}

	@Override
	public String schedulePost(String postText, int classId, String type,String date, String time) {

		String response = "";
		boolean isSuccess = false;
		try{
			Post post = buildPost(classId, type);
			post.setMessage(postText);
			post.setIsScheduled(true);
			Calendar scheduledDate = Calendar.getInstance();
			scheduledDate.set(DateTimeUtils.getYear(date), DateTimeUtils.getMonth(date), DateTimeUtils.getDay(date), 
					DateTimeUtils.getHour(time), DateTimeUtils.getMinute(time), 0);
			post.setScheduledDate(scheduledDate);
			isSuccess = postDAO.insertPost(post);
			if(isSuccess){
				jobScheduler.schedule(post);
			}

		}
		catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		if(isSuccess){
			//EmailUtils.sendEmail()
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;
	}

	@Override
	public void submitScheduledPost(Object object) {
		boolean isSuccess = false;
		if(object != null){
			try{
				Post post = (Post) object;
				post.setIsScheduled(false);
				post.setPostDate(Calendar.getInstance());
				isSuccess = new PostDAOImpl().updateIsScheduled(post);
			}
			catch(Exception e){
				e.printStackTrace();
				isSuccess = false;
			}
		}

	}

	@Override
	public List<Post> getScheduledPosts() {
		return postDAO.getScheduledPosts();
	}

	@Override
	public String submitEvent(String title, String desc, String date,
			int classId, String type) {

		String response = "";
		boolean isSuccess = false;
		try{
			Post post = buildPost(classId, type);
			post.setEventTitle(title);
			post.setEventDesc(desc);
			Calendar eventDate = Calendar.getInstance();
			eventDate.set(DateTimeUtils.getYear(date), DateTimeUtils.getMonth(date), DateTimeUtils.getDay(date));
			post.setEventDate(eventDate);
			isSuccess = postDAO.insertPost(post);
		}
		catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		if(isSuccess){
			//EmailUtils.sendEmail()
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;

	}

	@Override
	public String scheduleEvent(String title, int classId, String type, String desc,
			String date, String time) {

		String response = "";
		boolean isSuccess = false;
		try{
			Post post = buildPost(classId, type);
			post.setEventTitle(title);
			post.setEventDesc(desc);
			post.setIsScheduled(true);
			Calendar scheduledDate = Calendar.getInstance();
			scheduledDate.set(DateTimeUtils.getYear(date), DateTimeUtils.getMonth(date), DateTimeUtils.getDay(date), 
					DateTimeUtils.getHour(time), DateTimeUtils.getMinute(time), 0);
			post.setScheduledDate(scheduledDate);
			isSuccess = postDAO.insertPost(post);
			if(isSuccess){
				jobScheduler.schedule(post);
			}

		}
		catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		if(isSuccess){
			//EmailUtils.sendEmail()
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;
	}

	@Override
	public String checkForNotifications() {
		String response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		UserProfileVO userProfile = WebContextHolder.get().getLoggedInUserProfile();
		List<ClassSubjectTeacher> classSubjectTeachers = userProfile.getClasses();
		List<Integer> classIds = new ArrayList<Integer>();
		if(classSubjectTeachers!=null){
			for(ClassSubjectTeacher classObj : userProfile.getClasses()){
				classIds.add(classObj.getClassesByClassId().getId());
			}
			List<Post> posts = postDAO.getPostsForNotification(userProfile.getUser().getUid(), classIds,userProfile.getUser().getLastLogOutTime());
			if(posts !=null && CollectionUtils.isNotEmpty(posts)){
				response = JSONUtils.getSuccessJSONResponse(posts.size()+"");
			}
		}
		return response;
	}

	@Override
	public List<Post> getPostsForPrincipal() {
		return postDAO.getAllPosts();
	}
	
	@Override
	public List<CommentsVO> showComments(Integer postId) {
		// TODO Auto-generated method stub
		return postDAO.getAllComments(postId);
	}
}
