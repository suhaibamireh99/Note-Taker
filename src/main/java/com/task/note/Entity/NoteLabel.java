package com.task.note.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "note_label")
@Entity(name = "Note_Label")
@Getter
@Setter
public class NoteLabel {

    @EmbeddedId
    private NoteLabelId noteLabelId = new NoteLabelId();


    @JsonIgnore
    @ManyToOne
    @MapsId("noteId")
    @JoinColumn(
            name = "note_id",
            foreignKey = @ForeignKey(
                    name = "note_id_fk"
            )
    )
    private Note note;

    @ManyToOne
    @MapsId("labelId")
    @JoinColumn(
            name = "label_id",
            foreignKey = @ForeignKey(
                    name = "note_label_fk"
            )
    )
    private Label label;

    public NoteLabel() {
    }

    public NoteLabel(Note note, Label label) {
        if (note.getId() != null){
            this.noteLabelId.setNoteId(note.getId());
        }
        if (label.getId() != null){
            this.noteLabelId.setLabelId(label.getId());
        }
        this.note = note;
        this.label = label;
    }

    public NoteLabel(NoteLabelId noteLabelId, Note note, Label label) {
        this.noteLabelId = noteLabelId;
        this.note = note;
        this.label = label;
    }

}
