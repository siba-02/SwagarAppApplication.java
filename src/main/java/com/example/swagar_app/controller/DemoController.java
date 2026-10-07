package com.example.swagar_app.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User", description = "User Management APIs")
public class DemoController {
    @Operation( summary = "Get all users", description = "Fetch all users from database" )
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public List<String> getUsers()
    {
        return List.of("John", "David", "Sophia");
    }
    @Operation(summary = "Create new user")
    @ApiResponse(responseCode = "201", description = "User Created")
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody @Schema(description = "User name")
                                                 String name)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(name);
    }
}



