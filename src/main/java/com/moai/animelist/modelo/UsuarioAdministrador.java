package com.moai.animelist.modelo;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 * 
 */

public class UsuarioAdministrador extends Usuario
{

    /**
     *
     * @param username Nombre de Usuario
     * @param password Contraseña de Usuario
     */
    public UsuarioAdministrador(String username, String password) 
    {
        this.username = username;
        this.password = password;
    }

    /**
     *
     * @param actualPassword Contraseña de Usuario actual
     * @param newPassword Contraseña de Usuario nueva
     * @return Estado de la accion (Exito o Fracaso)
     */
    // Sin usar aun, esta se usará en una proxima entrega.
    public int changePassword(String actualPassword, String newPassword) 
    {
        if(actualPassword.equals(this.password))
        {
            this.password = newPassword;
            return (0);
        }
        return (-1);
    }
}
