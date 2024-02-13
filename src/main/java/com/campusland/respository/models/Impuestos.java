
package com.campusland.respository.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Impuestos {
    private int id_impuesto;
    private Cliente cliente;
    private double impuesto_pagado;
    private double valor_total;
    private int id_ref ;
    private int producto;

    public Impuestos(Cliente cliente, double impuesto_pagado, double valor_total, int id_ref) {
        this.cliente = cliente;
        this.impuesto_pagado = impuesto_pagado;
        this.valor_total = valor_total;
        this.id_ref = id_ref;
    }
    public void imprimir(){
        System.out.println("ID cliente: "+this.getCliente().getId());
        System.out.println("Impuesto pagado: "+this.getImpuesto_pagado());
        System.out.println("Valor total: "+this.getValor_total());
        System.out.println("ID referencia impuesto: "+this.getId_ref());
    }
}
