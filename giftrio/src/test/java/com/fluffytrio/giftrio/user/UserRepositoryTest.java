package com.fluffytrio.giftrio.user;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void createUser() {
        //given
        String userId = "user01";
        String userName = "nickname";
        String password = "password";

        userRepository.save(User.builder().email(userId).userName(userName).password(password).build());

        //when
        List<User> userList = userRepository.findAll();

        //then
        User user01 = userList.get(0);
        assertThat(user01.getEmail()).isEqualTo(userId);
        assertThat(user01.getUserName()).isEqualTo(userName);
        assertThat(user01.getPassword()).isEqualTo(password);
    }
}
