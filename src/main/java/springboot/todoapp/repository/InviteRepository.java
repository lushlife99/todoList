package springboot.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.todoapp.model.Invite;
import springboot.todoapp.model.User;

import java.util.Optional;

public interface InviteRepository extends JpaRepository<Invite, Long> {
    Optional<Invite> findByParticipant(User participant);
}
