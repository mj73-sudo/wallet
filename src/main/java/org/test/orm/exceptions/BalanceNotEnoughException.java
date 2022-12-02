package org.test.orm.exceptions;

public class BalanceNotEnoughException extends RuntimeException {
    public BalanceNotEnoughException(String message) {
        super(message);
    }
}
