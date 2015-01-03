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
import javax.persistence.OneToOne;
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
@Table(catalog = "test", name = "class_subject_teacher")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "ClassSubjectTeacher")
public class ClassSubjectTeacher implements Serializable {
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "teacher_id", referencedColumnName = "uid", nullable = false) })
	@XmlTransient
	User users;
	/**
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "subject_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Class classesBySubjectId;
	/**
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumns({ @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Class classesByClassId;

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
	public void setClassesBySubjectId(Class classesBySubjectId) {
		this.classesBySubjectId = classesBySubjectId;
	}

	/**
	 */
	@JsonIgnore
	public Class getClassesBySubjectId() {
		return classesBySubjectId;
	}

	/**
	 */
	public void setClassesByClassId(Class classesByClassId) {
		this.classesByClassId = classesByClassId;
	}

	/**
	 */
	@JsonIgnore
	public Class getClassesByClassId() {
		return classesByClassId;
	}

	/**
	 */
	public ClassSubjectTeacher() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ClassSubjectTeacher that) {
		setId(that.getId());
		setUsers(that.getUsers());
		setClassesBySubjectId(that.getClassesBySubjectId());
		setClassesByClassId(that.getClassesByClassId());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");

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
		if (!(obj instanceof ClassSubjectTeacher))
			return false;
		ClassSubjectTeacher equalCheck = (ClassSubjectTeacher) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
