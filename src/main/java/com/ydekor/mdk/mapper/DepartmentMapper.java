package com.ydekor.mdk.mapper;

import com.ydekor.mdk.dto.DepartmentDTO;
import com.ydekor.mdk.model.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface DepartmentMapper extends BaseMapper<Department, DepartmentDTO> {


}
