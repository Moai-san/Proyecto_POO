/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moai.animelist.modelo;

/**
 *
 * @author moai
 */
public class UnexpectedInputException extends Exception
{
    public UnexpectedInputException()
    {
        super("Illegal Input");
    }
}