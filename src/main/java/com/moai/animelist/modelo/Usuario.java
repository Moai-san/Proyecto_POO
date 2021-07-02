package com.moai.animelist.modelo;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public abstract class Usuario
{

    /**
     * Variable protegida de Nombre de Usuario
     */
    protected String username;

    /**
     * Variable protegida de Contraseña de Usuario
     */
    protected String password;
    
    /**
     * Metodo getter que obtiene el Username
     * 
     * @return Nombre de Usuario
     */
    public String getUsername() 
    {
        return username;
    }
}
