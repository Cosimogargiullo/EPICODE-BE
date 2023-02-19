package it.epicode.be.week6Day4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import it.epicode.be.week6Day4.models.Role;
import it.epicode.be.week6Day4.models.User;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
