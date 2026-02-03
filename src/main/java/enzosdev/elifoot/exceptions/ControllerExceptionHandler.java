package enzosdev.elifoot.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handlePlayerNotFoundException(PlayerNotFoundException ex){
        Map<String, String> response  = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("message", "Player not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ClubNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleClubNotFoundException(ClubNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("message", "Club not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StadiumNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleStadiumNotFoundException(StadiumNotFoundException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        response.put("message", "Stadium not found");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
