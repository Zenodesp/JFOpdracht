package com.example.jfopdracht.controllers;

import com.example.jfopdracht.dao.PersonDAO;
import com.example.jfopdracht.dao.productDAO;
import com.example.jfopdracht.entities.Person;
import com.example.jfopdracht.entities.product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class productController {

    private productDAO mProductDAO;

    private PersonDAO mPersonDAO;


    public productController(productDAO mProductDAO) {
        this.mProductDAO = mProductDAO;
    }

    @ModelAttribute("products")
    public Iterable<product> getAllProducts(){
        return mProductDAO.findAll();
    }

    @GetMapping({"/", "/index"})
    public String showIndex(ModelMap modelMap){
        return "index";
    }

    @GetMapping("/new")
    public String ShowNew(ModelMap modelMap){
        return "new";
    }

    @GetMapping("/about")
    public String ShowAbout(ModelMap modelMap){
        return "about";
    }

    @ModelAttribute("productToSave")
    public product myProduct(){
        return new product();
    }

    @ModelAttribute("PersonToSave")
    public Person myPerson(){
        return new Person();
    }

    @PostMapping("/new")
    public String insertProduct(@Valid @ModelAttribute("productToSave") product p1, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return "/new";
        }
        mProductDAO.save(p1);
        return "redirect:/index";
    }

    @PostMapping("/newperson")
    public String insertPerson(@Valid @ModelAttribute("PersonToSave") Person per1, BindingResult bindingResult){


        if(bindingResult.hasErrors()){
            return "/new";
        }
        mPersonDAO.save(per1);
        return "redirect:/index";
    }



}
