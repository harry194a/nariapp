package com.tmx.nari.agm.repositoy;

import com.tmx.nari.agm.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
/**
 * Created by Harutyun Badeyan
 * Date: 14.09.22
 * Time: 20:42
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    
    Optional<User> findByEmail(String email);
}
