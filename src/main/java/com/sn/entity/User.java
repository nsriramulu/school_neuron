package com.sn.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(catalog = "test", name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "Users")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "uid", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer uid;
	/**
	 */

	@Column(name = "username", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 */

	@Column(name = "password", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "email", length = 100)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "first_name", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String firstName;
	/**
	 */

	@Column(name = "last_name", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lastName;
	/**
	 */

	@Column(name = "gender", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String gender;
	/**
	 */

	@Column(name = "birthday", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String birthday;
	/**
	 */

	@Column(name = "contact_no", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contactNo;
	/**
	 */

	@Column(name = "address_line1", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine1;
	/**
	 */

	@Column(name = "address_line2", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine2;
	/**
	 */

	@Column(name = "landmark", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String landmark;
	/**
	 */

	@Column(name = "city", length = 30)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "pincode", length = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String pincode;
	/**
	 */

	@Column(name = "state", length = 30)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "country", length = 30)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String country;
	/**
	 */

	@Column(name = "profile_pic", length = 200)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String profilePic;
	/**
	 */

	@Column(name = "role", length = 30, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String role;
	/**
	 */

	@Column(name = "relation", length = 1)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String relation;
	/**
	 */

	@Column(name = "is_password_reset")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isPasswordReset;
	/**
	 */

	@Column(name = "is_locked")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isLocked;
	/**
	 */

	@Column(name = "is_advisor")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isAdvisor;
	/**
	 */

	@Column(name = "is_representative")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isRepresentative;
	/**
	 */

	@Column(name = "parent_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer parentId;
	/**
	 */

	@Column(name = "status")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer status;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "class_id", referencedColumnName = "id") })
	@XmlTransient
	Class classes;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.CommentLike> commentLikes;
	/**
	 */
	@OneToMany(mappedBy = "usersByUpdatedBy", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Comment> commentsesForCreatedBy;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.MessageConversations> messageConversationses;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.PostLike> postLikes;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.ClassSubjectTeacher> classSubjectTeachers;
	/**
	 */
	@OneToMany(mappedBy = "usersByUpdatedBy", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Post> postsesForUpdatedBy;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Schools> schoolses;
	/**
	 */
	@OneToMany(mappedBy = "usersByUpdatedBy", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Post> postsesForCreatedBy;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.MessageUsers> messageUserses;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Class> classeses;
	/**
	 */
	@OneToMany(mappedBy = "usersByUpdatedBy", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Comment> commentsesForUpdatedBy;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.UserUploads> userUploadses;
	/**
	 */
	@OneToMany(mappedBy = "users", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.Messages> messageses;

	/**
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 */
	public Integer getUid() {
		return this.uid;
	}

	/**
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 */
	public String getGender() {
		return this.gender;
	}

	/**
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 */
	public String getBirthday() {
		return this.birthday;
	}

	/**
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 */
	public String getContactNo() {
		return this.contactNo;
	}

	/**
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 */
	public String getAddressLine1() {
		return this.addressLine1;
	}

	/**
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 */
	public String getAddressLine2() {
		return this.addressLine2;
	}

	/**
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 */
	public String getLandmark() {
		return this.landmark;
	}

	/**
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 */
	public String getPincode() {
		return this.pincode;
	}

	/**
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 */
	public String getState() {
		return this.state;
	}

	/**
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 */
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	/**
	 */
	public String getProfilePic() {
		return this.profilePic;
	}

	/**
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 */
	public String getRole() {
		return this.role;
	}

	/**
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 */
	public String getRelation() {
		return this.relation;
	}

	/**
	 */
	public void setIsPasswordReset(Boolean isPasswordReset) {
		this.isPasswordReset = isPasswordReset;
	}

	/**
	 */
	public Boolean getIsPasswordReset() {
		return this.isPasswordReset;
	}

	/**
	 */
	public void setIsLocked(Boolean isLocked) {
		this.isLocked = isLocked;
	}

	/**
	 */
	public Boolean getIsLocked() {
		return this.isLocked;
	}

	/**
	 */
	public void setIsAdvisor(Boolean isAdvisor) {
		this.isAdvisor = isAdvisor;
	}

	/**
	 */
	public Boolean getIsAdvisor() {
		return this.isAdvisor;
	}

	/**
	 */
	public void setIsRepresentative(Boolean isRepresentative) {
		this.isRepresentative = isRepresentative;
	}

	/**
	 */
	public Boolean getIsRepresentative() {
		return this.isRepresentative;
	}

	/**
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 */
	public Integer getParentId() {
		return this.parentId;
	}

	/**
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 */
	public void setClasses(Class classes) {
		this.classes = classes;
	}

	/**
	 */
	@JsonIgnore
	public Class getClasses() {
		return classes;
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
	public void setCommentsesForCreatedBy(Set<Comment> commentsesForCreatedBy) {
		this.commentsesForCreatedBy = commentsesForCreatedBy;
	}

	/**
	 */
	@JsonIgnore
	public Set<Comment> getCommentsesForCreatedBy() {
		if (commentsesForCreatedBy == null) {
			commentsesForCreatedBy = new java.util.LinkedHashSet<com.sn.entity.Comment>();
		}
		return commentsesForCreatedBy;
	}

	/**
	 */
	public void setMessageConversationses(Set<MessageConversations> messageConversationses) {
		this.messageConversationses = messageConversationses;
	}

	/**
	 */
	@JsonIgnore
	public Set<MessageConversations> getMessageConversationses() {
		if (messageConversationses == null) {
			messageConversationses = new java.util.LinkedHashSet<com.sn.entity.MessageConversations>();
		}
		return messageConversationses;
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
	public void setClassSubjectTeachers(Set<ClassSubjectTeacher> classSubjectTeachers) {
		this.classSubjectTeachers = classSubjectTeachers;
	}

	/**
	 */
	@JsonIgnore
	public Set<ClassSubjectTeacher> getClassSubjectTeachers() {
		if (classSubjectTeachers == null) {
			classSubjectTeachers = new java.util.LinkedHashSet<com.sn.entity.ClassSubjectTeacher>();
		}
		return classSubjectTeachers;
	}

	/**
	 */
	public void setPostsesForUpdatedBy(Set<Post> postsesForUpdatedBy) {
		this.postsesForUpdatedBy = postsesForUpdatedBy;
	}

	/**
	 */
	@JsonIgnore
	public Set<Post> getPostsesForUpdatedBy() {
		if (postsesForUpdatedBy == null) {
			postsesForUpdatedBy = new java.util.LinkedHashSet<com.sn.entity.Post>();
		}
		return postsesForUpdatedBy;
	}

	/**
	 */
	public void setSchoolses(Set<Schools> schoolses) {
		this.schoolses = schoolses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Schools> getSchoolses() {
		if (schoolses == null) {
			schoolses = new java.util.LinkedHashSet<com.sn.entity.Schools>();
		}
		return schoolses;
	}

	/**
	 */
	public void setPostsesForCreatedBy(Set<Post> postsesForCreatedBy) {
		this.postsesForCreatedBy = postsesForCreatedBy;
	}

	/**
	 */
	@JsonIgnore
	public Set<Post> getPostsesForCreatedBy() {
		if (postsesForCreatedBy == null) {
			postsesForCreatedBy = new java.util.LinkedHashSet<com.sn.entity.Post>();
		}
		return postsesForCreatedBy;
	}

	/**
	 */
	public void setMessageUserses(Set<MessageUsers> messageUserses) {
		this.messageUserses = messageUserses;
	}

	/**
	 */
	@JsonIgnore
	public Set<MessageUsers> getMessageUserses() {
		if (messageUserses == null) {
			messageUserses = new java.util.LinkedHashSet<com.sn.entity.MessageUsers>();
		}
		return messageUserses;
	}

	/**
	 */
	public void setClasseses(Set<Class> classeses) {
		this.classeses = classeses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Class> getClasseses() {
		if (classeses == null) {
			classeses = new java.util.LinkedHashSet<com.sn.entity.Class>();
		}
		return classeses;
	}

	/**
	 */
	public void setCommentsesForUpdatedBy(Set<Comment> commentsesForUpdatedBy) {
		this.commentsesForUpdatedBy = commentsesForUpdatedBy;
	}

	/**
	 */
	@JsonIgnore
	public Set<Comment> getCommentsesForUpdatedBy() {
		if (commentsesForUpdatedBy == null) {
			commentsesForUpdatedBy = new java.util.LinkedHashSet<com.sn.entity.Comment>();
		}
		return commentsesForUpdatedBy;
	}

	/**
	 */
	public void setUserUploadses(Set<UserUploads> userUploadses) {
		this.userUploadses = userUploadses;
	}

	/**
	 */
	@JsonIgnore
	public Set<UserUploads> getUserUploadses() {
		if (userUploadses == null) {
			userUploadses = new java.util.LinkedHashSet<com.sn.entity.UserUploads>();
		}
		return userUploadses;
	}

	/**
	 */
	public void setMessageses(Set<Messages> messageses) {
		this.messageses = messageses;
	}

	/**
	 */
	@JsonIgnore
	public Set<Messages> getMessageses() {
		if (messageses == null) {
			messageses = new java.util.LinkedHashSet<com.sn.entity.Messages>();
		}
		return messageses;
	}

	/**
	 */
	public User() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(User that) {
		setUid(that.getUid());
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setEmail(that.getEmail());
		setFirstName(that.getFirstName());
		setLastName(that.getLastName());
		setGender(that.getGender());
		setBirthday(that.getBirthday());
		setContactNo(that.getContactNo());
		setAddressLine1(that.getAddressLine1());
		setAddressLine2(that.getAddressLine2());
		setLandmark(that.getLandmark());
		setCity(that.getCity());
		setPincode(that.getPincode());
		setState(that.getState());
		setCountry(that.getCountry());
		setProfilePic(that.getProfilePic());
		setRole(that.getRole());
		setRelation(that.getRelation());
		setIsPasswordReset(that.getIsPasswordReset());
		setIsLocked(that.getIsLocked());
		setIsAdvisor(that.getIsAdvisor());
		setIsRepresentative(that.getIsRepresentative());
		setParentId(that.getParentId());
		setStatus(that.getStatus());
		setClasses(that.getClasses());
		setCommentLikes(new java.util.LinkedHashSet<com.sn.entity.CommentLike>(that.getCommentLikes()));
		setCommentsesForCreatedBy(new java.util.LinkedHashSet<com.sn.entity.Comment>(that.getCommentsesForCreatedBy()));
		setMessageConversationses(new java.util.LinkedHashSet<com.sn.entity.MessageConversations>(that.getMessageConversationses()));
		setPostLikes(new java.util.LinkedHashSet<com.sn.entity.PostLike>(that.getPostLikes()));
		setClassSubjectTeachers(new java.util.LinkedHashSet<com.sn.entity.ClassSubjectTeacher>(that.getClassSubjectTeachers()));
		setPostsesForUpdatedBy(new java.util.LinkedHashSet<com.sn.entity.Post>(that.getPostsesForUpdatedBy()));
		setSchoolses(new java.util.LinkedHashSet<com.sn.entity.Schools>(that.getSchoolses()));
		setPostsesForCreatedBy(new java.util.LinkedHashSet<com.sn.entity.Post>(that.getPostsesForCreatedBy()));
		setMessageUserses(new java.util.LinkedHashSet<com.sn.entity.MessageUsers>(that.getMessageUserses()));
		setClasseses(new java.util.LinkedHashSet<com.sn.entity.Class>(that.getClasseses()));
		setCommentsesForUpdatedBy(new java.util.LinkedHashSet<com.sn.entity.Comment>(that.getCommentsesForUpdatedBy()));
		setUserUploadses(new java.util.LinkedHashSet<com.sn.entity.UserUploads>(that.getUserUploadses()));
		setMessageses(new java.util.LinkedHashSet<com.sn.entity.Messages>(that.getMessageses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("uid=[").append(uid).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("firstName=[").append(firstName).append("] ");
		buffer.append("lastName=[").append(lastName).append("] ");
		buffer.append("gender=[").append(gender).append("] ");
		buffer.append("birthday=[").append(birthday).append("] ");
		buffer.append("contactNo=[").append(contactNo).append("] ");
		buffer.append("addressLine1=[").append(addressLine1).append("] ");
		buffer.append("addressLine2=[").append(addressLine2).append("] ");
		buffer.append("landmark=[").append(landmark).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("pincode=[").append(pincode).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("country=[").append(country).append("] ");
		buffer.append("profilePic=[").append(profilePic).append("] ");
		buffer.append("role=[").append(role).append("] ");
		buffer.append("relation=[").append(relation).append("] ");
		buffer.append("isPasswordReset=[").append(isPasswordReset).append("] ");
		buffer.append("isLocked=[").append(isLocked).append("] ");
		buffer.append("isAdvisor=[").append(isAdvisor).append("] ");
		buffer.append("isRepresentative=[").append(isRepresentative).append("] ");
		buffer.append("parentId=[").append(parentId).append("] ");
		buffer.append("status=[").append(status).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((uid == null) ? 0 : uid.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof User))
			return false;
		User equalCheck = (User) obj;
		if ((uid == null && equalCheck.uid != null) || (uid != null && equalCheck.uid == null))
			return false;
		if (uid != null && !uid.equals(equalCheck.uid))
			return false;
		return true;
	}
}
