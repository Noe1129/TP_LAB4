/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity
//@Subselect("select sum(sueldo_bruto+monto_antig-(obra_social+fondo_complej+jubilacion)) as sueldoNeto, empleados.area \n"
//        + "from empleados join recibos on empleados.legajo=recibos.legajo \n"
//        + "where recibos.anio=2022 and recibos.mes=11\n"
//        + "group by empleados.area\n"
//        + "order by sueldoNeto")
@Subselect("select sum(sueldo_bruto+monto_antig-(obra_social+fondo_complej+jubilacion)) as sueldo_neto, empleados.area,anio,mes \n"
        + "from empleados join recibos on empleados.legajo=recibos.legajo \n"
        //        + "where recibos.anio=2022 and recibos.mes=11\n"
                + "group by empleados.area\n"
      //  + "order by sueldo_neto")
)
@Synchronize({"empleados", "recibos"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Reporte {

    @Id
    private double sueldoNeto;
    private String area;
    private int anio;
    private int mes;
            

}
