package com.sn.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 */

@Entity
@Table(catalog = "test", name = "product_admin")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "ProductAdmin")
public class ProductAdmin implements Serializable {
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

	@Column(name = "name", length = 100, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String name;
	/**
	 */

	@Column(name = "email", length = 256, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "password", length = 128, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "active", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer active;
	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar lastLogin;

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
	public void setName(String name) {
		this.name = name;
	}

	/**
	 */
	public String getName() {
		return this.name;
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
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 */
	public Integer getActive() {
		return this.active;
	}

	/**
	 */
	public void setLastLogin(Calendar lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 */
	public Calendar getLastLogin() {
		return this.lastLogin;
	}

	/**
	 */
	public ProductAdmin() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(ProductAdmin that) {
		setId(that.getId());
		setName(that.getName());
		setEmail(that.getEmail());
		setPassword(that.getPassword());
		setActive(that.getActive());
		setLastLogin(that.getLastLogin());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("active=[").append(active).append("] ");
		buffer.append("lastLogin=[").append(lastLogin).append("] ");

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
		if (!(obj instanceof ProductAdmin))
			return false;
		ProductAdmin equalCheck = (ProductAdmin) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
