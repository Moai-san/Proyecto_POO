package com.moai.animelist.vista;


import com.moai.animelist.controlador.GeneraArchivos;
import com.moai.animelist.modelo.*;
import java.io.*;
import java.util.LinkedList;
import org.apache.poi.xssf.usermodel.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author moai
 */
public class ReportUsers implements GeneraArchivos
{
    private LinkedList<Usuario> usuarios =new LinkedList<Usuario>();

    public ReportUsers()
    {
    
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
