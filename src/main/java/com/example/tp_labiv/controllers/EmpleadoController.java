/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.controllers;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.repositories.EmpleadoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonza
 */
@RestController
@Setter

//@RequestMapping("/empleados")//de similtp
public class EmpleadoController {
    @Autowired //de producto
    private EmpleadoRepository dao;

    
    @GetMapping("/empleados")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(dao.getAll());
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


    
}
