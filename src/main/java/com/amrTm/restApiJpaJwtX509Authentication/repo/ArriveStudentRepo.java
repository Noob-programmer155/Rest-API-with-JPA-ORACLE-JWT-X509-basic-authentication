package com.amrTm.restApiJpaJwtX509Authentication.repo;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amrTm.restApiJpaJwtX509Authentication.entity.ArrivalStudent;

@Repository
public interface ArriveStudentRepo extends JpaRepository<ArrivalStudent,Long>{
	@Modifying
	@Transactional
	@Query("select u from ArrivalStudent u where u.arrive between :start and :end")
	public List<ArrivalStudent> findArriveBeetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}