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
@Table(catalog = "test", name = "messages")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "Messages")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class Messages implements Serializable {
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
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdDate;
	/**
	 */

	@Column(name = "subject", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String subject;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "created_by", referencedColumnName = "uid", nullable = false) })
	@XmlTransient
	User users;
	/**
	 */
	@OneToMany(mappedBy = "messages", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.MessageUsers> messageUserses;
	/**
	 */
	@OneToMany(mappedBy = "messages", cascade = { CascadeType.REMOVE }, fetch = FetchType.LAZY)
	@XmlElement(name = "", namespace = "")
	java.util.Set<com.sn.entity.MessageConversations> messageConversationses;

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
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 */
	public String getSubject() {
		return this.subject;
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
	public Messages() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Messages that) {
		setId(that.getId());
		setCreatedDate(that.getCreatedDate());
		setSubject(that.getSubject());
		setUsers(that.getUsers());
		setMessageUserses(new java.util.LinkedHashSet<com.sn.entity.MessageUsers>(that.getMessageUserses()));
		setMessageConversationses(new java.util.LinkedHashSet<com.sn.entity.MessageConversations>(that.getMessageConversationses()));
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("createdDate=[").append(createdDate).append("] ");
		buffer.append("subject=[").append(subject).append("] ");

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
		if (!(obj instanceof Messages))
			return false;
		Messages equalCheck = (Messages) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
