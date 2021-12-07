package by.s.bagautdinov.lesson3.controller;

import by.s.bagautdinov.lesson3.model.Product;
import by.s.bagautdinov.lesson3.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@Log4j2
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
//    @ModelAttribute("products")
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
//        return productService.findAll();
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("products", productService.findById(id));
        return "product";
    }

    @PostMapping
    public String save(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/product";
    }
}
