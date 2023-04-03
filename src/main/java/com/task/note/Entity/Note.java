package com.task.note.Entity;

import lombok.Data;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static com.task.note.Entity.EntityConstants.*;

@Table(name = "note")
@Entity(name = "Note")
@Data
public class Note {

    @Id
    @SequenceGenerator(
            name = "note_sequence_generator",
            sequenceName = "note_sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "note_sequence_generator"
    )
    @Column(name = NOTE_ID_PROPERTY, updatable = false)
    private Long id;

    @Column(name = NOTE_TITLE_PROPERTY, nullable = false, length = 32)
    private String title;

    @Column(name = NOTE_CONTENT_PROPERTY, nullable = false, length = 300)
    private String content;


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "note"
    )
    private List<NoteLabel> noteLabelList = new ArrayList<>();



    public Note() {
    }

    public Note(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Note(Note note) {
        if(note.getId() != null){
            this.id = note.getId();
        }
        this.title = note.getTitle();
        this.content = note.getContent();
    }

    public void addNoteLabel(NoteLabel noteLabel) {
        if(!noteLabelList.contains(noteLabel)) {
            noteLabelList.add(noteLabel);
        }
    }

}
