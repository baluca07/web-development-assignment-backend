package hu.unideb.web_assingnment.data.repositories;

import hu.unideb.web_assingnment.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
