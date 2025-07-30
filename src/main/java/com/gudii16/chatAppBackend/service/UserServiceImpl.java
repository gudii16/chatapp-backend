package com.gudii16.chatAppBackend.service;

import com.gudii16.chatAppBackend.entity.AppUser;
import com.gudii16.chatAppBackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public AppUser save(AppUser appUser){
        return userRepository.save(appUser);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(
                appUser.getEmail(), appUser.getPassword(), new java.util.ArrayList<>()
        );
    }
}
