package com.cybersoft.cozastore03.controller;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("")
    public ResponseEntity<?> getAllProduct(){
        return new ResponseEntity<>("get all product", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertProduct(){
        return new ResponseEntity<>("insert product", HttpStatus.OK);
    }

}