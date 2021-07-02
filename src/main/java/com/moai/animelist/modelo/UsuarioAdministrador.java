package com.moai.animelist.modelo;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class UsuarioAdministrador extends Usuario
{
    /**
     * Constructor de la clase UsuarioAdministrador, usada para instanciar una variable
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
     * Metodo para modificar la Contraseña del Usuario (Sin uso actual)
     * 
     * @param actualPassword Contraseña de Usuario actual
     * @param newPassword Contraseña de Usuario nueva
     * @return Estado de la accion (Exito o Fracaso)
     */
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
