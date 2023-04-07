package springboot.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.todoapp.model.UserOrgConnection;

public interface UserOrgConnectionRepository extends JpaRepository<UserOrgConnection, Long> {
}
