
package com.campusland.respository.models;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
public class Impuesto_ref {
    private int id;
    private LocalDate periodo_fiscal;
    private double annio;
    private double porcentaje;
    private Impuestos id_impuesto;

    public Impuesto_ref(int id, LocalDate periodo_fiscal, double annio, double porcentaje, Impuestos id_impuesto) {
        this.id = id;
        this.periodo_fiscal = periodo_fiscal;
        this.annio = annio;
        this.porcentaje = porcentaje;
        this.id_impuesto = id_impuesto;
    }

    
    public void imprimir(){
        System.out.println("ID impuesto ref: "+getId());
        System.out.println("Fecha periodo fiscal: "+getPeriodo_fiscal());
        System.out.println("Año: "+getAnnio());
        System.out.println("Porcentaje"+getPorcentaje());
    }
}

