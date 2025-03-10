package org.example.mapper;

import org.example.model.Comment;
import org.example.model.Employee;
import org.example.model.Task;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CommentMapperTest {

    @InjectMocks
    private CommentMapperImpl commentMapper;

    @ParameterizedTest
    @InstancioSource
    void mapToDto(Comment source) {
        final var result = commentMapper.mapToDto(source);

        assertEquals(source.getText(), result.text());
        assertEquals(source.getId(), result.id());
        assertEquals(source.getCreated(), result.created());
        assertEquals(source.getEmployee().getId(), result.employee());
    }

    @ParameterizedTest
    @InstancioSource
    void mapToEntity(String source, Task task, Employee employee) {
        final var result = commentMapper.mapToEntity(source, task, employee);

        assertEquals(source, result.getText());
        assertEquals(task.getId(), result.getTask().getId());
        assertEquals(employee.getId(), result.getEmployee().getId());
    }
}