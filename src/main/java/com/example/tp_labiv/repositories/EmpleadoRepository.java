/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.repositories;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.models.Empleado;
import com.example.tp_labiv.models.Recibo;
import com.example.tp_labiv.models.Reporte;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gonza
 */
public interface EmpleadoRepository  {

    List<Empleado> getAll() throws DaoException;

    void createEmpleado(Empleado empleado) throws DaoException;

    List<Recibo> getbyId(int id) throws DaoException;

    void createRecibo(Recibo recibo) throws DaoException;
    
  
}
