package springboot.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.todoapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
