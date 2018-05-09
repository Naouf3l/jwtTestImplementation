package org.myproject.test.authent;

import org.myproject.test.common.repo.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        org.myproject.test.common.entity.User applicationUser = repository.findByLogin(login).get();
        if (applicationUser == null) {
            throw new UsernameNotFoundException(login);
        }
        return new User(applicationUser.getLogin(), applicationUser.getPassword(), emptyList());
    }
}
