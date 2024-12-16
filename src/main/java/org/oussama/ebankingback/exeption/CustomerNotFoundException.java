package org.oussama.ebankingback.exeption;

// exception Metier
// exception non surveiller
public class CustomerNotFoundException extends Exception {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
