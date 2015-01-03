package com.sn.dao;

import java.util.List;

import com.sn.entity.Post;

public interface PostDAO {
	boolean insertPost(Post post);
	
	boolean updatePost(Post post);
	
	List<Post> getPostsByClass(Integer classId);

	List<Post> getPostsByUserAndClass(Integer createdById, List<Integer> classId);
}

