package springboot.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.todoapp.model.Purpose;

public interface PurposeRepository extends JpaRepository<Purpose, Long> {
}
