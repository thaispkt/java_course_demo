package com.example.thanhtoan03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thanhtoan")
public class ThanhToanController {
    @GetMapping("")
    public String thanhToan(){
        return "Hello Thanh toan";
    }
}
