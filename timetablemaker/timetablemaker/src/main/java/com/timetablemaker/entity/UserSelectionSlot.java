package com.timetablemaker.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_selection_slot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSelectionSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private Long slotId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "slot_no", nullable = false)
    private Integer slotNo;
}
