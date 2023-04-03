package com.task.note.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LabelDto {
    private Long id;

    private String name;

    public LabelDto(String name) {
        this.name = name;
    }

    public LabelDto() {
    }
}
