package com.silstechnologie.virementservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Beneficiaire {
    private String identifiant;
    private String nom;
    private String prenom;
    private String RIB;
    private String type;
}
