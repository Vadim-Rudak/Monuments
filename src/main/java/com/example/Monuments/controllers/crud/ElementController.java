package com.example.Monuments.controllers.crud;

import com.example.Monuments.domain.Element;
import com.example.Monuments.repos.ElementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Map;

@Controller
public class ElementController {

    @Autowired
    private ElementRepo elementRepo;

    @PostMapping("/add_element")
    public String addElement(@RequestParam(name="type", required=false, defaultValue="0") int type,
                              @RequestParam(name="name", required=false, defaultValue="") String name,
                              @RequestParam(name="material", required=false, defaultValue="") String material,
                              @RequestParam(name="info", required=false, defaultValue="") String info,
                              @RequestParam(name="price", required=false, defaultValue="0") int price,
                              @RequestParam("file") MultipartFile file,
                              Map<String, Object> model) throws IOException {

        Element element = new Element();
        element.setType(type);
        element.setName(name);
        if (material.equals("")){
            element.setMaterial(null);
        }else{
            element.setMaterial(material);
        }
        element.setInfo(info);
        element.setPrice(price);
        element.setRes(encodeString(file.getBytes()));
        elementRepo.save(element);

        return "ok";
    }

    @PostMapping("/delete_element")
    public String deleteElement(@RequestParam(name="id", required=false, defaultValue="0") int id,
                                @RequestParam(name="type", required=false, defaultValue="0") int type,
                                Map<String, Object> model) throws IOException {

        elementRepo.deleteById((long) id);
        return "ok";
    }

    @PostMapping("/update_element")
    public String updateElement(@RequestParam(name="id", required=false, defaultValue="0") int id,
                             @RequestParam(name="name", required=false, defaultValue="") String name,
                             @RequestParam(name="material", required=false, defaultValue="") String material,
                             @RequestParam(name="info", required=false, defaultValue="") String info,
                             @RequestParam(name="price", required=false, defaultValue="0") int price,
                             @RequestParam(name="file", required=false) MultipartFile file,
                             Map<String, Object> model) throws IOException {

        Element element = elementRepo.getById((long) id);
        element.setName(name);
        element.setMaterial(material);
        element.setInfo(info);
        element.setPrice(price);
        if (file!=null){
            element.setRes(encodeString(file.getBytes()));
        }

        elementRepo.save(element);

        return "ok";
    }


    @RequestMapping(value = "/GetImage", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<?> getImage(@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        Element element = elementRepo.getById((long) id);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(Base64.getMimeDecoder().decode(element.getRes()));
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(bytes);
    }

}
