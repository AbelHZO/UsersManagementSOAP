package com.abelhzo.soap.repositorys;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abelhzo.jpa.Accessuser;

public interface AccessUsersRepository extends JpaRepository<Accessuser, Long> {

	@Modifying(clearAutomatically = true)
	@Query("UPDATE Accessuser au SET au.sessionactive = :sessionactive WHERE au.id.iduser = :iduser")
	Integer logoutAccessUsers(@Param("sessionactive") BigDecimal sessionactive, @Param("iduser") Long iduser);

	@Query("SELECT au FROM Accessuser au WHERE au.id.iduser = :iduser")
	Accessuser findByIduser(@Param("iduser") Long iduser);

	@Query("SELECT au FROM Accessuser au WHERE au.id.iduser = :iduser AND au.sessionactive = 1")
	Accessuser isActiveSessionUser(@Param("iduser") Long iduser);

	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM Accessuser au WHERE au.id.iduser = :iduser AND au.id.dateaccess = :dateaccess")
	void deleteLastAccess(@Param("iduser") Long iduser, @Param("dateaccess") Date dateaccess);
}
