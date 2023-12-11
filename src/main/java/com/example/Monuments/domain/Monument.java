package com.example.Monuments.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Monument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private int type;
    private String name;
    private String price;
    private String res;

}
