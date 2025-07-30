package com.gudii16.chatAppBackend.service;

import com.gudii16.chatAppBackend.entity.AppUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public AppUser save(AppUser appUser);
}
