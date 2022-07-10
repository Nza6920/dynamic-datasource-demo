package com.niu.datasource.service;

import com.niu.datasource.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void should_save_user_to_a_db() {
        User user = new User();
        user.setUserName("nza");
        user.setUserPhone("18708157016");
        user.setAddress("四川省成都市");
        user.setWeight(160);
        userService.save(user);
        assertThat(user.getUserId()).isNotEmpty();
    }

    @Test
    void should_find_user_from_b_db() {
        User user = userService.find("111");
        assertThat(user.getUserId()).isNotEmpty();
    }
}