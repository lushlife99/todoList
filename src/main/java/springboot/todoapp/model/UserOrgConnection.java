package springboot.todoapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserOrgConnection {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    User user;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Org org;

}
