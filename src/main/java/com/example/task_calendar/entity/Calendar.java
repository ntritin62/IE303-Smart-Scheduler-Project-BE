package com.example.task_calendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "calendar")
@Data
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "color")
    private String color;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("calendars")
    private User user;
}
