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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String userId;

    String username;

    String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<UserOrgConnection> orgList = new ArrayList<>(); // 초기화 시켜주는게 관례임. add할 때 널포인트가 안뜨게 하려고 초기화 시킴.

    public Org addOrg(){
        Org org = new Org();
        org.setName("Untitled");
        return org;
    }

}
