package springboot.todoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import springboot.todoapp.repository.PurposeRepository;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "org")
    @JsonIgnore
    private Org org;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Purpose> purpose = new ArrayList<>();


}

/*
    유저와 단체는 many to many.
    단체와 보드는 one to many
    단체에는 역할이 있음.
    보드와 목적은 one to many
 */