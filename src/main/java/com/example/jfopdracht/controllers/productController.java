package com.example.jfopdracht.controllers;

import com.example.jfopdracht.dao.PersonDAO;
import com.example.jfopdracht.dao.productDAO;
import com.example.jfopdracht.entities.Person;
import com.example.jfopdracht.entities.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class productController {

    @Autowired
    private productDAO mProductDAO;

    @Autowired
    private PersonDAO mPersonDAO;


    public productController(productDAO mProductDAO) {
        this.mProductDAO = mProductDAO;
    }

    @ModelAttribute("products")
    public Iterable<product> getAllProducts(){
        return mProductDAO.findAll();
    }

    @ModelAttribute("selectpersons")
    public Iterable<Person> getAllPersons(){
        return mPersonDAO.findAll();
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

    @GetMapping("/details")
    public String ShowDetails(ModelMap modelMap){
        return "details";
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

    @RequestMapping("/details/{id}")
    @ResponseBody
    public String ShowProductDetails(product p1, BindingResult br){

        if(br.hasErrors()){
            return "/index";
        }

        return "/details/{id}";
    }



}
