package com.moai.animelist.controlador;

import com.moai.animelist.modelo.*;
import org.apache.poi.xssf.usermodel.*;
import java.util.*;
import java.io.*;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class User_Management implements GeneraArchivos
{
    private LinkedList<Usuario> usuarios =new LinkedList<Usuario>();
    private Funciones llamar =new Funciones();

    /**
     *
     * @param username Nombre de Usuario
     * @param password Contraseña de Usuario
     * @return Nombre de Usuario creado
     */
    // Creacion de usuario
    public String sign_up(String username, String password)
    {
        if((username==null)||(username.equals("")))
        {
            return (null);
        }
        String ruta;//ruta
        ruta= ("User/"+username+".txt");
        //se intenta abrir archivo con el username ingresado
        try
        {
            BufferedReader user = new BufferedReader(new FileReader(ruta));
        }
        catch (FileNotFoundException e)
        {
            try
            {
                //se crea el archivo del usuario
                FileWriter user = new FileWriter(ruta);
                user.append(username+","+password);
                user.close();
                //se modifica la ruta para crear los archivos de la lista de favoritos del usuario
                ruta =("User/Fav/"+username+".csv");
                user =new FileWriter(ruta);
                user.close();
                //se modifica la ruta para crear los archivos de la lista de odiados del usuario
                ruta =("User/Hate/"+username+".csv");
                user =new FileWriter(ruta);
                user.close();
                //se modifica la ruta para crear los archivos de la lista de vistos del usuario
                ruta =("User/Watched/"+username+".csv");
                user =new FileWriter(ruta);
                user.close();
                return (username);//se retorna el nombre de usuario
            }
            catch (IOException a)
            {
                return (null);
            }
        }
        return (null);
    }

    /**
     *
     * @param username Nombre de Usuario
     * @param password Contraseña de Usuario
     * @return Nombre de Usuario logueado
     * @throws IOException Error de I/O
     */
    // Inicio de sesion
    public String log_me(String username, String password) throws IOException
    {
        if(username.equals("admin"))
        {
            if(password.equals("admin"))
            {
                return "admin";
            }
            else
            {
                return (null);
            }
        }
        String correctPassword;
        String ruta ="./User/"+username+".txt";
        CSV usar =new CSV();
        try
        {
            BufferedReader user =new BufferedReader(new FileReader(ruta));
            correctPassword =user.readLine();
            correctPassword =usar.get_csvField(correctPassword, 1);
            if (password.equals(correctPassword)==true)
            {
                return(username);//se retorna el nombre de usuario
            }
            return (null);
        }
        catch (FileNotFoundException e)
        {
            return (null);
        }
    }
    
    /**
     *
     * @throws IOException Error de I/O
     */
    @Override
    public void crearArchivoExcel() throws IOException
    {   
        if(usuarios.isEmpty())
        {
            llenarLista_usuarios();
        }
        
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet plantilla = libro.createSheet("Usuarios");
        XSSFRow columna;
        XSSFCell fila;
        
        for(int i=0;i<usuarios.size();i++)
        {
            columna = plantilla.createRow(i);
            fila = columna.createCell(0);
            fila.setCellValue(usuarios.get(i).getUsername());
        }
        
        FileOutputStream excel = new FileOutputStream("Usuarios.xlsx");
        libro.write(excel);
    }
    
    /**
     *
     */
    public void llenarLista_usuarios()
    {
        File Usuarios = new File("./User/");
        for(String line: Usuarios.list())
        {
            if (line.endsWith(".txt"))
            {
                usuarios.add(new UsuarioComun(line.substring(0, line.length()-4),null));
            }
        }
    }
    
    /**
     *
     * @throws IOException Error de I/O
     */
    @Override
    public void crearArchivoCSV() throws IOException
    {
        if(usuarios.isEmpty())
        {
            llenarLista_usuarios();
        }
        
        FileWriter archive = new FileWriter("./Usuarios.csv");
        for(int i=0;i<usuarios.size();i++)
        {
            archive.write(usuarios.get(i).getUsername()+"\n");
        }
        
        archive.flush();
        archive.close();
    }
}
