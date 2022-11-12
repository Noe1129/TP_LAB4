/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.dtos;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EmpleadoDTO {

    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private String area;
    private double sueldoBruto;

}
