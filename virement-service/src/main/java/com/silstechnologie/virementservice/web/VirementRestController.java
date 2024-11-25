package com.silstechnologie.virementservice.web;

import com.silstechnologie.virementservice.entities.Virement;
import com.silstechnologie.virementservice.feign.BeneficiaireRestClient;
import com.silstechnologie.virementservice.model.Beneficiaire;
import com.silstechnologie.virementservice.repositories.VirementRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VirementRestController {
    private VirementRepository virementRepository;
    private BeneficiaireRestClient beneficiaireRestClient;

    public VirementRestController(VirementRepository virementRepository, BeneficiaireRestClient beneficiaireRestClient) {
        this.virementRepository = virementRepository;
        this.beneficiaireRestClient = beneficiaireRestClient;
    }

    @GetMapping("/virements")
    List<Virement> getVirement(){
        List<Virement> virements = virementRepository.findAll();

        virements.forEach(v -> {
            Beneficiaire beneficiaire = beneficiaireRestClient.findBeneficiaireById(v.getIdentifiantBeneficiaire());
            v.setBeneficiaire(beneficiaire);
        });
        return virements;
    }
}
