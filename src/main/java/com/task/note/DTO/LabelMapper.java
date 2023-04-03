package com.task.note.DTO;

import com.task.note.Entity.Label;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LabelMapper {

    LabelDto toDto(Label label);

    Label fromDto(LabelDto labelDto);
}
