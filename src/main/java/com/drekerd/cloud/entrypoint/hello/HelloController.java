package com.drekerd.cloud.entrypoint.hello;

import com.drekerd.cloud.entrypoint.BaseController;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by drekerd (Mário Silva) or 10/01/2021
 */
@RestController
@RequestMapping("hello/")
public class HelloController extends BaseController {

    @GetMapping("/helloWorld")
    public ResponseEntity<String> helloWorldResponse() {
        System.out.printf("Entered");
        return createOkResponse("Hi");
    }
}
