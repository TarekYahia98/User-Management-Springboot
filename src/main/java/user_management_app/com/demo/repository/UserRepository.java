package user_management_app.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user_management_app.com.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
