package com.zesty.reactspringbootbackend.db;

import com.zesty.reactspringbootbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
