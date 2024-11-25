package com.silstechnologie.virementservice.feign;

import com.silstechnologie.virementservice.model.Beneficiaire;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("beneficiaire-service")
public interface BeneficiaireRestClient {
    @GetMapping("/api/beneficiaires/{identifiant}")
    Beneficiaire findBeneficiaireById(@PathVariable String identifiant);

    @GetMapping("/api/beneficiaires")
    PagedModel<Beneficiaire> findAllBeneficiaire();
}
