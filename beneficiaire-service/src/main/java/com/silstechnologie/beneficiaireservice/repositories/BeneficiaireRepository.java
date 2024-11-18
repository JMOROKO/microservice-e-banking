package com.silstechnologie.beneficiaireservice.repositories;

import com.silstechnologie.beneficiaireservice.entities.Beneficiaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BeneficiaireRepository extends JpaRepository<Beneficiaire, String> {
}
