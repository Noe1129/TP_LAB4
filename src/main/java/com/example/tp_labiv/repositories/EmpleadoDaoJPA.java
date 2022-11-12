/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.repositories;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.dtos.ReporteDTO;
import com.example.tp_labiv.models.Empleado;
import com.example.tp_labiv.models.Recibo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;


@Repository
public class EmpleadoDaoJPA implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Empleado> getAll() throws DaoException {
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
    }

    @Transactional
    public void createEmpleado(Empleado empleado) {

        em.merge(empleado);
    }

    @Override
    public List<Recibo> getbyId(int id) throws DaoException {
        return (List<Recibo>) em.createQuery("SELECT e FROM Recibo e WHERE e.empleado.legajo=" + id, Recibo.class).getResultList();
    }

    @Transactional
    public void createRecibo(Recibo recibo) {
        Empleado emp = em.find(Empleado.class, recibo.getEmpleado().getLegajo());
        emp.addRecibo(recibo);

        em.merge(recibo);
    }
    
        @Override
    public List<ReporteDTO[]> getReporte(int anio, int mes) throws DaoException {
       
        String consulta="select sum(sueldo_bruto+monto_antig-(obra_social+fondo_complej+jubilacion)), empleados.area\n" +
"from empleados join recibos on empleados.legajo=recibos.legajo where recibos.anio=(:anio) and recibos.mes=(:mes)\n" +
"group by empleados.area\n" +
"order by 1"; 
        Query q = em.createNativeQuery(consulta);
         q.setParameter("anio", anio);
         q.setParameter("mes", mes);
        return (List<ReporteDTO[]>) q.getResultList();
    }
    


    


}
