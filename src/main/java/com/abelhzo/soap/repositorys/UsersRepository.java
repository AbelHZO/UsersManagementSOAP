package com.abelhzo.soap.repositorys;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abelhzo.jpa.User;

public interface UsersRepository extends JpaRepository<User, Long> {
	
	@Modifying(clearAutomatically = true)
	@Query("UPDATE User u SET "
		 + "u.username = :username,"
		 + "u.email = :email,"
		 + "u.password = :password, "
		 + "u.birthday = :birthday, "
		 + "u.name = :name, "
		 + "u.firstlastname = :firstlastname, "
		 + "u.secondlastname = :secondlastname, "
		 + "u.celphone = :celphone, "
		 + "u.address = :address, "
		 + "u.genre = :genre, "
		 + "u.active = :active, "
		 + "u.updatedate = :updatedate, "
		 + "u.updatecount = :updatecount "
		 + "WHERE u.iduser = :iduser")
	Integer updateUserCustomized(@Param("username") String username,
								 @Param("email") String email,
								 @Param("password") String password,
								 @Param("birthday") Date birthday,
								 @Param("name") String name,
								 @Param("firstlastname") String firstlastname,
								 @Param("secondlastname") String secondlastname,
								 @Param("celphone") String celphone,
								 @Param("address") String address,
								 @Param("genre") String genre,
								 @Param("active") BigDecimal active,
								 @Param("updatedate") Timestamp updatedate,
								 @Param("updatecount") BigDecimal updatecount,
								 @Param("iduser") Long iduser);
	
	
	User findByUsernameAndPassword(String username, String password);
	
}
