package com.example.jfopdracht.controllers;

import com.example.jfopdracht.dao.productDAO;
import com.example.jfopdracht.entities.product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class productController {

    private productDAO mProductDAO;

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
}
