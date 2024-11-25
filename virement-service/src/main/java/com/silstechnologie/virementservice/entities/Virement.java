package com.silstechnologie.virementservice.entities;

import com.silstechnologie.virementservice.enums.TypeVirement;
import com.silstechnologie.virementservice.model.Beneficiaire;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Virement {
    @Id
    private String identifiant;
    private String ribSource;
    private Double montant;
    private String description;
    private Date dateVirement;
    @Enumerated(EnumType.STRING)
    private TypeVirement type;
    private String identifiantBeneficiaire;
    @Transient
    private Beneficiaire beneficiaire;
}
