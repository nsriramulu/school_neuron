package com.sn.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
@Table(catalog = "test", name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "Posts")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue
	@XmlElement
	Integer id;
	/**
	 */

	@Column(name = "message")
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String message;
	/**
	 */

	@Column(name = "ip", length = 30)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String ip;
	/**
	 */

	@Column(name = "uploads", length = 30)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String uploads;
	/**
	 */

	@Column(name = "like_count")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer likeCount;
	/**
	 */

	@Column(name = "comment_count")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer commentCount;
	/**
	 */

	@Column(name = "share_count")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer shareCount;
	/**
	 */

	@Column(name = "tag", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String tag;
	/**
	 */

	@Column(name = "teacher")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean teacher;
	/**
	 */

	@Column(name = "student")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean student;
	/**
	 */

	@Column(name = "parent")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean parent;
	/**
	 */

	@Column(name = "type")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String type;
	/**
	 */

	@Column(name = "class_id")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer classId;
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
	
	@Column(name = "is_scheduled")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isScheduled;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "scheduled_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar scheduledDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "post_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar postDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "updated_by", referencedColumnName = "uid") })
	@XmlTransient
	User usersByUpdatedBy;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "created_by", referencedColumnName = "uid", nullable = false) })
	@XmlTransient
	User usersByCreatedBy;
	/**
	 */
	@OneToMany(mappedBy = "posts", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.PostLike> postLikes;
	/**
	 */
//	@OneToMany(mappedBy = "posts", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
//	@XmlElement(name = "", namespace = "")
//	java.util.Set<com.sn.entity.Comment> comments;
	/**
	 */ 
	@OneToMany(mappedBy = "posts", cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.PostClass> postClasses;

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
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 */
	public void setUploads(String uploads) {
		this.uploads = uploads;
	}

	/**
	 */
	public String getUploads() {
		return this.uploads;
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
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 */
	public Integer getCommentCount() {
		return this.commentCount;
	}

	/**
	 */
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	/**
	 */
	public Integer getShareCount() {
		return this.shareCount;
	}

	/**
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}

	/**
	 */
	public String getTag() {
		return this.tag;
	}

	/**
	 */
	public void setTeacher(Boolean teacher) {
		this.teacher = teacher;
	}

	/**
	 */
	public Boolean getTeacher() {
		return this.teacher;
	}

	/**
	 */
	public void setStudent(Boolean student) {
		this.student = student;
	}

	/**
	 */
	public Boolean getStudent() {
		return this.student;
	}

	/**
	 */
	public void setParent(Boolean parent) {
		this.parent = parent;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	/**
	 */
	public Boolean getParent() {
		return this.parent;
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

	public Boolean getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(Boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	public Calendar getScheduledDate() {
		return scheduledDate;
	}

	public void setScheduledDate(Calendar scheduledDate) {
		this.scheduledDate = scheduledDate;
	}

	public Calendar getPostDate() {
		return postDate;
	}

	public void setPostDate(Calendar postDate) {
		this.postDate = postDate;
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
	public void setPostLikes(Set<PostLike> postLikes) {
		this.postLikes = postLikes;
	}

	/**
	 */
	@JsonIgnore
	public Set<PostLike> getPostLikes() {
		if (postLikes == null) {
			postLikes = new java.util.LinkedHashSet<com.sn.entity.PostLike>();
		}
		return postLikes;
	}

	/**
	 */
	public void setPostClasses(Set<PostClass> postClasses) {
		this.postClasses = postClasses;
	}

	/**
	 */
	@JsonIgnore
	public Set<PostClass> getPostClasses() {
		if (postClasses == null) {
			postClasses = new java.util.LinkedHashSet<com.sn.entity.PostClass>();
		}
		return postClasses;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 */
	public Post() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Post that) {
		setId(that.getId());
		setMessage(that.getMessage());
		setIp(that.getIp());
		setUploads(that.getUploads());
		setLikeCount(that.getLikeCount());
		setCommentCount(that.getCommentCount());
		setShareCount(that.getShareCount());
		setTag(that.getTag());
		setTeacher(that.getTeacher());
		setStudent(that.getStudent());
		setParent(that.getParent());
		setCreatedDate(that.getCreatedDate());
		setUpdatedDate(that.getUpdatedDate());
		setUsersByUpdatedBy(that.getUsersByUpdatedBy());
		setUsersByCreatedBy(that.getUsersByCreatedBy());
		setPostLikes(new java.util.LinkedHashSet<com.sn.entity.PostLike>(that.getPostLikes()));
		setPostClasses(new java.util.LinkedHashSet<com.sn.entity.PostClass>(that.getPostClasses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("message=[").append(message).append("] ");
		buffer.append("ip=[").append(ip).append("] ");
		buffer.append("uploads=[").append(uploads).append("] ");
		buffer.append("likeCount=[").append(likeCount).append("] ");
		buffer.append("commentCount=[").append(commentCount).append("] ");
		buffer.append("shareCount=[").append(shareCount).append("] ");
		buffer.append("tag=[").append(tag).append("] ");
		buffer.append("teacher=[").append(teacher).append("] ");
		buffer.append("student=[").append(student).append("] ");
		buffer.append("parent=[").append(parent).append("] ");
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
		if (!(obj instanceof Post))
			return false;
		Post equalCheck = (Post) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
