package com.task.note.Controller;

import com.task.note.DTO.NoteDto;
import com.task.note.Services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/notes")
    public List<NoteDto> getNotes() {
        return noteService.getNotes();
    }

    @GetMapping("/note/{noteId}")
    @PreAuthorize("hasRole('USER')")
    public NoteDto getNoteById(@PathVariable("noteId") Long noteId) {
        return noteService.findNoteById(noteId);
    }

    @PostMapping("/note")
    @PreAuthorize("hasRole('USER')")
    public void saveNote(@RequestBody NoteDto noteDto) {
        noteService.saveNote(noteDto);
    }

    @DeleteMapping("{noteId}")
    @PreAuthorize("hasRole('USER')")
    public void deleteNote(@PathVariable("noteId") Long noteId) {
        noteService.deleteNote(noteId);
    }


    @GetMapping("/notes/pageData")
    @PreAuthorize("hasRole('USER')")
    public Page getPageNotes(@RequestParam int page, @RequestParam int size,
                             @RequestParam(required = false) String searchTitle) {

        Pageable paging = PageRequest.of(page, size);
        if (StringUtils.hasLength(searchTitle)){
            return noteService.findPageNoteLabel(paging, searchTitle);
        }else{
            return noteService.findPageNoteLabel(paging);
        }
    }
}
