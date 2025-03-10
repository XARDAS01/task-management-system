package org.example.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.api.request.SignInRequest;
import org.example.api.request.SignUpRequest;
import org.example.exception.UsernameAlreadyExistException;
import org.example.mapper.EmployeeMapper;
import org.example.mapper.UserInfoMapper;
import org.example.repository.EmployeeRepository;
import org.example.security.JwtService;
import org.example.security.UserDetailsServiceImpl;
import org.example.service.AuthService;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Log4j2
public class AuthServiceImpl implements AuthService {

    private final UserDetailsServiceImpl userDetailsService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;
    private final UserInfoMapper userInfoMapper;

    @NonNull
    @Override
    public String signUp(@NonNull SignUpRequest request) {
        final var userInfo = userInfoMapper.mapSignUp(request);
        userInfo.setPassword(passwordEncoder.encode(request.password()));
        final var employee = employeeMapper.mapToEntity(userInfo);

        if(employeeRepository.findUserByUsername(userInfo.getUsername()).isPresent()) {
            throw new UsernameAlreadyExistException(userInfo.getUsername());
        }

        employeeRepository.save(employee);
        log.info("New employee account registered! {}", userInfo.getUsername());

        return jwtService.generateToken(userInfo.getUsername(), userInfo.getAuthorities());
    }

    @Override
    @NonNull
    public String signIn(@NonNull SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.username(),
                request.password()
        ));

        final var user = userDetailsService.loadUserByUsername(request.username());
        log.info("Employee account login! {}", request.username());

        return jwtService.generateToken(user.getUsername(), user.getAuthorities());
    }
}
