package org.ach.inventoryservice;

import org.ach.inventoryservice.entities.Product;
import org.ach.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main ( String[] args ) {
        SpringApplication.run ( InventoryServiceApplication.class , args );
    }

    @Bean
    CommandLineRunner commandLineRunner ( ProductRepository productRepository , RepositoryRestConfiguration repositoryRestConfiguration ){
        repositoryRestConfiguration.exposeIdsFor ( Product.class );
        return args -> {
           productRepository.saveAll (
                   List.of (
                           Product.builder ().name ( "computer" ).quantity (12).price ( 155 ).build (),
                           Product.builder ().name ( "printer" ).quantity (12).price ( 155 ).build (),
                           Product.builder ().name ( "smartphone" ).quantity (12).price ( 155 ).build ()
                   )

           );

        };
    }

}
