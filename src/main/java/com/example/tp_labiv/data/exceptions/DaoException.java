/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tp_labiv.data.exceptions;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DaoException extends Exception {

    private String message;

    public DaoException(String message, Throwable cause) {
        super(cause);
        this.message = message;
    }

}
