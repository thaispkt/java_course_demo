package com.example.demoELK;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
public class DemoController {
    private Logger logger = LoggerFactory.getLogger(DemoController.class);
    @GetMapping("")
    public String testlog(@RequestParam String message) {
        logger.info("SpringBoot has sent message: " + message);
        return "OK";
    }
}
