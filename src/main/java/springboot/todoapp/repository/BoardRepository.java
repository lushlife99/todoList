package springboot.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.todoapp.model.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
