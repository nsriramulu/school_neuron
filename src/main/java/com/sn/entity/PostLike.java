package com.sn.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@Table(catalog = "test", name = "post_like")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "PostLike")
public class PostLike implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "like_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer likeId;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "uid", referencedColumnName = "uid", nullable = false) })
	@XmlTransient
	User users;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Post posts;

	/**
	 */
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}

	/**
	 */
	public Integer getLikeId() {
		return this.likeId;
	}

	/**
	 */
	public void setUsers(User users) {
		this.users = users;
	}

	/**
	 */
	@JsonIgnore
	public User getUsers() {
		return users;
	}

	/**
	 */
	public void setPosts(Post posts) {
		this.posts = posts;
	}

	/**
	 */
	@JsonIgnore
	public Post getPosts() {
		return posts;
	}

	/**
	 */
	public PostLike() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(PostLike that) {
		setLikeId(that.getLikeId());
		setUsers(that.getUsers());
		setPosts(that.getPosts());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("likeId=[").append(likeId).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((likeId == null) ? 0 : likeId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof PostLike))
			return false;
		PostLike equalCheck = (PostLike) obj;
		if ((likeId == null && equalCheck.likeId != null) || (likeId != null && equalCheck.likeId == null))
			return false;
		if (likeId != null && !likeId.equals(equalCheck.likeId))
			return false;
		return true;
	}
}
