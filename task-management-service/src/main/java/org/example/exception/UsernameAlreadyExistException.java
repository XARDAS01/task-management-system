package org.example.exception;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistException extends TaskManagementException {

    private static final String EXCEPTION_CODE = "002";
    private static final String EXCEPTION_TITLE = "Username already exists!";
    private static final String EXCEPTION_DETAIL = "Employee account with username: %s already exists!";

    public UsernameAlreadyExistException(String username) {
        super(EXCEPTION_CODE, EXCEPTION_TITLE, String.format(EXCEPTION_DETAIL, username), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
