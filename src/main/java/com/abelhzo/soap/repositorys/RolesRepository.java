package com.abelhzo.soap.repositorys;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abelhzo.jpa.Role;

public interface RolesRepository extends JpaRepository<Role, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Role r SET "
		 + "r.rol = :rol, "
		 + "r.updatedate = :updatedate "
		 + "WHERE r.idrol = :idrol")
	Integer updateRoleCustomized(@Param("rol") String rol,
							     @Param("updatedate") Timestamp updatedate,
							     @Param("idrol") Long idrol);
	

}
