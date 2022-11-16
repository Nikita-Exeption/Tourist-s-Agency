package org.Nikita.repositories;

import org.Nikita.entities.User;
import org.Nikita.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;
import org.mapstruct.control.MappingControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    private final UserRepository repository;

    @Autowired
    public UserRepositoryTest(UserRepository repository){
        this.repository = repository;
    }

    public static final String NAME = "Name";
    public static final String PHONE = "+3804242214421";

    @Test
    void findByPhone() {
        User user = new User(NAME, PHONE);
        repository.save(user);

        User result = repository.findByPhone(PHONE).orElseThrow(UserNotFoundException::new);

        assertNotNull(result);
        assertEquals(NAME, result.getName());
        assertEquals(PHONE, result.getPhone());
    }
}