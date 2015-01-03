package com.sn.entity;

import java.io.Serializable;

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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 */

@Entity
@Table(catalog = "test", name = "schools")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "core/org/sn/core/domain", name = "Schools")
public class School implements Serializable {
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

	@Column(name = "code", length = 10, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String code;
	/**
	 */

	@Column(name = "name", length = 200, nullable = false)
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

	@Column(name = "about", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Lob
	@XmlElement
	String about;
	/**
	 */

	@Column(name = "address_line1", length = 50, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String addressLine1;
	/**
	 */

	@Column(name = "logo", length = 200)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String logo;
	/**
	 */

	@Column(name = "no_students")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer noStudents;
	/**
	 */

	@Column(name = "no_teachers")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer noTeachers;
	/**
	 */

	@Column(name = "founded_year", length = 50)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String foundedYear;
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

	@Column(name = "is_active")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Boolean isActive;
	/**
	 */

	@Column(name = "contact_name", length = 40)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String contactName;
	/**
	 */

	@Column(name = "phone", length = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;

	/**
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "contact_id", referencedColumnName = "uid") })
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
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 */
	public String getCode() {
		return this.code;
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
	public void setAbout(String about) {
		this.about = about;
	}

	/**
	 */
	public String getAbout() {
		return this.about;
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
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 */
	public String getLogo() {
		return this.logo;
	}

	/**
	 */
	public void setNoStudents(Integer noStudents) {
		this.noStudents = noStudents;
	}

	/**
	 */
	public Integer getNoStudents() {
		return this.noStudents;
	}

	/**
	 */
	public void setNoTeachers(Integer noTeachers) {
		this.noTeachers = noTeachers;
	}

	/**
	 */
	public Integer getNoTeachers() {
		return this.noTeachers;
	}

	/**
	 */
	public void setFoundedYear(String foundedYear) {
		this.foundedYear = foundedYear;
	}

	/**
	 */
	public String getFoundedYear() {
		return this.foundedYear;
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
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 */
	public Boolean getIsActive() {
		return this.isActive;
	}

	/**
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 */
	public String getContactName() {
		return this.contactName;
	}

	/**
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 */
	public String getPhone() {
		return this.phone;
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
	public School() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(School that) {
		setId(that.getId());
		setCode(that.getCode());
		setName(that.getName());
		setEmail(that.getEmail());
		setAbout(that.getAbout());
		setAddressLine1(that.getAddressLine1());
		setLogo(that.getLogo());
		setNoStudents(that.getNoStudents());
		setNoTeachers(that.getNoTeachers());
		setFoundedYear(that.getFoundedYear());
		setAddressLine2(that.getAddressLine2());
		setLandmark(that.getLandmark());
		setCity(that.getCity());
		setPincode(that.getPincode());
		setState(that.getState());
		setCountry(that.getCountry());
		setIsActive(that.getIsActive());
		setContactName(that.getContactName());
		setPhone(that.getPhone());
		setUsers(that.getUsers());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("id=[").append(id).append("] ");
		buffer.append("code=[").append(code).append("] ");
		buffer.append("name=[").append(name).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("about=[").append(about).append("] ");
		buffer.append("addressLine1=[").append(addressLine1).append("] ");
		buffer.append("logo=[").append(logo).append("] ");
		buffer.append("noStudents=[").append(noStudents).append("] ");
		buffer.append("noTeachers=[").append(noTeachers).append("] ");
		buffer.append("foundedYear=[").append(foundedYear).append("] ");
		buffer.append("addressLine2=[").append(addressLine2).append("] ");
		buffer.append("landmark=[").append(landmark).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("pincode=[").append(pincode).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("country=[").append(country).append("] ");
		buffer.append("isActive=[").append(isActive).append("] ");
		buffer.append("contactName=[").append(contactName).append("] ");
		buffer.append("phone=[").append(phone).append("] ");

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
		if (!(obj instanceof School))
			return false;
		School equalCheck = (School) obj;
		if ((id == null && equalCheck.id != null) || (id != null && equalCheck.id == null))
			return false;
		if (id != null && !id.equals(equalCheck.id))
			return false;
		return true;
	}
}
