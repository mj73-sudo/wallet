package org.test.orm.exceptions;

public class InvalidUsernamePasswordException extends RuntimeException {
    public InvalidUsernamePasswordException(String message) {
        super(message);
    }
}
