package com.ydekor.mdk.controller;

import com.ydekor.mdk.dto.DepartmentDTO;
import com.ydekor.mdk.mapper.DepartmentMapper;
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
    private final DepartmentMapper departmentMapper;


    @DeleteMapping("/{id}")
    public String deleteRecord(@PathVariable Long id) {
        departmentService.delete(id);
        return "record id " + id + " deleted success";
    }

    @PutMapping
    public DepartmentDTO updateRecord(@RequestBody DepartmentDTO departmentDTO) {
        return departmentMapper.sourceToDto(departmentService.update(departmentMapper.dtoToSource(departmentDTO)));
    }

    @PostMapping
    public DepartmentDTO createRecord(@RequestBody DepartmentDTO departmentDTO) {
        return departmentMapper.sourceToDto(departmentService.create(departmentMapper.dtoToSource(departmentDTO)));
    }

    @GetMapping // обработка get запросов
    public List<DepartmentDTO> getAll() {
        return departmentMapper.sourcesToDtos(departmentService.getAll());
    }
}
