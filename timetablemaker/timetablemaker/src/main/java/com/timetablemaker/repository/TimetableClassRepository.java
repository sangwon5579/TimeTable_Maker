package com.timetablemaker.repository;

import com.timetablemaker.entity.TimetableClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableClassRepository extends JpaRepository<TimetableClass, Long> {
}
