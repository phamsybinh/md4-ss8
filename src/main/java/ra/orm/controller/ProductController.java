package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.orm.entity.Product;
import ra.orm.service.IProductService;

import javax.jws.WebParam;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/list")
    public String list(@RequestParam(name = "page", defaultValue = "0") int page,@RequestParam(name = "size", defaultValue ="2") int size, Model model){
        List<Product> products = productService.findAll(page,size);
        int totalRecord = productService.count();
        int totalPage = (int) Math.ceil((double) totalRecord/size);
        model.addAttribute("countTotalPage", totalPage);
        model.addAttribute("totalPage", IntStream.rangeClosed(1, totalPage)
                .boxed()
                .collect(Collectors.toList()));
        model.addAttribute("currentPage",page);
        model.addAttribute("products",products);
        return "product/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam Integer id){
        productService.remove(id);
        return "redirect:/products/list";
    }
    @GetMapping("/save")
    public String add(Model model){
        model.addAttribute("product", new Product());
        return "product/add";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("product") Product product){
        product.setIsDeleted(false);
        productService.save(product);
        return "redirect:/products/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "product/edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("product") Product product, Model model){
        productService.save(product);
        return "redirect:/products/list";
    }
    @GetMapping("/search")
    public String search(@RequestParam(name = "productName") String name, Model model){
        model.addAttribute("products",productService.findProductByName(name));        ;
        return "product/list";
    }


}
