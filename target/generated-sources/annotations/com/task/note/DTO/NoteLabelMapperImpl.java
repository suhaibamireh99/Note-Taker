package com.task.note.DTO;

import com.task.note.Entity.NoteLabel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T23:18:02+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
@Component
public class NoteLabelMapperImpl implements NoteLabelMapper {

    @Override
    public NoteLabelDto toDto(NoteLabel noteLabel) {
        if ( noteLabel == null ) {
            return null;
        }

        NoteLabelDto noteLabelDto = new NoteLabelDto();

        noteLabelDto.setNoteLabelId( noteLabel.getNoteLabelId() );
        noteLabelDto.setNote( noteLabel.getNote() );
        noteLabelDto.setLabel( noteLabel.getLabel() );

        return noteLabelDto;
    }

    @Override
    public NoteLabel fromDto(NoteLabelDto noteLabelDto) {
        if ( noteLabelDto == null ) {
            return null;
        }

        NoteLabel noteLabel = new NoteLabel();

        noteLabel.setNoteLabelId( noteLabelDto.getNoteLabelId() );
        noteLabel.setNote( noteLabelDto.getNote() );
        noteLabel.setLabel( noteLabelDto.getLabel() );

        return noteLabel;
    }
}
