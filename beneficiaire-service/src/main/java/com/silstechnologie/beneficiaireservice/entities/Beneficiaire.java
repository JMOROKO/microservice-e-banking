package com.silstechnologie.beneficiaireservice.entities;

import com.silstechnologie.beneficiaireservice.enums.TypeBeneficiaire;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Beneficiaire {
    @Id
    private String identifiant;
    private String nom;
    private String prenom;
    private String RIB;
    @Enumerated(EnumType.STRING)
    private TypeBeneficiaire type;
}
