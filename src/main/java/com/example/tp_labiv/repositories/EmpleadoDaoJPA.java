/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.repositories;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.dtos.ReporteSueldoArea;
import com.example.tp_labiv.models.Empleado;
import com.example.tp_labiv.models.Recibo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpleadoDaoJPA implements EmpleadoRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private DataSource dataSource;

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
    public List<ReporteSueldoArea> getReporte(int year, int month) throws DaoException {

        List<ReporteSueldoArea> lst = new ArrayList<>();
        String consulta = "SELECT * FROM ReporteSueldoArea WHERE anio=" + year + " AND mes=" + month;

        try ( Connection cnn = dataSource.getConnection();  Statement st = cnn.createStatement();  ResultSet rs = st.executeQuery(consulta);) {
            while (rs.next()) {
                int anio = rs.getInt("anio");
                int mes = rs.getInt("mes");
                String area = rs.getString("area");
                double neto = rs.getDouble("Neto");

                lst.add(new ReporteSueldoArea(anio, mes, area, neto));

            }
        } catch (SQLException e) {
            throw new DaoException("Error de datos", e);
        }

        return lst;
    }

}
