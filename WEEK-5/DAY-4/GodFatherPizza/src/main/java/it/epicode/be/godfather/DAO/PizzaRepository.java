package it.epicode.be.godfather.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.epicode.be.godfather.model.PizzaBase;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaBase, Integer> {

}
