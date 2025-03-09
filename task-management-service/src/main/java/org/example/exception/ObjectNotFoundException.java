package org.example.exception;

import org.springframework.http.HttpStatus;

public class ObjectNotFoundException extends TaskManagementException {

    private static final String EXCEPTION_CODE = "001";
    private static final String EXCEPTION_TITLE = "Object not found!";
    private static final String EXCEPTION_DETAIL = "Object: %s not found!";

    public ObjectNotFoundException(Class clazz) {
        super(EXCEPTION_CODE, EXCEPTION_TITLE, String.format(EXCEPTION_DETAIL, clazz.getSimpleName()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
