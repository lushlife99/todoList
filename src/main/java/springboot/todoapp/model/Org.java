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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org", fetch = FetchType.EAGER, orphanRemoval = true)
    List<Board> board = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "org")
    List<UserOrgConnection> connections = new ArrayList<>();

    private boolean visible = true;  //GUEST에게 보여줄 지 말지 결정.

    public Org setOrg(Org org1){
        this.name = org1.name;
        for(int i = 0; i < board.size(); i++){
            board.get(i).setTitle(org1.getBoard().get(i).getTitle());
            for(int j =0 ; j < board.get(i).getPurpose().size(); j++){
                board.get(i).getPurpose().get(j).setTitle(org1.getBoard().get(i).getPurpose().get(j).getTitle());
                board.get(i).getPurpose().get(j).setContext(org1.getBoard().get(i).getPurpose().get(j).getContext());
            }
        }
        return this;
    }
}
