package co.com.dosman.gateway.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import java.time.Duration;


@RestController
@Slf4j
public class GatewayController {
    private static final String RESILIENCE4J_INSTANCE_NAME = "example";
    private static final String FALLBACK_METHOD = "fallbackMethod";

    @GetMapping(value = "/timeout/{timeout}", produces = MediaType.APPLICATION_JSON_VALUE)
    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<Boolean>> timeout(@PathVariable int timeout) {
        return Mono.just(new ResponseEntity<>(true, HttpStatus.OK)).delayElement(Duration.ofSeconds(timeout));
    }

    @GetMapping(value = "/timeDelay/{delay}", produces = MediaType.APPLICATION_JSON_VALUE)
    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public Mono<ResponseEntity<Boolean>> timeDelay(@PathVariable int delay) {
        return Mono.just(new ResponseEntity<>(true, HttpStatus.OK)).delayElement(Duration.ofSeconds(delay));
    }

    private Mono<ResponseEntity<Boolean>> fallbackMethod(int value, Throwable t) {
        return Mono.just(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
    }
}

