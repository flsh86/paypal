package com.paypal.rest;

import com.paypal.service.UserService;
import com.paypal.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRest {
    private UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> dto = this.userService.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/order", params = "id")
    public ResponseEntity<UserDTO> findByOrderId(@RequestParam Long id) {
        return ResponseEntity.ok(this.userService.findByOrders_id(id));
    }
}
