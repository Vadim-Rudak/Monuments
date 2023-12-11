package com.example.Monuments.controllers.crud;

import com.example.Monuments.domain.Material;
import com.example.Monuments.domain.PhotoWork;
import com.example.Monuments.repos.PhotoWorkRepo;
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
public class WorkPhotoController {

    @Autowired
    private PhotoWorkRepo photoWorkRepo;

    @PostMapping("/add_photo_work")
    public String addPhotoWork(@RequestParam(name="titel", required=false, defaultValue="-1") String titel,
                              @RequestParam("material") String material,
                              @RequestParam("file") MultipartFile file_photo,
                              Map<String, Object> model) throws IOException {
        PhotoWork photoWork = new PhotoWork();
        photoWork.setTitel(titel);
        photoWork.setMaterial(material);
        photoWork.setRes(encodeString(file_photo.getBytes()));

        photoWorkRepo.save(photoWork);

        return "ok";
    }


    @PostMapping("/update_photo_work")
    public String updatePhotoWork(@RequestParam(name="id", required=false, defaultValue="0") Long id,
                              @RequestParam(name="titel", required=false, defaultValue=" ") String titel,
                              @RequestParam("material") String material,
                              @RequestParam(name="file", required=false) MultipartFile file_photo,
                              Map<String, Object> model) throws IOException {

        PhotoWork photoWork = photoWorkRepo.getById(id);
        photoWork.setTitel(titel);
        photoWork.setMaterial(material);
        if (file_photo!=null){
            photoWork.setRes(encodeString(file_photo.getBytes()));
        }
        photoWorkRepo.save(photoWork);

        return "ok";
    }

    @PostMapping("/delete_photo_work")
    public String deletePhotoWork(@RequestParam(name="id", required=false, defaultValue="0") int id,
                                  Map<String, Object> model) throws IOException {

        photoWorkRepo.deleteById((long) id);

        return "ok";
    }

    public static String encodeString(byte[] bytes) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(bytes);
    }
}
