package com.cybersoft.cozastore03.controller;

import com.cybersoft.cozastore03.entity.CategoryEntity;
import com.cybersoft.cozastore03.payload.response.BaseResponse;
import com.cybersoft.cozastore03.service.implementation.CategoryServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);
    @Autowired
    private CategoryServiceImplementation categoryServiceImplementation;

    @GetMapping("")
    public ResponseEntity<?> getCategory() // Category ko cần nhận parameter gì cả
    {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(categoryServiceImplementation.getAllCategory());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
//        return new ResponseEntity<>("Category return okay", HttpStatus.OK);
    }
}
