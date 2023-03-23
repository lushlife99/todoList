package springboot.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserOrgConnection {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    User user;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    Org org;

}
