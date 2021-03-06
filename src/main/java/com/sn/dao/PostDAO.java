package com.sn.dao;

import java.util.Calendar;
import java.util.List;

import com.sn.entity.Post;
import com.sn.vo.CommentsVO;

public interface PostDAO {
	boolean insertPost(Post post);
	
	boolean updateCommentCount(Post post);
	
	List<Post> getPostsByUserAndClass(Integer createdById, List<Integer> classId);

	List<Post> getScheduledPosts();

	boolean updateLikeCount(Post post);

	boolean updateIsScheduled(Post post);

	List<Post> getPostsForNotification(Integer uid, List<Integer> classIds, Calendar calendar);

	List<Post> getAllPosts();
	
	List<CommentsVO> getAllComments(Integer postId);
	
	List<Post> getEventsByUserAndClass(Integer teacherId, List<Integer> classIds);

	List<Post> getAssignmentsByUserAndClass(Integer teacherId,
			List<Integer> classIds);

	List<Post> getPostsByClassAndType(Integer classId, String type);
}

