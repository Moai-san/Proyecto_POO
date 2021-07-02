package com.moai.animelist.modelo;

import java.util.*;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class AniList
{
    private LinkedList<Anime> List;
    
    /**
     * Constructor de la clase AniList, usada para instanciar una variable
     */
    public AniList()
    {
        this.List = new LinkedList<Anime>();
    }

    /**
     * Constructor copia de la clase AniList usada para copiar un AniList
     * 
     * @param toCopy Variable AniList
     */
    public AniList(AniList toCopy)
    {
        this.List = toCopy.List;
    }
    
    /**
     * Metodo que añade un anime a la AniList
     * 
     * @param toadd Estructura de anime
     * @return Estado de la accion (Exito o Fracaso)
     */
    public boolean add(Anime toadd)
    {
        return List.add(toadd);
    }
    
    /**
     * Metodo que verifica el tamaño de la AniList
     * 
     * @return El tamaño de la AniList
     */
    public int size()
    {
        return List.size();
    }
    
    /**
     * Metodo que obtiene un anime de la AniList
     * 
     * @param i Indice del anime en la AniList
     * @return El anime que se encuentra en el indice de la AniList
     */
    public Anime get(int i)
    {
        return List.get(i);
    }
    
    /**
     * Metodo que elimina un anime de la AniList
     * 
     * @param i Indice del anime en la AniList
     * @return El anime que se elimino de la AniList
     */
    public Anime remove(int i)
    {
        return List.remove(i);
    }
}
