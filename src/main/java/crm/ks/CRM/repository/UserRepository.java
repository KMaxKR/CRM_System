package crm.ks.CRM.repository;

import crm.ks.CRM.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String Username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
