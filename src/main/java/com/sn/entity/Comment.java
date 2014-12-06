package com.sn.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@Table(catalog = "test", name = "comments")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "Comments")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "comment", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String comment;
	/**
	 */

	@Column(name = "like_count")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer likeCount;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdDate;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar updatedDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "updated_by", referencedColumnName = "uid") })
	@XmlTransient
	User usersByUpdatedBy;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "created_by", referencedColumnName = "uid", nullable = false) })
	@XmlTransient
	User usersByCreatedBy;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Post posts;
	/**
	 */
	@OneToMany(mappedBy = "comments", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.CommentLike> commentLikes;

	/**
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 */
	public String getComment() {
		return this.comment;
	}

	/**
	 */
	public void setLikeCount(Integer likeCount) {
		this.likeCount = likeCount;
	}

	/**
	 */
	public Integer getLikeCount() {
		return this.likeCount;
	}

	/**
	 */
	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 */
	public Calendar getCreatedDate() {
		return this.createdDate;
	}

	/**
	 */
	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 */
	public Calendar getUpdatedDate() {
		return this.updatedDate;
	}

	/**
	 */
	public void setUsersByUpdatedBy(User usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	/**
	 */
	@JsonIgnore
	public User getUsersByUpdatedBy() {
		return usersByUpdatedBy;
	}

	/**
	 */
	public void setUsersByCreatedBy(User usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	/**
	 */
	@JsonIgnore
	public User getUsersByCreatedBy() {
		return usersByCreatedBy;
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
	public void setCommentLikes(Set<CommentLike> commentLikes) {
		this.commentLikes = commentLikes;
	}

	/**
	 */
	@JsonIgnore
	public Set<CommentLike> getCommentLikes() {
		if (commentLikes == null) {
			commentLikes = new java.util.LinkedHashSet<com.sn.entity.CommentLike>();
		}
		return commentLikes;
	}

	/**
	 */
	public Comment() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Comment that) {
		setId(that.getId());
		setComment(that.getComment());
		setLikeCount(that.getLikeCount());
		setCreatedDate(that.getCreatedDate());
		setUpdatedDate(that.getUpdatedDate());
		setUsersByUpdatedBy(that.getUsersByUpdatedBy());
		setUsersByCreatedBy(that.getUsersByCreatedBy());
		setPosts(that.getPosts());
		setCommentLikes(new java.util.LinkedHashSet<com.sn.entity.CommentLike>(that.getCommentLikes()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("comment=[").append(comment).append("] ");
		buffer.append("likeCount=[").append(likeCount).append("] ");
		buffer.append("createdDate=[").append(createdDate).append("] ");
		buffer.append("updatedDate=[").append(updatedDate).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((id == null) ? 0 : id.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Comment))
			return false;
		Comment equalCheck = (Comment) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
