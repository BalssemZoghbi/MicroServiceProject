package com.example.chambre.entity;
import com.example.chambre.config.FeignConfig;
import com.example.chambre.dto.HotelDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Hotel-MS", configuration = FeignConfig.class)
public interface HotelClient {
    @GetMapping("api/hotel/{id}")
    @CircuitBreaker(name="Hotel-MS",fallbackMethod ="fallbackGetHotelById")
    HotelDto getHotelById(@PathVariable("id") String id);

    default HotelDto fallbackGetHotelById(String id, Throwable throwable) {
        return new HotelDto("0", "Fallback hotel", "0");
    }
}
