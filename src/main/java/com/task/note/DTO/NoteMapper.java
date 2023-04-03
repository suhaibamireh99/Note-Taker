package com.task.note.DTO;

import com.task.note.Entity.Note;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteMapper {


    NoteDto toDto(Note note);

    Note fromDto(NoteDto noteDto);

    List<NoteDto> toDtos(List<Note> notes);

    List<Note> fromDtos(List<NoteDto> noteDtos);
}
