package es.kami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.kami.entity.Proyectos;

@Repository
public interface IProyectoRepository extends JpaRepository<Proyectos, Long> {
}