package com.silstechnologie.virementservice;

import com.silstechnologie.virementservice.entities.Virement;
import com.silstechnologie.virementservice.enums.TypeVirement;
import com.silstechnologie.virementservice.feign.BeneficiaireRestClient;
import com.silstechnologie.virementservice.model.Beneficiaire;
import com.silstechnologie.virementservice.repositories.VirementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class VirementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirementServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BeneficiaireRestClient beneficiaireRestClient, VirementRepository virementRepository){
        return args -> {
            Collection<Beneficiaire> beneficiaires = beneficiaireRestClient.findAllBeneficiaire().getContent();
            beneficiaires.forEach(b -> {

                Virement virement = Virement.builder()
                        .identifiant(UUID.randomUUID().toString())
                        .ribSource(String.valueOf(1+new Random().nextInt(1000000)))
                        .montant(Math.random()*50000)
                        .description("Argent viré à "+b.getNom())
                        .dateVirement(new Date())
                        .type(Math.random()*0.5>1? TypeVirement.INSTANTANE : TypeVirement.NORMAL)
                        .identifiantBeneficiaire(b.getIdentifiant())
                        .build();
                virementRepository.save(virement);
            });
        };
    }
}
