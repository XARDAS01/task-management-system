package org.example.mapper;

import org.example.api.dto.CommentDto;
import org.example.model.Comment;
import org.example.model.Employee;
import org.example.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "employee", source = "employee.id")
    CommentDto mapToDto(Comment source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "text", source = "source")
    @Mapping(target = "task", source = "task")
    @Mapping(target = "employee", source = "employee")
    Comment mapToEntity(String source, Task task, Employee employee);
}
