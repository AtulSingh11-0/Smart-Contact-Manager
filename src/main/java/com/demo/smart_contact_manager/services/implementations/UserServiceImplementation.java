package com.demo.smart_contact_manager.services.implementations;

import com.demo.smart_contact_manager.exceptions.UserNotFoundException;
import com.demo.smart_contact_manager.models.User;
import com.demo.smart_contact_manager.repositories.UserRepository;
import com.demo.smart_contact_manager.request.UserForm;
import com.demo.smart_contact_manager.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImplementation implements UserService {

  @Autowired
  private UserRepository repo;

  @Override
  public Optional<User> getUserById(Integer id) {
    User user = repo
        .findById(id)
        .orElseThrow(() -> new UserNotFoundException("User not found"));
    logUserStatus(user);
    return Optional.of(user);
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    User user = repo
        .findByEmail(email)
        .orElseThrow(() -> new UserNotFoundException("User not found"));
    logUserStatus(user);
    return Optional.of(user);
  }

  @Override
  public User saveUser(UserForm userForm) {
    if (repo.findByEmail(userForm.getEmail()).isPresent()) {
      log.info("User already exists with email: {}", userForm.getEmail());
      return null;
    }
    User user = new User();
    user.setName(userForm.getName());
    user.setEmail(userForm.getEmail());
    user.setPassword(userForm.getPassword());
    user.setPhoneNumber(userForm.getPhone());
    user.setAbout(userForm.getAbout());
    user.setImageUrl(
        "https://images.unsplash.com/photo-1560250097-0b93528c311a?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
    User savedUser = repo.save(user);
    log.info("User saved: {}", savedUser.toString());
    return savedUser;
  }

  @Override
  public boolean deleteUser(Integer id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      log.info("User deleted with id: {}", id);
      return true;
    }
    return false;
  }

  @Override
  public Optional<User> updateUser(Integer id, UserForm userForm) {
    if (repo.existsById(id)) {
      Optional<User> user = repo.findById(id);
      if (user.isPresent()) {
        user.get().setName(userForm.getName());
        user.get().setEmail(userForm.getEmail());
        user.get().setPassword(userForm.getPassword());
        user.get().setPhoneNumber(userForm.getPhone());
        user.get().setAbout(userForm.getAbout());
        User updatedUser = repo.save(user.get());
        log.info("User updated: {}", updatedUser.toString());
        return Optional.of(updatedUser);
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<List<User>> getAllUsers() {
    List<User> userList = repo.findAll();
    log.info("Users found: {}", userList.toString());
    return Optional.of(userList);
  }

  @Override
  public boolean isUserPresent(Integer id) {
    if (repo.existsById(id)) {
      log.info("User found with id: {}", id);
      return true;
    }
    return false;
  }

  @Override
  public boolean isUserPresentByEmail(String email) {
    if (repo.findByEmail(email).isPresent()) {
      log.info("User found with email: {}", email);
      return true;
    }
    return false;
  }

  private void logUserStatus ( User user ) {
    log.info("User found: {}", user.toString());
  }
}
