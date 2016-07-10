package com.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class BaseControllerTest {

    StandaloneMockMvcBuilder getStandaloneMockMvcBuilder(Object controller) {
        return standaloneSetup(controller);
    }

    @SneakyThrows
    public static String toJsonString(Object object) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        new ObjectMapper().writeValue(outputStream, object);
        return new String(outputStream.toByteArray());
    }
}

