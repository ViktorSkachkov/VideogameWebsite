package com.example.demo.controller;

import com.example.demo.business.cases.users.*;
import com.example.demo.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetUsersUseCase getUsersUseCase;
    @MockBean
    private GetUserUseCase getUserUseCase;
    @MockBean
    private AddUserUseCase addUserUseCase;
    @MockBean
    private UpdateUserUseCase updateUserUseCase;
    @MockBean
    private DeleteUserUseCase deleteUserUseCase;

    @Test
    void AddUser() throws Exception{
        User user = User.builder()
                .id(3)
                .username("username3")
                .email("email3")
                .bankAccount("bankAccount3")
                //.role("role3")
                .build();
        when(addUserUseCase.AddUser(user))
                .thenReturn(user);
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                            {"id":3, "username":"username3", "email":"email3","bankAccount":"bankAccount3","role":"role3"}
                        """)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("""
                            {"id":3, "username":"username3", "email":"email3","bankAccount":"bankAccount3","role":"role3"}
                       """));
        verify(addUserUseCase).AddUser(user);
    }
    @Test
    void DeleteUser() throws Exception{
        User user = User.builder()
                .id(1)
                .username("username1")
                .email("email1")
                .bankAccount("bankAccount1")
                //.role("role1")
                .build();
        when(deleteUserUseCase.DeleteUser(1))
                .thenReturn(user);
        mockMvc.perform(delete("/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                    {"id":1, "username":"username1", "email":"email1","bankAccount":"bankAccount1","role":"role1"}
"""));
        verify(deleteUserUseCase).DeleteUser(1);
    }
    @Test
    void GetUsers() throws Exception{
        User user1 = User.builder()
                .id(1)
                .username("username1")
                .email("email1")
                .bankAccount("bankAccount1")
                //.role("role1")
                .build();
        User user2 = User.builder()
                .id(2)
                .username("username2")
                .email("email2")
                .bankAccount("bankAccount2")
                //.role("role2")
                .build();
        when(getUsersUseCase.GetUsers())
                .thenReturn(List.of(user1, user2));
        mockMvc.perform(get("/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            [{"id":1, "username":"username1", "email":"email1","bankAccount":"bankAccount1","role":"role1"},
                            {"id":2, "username":"username2", "email":"email2","bankAccount":"bankAccount2","role":"role2"}]
                          """));
        verify(getUsersUseCase).GetUsers();
    }
    @Test
    void GetUser() throws Exception{
        User user = User.builder()
                .id(1)
                .username("username1")
                .email("email1")
                .bankAccount("bankAccount1")
                //.role("role1")
                .build();
        when(getUserUseCase.GetUser(1))
                .thenReturn(user);
        mockMvc.perform(get("/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            {"id":1, "username":"username1", "email":"email1","bankAccount":"bankAccount1","role":"role1"}
                          """));
        verify(getUserUseCase).GetUser(1);
    }
    @Test
    void UpdateUser() throws Exception{
        User user = User.builder()
                .id(1)
                .username("username3")
                .email("email3")
                .bankAccount("bankAccount3")
                //.role("role3")
                .build();
        when(updateUserUseCase.UpdateUser(user))
                .thenReturn(user);
        mockMvc.perform(put("/users")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content("""
                            {"id":1, "username":"username3", "email":"email3","bankAccount":"bankAccount3","role":"role3"}
                        """)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().json("""
                            {"id":1, "username":"username3", "email":"email3","bankAccount":"bankAccount3","role":"role3"}
                       """));
        verify(updateUserUseCase).UpdateUser(user);
    }
}