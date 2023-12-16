package com.cybersoft.cozastore03.service.implementation;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImplementation {
    void save(MultipartFile file);
    Resource load(String filename);
}
