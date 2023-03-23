package com.challenge.alkemyChallenge.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class CustomResponseDelete<P> {
    private String message;
    private ResponseEntity responseEntity;

    public CustomResponseDelete(String message, ResponseEntity responseEntity) {
        this.message = message;
        this.responseEntity = responseEntity;
    }

}