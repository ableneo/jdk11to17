package com.ableneo.jdk11to17.ex13bundling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class IndexController {

    @RequestMapping("/")
    public Mono<ResponseEntity<String>> index() {
        return Mono.just(new ResponseEntity<>("Hello, world", HttpStatus.OK));
    }

}
