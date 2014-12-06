package com.sn.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@Table(catalog = "test", name = "message_conversations")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "MessageConversations")
public class MessageConversations implements Serializable {
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

	@Column(name = "message", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String message;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar createdDate;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "parent_message_id", referencedColumnName = "id", nullable = false) })
	@XmlTransient
	Messages messages;
	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "created_by", referencedColumnName = "uid", nullable = false) })
	@XmlTransient
	User users;

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
	public void setMessages(Messages messages) {
		this.messages = messages;
	}

	/**
	 */
	@JsonIgnore
	public Messages getMessages() {
		return messages;
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
	public MessageConversations() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(MessageConversations that) {
		setId(that.getId());
		setMessage(that.getMessage());
		setCreatedDate(that.getCreatedDate());
		setMessages(that.getMessages());
		setUsers(that.getUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("message=[").append(message).append("] ");
		buffer.append("createdDate=[").append(createdDate).append("] ");

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
		if (!(obj instanceof MessageConversations))
			return false;
		MessageConversations equalCheck = (MessageConversations) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
