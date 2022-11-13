/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.controllers;

import com.example.tp_labiv.data.exceptions.DaoException;
import com.example.tp_labiv.dtos.EmpleadoDTO;
import com.example.tp_labiv.dtos.ReciboDTO;
import com.example.tp_labiv.models.Empleado;
import com.example.tp_labiv.models.Recibo;
import com.example.tp_labiv.repositories.EmpleadoRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@Setter
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoRepository dao;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(dao.getAll());
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> registrarEmpleado(@RequestBody EmpleadoDTO empleadoDto) throws DaoException {
        Empleado empleado = new Empleado(
                empleadoDto.getNombre(),
                empleadoDto.getApellido(),
                empleadoDto.getFechaNacimiento(),
                empleadoDto.getFechaIngreso(),
                empleadoDto.getArea(),
                empleadoDto.getSueldoBruto());

        dao.createEmpleado(empleado);
        return ResponseEntity.ok("Empleado registrado");

    }

    @GetMapping("/recibo/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        if (id == 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Id recibo no puede ser 0");
        }
        try {
            return ResponseEntity.ok(dao.getbyId(id));
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error de datos!");
        }
    }

    @PostMapping("/recibos/nuevo")
    public ResponseEntity<?> registrarRecibo(@RequestBody ReciboDTO reciboDto) throws DaoException {
        Empleado aux = new Empleado();
        aux.setLegajo(reciboDto.getLegajo());
        Recibo recibo = new Recibo(0,
                reciboDto.getMes(),
                reciboDto.getAnio(),
                reciboDto.getAntiguedad(),
                reciboDto.getJubilacion(),
                reciboDto.getObraSocial(),
                reciboDto.getFondoComplejidad(),
                aux);
        dao.createRecibo(recibo);
        return ResponseEntity.ok("Recibo registrado");

    }
    
    @GetMapping("/reporte/{year}/{month}")
    public ResponseEntity<?> getReporte(@PathVariable int year, @PathVariable int month) {
        try {
            return ResponseEntity.ok(dao.getReporte(year,month));
        } catch (DaoException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }



}
