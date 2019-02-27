package es.kami.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.kami.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
