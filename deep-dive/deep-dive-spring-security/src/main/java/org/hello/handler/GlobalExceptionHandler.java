package org.hello.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice()
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(HttpServletRequest req, Exception exception) {
        return ResponseEntity.internalServerError().body(exception.getMessage());
    }

    @ExceptionHandler({
            AccessDeniedException.class,
            AuthenticationException.class
    })
    public ResponseEntity<Object> handleAuthException(HttpServletRequest req, Exception exception) {
        if (exception instanceof AccessDeniedException accessDeniedException) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(accessDeniedException.getMessage());
        }
        if (exception instanceof AuthenticationException authenticationException) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationException.getMessage());
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
    }
}
