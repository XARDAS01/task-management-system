package org.example.mapper;

import org.example.api.request.SignUpRequest;
import org.instancio.junit.InstancioSource;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserInfoMapperTest {

    @InjectMocks
    private UserInfoMapperImpl userInfoMapper;

    @ParameterizedTest
    @InstancioSource
    void mapToDto(SignUpRequest source) {
        final var result = userInfoMapper.mapSignUp(source);

        assertEquals(source.password(), result.getPassword());
        assertEquals(source.role(), result.getRole());
        assertEquals(source.username(), result.getUsername());
    }
}
