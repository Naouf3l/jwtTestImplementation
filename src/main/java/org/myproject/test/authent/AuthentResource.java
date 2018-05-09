package org.myproject.test.authent;

import org.myproject.test.common.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(path = "/authent")
public class AuthentResource {

    private final AuthentService service;

    public AuthentResource(AuthentService service) {
        this.service = service;
    }

    @RequestMapping(value = "sign-up", method = POST, consumes = "application/json")
    public ResponseEntity signUp(@RequestBody User user) {
        try{
            service.saveAnUser(user);
        }catch (final RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(user.getLogin(), HttpStatus.OK);
    }
}