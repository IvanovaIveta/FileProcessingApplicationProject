package com.company;

public class EmptyFileException extends Exception {

    public EmptyFileException(){
        super();
    }

    public String getMessage() {
        return "The file is empty!";
    }
}