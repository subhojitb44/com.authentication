package org.authentication.services.interfaces;

import org.authentication.entities.AppUser;

import java.util.List;

public interface UserServiceInterface {
    List<AppUser> getAllUsers();
    AppUser saveUser(AppUser user);
    AppUser findUserByUsername(String username);
    boolean isUsernameAlreadyExists(String username);
}