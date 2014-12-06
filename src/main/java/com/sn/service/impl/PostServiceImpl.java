package com.sn.service.impl;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sn.constants.ResponseStatus;
import com.sn.dao.PostDAO;
import com.sn.entity.Class;
import com.sn.entity.Post;
import com.sn.entity.PostClass;
import com.sn.entity.User;
import com.sn.service.PostService;
import com.sn.utils.JSONUtils;

@Component("postService")
public class PostServiceImpl implements PostService {
	@Autowired
	PostDAO postDAO;

	@Override
	public String submitPost(String postText, Integer classId, String type) {
		String response = "";
		boolean isSuccess = false;
		try{
			Post post = new Post();
			post.setMessage(postText);
			post.setCommentCount(0);
			post.setCreatedDate(Calendar.getInstance());
			post.setLikeCount(0);
			post.setStudent(true);
			post.setTeacher(true);
			post.setParent(true);
			post.setType(type);
			User createdByUser = new User();
			createdByUser.setUid(1);
			post.setUsersByCreatedBy(createdByUser);
			com.sn.entity.Class classes = new Class();
			classes.setId(classId);
			PostClass postClass = new PostClass();
			postClass.setPosts(post);
			postClass.setClasses(classes);
			Set<PostClass> postClasses = new HashSet<>();
			postClasses.add(postClass);
			post.setPostClasses(postClasses);
			isSuccess = postDAO.insertPost(post);
		}
		catch(Exception e){
			e.printStackTrace();
			isSuccess = false;
		}
		if(isSuccess){
			response = JSONUtils.getSuccessJSONResponse(ResponseStatus.SUCCESS.getCode());
		}
		else{
			response = JSONUtils.getErrorJSONRresponse(ResponseStatus.FAILURE.getCode());
		}
		return response;
	}

	@Override
	public List<Post> getPostsForStudentOrParent(Integer classId) {
		return postDAO.getPostsByClass(classId);
	}

	@Override
	public List<Post> getPostsForTeacher(Integer teacherId, List<Integer> classIds) {
		return postDAO.getPostsByUserAndClass(teacherId, classIds);
	}

	@Override
	public String submitComment(Integer postId, String comment, Integer commentCount, Integer userId) {
		Post post = new Post();
		post.setId(postId);
		post.setCommentCount(commentCount+1);
		return "";//postDAO.getPostsByUserAndClass(teacherId, classIds);
	}
}
