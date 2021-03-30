package com.moai.animelist;
/**
 *
 * @author moai
 */

import java.io.*;
import java.util.*;
import com.moai.animelist.*;

public class Funciones
{
    private ArrayList<Anime> catalogue =new ArrayList<Anime>(); //Lista doblemente enlazada
    //añade anime (se ira modificando segun se creen estructuras de datos nuevas, por ahora solo ingresa al catalogo
    public void addAnime(Anime anime)
    {
        catalogue.add(anime);
    }
    
    //importa catalogo
    public void importCatalogue() throws FileNotFoundException,IOException
    {
        CSV animeCSV =new CSV("DB"); //archivo csv
        String linea =animeCSV.firstLine();
        Anime toAdd =new Anime(animeCSV, linea); //anime a añadir en estructuras de datos e inicializar valores del anime a añadir
        this.addAnime(toAdd);
        while(true)
        {
            linea =(null);
            linea =animeCSV.nextLine();
            toAdd =new Anime(animeCSV, linea);
            if(linea==(null))
            {
                break;
            }
            this.addAnime(toAdd);
        }
    }
    
    //Sobrecarga Requisito ep.2
    public void importCatalogue(CSV animeCSV,String linea) throws FileNotFoundException,IOException
    {
        Anime toAdd =new Anime(animeCSV, linea); //anime a añadir en estructuras de datos e inicializar valores del anime a añadir
        this.addAnime(toAdd);
        while(true)
        {
            linea =(null);
            linea =animeCSV.nextLine();
            toAdd =new Anime(animeCSV, linea);
            if(linea==(null))
            {
                break;
            }
            this.addAnime(toAdd);
        }
    }
    
    
}
