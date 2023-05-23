package com.project_1.university.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class TeacherPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "teacherName", columnDefinition = "VARCHAR(25)")
    private String name;
    @Column(name = "teacherSurname", columnDefinition = "VARCHAR(50)")
    private String surname;
    @Column(name = "teacherEmail", columnDefinition = "VARCHAR(75)")
    private String email;

    public TeacherPojo(String firstName, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
