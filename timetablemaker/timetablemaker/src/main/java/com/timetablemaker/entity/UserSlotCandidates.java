package com.timetablemaker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_slot_candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSlotCandidates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", nullable = false)
    private UserSelectionSlot userSelectionSlot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id", nullable = false)
    private SubjectClass subjectClass;
}
