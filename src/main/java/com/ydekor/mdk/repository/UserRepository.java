package com.ydekor.mdk.repository;

import com.ydekor.mdk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
