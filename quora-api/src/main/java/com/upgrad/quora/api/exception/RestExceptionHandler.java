package com.upgrad.quora.api.exception;

import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> SignUpRestrictedException(SignUpRestrictedException exc, WebRequest request){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(exc.getCode()).message(exc.getErrorMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<ErrorResponse> AuthenticationFailedException(AuthenticationFailedException afe, WebRequest request){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(afe.getCode()).message(afe.getErrorMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> UserNotFoundException(UserNotFoundException sre, WebRequest request){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(sre.getCode()).message(sre.getErrorMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(AuthorizationFailedException.class)
    public ResponseEntity<ErrorResponse> AuthorizationFailedException(AuthorizationFailedException sre, WebRequest request){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(sre.getCode()).message(sre.getErrorMessage()), HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(SignOutRestrictedException.class)
    public ResponseEntity<ErrorResponse> SignOutRestrictedException(SignOutRestrictedException sre, WebRequest request){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(sre.getCode()).message(sre.getErrorMessage()), HttpStatus.UNAUTHORIZED);
    }
}
