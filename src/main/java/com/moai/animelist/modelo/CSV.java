package com.moai.animelist.modelo;

import java.util.*;
import java.io.*;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 * 
 */

public class CSV
{
    //Variables de instancia
    
    private BufferedReader file;
    private String currentLine;

    //Constructor

    /**
     *
     * @param name Nombre del archivo
     * @throws FileNotFoundException Error de archivo no encontrado
     */
    public CSV(String name) throws FileNotFoundException
    {
      this.file =new BufferedReader(new FileReader("./"+name+".csv"));
    }
    
    /**
     *
     * @param ruta Direccion del archivo en carpeta
     * @param archivo Nombre del archivo
     * @throws FileNotFoundException Error de archivo no encontrado
     */
    public CSV(String ruta,String archivo) throws FileNotFoundException
    {
        this.file =new BufferedReader(new FileReader(ruta+archivo));
    }
    
    /**
     *
     */
    public CSV()
    {
    }

    //Metodos/Funciones

    /**
     *
     * @return Primera linea del CSV
     * @throws IOException Error de I/O
     */
    public String firstLine() throws IOException
    {
        return nextLine();
    }
    
    /**
     *
     * @return Linea siguiente del CSV
     * @throws IOException Error de I/O
     */
    public String nextLine() throws IOException
    {
        this.currentLine =this.file.readLine();
        return(this.currentLine);
    }
    
    /**
     *
     * @param line Linea del CSV
     * @param field Campo de la linea del CSV
     * @return Dato del campo del CSV
     */
    public String get_csvField(String line,int field)
    {
        Scanner s = new Scanner(line);
        int index =(0);
        s.useDelimiter(",|\\n");
        String output;
        
        while(s.hasNext())
        {
            output =(s.next());
            if((output.charAt(0))==('\"'))
            {
                while (true)
                {
                    if ((output.charAt((output.length())-1))==('\"'))
                    {
                        break;
                    }
                    output =(output+","+(s.next()));
                }
            }
            
            if (index==field)
            {
                s.close();
                return(output);
            }
            index =(index+1);
        }
        //System.out.println("Campo "+field+" no Existe");
        s.close();
        return(null);
    }

    /**
     *
     * @param field Campo de la linea del CSV
     * @param line Linea del CSV
     * @return Dato del campo del CSV
     */
    // Sobrecarga ep2
    public String get_csvField(int field,String line)
    {
        Scanner s = new Scanner(line);
        int index =(0);
        s.useDelimiter(",|\\n");
        String output;
        
        while(s.hasNext())
        {
            output =(s.next());
            if((output.charAt(0))==('\"'))
            {
                while (true)
                {
                    output =(output+","+(s.next()));
                    if ((output.charAt((output.length())-1))==('\"'))
                    {
                        break;
                    }
                }
            }
            
            if (index==field)
            {
                return(output);
            }
            index =(index+1);
        }
        //System.out.println("Campo "+field+" no Existe");
        return(null);
    }
    
    /**
     *
     * @throws IOException Error de I/O
     */
    public void close() throws IOException
    {
        file.close();
    }
}