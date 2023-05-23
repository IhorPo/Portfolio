package com.project_1.university.models;

import com.project_1.university.enums.Group;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Student")
public class StudentPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "studentName", columnDefinition = "VARCHAR(25)")
    private String name;
    @Column(name = "studentSurname", columnDefinition = "VARCHAR(50)")
    private String surname;
    @Column(name = "studentEmail", columnDefinition = "VARCHAR(75)")
    private String email;
    @Enumerated(EnumType.STRING)
    private Group studentGroup;

    public StudentPojo(String name, String surname, String email, Group studentGroup) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.studentGroup = studentGroup;
    }
}
