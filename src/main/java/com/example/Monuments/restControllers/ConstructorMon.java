package com.example.Monuments.restControllers;

import com.example.Monuments.domain.Monument;
import com.example.Monuments.repos.MonumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConstructorMon {

    @Autowired
    private MonumentRepo monumentRepo;

    @RequestMapping(value = "/getListMonuments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object getListMonuments(@RequestParam(name="type", required=false, defaultValue="1") Integer type){

        Iterable<Monument> listMonuments = monumentRepo.findByType(type);
        return listMonuments;
    }

}
