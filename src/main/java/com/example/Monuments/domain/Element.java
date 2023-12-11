package com.example.Monuments.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int type;
    private String material = null;
    private String name;
    private String info;
    private int price;
    private String res;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idelement")
    private List<Task> taskList;

}
