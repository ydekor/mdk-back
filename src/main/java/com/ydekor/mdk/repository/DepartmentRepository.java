package com.ydekor.mdk.repository;

import com.ydekor.mdk.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
