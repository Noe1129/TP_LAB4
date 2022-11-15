/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.repositories;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.dtos.ReporteSueldoArea;
import com.example.tp_labiv.models.Empleado;
import com.example.tp_labiv.models.Recibo;
import java.util.List;



public interface EmpleadoRepository {

    List<Empleado> getAll() throws DaoException;

    void createEmpleado(Empleado empleado) throws DaoException;

    List<Recibo> getbyId(int id) throws DaoException;

    void createRecibo(Recibo recibo) throws DaoException;

    public List<ReporteSueldoArea> getReporte(int year, int month) throws DaoException;

}
