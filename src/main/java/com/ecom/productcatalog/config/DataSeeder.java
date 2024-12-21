package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.respository.CategoryRepository;
import com.ecom.productcatalog.respository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//initialize our application with some data
@Component
public class DataSeeder implements CommandLineRunner {

    private  final ProductRepository productRepository;
    private  final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //create some categories
        Category Electronics = new Category();
        Electronics.setName("Electronics");
        categoryRepository.save(Electronics);

        Category HomeAndKitchen = new Category();
        HomeAndKitchen.setName("Home and Kitchen");
        categoryRepository.save(HomeAndKitchen);

        Category Clothing = new Category();
        Clothing.setName("Clothing");
        categoryRepository.save(Clothing);

        //create some products

        Product laptop=new Product();
        laptop.setName("Laptop");
        laptop.setDescription("A high-performance laptop");
        laptop.setPrice(999.99);
        laptop.setImageUrl("https://placehold.co/600x400");
        laptop.setCategory(Electronics);
        productRepository.save(laptop);

        Product phone=new Product();
        phone.setName("Phone");
        phone.setDescription("A powerful phone");
        phone.setPrice(699.99);
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setCategory(Electronics);
        productRepository.save(phone);

        Product coffeeMaker=new Product();
        coffeeMaker.setName("Coffee Maker");
        coffeeMaker.setDescription("A coffee maker");
        coffeeMaker.setPrice(49.99);
        coffeeMaker.setImageUrl("https://placehold.co/600x400");
        coffeeMaker.setCategory(HomeAndKitchen);
        productRepository.save(coffeeMaker);

        Product toaster=new Product();
        toaster.setName("Toaster");
        toaster.setDescription("A toaster");
        toaster.setPrice(19.99);
        toaster.setImageUrl("https://placehold.co/600x400");
        toaster.setCategory(HomeAndKitchen);
        productRepository.save(toaster);

        Product tShirt=new Product();
        tShirt.setName("T-Shirt");
        tShirt.setDescription("A t-shirt");
        tShirt.setPrice(9.99);
        tShirt.setImageUrl("https://placehold.co/600x400");
        tShirt.setCategory(Clothing);
        productRepository.save(tShirt);

        Product jeans=new Product();
        jeans.setName("Jeans");
        jeans.setDescription("Jeans");
        jeans.setPrice(49.99);
        jeans.setImageUrl("https://placehold.co/600x400");
        jeans.setCategory(Clothing);
        productRepository.save(jeans);





    }
}
