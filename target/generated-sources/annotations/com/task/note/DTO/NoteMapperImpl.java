package com.task.note.DTO;

import com.task.note.Entity.Note;
import com.task.note.Entity.NoteLabel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T23:18:02+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class NoteMapperImpl implements NoteMapper {

    @Override
    public NoteDto toDto(Note note) {
        if ( note == null ) {
            return null;
        }

        NoteDto noteDto = new NoteDto();

        noteDto.setId( note.getId() );
        noteDto.setTitle( note.getTitle() );
        noteDto.setContent( note.getContent() );
        List<NoteLabel> list = note.getNoteLabelList();
        if ( list != null ) {
            noteDto.setNoteLabelList( new ArrayList<NoteLabel>( list ) );
        }

        return noteDto;
    }

    @Override
    public Note fromDto(NoteDto noteDto) {
        if ( noteDto == null ) {
            return null;
        }

        Note note = new Note();

        note.setId( noteDto.getId() );
        note.setTitle( noteDto.getTitle() );
        note.setContent( noteDto.getContent() );
        List<NoteLabel> list = noteDto.getNoteLabelList();
        if ( list != null ) {
            note.setNoteLabelList( new ArrayList<NoteLabel>( list ) );
        }

        return note;
    }

    @Override
    public List<NoteDto> toDtos(List<Note> notes) {
        if ( notes == null ) {
            return null;
        }

        List<NoteDto> list = new ArrayList<NoteDto>( notes.size() );
        for ( Note note : notes ) {
            list.add( toDto( note ) );
        }

        return list;
    }

    @Override
    public List<Note> fromDtos(List<NoteDto> noteDtos) {
        if ( noteDtos == null ) {
            return null;
        }

        List<Note> list = new ArrayList<Note>( noteDtos.size() );
        for ( NoteDto noteDto : noteDtos ) {
            list.add( fromDto( noteDto ) );
        }

        return list;
    }
}
