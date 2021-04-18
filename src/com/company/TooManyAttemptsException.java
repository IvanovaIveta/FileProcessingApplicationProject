package com.company;

public class TooManyAttemptsException extends Exception{

    public TooManyAttemptsException(){
        super();
    }

    public String getMessage() {
        return "Sorry.You have no more attempts allowed.";
    }
}
