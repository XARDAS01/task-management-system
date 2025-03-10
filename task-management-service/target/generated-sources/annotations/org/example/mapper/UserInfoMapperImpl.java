package org.example.mapper;

import javax.annotation.processing.Generated;
import org.example.api.request.SignUpRequest;
import org.example.model.UserInfo;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-10T13:44:19+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class UserInfoMapperImpl implements UserInfoMapper {

    @Override
    public UserInfo mapSignUp(SignUpRequest source) {
        if ( source == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setUsername( source.username() );
        userInfo.setPassword( source.password() );
        userInfo.setRole( source.role() );

        userInfo.setAccountNonExpired( true );
        userInfo.setAccountNonLocked( true );
        userInfo.setCredentialsNonExpired( true );
        userInfo.setEnabled( true );

        return userInfo;
    }
}
