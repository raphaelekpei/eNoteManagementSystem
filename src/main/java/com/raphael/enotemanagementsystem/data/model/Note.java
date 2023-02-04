package com.raphael.enotemanagementsystem.data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
        this.createdAt = LocalDate.now();
        this.updatedAt = LocalDate.now();
    }
}
