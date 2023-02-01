package com.mosby.security2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mosby.security2.entities.NoticeDetail;

public interface NoticeDetailRepository extends CrudRepository<NoticeDetail, Integer> {

	@Query(value = "from NoticeDetail n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<NoticeDetail> findAllActiveNotices();
}
