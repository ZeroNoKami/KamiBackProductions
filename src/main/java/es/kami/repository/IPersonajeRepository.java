package es.kami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.kami.entity.Personajes;

@Repository
public interface IPersonajeRepository extends JpaRepository<Personajes, Long> {
	

}
