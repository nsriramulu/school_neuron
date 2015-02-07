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
@Table(catalog = "test", name = "event_results")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "EventResult")
@XmlRootElement(namespace = "core/org/sn/core/domain")
public class EventResult implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 */
//	
//	id
//	event_id
//	yes
//	no
//	may_be
//	user_id
//	date_time
//
	private static final long serialVersionUID = 1L;

	@Column(name = "id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id 
	@GeneratedValue
	@XmlElement
	Integer id;
//
//	/**
//	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({ @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false) })
//	@XmlTransient
//	Post posts;
//	/**
//	 */
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumns({ @JoinColumn(name = "class_id", referencedColumnName = "id", nullable = false) })
//	@XmlTransient
//	Class classes;
//
//	/**
//	 */
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	/**
//	 */
//	public Integer getId() {
//		return this.id;
//	}
//
//	/**
//	 */
//	public void setPosts(Post posts) {
//		this.posts = posts;
//	}
//
//	/**
//	 */
//	@JsonIgnore
//	public Post getPosts() {
//		return posts;
//	}
//
//	/**
//	 */
//	public void setClasses(Class classes) {
//		this.classes = classes;
//	}
//
//	/**
//	 */
//	@JsonIgnore
//	public Class getClasses() {
//		return classes;
//	}
//
}
