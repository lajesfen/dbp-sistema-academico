package edu.utec.sistemacad.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private float amount;

    private String description;

    private Date due_date;

    private boolean debt;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
