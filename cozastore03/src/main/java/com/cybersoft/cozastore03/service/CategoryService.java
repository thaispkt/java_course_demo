package com.cybersoft.cozastore03.service;

import com.cybersoft.cozastore03.dto.CategoryDTO;
import com.cybersoft.cozastore03.entity.CategoryEntity;
import com.cybersoft.cozastore03.repository.CategoryRepository;
import com.cybersoft.cozastore03.service.implementation.CategoryServiceImplementation;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import net.bytebuddy.description.method.MethodDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImplementation {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RedisTemplate redisTemplate;
    private Gson gson = new Gson();
    @Cacheable("category")
    @Override

    public List<CategoryDTO> getAllCategory() {
        System.out.println("Chua vao cache");
//        List<CategoryEntity> list = categoryRepository.findAll();
        List<CategoryDTO> listCategoryDTO = new ArrayList<>();
        if(redisTemplate.hasKey("category") != null || redisTemplate.opsForValue().get("category").toString().isEmpty()) {
            Type listType = new TypeToken<List<CategoryDTO>>(){}.getType();
            String data = redisTemplate.opsForValue().get("category").toString();
            listCategoryDTO = gson.fromJson(data,listType);
            System.out.println("Already cached");
        } else {
            System.out.println("Not cached");
            List<CategoryEntity> list = categoryRepository.findAll();
            for (CategoryEntity item : list) {
                CategoryDTO categoryDTO = new CategoryDTO();
                categoryDTO.setId(item.getId());
                categoryDTO.setCategoryName(item.getName());
                listCategoryDTO.add(categoryDTO);
            }

            String data = gson.toJson(listCategoryDTO);
            redisTemplate.opsForValue().set("category",data);
        }

        return listCategoryDTO;
    }
}
