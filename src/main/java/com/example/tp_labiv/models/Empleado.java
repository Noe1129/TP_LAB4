/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gonza
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

 @Id
  //  @GeneratedValue
    @Column(name = "legajo")
    private int legajo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "fecha_nac")
    private Date fechaNacimiento;
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;
    @Column(name = "area")
    private String area;
    @Column(name = "sueldo_bruto")
    private double sueldoBruto;

    @OneToMany(targetEntity = Recibo.class, mappedBy = "empleado")
    @JsonManagedReference
    private List<Recibo> recibos;

}
