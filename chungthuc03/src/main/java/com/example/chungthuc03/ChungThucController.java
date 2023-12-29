package com.example.chungthuc03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chungthuc")
public class ChungThucController {
    @GetMapping("")
    public String chungThuc(){
        return "Hello Chung thuc";
    }
}
