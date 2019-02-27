package es.kami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.kami.entity.Tipo;

@Repository
public interface ITipoRepository extends JpaRepository<Tipo, Long> {
}
