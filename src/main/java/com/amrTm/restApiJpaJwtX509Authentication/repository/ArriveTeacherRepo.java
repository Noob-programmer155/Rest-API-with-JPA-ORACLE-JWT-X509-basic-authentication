package com.amrTm.restApiJpaJwtX509Authentication.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.amrTm.restApiJpaJwtX509Authentication.entity.ArrivalTeacher;

@Repository
public interface ArriveTeacherRepo extends JpaRepository<ArrivalTeacher, Long>{
	@Transactional
	@Query("select u from ArrivalTeacher u where u.arrive between :start and :end")
	public List<ArrivalTeacher> findArriveBeetween(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
	@PreAuthorize("hasAuthority('ADMIN')")
	public void deleteByIdArrive(Long id);
}
