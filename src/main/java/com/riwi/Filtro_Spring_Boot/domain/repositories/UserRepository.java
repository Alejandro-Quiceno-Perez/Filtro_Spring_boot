package com.riwi.Filtro_Spring_Boot.domain.repositories;

import com.riwi.Filtro_Spring_Boot.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
