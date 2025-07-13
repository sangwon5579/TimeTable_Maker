package com.timetablemaker.repository;

import com.timetablemaker.entity.Dept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, String> {
}
