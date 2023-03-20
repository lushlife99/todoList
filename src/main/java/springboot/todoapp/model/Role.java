package springboot.todoapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @ElementCollection
    @CollectionTable(name = "org_role_list",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "org_id")
    @Column(name = "roletype")
    @Enumerated(EnumType.STRING)
    private Map<Long, ROLETYPE> roleList;


    public Map<Long, ROLETYPE> promoteRole(Long id){
        roleList.put(id, ROLETYPE.ADMIN);
        return roleList;
    }

    public Map<Long, ROLETYPE> deleteUser(Long id){
        roleList.remove(id);
        return roleList;
    }

}
