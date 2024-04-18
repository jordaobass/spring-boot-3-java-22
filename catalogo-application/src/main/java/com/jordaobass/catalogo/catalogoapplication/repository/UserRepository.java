package com.jordaobass.catalogo.catalogoapplication.repository;

import java.util.Optional;

import com.jordaobass.catalogo.catalogoapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
}
