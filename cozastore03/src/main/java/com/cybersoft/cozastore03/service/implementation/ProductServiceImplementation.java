package com.cybersoft.cozastore03.service.implementation;

import com.cybersoft.cozastore03.dto.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductServiceImplementation {
    List<ProductDTO> getAllProduct();
     void save(MultipartFile file, String title, double price, int idCategory, String tag);
}
