package com.example.Monuments.controllers.crud;

import com.example.Monuments.domain.Material;
import com.example.Monuments.domain.PhotoWork;
import com.example.Monuments.repos.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

@Controller
public class MaterialsController {

    @Autowired
    private MaterialRepo materialRepo;


    @PostMapping("/add_material")
    public String addMaterial(@RequestParam(name="name", required=false, defaultValue=" ") String name,
                              @RequestParam(name="info", required=false,defaultValue=" ") String info,
                              @RequestParam(name="file", required=false) MultipartFile file,
                              Map<String, Object> model) throws IOException {

        Material material = new Material();
        material.setName(name);
        material.setInfo(info);
        if (file!=null){
            material.setRes(encodeString(file.getBytes()));
        }
        materialRepo.save(material);

        return "ok";
    }


    @PostMapping("/update_material")
    public String updateMaterial(@RequestParam(name="id", required=false, defaultValue="0") Long id,
                                  @RequestParam(name="name", required=false, defaultValue=" ") String name,
                                  @RequestParam("info") String info,
                                  @RequestParam(name="file", required=false) MultipartFile file,
                                  Map<String, Object> model) throws IOException {

        Material material1 = materialRepo.getById(id);
        material1.setName(name);
        material1.setInfo(info);
        if(file!=null){
            material1.setRes(encodeString(file.getBytes()));
        }

        materialRepo.save(material1);

        return "ok";
    }

    @PostMapping("/delete_material")
    public String deleteMaterial(@RequestParam(name="id", required=false, defaultValue="0") Long id, Map<String, Object> model){
        materialRepo.deleteById(id);
        return "redirect:/EditMaterial";
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
