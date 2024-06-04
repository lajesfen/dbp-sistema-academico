package edu.utec.sistemacad.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String dni;

    private Date date_born;

    private String email;

    private String avatar_url;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Section> sections = new ArrayList<>();
}
