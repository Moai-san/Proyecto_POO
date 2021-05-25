package com.moai.animelist.controlador;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 * 
 */

import java.io.*;
import com.moai.animelist.modelo.*;
import org.apache.poi.xssf.usermodel.*;


public class User_Management implements GeneraArchivos
{
    private Funciones llamar =new Funciones();
    //creacion de usuario
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
    
    //inicio de sesion
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
    
    @Override
    public void crearArchivoExcel() throws IOException
    {
        int x = 0;
        File Usuarios = new File("./User/");
        
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet plantilla = libro.createSheet("Usuarios");
        XSSFRow columna;
        XSSFCell fila;
        
        for(String line: Usuarios.list())
        {
            if (line.endsWith(".txt"))
            {
                columna = plantilla.createRow(x);
                fila = columna.createCell(0);
                fila.setCellValue(line);
                x++;
            }
        }
        
        FileOutputStream excel = new FileOutputStream("Usuarios.xlsx");
        libro.write(excel);
    }
    
    @Override
    public void crearArchivoCSV() throws IOException
    {
        File Usuarios = new File("./User/");
        FileWriter archive = new FileWriter("Usuarios.csv");
        
        for(String line: Usuarios.list())
        {
            if (line.endsWith(".txt"))
            {
                archive.write(line);
            }
        }
        
        archive.flush();
        archive.close();
    }
}
