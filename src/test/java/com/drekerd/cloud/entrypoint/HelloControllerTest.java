package com.drekerd.cloud.entrypoint;

import com.drekerd.cloud.entrypoint.hello.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by drekerd (Mário Silva) or 10/01/2021
 */

@ExtendWith(MockitoExtension.class)
public class HelloControllerTest {

    private HelloController helloController = new HelloController();

    @Test
    public void getHelloFromRequest() {

        ResponseEntity response = helloController.helloWorldResponse();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hi", response.getBody());
    }


}
