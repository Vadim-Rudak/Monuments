package com.example.Monuments.controllers.Administration;

import com.example.Monuments.repos.CatalogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EditCatalogPage {

    @Autowired
    private CatalogRepo catalogRepo;

    @RequestMapping("/EditCatalog")
    public String editCatalog( Model model){

        model.addAttribute("CatalogListM",catalogRepo.findByCategory(1, Sort.by("id")));
        model.addAttribute("CatalogListC",catalogRepo.findByCategory(2, Sort.by("id")));
        model.addAttribute("CatalogListO",catalogRepo.findByCategory(3, Sort.by("id")));

        return "Administration/AdminEditCatalog";
    }
}
