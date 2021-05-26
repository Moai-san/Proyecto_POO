package com.moai.animelist.modelo;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 * 
 */

public abstract class Usuario
{

    /**
     *
     */
    protected String username;

    /**
     *
     */
    protected String password;
    
    /**
     *
     * @return Nombre de Usuario
     */
    public String getUsername() 
    {
        return username;
    }
}
