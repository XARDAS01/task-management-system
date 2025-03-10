package org.example.mapper;

import org.example.api.request.CreateTaskRequest;
import org.example.model.Employee;
import org.example.model.Task;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @Mock
    private CommentMapper commentMapper;

    @InjectMocks
    private TaskMapperImpl taskMapper;

    @ParameterizedTest
    @InstancioSource
    void mapToDto(Task source) {
        final var result = taskMapper.mapToDto(source);

        assertEquals(source.getId(), result.id());
        assertEquals(source.getCreated(), result.created());
        assertEquals(source.getPriority(), result.priority());
        assertEquals(source.getStatus(), result.status());
        assertEquals(source.getDescription(), result.description());
        assertEquals(source.getTitle(), result.title());
        assertEquals(source.getComment(), result.comment());
    }

    @ParameterizedTest
    @InstancioSource
    void mapToDto(CreateTaskRequest source, Employee employee) {
        final var result = taskMapper.mapToEntity(source, employee);

        assertEquals(source.title(), result.getTitle());
        assertEquals(source.description(), result.getDescription());
        assertEquals(source.comment(), result.getComment());
        assertEquals(source.priority(), result.getPriority());
    }
}
