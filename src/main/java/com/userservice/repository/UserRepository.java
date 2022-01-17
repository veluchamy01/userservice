/**
 * 
 */
package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.entity.User;

/**
 * @author mrvel
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(long id);

}
