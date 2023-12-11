package com.example.Monuments.controllers;

import com.example.Monuments.domain.Element;
import com.example.Monuments.repos.CatalogRepo;
import com.example.Monuments.repos.ElementRepo;
import com.example.Monuments.repos.SettingsRepo;
import com.example.Monuments.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.List;

@Controller
public class Catalog {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private DashboardService dashboardService;

    @Autowired
    private CatalogRepo catalogRepo;

    @Autowired
    private SettingsRepo settingsRepo;


    @RequestMapping("/catalog")
    public String seeCatalog(HttpServletRequest request,Model model){

        List<com.example.Monuments.domain.Catalog> ls1 = catalogRepo.findByCategory(1, Sort.by("id"));
        if(ls1.size()!=0){
            model.addAttribute("seeM",true);
        }
        List<com.example.Monuments.domain.Catalog> ls2 = catalogRepo.findByCategory(2, Sort.by("id"));
        if(ls2.size()!=0){
            model.addAttribute("seeC",true);
        }
        List<com.example.Monuments.domain.Catalog> ls3 = catalogRepo.findByCategory(3, Sort.by("id"));
        if(ls3.size()!=0){
            model.addAttribute("seeO",true);
        }

        model.addAttribute("ListMonuments",ls1);
        model.addAttribute("ListСross",ls2);
        model.addAttribute("ListOther",ls3);

        String ipAddress = request.getRemoteAddr();
        dashboardService.seeUserForDashboard(ipAddress,2);
        return "catalog_page";
    }

    @RequestMapping(value = "/GetCatalogImage", method = RequestMethod.GET, produces = "application/pdf")
    public ResponseEntity<?> getImage(@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        com.example.Monuments.domain.Catalog catalog = catalogRepo.getById((long) id);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(Base64.getMimeDecoder().decode(catalog.getImg()));
    }

    @RequestMapping("/list")
    public String seeUseList (@RequestParam(name = "type", required = false, defaultValue = "0") int type, Model model,HttpServletRequest request){

        String ipAddress = request.getRemoteAddr();
        dashboardService.seeUserForDashboard(ipAddress,2);

        model.addAttribute("titel",catalogRepo.getById((long) type).getName());

        Iterable<Element> listElements = elementRepo.findByType(type);
        model.addAttribute("ListElements",listElements);
        model.addAttribute("seePrice",settingsRepo.getById((long) 1).getVisibility());

        return "list_page";
    }

}