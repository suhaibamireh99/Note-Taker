package com.task.note.DTO;

import com.task.note.Entity.NoteLabel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface NoteLabelMapper {

    NoteLabelDto toDto(NoteLabel noteLabel);

    NoteLabel fromDto(NoteLabelDto noteLabelDto);

}
