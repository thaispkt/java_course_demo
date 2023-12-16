package com.cybersoft.cozastore03.controller;

import com.cybersoft.cozastore03.service.implementation.FileServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileServiceImplementation fileServiceImplementation;
    @GetMapping("/{filename}")
    ResponseEntity<?> downloadFile(@PathVariable String filename) {
        Resource resource = fileServiceImplementation.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\"" + filename  + "\"")
                .body(resource);
    }
}
