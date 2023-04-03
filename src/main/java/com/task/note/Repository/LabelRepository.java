package com.task.note.Repository;

import com.task.note.Entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LabelRepository extends JpaRepository<Label, Long> {

    @Query("SELECT l FROM Label l WHERE l.name = :name")
    Optional<Label> findLabelByName (@Param("name") String name);

    @Query(value = "DELETE FROM Label l WHERE l.id =:labelId AND l.id not IN" +
            " (SELECT nl.label_id FROM Note_Label nl WHERE nl.label_id = :labelId)",
    nativeQuery = true)
    void deleteLabelById(@Param("labelId") Long labelId);
}
