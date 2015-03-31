package com.sn.service;

import java.util.List;

import com.sn.entity.Post;
import com.sn.vo.CommentsVO;


public interface PostService {
	List<Post> getPostsForTeacher(Integer teacherId,List<Integer> classId, String postFor);
	String submitComment(Integer postId, String comment, Integer commentCount, Integer userId);
	void submitScheduledPost(Object object);
	List<Post> getScheduledPosts();
	String addLike(Integer postId, Integer likeCount, Integer uid);
	String checkForNotifications();
	List<Post> getPostsForPrincipal();
	List<CommentsVO> showComments(Integer postId);
	String submitEvent(String title, String desc, String date, String time,
			int classId, String type, String docName);
	String scheduleEvent(String title, int classId, String type, String desc,
			String date, String time, String scheduledDate,
			String scheduledTime, String docName);
	String respondToEvent(Integer response, Integer eventId, Integer uid);
	String schedulePost(String postText, int classId, String type, String date,
			String time, String docName);
	String submitUpdate(String postText, Integer classId, String type,
			String docName);
	List<Post> getPostsForStudentOrParent(Integer classId, String type);
	String submitOnlineAssignment(Integer postId, String comment, String fileName, Integer submittedCount);
	String submitQuiz(String quizType,String quizTitle,String dueDate,String pointPerQue,String questionSet);
}
