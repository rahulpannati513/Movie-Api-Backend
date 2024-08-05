package com.rahul.movieapibackend.Exceptions;

public class FileExistsException extends Exception{
    public FileExistsException(String message) {
        super(message);
    }
}
