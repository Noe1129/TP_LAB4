/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Formula;

/**
 *
 * @author gonza
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recibos")
public class Recibo {

    public Recibo(int nroRecibo, int mes, int anio, double antiguedad, double jubilacion, double obraSocial, double fondoComplejidad, Empleado empleado) {
        this.nroRecibo = nroRecibo;
        this.mes = mes;
        this.anio = anio;
        this.antiguedad = antiguedad;
        this.jubilacion = jubilacion;
        this.obraSocial = obraSocial;
        this.fondoComplejidad = fondoComplejidad;
        this.empleado = empleado;
    }
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_recibo")
    private int nroRecibo;

    private int mes;

    private int anio;

    @Column(name = "monto_antig")
    private double antiguedad;

    private double jubilacion;

    @Column(name = "obra_social")
    private double obraSocial;

    @Column(name = "fondo_complej")
    private double fondoComplejidad;
    
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn (name = "legajo")
    @JsonBackReference
    private Empleado empleado;
    
//    @Transient
//    private double sueldoNeto=this.jubilacion;
//    @Formula("monto_antig+e.sueldo_bruto")
//    private float sueldoNeto;
   // private double valor= empleado.getSueldoBruto();
    
//        @Formula("(select count(monto_antig) from recibos)")
//    private float sueldoNeto;
        
    @Formula("(select empleados.sueldo_bruto+monto_antig-(obra_social+fondo_complej+jubilacion) from empleados where empleados.legajo=legajo)")
    private float sueldoNeto;
    
}
