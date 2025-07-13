package com.timetablemaker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dept")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept {

    @Id
    @Column(name = "dept_cd", length = 255)
    private String deptCd;

    @Column(name = "dept_name", nullable = false, length = 255)
    private String deptName;

    @Column(name = "campus_cd", nullable = false, length = 255)
    private String campusCd;
}
