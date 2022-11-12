/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.repositories;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.models.Empleado;
import com.example.tp_labiv.models.Recibo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gonza
 */
@Repository
public class EmpleadoDaoJPA implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Empleado> getAll() throws DaoException {
        return em.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
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

}
