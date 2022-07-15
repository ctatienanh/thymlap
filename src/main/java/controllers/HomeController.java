package controllers;

import models.Category;
import models.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.CategoryService;
import service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@Controller
public class HomeController {
    CustomerService customerService = new CustomerService();
    CategoryService categoryService = new CategoryService();

    @GetMapping("/customer")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("customers", customerService.list);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("category",categoryService.categories );
        return modelAndView;
    }
    @PostMapping ("/create")
    public ModelAndView create(@ModelAttribute Customer customer, @RequestParam int idcategory){
        Category category = categoryService.finbyid(idcategory);
        customer.setCategory(category);
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam int id){
        customerService.delete(customerService.finid(id));
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView showEdit(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("category",categoryService.categories );
        modelAndView.addObject("customer", customerService.finbyid(id));
        return modelAndView;
    }
    @PostMapping ("/edit")
    public ModelAndView Edit(@ModelAttribute Customer customer, @RequestParam int idcategory){
        Category category = categoryService.finbyid(idcategory);
        customer.setCategory(category);
        customerService.edit(customer,customerService.finid(customer.getId()));
        ModelAndView modelAndView = new ModelAndView("redirect:/customer");
        return modelAndView;
    }


}
