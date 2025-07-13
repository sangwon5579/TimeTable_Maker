package com.timetablemaker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "subject")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {

    @Id
    @Column(name = "subject_cd", length = 255)
    private String subjectCd;

    @Column(name = "subject_name", nullable = false, length = 255)
    private String subjectName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_cd", nullable = false)
    private Dept dept;

    @Column(nullable = false)
    private Integer credit;
}
