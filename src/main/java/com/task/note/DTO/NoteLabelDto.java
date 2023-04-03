package com.task.note.DTO;

import com.task.note.Entity.Label;
import com.task.note.Entity.Note;
import com.task.note.Entity.NoteLabelId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoteLabelDto {

    private NoteLabelId noteLabelId;

    private Note note;

    private Label label;

    public NoteLabelDto() {
    }

    public NoteLabelDto(Note note, Label label) {
        this.note = note;
        this.label = label;
    }
}
