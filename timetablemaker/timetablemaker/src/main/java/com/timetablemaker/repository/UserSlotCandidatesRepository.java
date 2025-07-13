package com.timetablemaker.repository;

import com.timetablemaker.entity.UserSlotCandidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSlotCandidatesRepository extends JpaRepository<UserSlotCandidates, Long> {
}
