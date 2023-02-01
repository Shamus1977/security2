package com.mosby.security2.entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_message")
public class ContactMessage {

	@Id
	private String contactId;

	private String contactName;

	private String contactEmail;
	
	private String subject;

	private String message;

	private Date createDt;

	public String getContactId() {
		return contactId;
	}

	public void setContactId(String contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	@Override
	public String toString() {
		return "ContactMessage [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail="
				+ contactEmail + ", subject=" + subject + ", message=" + message + ", createDt=" + createDt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactMessage other = (ContactMessage) obj;
		return Objects.equals(contactId, other.contactId);
	}
	
	
}
