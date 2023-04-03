package com.task.note.Services;

import com.task.note.DTO.*;
import com.task.note.Entity.Label;
import com.task.note.Entity.Note;
import com.task.note.Entity.NoteLabel;
import com.task.note.Repository.LabelRepository;
import com.task.note.Repository.NoteLabelRepository;
import com.task.note.Repository.NoteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private LabelRepository labelRepository;

    @Autowired
    private NoteLabelRepository noteLabelRepository;

    @Autowired
    private NoteMapper noteMapper;

    @Autowired
    private NoteLabelMapper noteLabelMapper;



    public List<NoteDto> getNotes() {
        log.info("Executing getNotes");
        noteRepository.findAll();
        return noteMapper.toDtos(noteRepository.findAll());
    }

    public NoteDto findNoteById(Long noteId){
        log.info("Executing findNoteById");
        NoteDto dto = noteMapper.toDto(noteRepository.findById(noteId).orElseThrow(() ->
                new UsernameNotFoundException(String.format("note with %s not found",noteId))));
        if (dto.getNoteLabelList().size()>0){
            dto.setLabelName(dto.getNoteLabelList().get(0).getLabel().getName());
        }
        return dto;
    }

    public void saveNote(NoteDto noteDto) {
        log.info("Executing saveNotes");
        noteRepository.saveAndFlush(saveNoteLogic(noteDto));
    }

    public void deleteNote(Long noteId) {
        log.info("Executing deleteNote");
        deleteLogic(noteId);
    }

    private void deleteLogic(Long noteId) {
        NoteDto note = findNoteById(noteId);
        List<Long> labelIds = new ArrayList<>();
        for(NoteLabel noteLabel: note.getNoteLabelList()){
            labelIds.add(noteLabel.getNoteLabelId().getLabelId());
        }
        noteRepository.deleteById(noteId);
        try {
            labelIds.forEach(id -> labelRepository.deleteLabelById(id));
        }catch (Exception e){
            log.error("label deletion error");
        }
    }


    public Page<NoteLabelDto> findPageNoteLabel(Pageable pageable){
        Page<NoteLabel> noteEntities = noteLabelRepository.findAll(pageable);
        return getNoteLabelDtos(noteEntities);
    }

    public Page<NoteLabelDto> findPageNoteLabel(Pageable pageable, String searchText){
        Page<NoteLabel> noteLabels = noteLabelRepository.findAllBasedSearch(pageable,searchText);
        return getNoteLabelDtos(noteLabels);
    }

    private Page<NoteLabelDto> getNoteLabelDtos(Page<NoteLabel> noteLabels) {
        List<NoteLabelDto> noteLabelDtos = new ArrayList<>();
        for (NoteLabel noteEntity: noteLabels.getContent()){
            NoteLabelDto noteLabelDto =  noteLabelMapper.toDto(noteEntity);
            noteLabelDtos.add(noteLabelDto);
        }
        Page<NoteLabelDto> pageNoteLabelDtos = new PageImpl<>(noteLabelDtos);
        log.info("the data [{}]", pageNoteLabelDtos.getContent());

        return pageNoteLabelDtos;
    }

    private Note saveNoteLogic(NoteDto noteDto) {
        if (noteDto.getLabelName() != null){
            Optional<Label> fetchedLabel = labelRepository.findLabelByName(noteDto.getLabelName());
            if (fetchedLabel.isEmpty()) {
                Note note = noteMapper.fromDto(noteDto);
                Label label =  labelRepository.saveAndFlush(new Label(noteDto.getLabelName()));

                note.addNoteLabel(new NoteLabel(note, label));
                return note;
            }else {
                    Note note = noteMapper.fromDto(noteDto);
                    note.setNoteLabelList(new ArrayList<>());
                    note.addNoteLabel(new NoteLabel(note, fetchedLabel.get()));
                    return note;
            }
        }else {
            return new Note(noteMapper.fromDto(noteDto));
        }
    }
}
