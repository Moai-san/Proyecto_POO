/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moai.animelist.vista;

import com.moai.animelist.modelo.*;
import java.io.*;

/**
 *
 * @author moai
 */
public class ExportData
{
    private AniList watched;
    private AniList faved;
    private AniList hated;
    
    public ExportData(AniList watchedTo_use,AniList favTo_use,AniList hateTo_use)
    {
        this.watched = new AniList(watchedTo_use);
        this.faved = new AniList(favTo_use);
        this.hated = new AniList(hateTo_use);
    }
        
    /**
     *
     * @param dir Nombre de carpeta
     */
    public void assertFolder_andCreate_ifFalse(String dir)
    {
        File directory=new File(dir);
        if (directory.exists()!=true)
        {
            directory.mkdirs();
        }
    }
    
    /**
     *
     * @param animu Estructura Anime
     * @param line Linea de escritura de Archivo
     * @throws IOException Error de I/O
     */
    public void writeAnime_intoCSV(Anime animu, FileWriter line) throws IOException
    {
        for (int j = 0; j < 9; j++)
        {
            /*Se guarda los valores con comas mediante el uso de switch 
            y el ciclo for que se mueve por las filas*/
            switch(j)
            {
                case 0:
                {
                    line.append(Integer.toString(animu.getMal_id()));
                    line.append(",");
                    break;
                }
                case 1:
                {
                    line.append(animu.getName());
                    line.append(",");
                    break;
                }
                case 2:
                {
                    line.append(animu.getType());
                    line.append(",");
                    break;
                }
                case 3:
                {
                    line.append(Integer.toString(animu.getEpisodes()));
                    line.append(",");
                    break;
                }
                case 4:
                {
                    line.append(animu.getDuration());
                    line.append(",");
                    break;
                }
                case 5:
                {
                    line.append(animu.getRating());
                    line.append(",");
                    break;
                }
                case 6:
                {
                    line.append(Integer.toString(animu.getYear()));
                    line.append(",");
                    break;
                }
                case 7:
                {
                    line.append(animu.getStudio());
                    line.append(",");
                    break;
                }
                case 8:
                {
                    line.append(animu.getGenre());
                    line.append("\n");
                    break;
                }
            }
        }
    }
    
    
    /**
     *
     * @param username Nombre de Usuario
     * @throws IOException Error de I/O
     */
    //modificacion datos usuario para persistencia
    //exportar listas del usuario (para no perder los datos despues de ejecutar)
    public void export_userData(String username) throws IOException
    {
        FileWriter output;
        String ruta;
        ruta =("./User/Fav/");
        assertFolder_andCreate_ifFalse(ruta);
        ruta =(ruta+username+".csv");
        output =new FileWriter(ruta);
        for (int i = 0; i < faved.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime aux =faved.get(i);
            writeAnime_intoCSV(aux,output);
        }
        output.flush();
        output.close();
        ruta =("./User/Hate/");
        assertFolder_andCreate_ifFalse(ruta);
        ruta =(ruta+username+".csv");
        output =new FileWriter(ruta);
        for (int i = 0; i < hated.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime aux =hated.get(i);
            writeAnime_intoCSV(aux,output);
        }
        output.flush();
        output.close();
        ruta =("./User/Watched/");
        assertFolder_andCreate_ifFalse(ruta);
        ruta =(ruta+username+".csv");
        output =new FileWriter(ruta);
        for (int i = 0; i < watched.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime aux =watched.get(i);
            writeAnime_intoCSV(aux,output);
        }
        output.flush();
        output.close();
    }
}
