package com.timetablemaker.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Table(name = "user_option")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_option_id")
    private Long userOptionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "avoid_days", length = 255)
    private String avoidDays;

    @Column(name = "max_gap_time")
    private Integer maxGapTime;

    @Column(name = "preferred_days_off", length = 255)
    private String preferredDaysOff;

    @Column(name = "avoid_time_start")
    private LocalTime avoidTimeStart;

    @Column(name = "avoid_time_end")
    private LocalTime avoidTimeEnd;

    @Column(name = "prefer_online")
    private Boolean preferOnline;
}
