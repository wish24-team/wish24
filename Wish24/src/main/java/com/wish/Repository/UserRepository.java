
package com.wish.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wish.Model.User;


/**
 * @author Akash.Kushwah
 * @version 1.0.0.0
 */
public interface UserRepository extends JpaRepository<User,String>{

	User findByPhoneNumber(String userName);

	User findByEmail(String userName);

}
