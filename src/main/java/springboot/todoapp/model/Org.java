package springboot.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Org {

    @Id    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org", fetch = FetchType.EAGER)
    List<Board> board = new ArrayList<>();

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org")
    List<UserOrgConnection> connections = new ArrayList<>();

    private boolean visible = true;  //GUEST에게 보여줄 지 말지 결정.

}
