package com.task.note.Entity;

import lombok.Data;

import javax.persistence.*;


import static com.task.note.Entity.EntityConstants.*;

@Table(name = "label")
@Entity(name = "Label")
@Data
public class Label {

    @Id
    @SequenceGenerator(
            name = "label_sequence_generator",
            sequenceName = "label_sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "label_sequence_generator"
    )
    @Column(name = LABEL_ID_PROPERTY, updatable = false)
    private Long id;

    @Column(name = LABEL_NAME_PROPERTY, nullable = false, length = 32)
    private String name;


    public Label() {
    }

    public Label(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Label(String name) {
        this.name = name;
    }

    public Label(Label label){
        this.name = label.getName();
    }

}
