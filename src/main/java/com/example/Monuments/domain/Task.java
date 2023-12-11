package com.example.Monuments.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Task {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "idelement")
    private int idelement;

    @Column(name = "phonenumber")
    private String phone_number;

    @Column(name = "allname")
    private String all_name;

    @Column(name = "moreinfo")
    private String more_info;

    @Column(name = "datecreate")
    private String date_create;

    @Column(name = "statussee")
    private boolean status_see;

    @Column(name = "statusdone")
    private boolean status_done;

    @Column(name="laststatusupdate")
    private String last_status_update;

    @OneToOne
    @JoinColumn(name = "idelement",insertable = false,updatable = false)
    private Element element = null;


}
