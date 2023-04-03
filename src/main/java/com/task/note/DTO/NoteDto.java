package com.task.note.DTO;

import com.task.note.Entity.NoteLabel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NoteDto {

    private Long id;

    private String title;

    private String content;

    private String labelName;

    private List<NoteLabel> noteLabelList;

    public NoteDto(String title, String content, String labelName) {
        this.title = title;
        this.content = content;
        this.labelName = labelName;
    }

    public NoteDto() {
    }
}
