package com.task.note.Entity;

import lombok.EqualsAndHashCode;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class NoteLabelId implements Serializable {

    @Column(name = "note_id")
    private long noteId;

    @Column(name = "label_id")
    private long labelId;


    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public NoteLabelId() {
    }

    public NoteLabelId(long noteId, long labelId) {
        this.noteId = noteId;
        this.labelId = labelId;
    }
}
