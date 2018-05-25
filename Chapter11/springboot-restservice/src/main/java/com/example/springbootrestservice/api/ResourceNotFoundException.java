package com.example.springbootrestservice.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {

    private static final long serialVersionUID = 1L;

  public ResourceNotFoundException() {
    this("resource not found");
  }

  public ResourceNotFoundException(String message) {

    this(message,null);
  }

  public ResourceNotFoundException(String message, Throwable cause) {

    super(message, cause);
  }
}
