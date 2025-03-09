package org.example.mapper;

import org.example.api.dto.TaskDto;
import org.example.api.request.CreateTaskRequest;
import org.example.model.Employee;
import org.example.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Mapper(componentModel = "spring", uses = {CommentMapper.class})
public interface TaskMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assignees", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "status", constant = "TODO")
    @Mapping(target = "assigner", source = "employee")
    @Mapping(target = "title", source = "source.title")
    @Mapping(target = "description", source = "source.description")
    @Mapping(target = "comment", source = "source.comment")
    @Mapping(target = "priority", source = "source.priority")
    Task mapToEntity(CreateTaskRequest source, Employee employee);

    @Mapping(target = "assigner", source = "assigner.id")
    @Mapping(target = "assignees", source = "assignees")
    TaskDto mapToDto(Task source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "assigner", ignore = true)
    @Mapping(target = "assignees", ignore = true)
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "comments", ignore = true)
    void update(@MappingTarget Task target, TaskDto source);

    default List<UUID> assigneesToUuid(Set<Employee> assignees) {
        return assignees.stream().map(Employee::getId).toList();
    }
}
