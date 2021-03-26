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
        Anime toAdd =new Anime(); //anime a añadir en estructuras de datos
        CSV animeCSV =new CSV("DB"); //archivo csv
        String linea =animeCSV.firstLine();
        toAdd.initAnime(animeCSV, linea); //inicializar valores del anime a añadir
        this.addAnime(toAdd);
        while(true)
        {
            linea =(null);
            toAdd =new Anime();
            linea =animeCSV.nextLine();
            toAdd.initAnime(animeCSV, linea);
            if(linea==(null))
            {
                break;
            }
            this.addAnime(toAdd);
        }
    }
    
    
}
