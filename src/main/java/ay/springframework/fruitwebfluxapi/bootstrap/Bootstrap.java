package ay.springframework.fruitwebfluxapi.bootstrap;

import ay.springframework.fruitwebfluxapi.domain.Category;
import ay.springframework.fruitwebfluxapi.domain.Vendor;
import ay.springframework.fruitwebfluxapi.repositories.CategoryRepository;
import ay.springframework.fruitwebfluxapi.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by aliyussef on 22/03/2021
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count().block() == 0) {
            System.out.println("Loading data: ");
            loadCategories();
            loadVendors();
        }
    }

    private void loadCategories() {
        categoryRepository.save(Category.builder().description("Fruits").build()).block();
        categoryRepository.save(Category.builder().description("Nuts").build()).block();
        categoryRepository.save(Category.builder().description("Breads").build()).block();
        categoryRepository.save(Category.builder().description("Meats").build()).block();
        categoryRepository.save(Category.builder().description("Eggs").build()).block();

        System.out.println("Loaded Categories: " + categoryRepository.count().block());
    }

    private void loadVendors() {
        vendorRepository.save(Vendor.builder().firstName("Joe").lastName("Buck").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Michael").lastName("Weston").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Jessie").lastName("Tom").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Bill").lastName("Gets").build()).block();
        vendorRepository.save(Vendor.builder().firstName("Jimmy").lastName("Sanders").build()).block();

        System.out.println("Loaded Vendors: " + vendorRepository.count().block());
    }
}
