package org.example.mapper;

import org.example.api.dto.EmployeeDto;
import org.example.model.Employee;
import org.example.model.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {TaskMapper.class, CommentMapper.class})
public interface EmployeeMapper {

    EmployeeDto mapToDto(Employee source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tasksAssignedByMe", ignore = true)
    @Mapping(target = "tasksAssignedToMe", ignore = true)
    @Mapping(target = "commentsWrittenByMe", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "userInfo", source = "source")
    Employee mapToEntity(UserInfo source);
}
