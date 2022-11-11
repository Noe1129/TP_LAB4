/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.repositories;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.models.Empleado;
import java.util.List;

/**
 *
 * @author gonza
 */
public interface EmpleadoRepository {
    List<Empleado> getAll() throws DaoException;
}
