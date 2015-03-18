package com.sn.entity;

import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(catalog = "test", name = "student_assignment")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "StudentAssignment")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class StudentAssignment {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue
	@XmlElement
	Integer id;
	
	@Column(name = "student_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer studentId;

	@Column(name = "marks")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer marks;
	
	@Column(name = "isCompleted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isCompleted;
	
	@Column(name = "isSubmitted")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isSubmitted;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "submittedDate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar submittedDate;
	
	@Column(name = "docName")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String docName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdDate;
	
	@Column(name = "modified_by")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modified_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar updatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "assignment_id", referencedColumnName = "id") })
	@XmlTransient
	Post assignment;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	public Boolean getIsCompleted() {
		return isCompleted;
	}

	public void setIsCompleted(Boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Boolean getIsSubmitted() {
		return isSubmitted;
	}

	public void setIsSubmitted(Boolean isSubmitted) {
		this.isSubmitted = isSubmitted;
	}

	public Calendar getSubmittedDate() {
		return submittedDate;
	}

	public void setSubmittedDate(Calendar submittedDate) {
		this.submittedDate = submittedDate;
	}

	public String getDocName() {
		return docName;
	}

	public void setDocName(String docName) {
		this.docName = docName;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Calendar getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Calendar updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Post getAssignment() {
		return assignment;
	}

	public void setAssignment(Post assignment) {
		this.assignment = assignment;
	}
	
}
