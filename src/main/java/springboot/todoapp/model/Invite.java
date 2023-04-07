package springboot.todoapp.model;


import jakarta.persistence.*;
import lombok.Data;
import springboot.todoapp.dto.InviteDto;

@Data
@Entity
public class Invite {
    @Id @GeneratedValue
    private Long id;

    @OneToOne private User invitor;
    @OneToOne private User participant;
    @OneToOne private Org org;


}
