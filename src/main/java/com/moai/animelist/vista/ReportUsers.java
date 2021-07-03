package com.moai.animelist.vista;

import org.apache.poi.xssf.usermodel.*;
import com.moai.animelist.modelo.*;
import java.util.LinkedList;
import java.io.*;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class ReportUsers implements GeneraArchivosStrategy
{
    private LinkedList<Usuario> usuarios =new LinkedList<Usuario>();

    /**
     * Constructor de la clase ReportUsers, usada para instanciar una variable
     */
    public ReportUsers()
    {
    }
    
    /**
     * Metodo que exporta la lista de los usuarios a archivo Excel
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
        libro.close();
    }
    
    /**
     * Metodo que llena la lista de usuarios
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
     * Metodo que exporta la lista de los usuarios a archivo CSV
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
