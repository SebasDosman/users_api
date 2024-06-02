package co.com.dosman.gateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.core.lang.NonNull;
import io.github.resilience4j.core.registry.EntryAddedEvent;
import io.github.resilience4j.core.registry.EntryRemovedEvent;
import io.github.resilience4j.core.registry.EntryReplacedEvent;
import io.github.resilience4j.core.registry.RegistryEventConsumer;
import io.github.resilience4j.timelimiter.TimeLimiter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ResilienceConfig {
    private static final Logger Log = LoggerFactory.getLogger(ResilienceConfig.class);

    @Bean
    public RegistryEventConsumer<CircuitBreaker> circuitBreakerEventConsumer() {
        return new RegistryEventConsumer<>() {
            @Override
            public void onEntryAddedEvent(@NonNull EntryAddedEvent<CircuitBreaker> entryAddedEvent) {
                entryAddedEvent.getAddedEntry().getEventPublisher()
                        .onFailureRateExceeded(event -> Log.error("Circuit breaker {} failure rate {} on {}", event.getCircuitBreakerName(), event.getFailureRate(), event.getCreationTime()))
                        .onSlowCallRateExceeded(event -> Log.error("Circuit breaker {} slow call rate {} on {}", event.getCircuitBreakerName(), event.getSlowCallRate(), event.getCreationTime()))
                        .onCallNotPermitted(event -> Log.error("Circuit breaker {} call not permitted {}", event.getCircuitBreakerName(), event.getCreationTime()))
                        .onError(event -> Log.error("Circuit breaker {} error with duration {}s", event.getCircuitBreakerName(), event.getElapsedDuration().getSeconds()))
                        .onStateTransition(event -> Log.warn("Circuit breaker {} state transition from {} to {} on {}", event.getCircuitBreakerName(), event.getStateTransition().getFromState(), event.getStateTransition().getToState(), event.getCreationTime()));
            }

            @Override
            public void onEntryRemovedEvent(@NonNull EntryRemovedEvent<CircuitBreaker> entryRemoveEvent) {
                entryRemoveEvent.getRemovedEntry().getEventPublisher()
                        .onFailureRateExceeded(event -> Log.debug("Circuit breaker event removed {}", event.getCircuitBreakerName()));
            }

            @Override
            public void onEntryReplacedEvent(@NonNull EntryReplacedEvent<CircuitBreaker> entryReplacedEvent) {
                entryReplacedEvent.getNewEntry().getEventPublisher()
                        .onFailureRateExceeded(event -> Log.debug("Circuit breaker event replaced {}", event.getCircuitBreakerName()));
            }
        };
    }

    @Bean
    public RegistryEventConsumer<TimeLimiter> timeLimiterEventConsumer() {
        return new RegistryEventConsumer<>() {
            @Override
            public void onEntryAddedEvent(@NonNull EntryAddedEvent<TimeLimiter> entryAddedEvent) {
                entryAddedEvent.getAddedEntry().getEventPublisher()
                        .onTimeout(event -> Log.error("Time limiter {} timeout TIMEOUT on {}", event.getTimeLimiterName(), event.getCreationTime()));
            }

            @Override
            public void onEntryRemovedEvent(@NonNull EntryRemovedEvent<TimeLimiter> entryRemoveEvent) {
                entryRemoveEvent.getRemovedEntry().getEventPublisher()
                        .onTimeout(event -> Log.debug("Time limiter event removed {}", event.getTimeLimiterName()));
            }

            @Override
            public void onEntryReplacedEvent(@NonNull EntryReplacedEvent<TimeLimiter> entryReplacedEvent) {
                entryReplacedEvent.getNewEntry().getEventPublisher()
                        .onTimeout(event -> Log.debug("Time limiter event replaced {}", event.getTimeLimiterName()));
            }
        };
    }
}