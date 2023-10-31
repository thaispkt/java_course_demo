package com.cybersoft.demospringboot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
@Controller: dùng để định nghĩa path mà khi mà nội dung path trả ra là HTML
@ResponseBody: Giúp cho annotation @Controller có thể tra ra kiểu String dùng để viết REST API
@RestController: là sự kết hợp của @Controller và @ResponseBody => Viết API
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("")
//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "Hello Spring Boot";
    }
    @GetMapping("/cybersoft")
//    @RequestMapping(method = RequestMethod.GET, path = "/hello/cybersoft")
    public String helloCypersoft() {
        return "Hello Spring Cypersoft";
    }
}
