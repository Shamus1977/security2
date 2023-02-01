package com.mosby.security2.entities;

import java.sql.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notice_detail")
public class NoticeDetail {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int noticeId;

	private String noticeSummary;

	private String noticeDetails;

	private Date noticBegDt;
	
	private Date noticEndDt;
	
	private Date createDt;
	
	private Date updateDt;

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeSummary() {
		return noticeSummary;
	}

	public void setNoticeSummary(String noticeSummary) {
		this.noticeSummary = noticeSummary;
	}

	public String getNoticeDetails() {
		return noticeDetails;
	}

	public void setNoticeDetails(String noticeDetails) {
		this.noticeDetails = noticeDetails;
	}

	public Date getNoticBegDt() {
		return noticBegDt;
	}

	public void setNoticBegDt(Date noticBegDt) {
		this.noticBegDt = noticBegDt;
	}

	public Date getNoticEndDt() {
		return noticEndDt;
	}

	public void setNoticEndDt(Date noticEndDt) {
		this.noticEndDt = noticEndDt;
	}

	public Date getCreateDt() {
		return createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	public String toString() {
		return "NoticeDetail [noticeId=" + noticeId + ", noticeSummary=" + noticeSummary + ", noticeDetails="
				+ noticeDetails + ", noticBegDt=" + noticBegDt + ", noticEndDt=" + noticEndDt + ", createDt=" + createDt
				+ ", updateDt=" + updateDt + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(noticeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticeDetail other = (NoticeDetail) obj;
		return noticeId == other.noticeId;
	}
	
}
