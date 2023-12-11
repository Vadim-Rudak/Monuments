package com.example.Monuments.controllers.crud;

import com.example.Monuments.domain.Catalog;
import com.example.Monuments.repos.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

@Controller
public class CatalogController {

    @Autowired
    private CatalogRepo catalogRepo;


    @PostMapping("/add_in_catalog")
    public String addToCatalog(@RequestParam(name="name", required=false, defaultValue=" ") String name,
                              @RequestParam(name="category", required=false,defaultValue=" ") int category,
                              @RequestParam(name="file", required=false) MultipartFile file,
                              Map<String, Object> model) throws IOException {

        Catalog catalog = new Catalog();
        catalog.setName(name);
        catalog.setCategory(category);
        catalog.setImg(encodeString(file.getBytes()));
        catalogRepo.save(catalog);

        return "ok";
    }

    @PostMapping("/update_item_category")
    public String updateMaterial(@RequestParam(name="id", required=false, defaultValue="0") Long id,
                                 @RequestParam(name="name", required=false, defaultValue=" ") String name,
                                 @RequestParam("category") int category,
                                 @RequestParam(name="file", required=false) MultipartFile file,
                                 Map<String, Object> model) throws IOException {

        Catalog catalog = catalogRepo.getById(id);
        catalog.setName(name);
        catalog.setCategory(category);
        if(file!=null){
            catalog.setImg(encodeString(file.getBytes()));
        }

        catalogRepo.save(catalog);

        return "ok";
    }

    @PostMapping("/delete_item_catalog")
    public String deleteMaterial(@RequestParam(name="id", required=false, defaultValue="0") Long id, Map<String, Object> model){
        catalogRepo.deleteById(id);
        return "ok";
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
