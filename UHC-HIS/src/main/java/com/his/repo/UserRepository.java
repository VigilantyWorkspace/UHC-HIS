package com.his.repo;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.his.entity.User;



@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {

    User findByEmail(String email_id);

    List<User> findByRoleNameIgnoreCaseContaining(String roleName);
    
    User findByPasswordAndEmail(String pwd,String email);
    
    @Transactional
	@Modifying
	@Query(value="UPDATE HIS_USER_MASTER set DELETE_STATUS='N' where USER_ID=?",nativeQuery=true)
	public int  updateStatus(Long USER_ID);

//    List<User> findByLastNameIgnoreCaseContaining(String lastName);
//
//    List<User> findByEmailIgnoreCaseContaining(String email);

    @Query("SELECT t FROM User t WHERE " +
            "LOWER(t.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(t.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    Page<User> searchByTerm(@Param("searchTerm") String searchTerm, Pageable pageable);
}
