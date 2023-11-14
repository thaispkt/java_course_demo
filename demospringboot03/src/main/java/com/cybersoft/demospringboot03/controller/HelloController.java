package com.cybersoft.demospringboot03.controller;

import com.cybersoft.demospringboot03.controller.request.LoginRequest;
import com.cybersoft.demospringboot03.entity.Student;
import com.cybersoft.demospringboot03.entity.UsersEntity;
import com.cybersoft.demospringboot03.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
@Controller: dùng để định nghĩa path mà khi mà nội dung path trả ra là HTML
@ResponseBody: Giúp cho annotation @Controller có thể tra ra kiểu String dùng để viết REST API
@RestController: là sự kết hợp của @Controller và @ResponseBody => Viết API
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    // Create a list to store students
    private List<Student> studentList = new ArrayList<>();
    /*
    1. Tham số truyền trên browser: @RequestParam
    2. Tham số truyền ngầm: @RequestParam
    3. Tham số đóng vai trò là 1 đường dẫn @PathVariable
    4. Tham số là đối tượng: @RequestBody
    Theo nguyên tắc RestFUL API thì phương thức GET bắt buộc dùng path parameter, chứ ko dùng form
     */
    @Autowired
    private Student student;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("")
//    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    /*
    public String hello() {
        return "Hello Spring Boot";
    }
    */
    /*
    public String hello(@RequestParam String hoten, @RequestParam int tuoi) {
        List<UsersEntity> list = userRepository.findAll();
        return "Hello Spring Boot: " + hoten + "tuoi: " + tuoi;
        return "Hello Spring Boot: " + hoten + " tuoi: " + tuoi + " - IOC: " + student.getName();
    }
    */

    public ResponseEntity<?> hello(@RequestParam String hoten, @RequestParam int tuoi) {
        List<UsersEntity> list = userRepository.findAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping("/cybersoft")
//    @RequestMapping(method = RequestMethod.GET, path = "/hello/cybersoft")
    public String helloCypersoft(@RequestBody LoginRequest loginRequest) {
        return "Hello Spring Cypersoft: " + loginRequest.getUsername() + " - " + loginRequest.getPassword();
    }

    @PutMapping("/update/{id}")
    /* trả về String
    public String update(@PathVariable int id){
        return "Update id = "+id;
    }
     */
    // trả về đối tượng object
    // ? là nhận String, int đều được
//    @RequestMapping(method = RequestMethod.GET, path = "/hello/cybersoft")
    public ResponseEntity<?> update(@PathVariable int id){
        return new ResponseEntity<>("Update id = " + id, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
