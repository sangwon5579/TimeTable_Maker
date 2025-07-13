package com.timetablemaker.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Table(name = "subject_class")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Long classId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_cd", nullable = false)
    private Subject subject;

    @Column(name = "section_no", nullable = false, length = 255)
    private String sectionNo;

    @Column(name = "prof_name", length = 255)
    private String profName;

    @Column(name = "lang_type", nullable = false, length = 255)
    private String langType;

    @Column(name = "class_type", nullable = false, length = 255)
    private String classType;

    @Column(name = "day_of_week", nullable = false, length = 255)
    private String dayOfWeek;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalTime endTime;

    @Column(length = 255)
    private String room;
}
