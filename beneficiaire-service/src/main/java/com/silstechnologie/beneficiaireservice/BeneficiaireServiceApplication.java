package com.silstechnologie.beneficiaireservice;

import com.silstechnologie.beneficiaireservice.entities.Beneficiaire;
import com.silstechnologie.beneficiaireservice.enums.TypeBeneficiaire;
import com.silstechnologie.beneficiaireservice.repositories.BeneficiaireRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@SpringBootApplication
public class BeneficiaireServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaireServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BeneficiaireRepository beneficiaireRepository){
        return args-> {
            Collection<String> noms = new ArrayList<>();
            noms.add("MOROKO");
            noms.add("KOFFI");
            noms.add("KOUADIO");
            noms.forEach(nom -> {
                Beneficiaire beneficiaire = Beneficiaire.builder()
                        .identifiant(UUID.randomUUID().toString())
                        .nom(nom)
                        .prenom("JEAN")
                        .RIB(UUID.randomUUID().toString())
                        .type(Math.random() > 0.5 ? TypeBeneficiaire.MORALE : TypeBeneficiaire.PHYSIQUE)
                        .build();
                beneficiaireRepository.save(beneficiaire);
            });

        };
    }

}
