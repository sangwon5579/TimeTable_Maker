package com.timetablemaker.repository;

import com.timetablemaker.entity.UserOption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserOptionRepository extends JpaRepository<UserOption, Long> {
}
