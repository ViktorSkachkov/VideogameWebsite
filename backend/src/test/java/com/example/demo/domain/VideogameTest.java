package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class VideogameTest {
    @Test
    void CompareEquals() {
        Videogame videogame1 = Videogame.builder()
                .id(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        Videogame videogame2 = Videogame.builder()
                .id(1)
                .name("name1")
                .price(10)
                .description("description1")
                .image("image1")
                .build();
        assertEquals(videogame1, videogame2);
    }

    @Test
    void CompareNotEquals() {
        /*User user1 = User.builder()
                .id(5)
                .username("username5")
                .email("email5")
                .bankAccount("bankAccount5")
                .role("role5")
                .build();
        User user2 = User.builder()
                .id(6)
                .username("username6")
                .email("email5")
                .bankAccount("bankAccount5")
                .role("role5")
                .build();
        assertNotEquals(user1, user2);*/
    }
}