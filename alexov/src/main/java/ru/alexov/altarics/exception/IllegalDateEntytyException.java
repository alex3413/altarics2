package ru.alexov.altarics.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code =HttpStatus.BAD_REQUEST, reason= "Illegal date of entyty parametr exception")
public class IllegalDateEntytyException extends RuntimeException {

}
