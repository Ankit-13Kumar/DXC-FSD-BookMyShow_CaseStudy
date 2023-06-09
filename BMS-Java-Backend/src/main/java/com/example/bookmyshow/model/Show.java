package com.example.bookmyshow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "shows", uniqueConstraints={@UniqueConstraint(columnNames={"date","theater_id","startTime"})})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Show {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="show_seq")
    @SequenceGenerator(name = "show_seq", sequenceName = "show_seq", initialValue = 1, allocationSize=1)
    private Long id;

    private LocalDate date;

    private LocalTime startTime;

    @OneToOne(orphanRemoval = true, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "theater_id")
    private Theater theater;



}