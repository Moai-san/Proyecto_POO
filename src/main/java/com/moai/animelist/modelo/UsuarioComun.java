package com.moai.animelist.modelo;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 * 
 */

public class UsuarioComun extends Usuario{

    /**
     *
     * @param username Nombre de Usuario
     * @param password Contraseña de Usuario
     */
    public UsuarioComun(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
}
