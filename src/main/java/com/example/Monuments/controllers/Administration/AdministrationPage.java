package com.example.Monuments.controllers.Administration;

import com.example.Monuments.domain.Element;
import com.example.Monuments.domain.Material;
import com.example.Monuments.domain.PhotoWork;
import com.example.Monuments.domain.Task;
import com.example.Monuments.repos.ElementRepo;
import com.example.Monuments.repos.MaterialRepo;
import com.example.Monuments.repos.PhotoWorkRepo;
import com.example.Monuments.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityManager;

@Controller
public class AdministrationPage {

    @Autowired
    private ElementRepo elementRepo;

    @Autowired
    private MaterialRepo materialRepo;

    @Autowired
    private PhotoWorkRepo photoWorkRepo;

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private EntityManager entityManager;


    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/A")
    public String adminPage(){
        return "Administration/AdminPage";
    }

    @RequestMapping("/Tasks")
    public String seeTasks( Model model){

        Iterable<Task> listTasks = taskRepo.findAll();
        model.addAttribute("ListTasks",listTasks);

        return "Administration/AdminPageTask";
    }

    @RequestMapping("/EditMaterials")
    public String editMaterials( Model model){

        Iterable<Material> listMaterials = materialRepo.findAll();
        model.addAttribute("ListMaterials",listMaterials);

        return "Administration/AdminPageMaterials";
    }

    @RequestMapping("/EditPhotos")
    public String editPhotos( Model model){

        Iterable<PhotoWork> listPhotosWork = photoWorkRepo.findAll();
        model.addAttribute("ListPhotos",listPhotosWork);

        return "Administration/AdminPagePhotos";
    }

    @RequestMapping("/EditSettings")
    public String editSettings( Model model){

        return "Administration/AdminPagePhotos";
    }

    @RequestMapping("/EditListCatalog")
    public String editList(@RequestParam(name = "type", required = false, defaultValue = "0") int type,@RequestParam(name = "category", required = false, defaultValue = "0") int category, Model model){

        model.addAttribute("type",type);
        model.addAttribute("category",category);

        Iterable<Element> listElements = elementRepo.findByType(type);
        model.addAttribute("ListAllElements",listElements);

        return "Administration/AdminPageEditList";
    }
}