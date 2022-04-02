package com.crud_app.spring.structure;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roll")
    private Integer roll;

    @Column(name = "first")
    private String first;

    @Column(name = "last")
    private String last;

    @Column(name = "class")
    private Integer clas;

    @Column(name = "grade")
    private String grade;

    @Column(name = "divi")
    private String divi;
}
