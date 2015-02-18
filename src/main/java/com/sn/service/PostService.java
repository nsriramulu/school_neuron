package com.sn.service;

import java.util.List;

import com.sn.entity.Post;
import com.sn.vo.CommentsVO;


public interface PostService {
	String submitUpdate(String postText,Integer postClass, String type);
	List<Post> getPostsForTeacher(Integer teacherId,List<Integer> classId, String postFor);
	List<Post> getPostsForStudentOrParent(Integer classId);
	String submitComment(Integer postId, String comment, Integer commentCount, Integer userId);
	String schedulePost(String post, int parseInt, String type, String date, String time);
	void submitScheduledPost(Object object);
	List<Post> getScheduledPosts();
	String addLike(Integer postId, Integer likeCount, Integer uid);
	String submitEvent(String title, String desc, String date, String time, int parseInt,
			String type);
	String scheduleEvent(String title, int parseInt, String type, String date,String desc,
			String time, String scheduleDate, String scheduleTime);
	String checkForNotifications();
	List<Post> getPostsForPrincipal();
	List<CommentsVO> showComments(Integer postId);
	String respondToEvent(Integer response, Integer eventId, Integer uid);
}
