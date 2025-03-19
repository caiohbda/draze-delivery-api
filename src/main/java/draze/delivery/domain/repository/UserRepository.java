package draze.delivery.domain.repository;

import draze.delivery.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
=======
public class UserRepository{
>>>>>>> 22d5989361137606581ffead2a83868f70251403
}
