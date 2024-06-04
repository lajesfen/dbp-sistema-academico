package edu.utec.sistemacad.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String dni;

    private Date date_born;

    private String email;

    private String address;

    private String phone;

    private String carreer;

    private String avatar_url;

    private String program;

    private String entry_period;

    private float weighted_average;
    
    private int merit_order;

    private int carreer_merit_order;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"students"})
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"student"})
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties({"student"})
    @JsonIgnore
    private List<Grade> grades = new ArrayList<>();
}
