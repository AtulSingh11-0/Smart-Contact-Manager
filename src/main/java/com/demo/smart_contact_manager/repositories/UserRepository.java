package com.demo.smart_contact_manager.repositories;

import com.demo.smart_contact_manager.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository< User, Integer> {
  Optional< User> findByEmail ( String email );
}
