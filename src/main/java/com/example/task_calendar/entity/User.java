package com.example.task_calendar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String userName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    @JsonIgnore
    private String password;



    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Calendar> calendars;

    public void add(Calendar tempCalendar) {
        if(calendars == null) {
            calendars = new ArrayList<>();
        }

        calendars.add(tempCalendar);

        tempCalendar.setUser(this);
    }

    public void remove(Calendar tempCalendar) {
        calendars.remove(tempCalendar);
    }
}
