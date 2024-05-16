package com.demo.smart_contact_manager.services;

import com.demo.smart_contact_manager.models.User;
import com.demo.smart_contact_manager.request.UserForm;

import java.util.List;
import java.util.Optional;

public interface UserService {

  Optional< User > getUserById ( Integer id );

  Optional< User > getUserByEmail ( String email );

  User saveUser ( UserForm userForm );

  boolean deleteUser ( Integer id );

  Optional<User> updateUser ( Integer id, UserForm userForm );

  Optional< List<User> > getAllUsers ();

  boolean isUserPresent ( Integer id );

  boolean isUserPresentByEmail ( String email );

}
