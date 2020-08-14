package com.epam.authserver.service;

import com.epam.authserver.model.User;
import com.epam.authserver.model.UserPrincipal;
import com.epam.authserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserPrincipalService(@Qualifier("UserRepo") final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        Optional<User> returnedUser = userRepository.findByUsername(username);
        returnedUser.orElseThrow(()-> new UsernameNotFoundException("User or password wrong"));
        UserDetails userDetails = new UserPrincipal(returnedUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
