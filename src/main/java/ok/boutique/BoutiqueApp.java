package ok.boutique;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ok.boutique.dao.ProducerRepository;
import ok.boutique.dao.ProductRepository;
import ok.boutique.entity.Producer;
import ok.boutique.entity.Product;
import ok.boutique.entity.Product.Type;
import ok.boutique.service.ProducerService;
import ok.boutique.service.ProductService;

@SpringBootApplication
public class BoutiqueApp {

	public static void main(String[] args) {
		SpringApplication.run(BoutiqueApp.class, args);	
	}

    // HUJ 88 14
      @Bean
    CommandLineRunner dataLoader(ProducerRepository repo, ProductRepository repoProduct, ProducerService producerService, ProductService productService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                repo.save(new Producer("Acqua Di Parma", "Italy"));
                repo.save(new Producer("Caron", "France"));

                Producer prod = producerService.findByName("Acqua Di Parma");
                Producer prod2 = producerService.findByName("Caron");

                Product product1 = new Product();
                product1.setName("Colonia Essenza");
                product1.setCurrentVolume(100);
                product1.setMaxVolume(100);
                product1.setProducer(prod);
                product1.setType(Type.PRODUCT_SEALED);


                Product product2 = new Product();
                product2.setName("Pour Un Homme");
                product2.setCurrentVolume(60);
                product2.setMaxVolume(100);
                product2.setProducer(prod2);
                product2.setType(Type.TESTER);


                repoProduct.save(product1);
                repoProduct.save(product2);

                Product peja = productService.findByName("Pour Un Homme");
                System.out.println(peja);


            }
        };
    }

}
