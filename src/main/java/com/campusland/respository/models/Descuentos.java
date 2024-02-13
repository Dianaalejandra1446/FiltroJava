package com.campusland.respository.models;

import lombok.*;

@Data
@NoArgsConstructor
public class Descuentos {
    private int id_descuento;
    private String tipo_descuento;
    private String condiciones_aplicacion;
    private double porcentaje;
    private String estado;
    private Producto id_producto;
    private Cliente id_cliente;

    public Descuentos(int id_descuento, String tipo_descuento, String condiciones_aplicacion, double porcentaje, String varchar, Producto id_producto, Cliente id_cliente) {
        this.id_descuento = id_descuento;
        this.tipo_descuento = tipo_descuento;
        this.condiciones_aplicacion = condiciones_aplicacion;
        this.porcentaje = porcentaje;
        this.estado = estado;
        this.id_producto = id_producto;
        this.id_cliente = id_cliente;
    }
    public void imprimir(){
        System.out.println("ID descuento: "+getId_descuento());
        System.out.println("Tipo descuento: "+getTipo_descuento());
        System.out.println("Condiciones aplicacion: "+getCondiciones_aplicacion());
        System.out.println("Porcentaje: "+getPorcentaje());
        System.out.println("Estado: "+getEstado());
        System.out.println("ID producto: "+getId_producto().getCodigo());
        System.out.println("ID cliente: "+getId_cliente().getId());
    }
}

