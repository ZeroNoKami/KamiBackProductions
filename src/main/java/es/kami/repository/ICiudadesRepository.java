package es.kami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.kami.entity.Ciudades;

@Repository
public interface ICiudadesRepository extends JpaRepository<Ciudades, Long> {
}