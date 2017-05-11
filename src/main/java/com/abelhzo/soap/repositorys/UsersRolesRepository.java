package com.abelhzo.soap.repositorys;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abelhzo.jpa.Usersrole;

public interface UsersRolesRepository extends JpaRepository<Usersrole, Long> {

	@Query("SELECT ur FROM Usersrole ur WHERE ur.id.iduser = :iduser")
	List<Usersrole> findByIduser(@Param("iduser") Long iduser);

	@Modifying(clearAutomatically = true)
	@Query("DELETE FROM Usersrole ur WHERE ur.id.iduser = :iduser")
	void deleteUsersRolesByIduser(@Param("iduser") Long iduser);

}
