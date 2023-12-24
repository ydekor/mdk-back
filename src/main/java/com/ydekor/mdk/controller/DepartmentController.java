package com.ydekor.mdk.controller;

import com.ydekor.mdk.model.Department;
import com.ydekor.mdk.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RestController // аннотация
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        departmentService.delete(id);
        return "record id " + id + " deleted success";
    }

    @PutMapping
    public Department updateRecord(@RequestBody Department department) {
        return departmentService.update(department);
    }

    @PostMapping
    public Department createRecord(@RequestBody Department department) {
        return departmentService.create(department);
    }

    @GetMapping // обработка get запросов
    public List<Department> getAll() {
        return departmentService.getAll();
    }
}
