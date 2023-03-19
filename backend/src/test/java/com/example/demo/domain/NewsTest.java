package com.example.demo.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewsTest {
    @Test
    void CompareEquals() {
        News news1 = News.builder()
                .id(1)
                .image("name1")
                .title("title1")
                .text("text1")
                .gameId(1)
                .build();
        News news2 = News.builder()
                .id(1)
                .image("name1")
                .title("title1")
                .text("text1")
                .gameId(1)
                .build();
        assertEquals(news1, news2);
    }
    @Test
    void CompareNotEquals() {
        News news1 = News.builder()
                .id(1)
                .image("name1")
                .title("title1")
                .text("text1")
                .gameId(1)
                .build();
        News news2 = News.builder()
                .id(2)
                .image("name1")
                .title("title2")
                .text("text1")
                .gameId(1)
                .build();
        assertNotEquals(news1, news2);
    }
}