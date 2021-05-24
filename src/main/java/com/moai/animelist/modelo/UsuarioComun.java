package com.moai.animelist.modelo;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 * 
 */
public class UsuarioComun extends Usuario{

    public UsuarioComun(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }
    
}
