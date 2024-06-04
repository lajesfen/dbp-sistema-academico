package edu.utec.sistemacad.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    private String id;

    private String name;

    private String area;

    private String program;

    private int level;

    private int credits;

    @OneToMany(mappedBy = "course", cascade = CascadeType.PERSIST)
    private List<Section> sections = new ArrayList<>();

    @OneToMany(mappedBy = "course")
    @JsonIgnoreProperties({"course"})
    @JsonIgnore
    private List<Grade> grades = new ArrayList<>();
}