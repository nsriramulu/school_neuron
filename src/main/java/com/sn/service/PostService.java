package com.sn.service;

import java.util.List;

import com.sn.entity.Post;


public interface PostService {
	String submitPost(String postText,Integer postClass, String type);
	List<Post> getPostsForTeacher(Integer teacherId,List<Integer> classId);
	List<Post> getPostsForStudentOrParent(Integer classId);
	String submitComment(Integer postId, String comment, Integer commentCount, Integer userId);
	String schedulePost(String post, int parseInt, String type, String date, String time);
	void submitScheduledPost(Object object);
	List<Post> getScheduledPosts();
	String addLike(Integer postId, Integer likeCount, Integer uid);
}
