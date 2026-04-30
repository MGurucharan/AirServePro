package com.airservepro.airservepro.repository;

import com.airservepro.airservepro.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
