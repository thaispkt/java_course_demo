package com.cybersoft.cozastore03.service;

import com.cybersoft.cozastore03.dto.ProductDTO;
import com.cybersoft.cozastore03.entity.CategoryEntity;
import com.cybersoft.cozastore03.entity.ProductEntity;
import com.cybersoft.cozastore03.repository.ProductRepository;
import com.cybersoft.cozastore03.service.implementation.FileServiceImplementation;
import com.cybersoft.cozastore03.service.implementation.ProductServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceImplementation {
    @Autowired
    private FileServiceImplementation fileServiceImplemtation;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProduct() {
        List<ProductEntity> list = productRepository.findAll();
        List<ProductDTO> dtoList = new ArrayList<>();
        for(ProductEntity item:list) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(item.getId());
            productDTO.setProductName(item.getTitle());
//            productDTO.setImage(item.getImages());
            // get dynamic domain name Spring boot
            productDTO.setImage("http://localhost:9090/file/"+item.getImages());
            productDTO.setPrice(item.getPrice());
            dtoList.add(productDTO);
        }
        return dtoList;
    }
//    @Transactional
// Customize transaction cho những Exeception ko phải RunTime Exception
//    @Transactional(rollbackFor = {RuntimeException.class, Exception.class})
    @Override
    public void save(MultipartFile file, String title, double price, int idCategory, String tag) {
        fileServiceImplemtation.save(file);
        ProductEntity productEntity = new ProductEntity();
        productEntity.setImages(file.getOriginalFilename());
        productEntity.setTitle(title);
        productEntity.setPrice(price);
        productEntity.setTag(tag != null ? tag : "");

        CategoryEntity category = new CategoryEntity();
        category.setId(idCategory);
        productEntity.setCategory(category);
        try{
            productRepository.save(productEntity);
            // -> data đã được record vào database dù exception do logic code đã xảy ra -> solution: đặt annotation
            // @Transactional của thư viện Spring trước hàm Save() để rollback
            // Chỉ thêm @Transactional trước ADD, DELETE, MODIFY, ko cần đặt trước GET
            throw new RuntimeException("Cố tình throw exception");
        } catch (Exception e) {
            throw new RuntimeException("Error insert product: " + e.getMessage());
        }
    }
}
