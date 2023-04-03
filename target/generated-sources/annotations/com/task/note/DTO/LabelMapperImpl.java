package com.task.note.DTO;

import com.task.note.Entity.Label;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-03T20:23:38+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class LabelMapperImpl implements LabelMapper {

    @Override
    public LabelDto toDto(Label label) {
        if ( label == null ) {
            return null;
        }

        LabelDto labelDto = new LabelDto();

        labelDto.setId( label.getId() );
        labelDto.setName( label.getName() );

        return labelDto;
    }

    @Override
    public Label fromDto(LabelDto labelDto) {
        if ( labelDto == null ) {
            return null;
        }

        Label label = new Label();

        label.setId( labelDto.getId() );
        label.setName( labelDto.getName() );

        return label;
    }
}
