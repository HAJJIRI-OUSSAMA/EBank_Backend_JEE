package org.oussama.ebankingback.exeption;

public class BalanceNotSufficientException extends Exception {
    public BalanceNotSufficientException(String message) {
        super(message);

    }
}
