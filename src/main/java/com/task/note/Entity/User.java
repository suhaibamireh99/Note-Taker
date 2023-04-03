package com.task.note.Entity;

import lombok.Data;
import javax.persistence.*;


import static com.task.note.Entity.EntityConstants.*;

@Table(name = "users")
@Entity(name = "User")
@Data
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence_generator",
            sequenceName = "user_sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence_generator"
    )
    @Column(name = USER_ID_PROPERTY, updatable = false)
    private Long id;

    @Column(name = USER_NAME_PROPERTY, nullable = false, length = 32)
    private String name;

    @Column(name = USER_SURNAME_PROPERTY, nullable = false, length = 32)
    private String surName;

    @Column(name = "user_pass", nullable = false, length = 130)
    private String password;

    public User() {
    }

    public User(Long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public User(String name, String surName, String password) {
        this.name = name;
        this.surName = surName;
        this.password = password;
    }
}
