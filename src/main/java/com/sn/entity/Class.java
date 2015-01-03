package com.sn.entity;

import java.io.Serializable;
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
@Table(catalog = "test", name = "classes")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "Classes")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class Class implements Serializable {
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

	@Column(name = "class_name", length = 11, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String className;
	/**
	 */

	@Column(name = "is_active", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isActive;
	
	@Column(name = "section")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String section;
	
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "advisor_id", referencedColumnName = "uid") })
	@XmlTransient
	User users;
	/**
	 */
	@OneToMany(mappedBy = "classesBySubjectId", cascade = { CascadeType.REMOVE }, fetch = FetchType.EAGER)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.ClassSubjectTeacher> classSubjectTeachersForClassId;
	/**
	 */
	@OneToMany(mappedBy = "classesBySubjectId", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.ClassSubjectTeacher> classSubjectTeachersForSubjectId;
	/**
	 */
	@OneToMany(mappedBy = "classes", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.User> userses;
	/**
	 */
	@OneToMany(mappedBy = "classes", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
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
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 */
	public String getClassName() {
		return this.className;
	}

	/**
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 */
	public Boolean getIsActive() {
		return this.isActive;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
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
	public void setClassSubjectTeachersForClassId(Set<ClassSubjectTeacher> classSubjectTeachersForClassId) {
		this.classSubjectTeachersForClassId = classSubjectTeachersForClassId;
	}

	/**
	 */
	@JsonIgnore
	public Set<ClassSubjectTeacher> getClassSubjectTeachersForClassId() {
		if (classSubjectTeachersForClassId == null) {
			classSubjectTeachersForClassId = new java.util.LinkedHashSet<com.sn.entity.ClassSubjectTeacher>();
		}
		return classSubjectTeachersForClassId;
	}

	/**
	 */
	public void setClassSubjectTeachersForSubjectId(Set<ClassSubjectTeacher> classSubjectTeachersForSubjectId) {
		this.classSubjectTeachersForSubjectId = classSubjectTeachersForSubjectId;
	}

	/**
	 */
	@JsonIgnore
	public Set<ClassSubjectTeacher> getClassSubjectTeachersForSubjectId() {
		if (classSubjectTeachersForSubjectId == null) {
			classSubjectTeachersForSubjectId = new java.util.LinkedHashSet<com.sn.entity.ClassSubjectTeacher>();
		}
		return classSubjectTeachersForSubjectId;
	}

	/**
	 */
	public void setUserses(Set<User> userses) {
		this.userses = userses;
	}

	/**
	 */
	@JsonIgnore
	public Set<User> getUserses() {
		if (userses == null) {
			userses = new java.util.LinkedHashSet<com.sn.entity.User>();
		}
		return userses;
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

	/**
	 */
	public Class() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Class that) {
		setId(that.getId());
		setClassName(that.getClassName());
		setIsActive(that.getIsActive());
		setUsers(that.getUsers());
		setClassSubjectTeachersForClassId(new java.util.LinkedHashSet<com.sn.entity.ClassSubjectTeacher>(that.getClassSubjectTeachersForClassId()));
		setClassSubjectTeachersForSubjectId(new java.util.LinkedHashSet<com.sn.entity.ClassSubjectTeacher>(that.getClassSubjectTeachersForSubjectId()));
		setUserses(new java.util.LinkedHashSet<com.sn.entity.User>(that.getUserses()));
		setPostClasses(new java.util.LinkedHashSet<com.sn.entity.PostClass>(that.getPostClasses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("className=[").append(className).append("] ");
		buffer.append("isActive=[").append(isActive).append("] ");

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
		if (!(obj instanceof Class))
			return false;
		Class equalCheck = (Class) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
