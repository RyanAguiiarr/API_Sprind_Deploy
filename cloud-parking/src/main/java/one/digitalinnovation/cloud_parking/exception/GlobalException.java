package one.digitalinnovation.cloud_parking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ParkingNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleParkingNotFoundException(ParkingNotFoundException e) {
            Map<String, Object> result = new HashMap<>();
            result.put("status", HttpStatus.NOT_FOUND.value());
            result.put("timestamp", LocalDateTime.now());
            result.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }

    @ExceptionHandler(ParkingTrueException.class)
    public ResponseEntity<Map<String, Object>> handleParkingTrueException(ParkingTrueException e) {
        Map<String, Object> result = new HashMap<>();
        result.put("status", HttpStatus.NOT_FOUND.value());
        result.put("timestamp", LocalDateTime.now());
        result.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
    }


}
