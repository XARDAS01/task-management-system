package org.example.mapper;

import org.example.model.Employee;
import org.example.model.UserInfo;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class EmployeeMapperTest {

    @Mock
    private TaskMapperImpl taskMapper;

    @Mock
    private CommentMapper commentMapper;

    @InjectMocks
    private EmployeeMapperImpl employeeMapper;

    @ParameterizedTest
    @InstancioSource
    void mapToDto(Employee source) {
        final var result = employeeMapper.mapToDto(source);

        assertEquals(source.getId(), result.id());
        assertEquals(source.getCreated(), result.created());

        assertEquals(source.getUserInfo().getRole(), result.userInfo().role());
        assertEquals(source.getUserInfo().getUsername(), result.userInfo().username());
    }

    @ParameterizedTest
    @InstancioSource
    void mapToEntity(UserInfo source) {
        final var result = employeeMapper.mapToEntity(source);

        assertEquals(source.getUsername(), result.getUserInfo().getUsername());
        assertEquals(source.getRole(), result.getUserInfo().getRole());
    }
}
