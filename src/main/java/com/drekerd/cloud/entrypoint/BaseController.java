package com.drekerd.cloud.entrypoint;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by drekerd (Mário Silva) or 10/01/2021
 */
public class BaseController {

    public <T> ResponseEntity<T> createOkResponse(final T response) {
        System.out.print(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
