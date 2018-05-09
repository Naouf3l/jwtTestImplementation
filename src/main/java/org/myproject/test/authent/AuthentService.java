package org.myproject.test.authent;

import org.myproject.test.common.entity.User;
import org.myproject.test.common.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthentService {


    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthentService(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    User getAnUser(final String login, final String password) {
        Optional<User> optionalUser = repository.findByLoginAndPassword(login, password);
        if(!optionalUser.isPresent()){
            throw new RuntimeException("This user does not exist.");
        }
        return optionalUser.get();
    }

    public void saveAnUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
}
