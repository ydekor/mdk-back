package com.ydekor.mdk.service;

import com.ydekor.mdk.model.Department;
import com.ydekor.mdk.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department create(Department department) {
        if (department.getId() != null) {
            throw new RuntimeException("id is not allowed here");
        }
        return departmentRepository.save(department);
    }

    public Department update(Department department) {
        if (department.getId() == null) {
            throw new RuntimeException("id is required");
        }
        return departmentRepository.save(department);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }
}
