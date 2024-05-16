package com.demo.smart_contact_manager.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForm {

  @NotBlank(message = "Name is required")
  @Size(min = 3, message = "Name must be at least 3 Characters long")
  private String name;

  @NotBlank(message = "Email is required")
  @Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email")
  private String email;

  @NotBlank(message = "Password is required")
  @Size(min = 3, message = "Password must be at least 3 Characters long")
  private String password;

  @NotBlank(message = "Phone is required")
  @Pattern(regexp = "^[6-9]\\\\d{9}$", message = "Invalid Phone Number")
  private String phone;

  @NotBlank(message = "About is required")
  private String about;

}
