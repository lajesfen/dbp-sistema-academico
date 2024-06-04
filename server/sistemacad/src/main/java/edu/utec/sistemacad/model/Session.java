package edu.utec.sistemacad.model;

import java.util.Date;

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
@Table(name = "session")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date start_time;

    private Date end_time;

    private String type;

    private String url;
    
    private String classroom;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
}

