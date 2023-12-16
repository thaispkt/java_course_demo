package com.cybersoft.cozastore03.controller;

import com.cybersoft.cozastore03.dto.ProductDTO;
import com.cybersoft.cozastore03.exception.ProductNotFoundException;
import com.cybersoft.cozastore03.payload.response.BaseResponse;
import com.cybersoft.cozastore03.service.implementation.FileServiceImplementation;
import com.cybersoft.cozastore03.service.implementation.ProductServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    @Autowired
    private FileServiceImplementation fileServiceImplemtation;

    @Autowired
    private ProductServiceImplementation productServiceImplementation;
    @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
    public class OrderNotFoundException extends RuntimeException {
        // ...
    }
    @GetMapping("")
    public ResponseEntity<?> getAllProduct() {
//        throw new ProductNotFoundException("Hello Title product","Hello message error");
//        throw new RuntimeException("Test exception");
        List<ProductDTO> list = productServiceImplementation.getAllProduct();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(list);
        return new ResponseEntity<>(baseResponse,HttpStatus.OK);
//        return new ResponseEntity<>("get all product", HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> insertProduct(@RequestParam MultipartFile file,
                                           @RequestParam String title,
                                           @RequestParam double price,
                                           @RequestParam int idCategory,
                                           @RequestParam(required = false) String tag) {
        logger.info(("Debug: filename = " + file.getOriginalFilename() + " - size = " + file.getSize() + " " +
                "-" + " type = " + file.getContentType()));
        productServiceImplementation.save(file, title, price, idCategory, tag);
        return new ResponseEntity<>("insert product", HttpStatus.OK);

    }

}