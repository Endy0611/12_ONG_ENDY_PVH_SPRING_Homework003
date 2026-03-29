package com.example._2_ong_endy_pvh_spring_homework003.exception;

public class DuplicateUserException extends RuntimeException{
    public DuplicateUserException() {
    }

    public DuplicateUserException(String message) {
        super(message);
    }
}
