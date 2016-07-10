package com.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.SpringBootBasicMocitoApplication;
import com.google.gson.Gson;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import controller.UserController;
import model.User;
import service.CustomGsonBuilder;
import service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootBasicMocitoApplication.class)
@WebAppConfiguration
public class UserControllerTest extends BaseControllerTest {

    UserController userController;
    private MockMvc mvc;

    @Mock
    private UserService userService;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        initMocks(this);
        userController = new UserController(userService);
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldGetId() throws Exception {
        String email = "pers02@test.com";

        getStandaloneMockMvcBuilder(userController)
                .build()
                .perform(
                        get("/customer/id?email=pers02@test.com"))
                .andExpect(status().isOk());
        verify(userService, times(1)).getUserId(email);
    }

    @Test
    public void shouldPostId() throws Exception {
        User user = new User();
        user.setUsername("username");
      
        Gson gson = CustomGsonBuilder.createCustomGsonBuilder().create();
        String json = gson.toJson(user);
        getStandaloneMockMvcBuilder(userController)
                .build()
                .perform(
                        post("/customer/id/post").content(json).
                                contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

}

