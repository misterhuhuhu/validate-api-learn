package beanvalidation.application.controllers;


import beanvalidation.application.entities.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    
    
    @GetMapping("/users")
    public List<User> getUsers() {
        return Collections.emptyList();
    }
    @PostMapping("/users")
    ResponseEntity<String> addUser(@Valid @RequestBody User user) {
        return ResponseEntity.ok("校验User成功");
    }
    
    /**
     * <p>
     *     需要声明 ExceptionHandler ,否则返回不明
     *     {
     *   "timestamp": "2023-10-20T08:25:36.387+00:00",
     *   "status": 400,
     *   "error": "Bad Request",
     *   "path": "/users"
     *    }
     * </p>
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
