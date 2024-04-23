package com.example.Monuments.controllers;

import com.example.Monuments.domain.Element;
import com.example.Monuments.domain.Material;
import com.example.Monuments.domain.PhotoWork;
import com.example.Monuments.domain.Settings;
import com.example.Monuments.repos.ElementRepo;
import com.example.Monuments.repos.MaterialRepo;
import com.example.Monuments.repos.PhotoWorkRepo;
import com.example.Monuments.repos.SettingsRepo;
import com.example.Monuments.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class TopMenu {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private PhotoWorkRepo photoWorkRepo;

    @Autowired
    private MaterialRepo materialRepo;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private SettingsRepo settingsRepo;

    @RequestMapping("/")
    public String seeTopPage(Model model, HttpServletRequest request){

        Iterable<Element> listElement = elementRepo.findByType(0);
        Iterable<PhotoWork> listPhotosWork = photoWorkRepo.findAll();
        Iterable<Material> listMaterial = materialRepo.findAll();
        model.addAttribute("ListElements",listElement);
        model.addAttribute("ListPhotos",listPhotosWork);
        model.addAttribute("ListMaterials",listMaterial);

        List<Settings> listSettings = settingsRepo.findAll(Sort.by("id"));
        model.addAttribute("seePrice",listSettings.get(0).getVisibility());
        model.addAttribute("locate",listSettings.get(1).getName());
        model.addAttribute("phone",listSettings.get(2).getName());
        model.addAttribute("time",listSettings.get(3).getName());
        model.addAttribute("mail",listSettings.get(4).getName());

        String ipAddress = request.getRemoteAddr();
        dashboardService.seeUserForDashboard(ipAddress,1);

        return "top_page";
    }

    @RequestMapping(value= "/.well-known/pki-validation/654609BC97742A0A76B16084CE2829C9.txt", method= RequestMethod.GET)
    public ResponseEntity<?> verif() throws FileNotFoundException {

        File file = new File("/home/web/verif/654609BC97742A0A76B16084CE2829C9.txt");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(resource);
    }

}