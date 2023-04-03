package com.task.note.Repository;

import com.task.note.Entity.NoteLabel;
import com.task.note.Entity.NoteLabelId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NoteLabelRepository extends JpaRepository<NoteLabel, NoteLabelId> {

    @Query("SELECT DISTINCT n from Note_Label n where LOWER(n.note.title) LIKE LOWER(CONCAT('%', :textSearch, '%')) " +
            "or LOWER(n.note.content) LIKE LOWER(CONCAT('%',:textSearch,'%'))" +
            "or LOWER(n.label.name) LIKE LOWER(CONCAT('%',:textSearch,'%') )"
    )
    Page findAllBasedSearch(Pageable pageable,
                            @Param("textSearch") String textSearch);
}
