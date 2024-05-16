package com.demo.smart_contact_manager.exceptions;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException ( String message ) {
    super(message);
  }
}
