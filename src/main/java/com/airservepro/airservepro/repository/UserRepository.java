package com.airservepro.airservepro.repository;

import com.airservepro.airservepro.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
}
