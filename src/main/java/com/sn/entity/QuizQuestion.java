package com.sn.entity;

import java.io.Serializable;
import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@Table(catalog = "test", name = "quiz_question")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "QuizQuestion")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class QuizQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */
	
	@Column(name = "question_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue
	@XmlElement
	Integer questionId;
	/**
	 */
	
	@Column(name = "question")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String question;

	@Column(name = "teacher_id")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdDate;
	
	@Column(name = "updated_by")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer updatedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar updatedDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "quiz_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Post quiz;
	
	@OneToMany(mappedBy = "quizQuestion", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.QuizAnswer> answers;
	
	@OneToMany(mappedBy = "quizQuestion", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.StudentQuiz> studentQuizSet;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Post getQuiz() {
		return quiz;
	}

	public void setQuiz(Post quiz) {
		this.quiz = quiz;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Calendar getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Calendar createdBy) {
		this.createdBy = createdBy;
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

	public java.util.Set<com.sn.entity.QuizAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(java.util.Set<com.sn.entity.QuizAnswer> answers) {
		this.answers = answers;
	}

	public java.util.Set<com.sn.entity.StudentQuiz> getStudentQuizSet() {
		return studentQuizSet;
	}

	public void setStudentQuizSet(
			java.util.Set<com.sn.entity.StudentQuiz> studentQuizSet) {
		this.studentQuizSet = studentQuizSet;
	}
}
