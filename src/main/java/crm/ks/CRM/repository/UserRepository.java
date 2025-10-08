package crm.ks.CRM.repository;

import crm.ks.CRM.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findUserByUsername(String Username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
