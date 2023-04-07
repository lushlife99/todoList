package springboot.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.todoapp.model.Org;

public interface OrgRepository extends JpaRepository<Org, Long> {
}
