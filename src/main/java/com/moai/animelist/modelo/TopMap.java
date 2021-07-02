package com.moai.animelist.modelo;

import java.util.*;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class TopMap
{
    private TreeMap<Integer, HashMap<Integer, Anime>> Top;
    
    /**
     * Constructor de la clase TopMap, usada para instanciar una variable
     */
    public TopMap()
    {
        this.Top = new TreeMap<Integer,HashMap<Integer,Anime>>();
    }

    /**
     * Constructor copia de la clase AniList usada para copiar un TopMap
     * 
     * @param toCopy Variable TopMap
     */
    public TopMap(TopMap toCopy)
    {
        this.Top = toCopy.Top;
    }
    
    /**
     * Metodo que entrega el primer par llave-dato del TopMap
     * 
     * @return El primer valor de llave-dato que hay en el treemap
     */
    public Map.Entry<Integer, HashMap<Integer, Anime>> firstEntry()
    {
        return Top.firstEntry();
    }
    
    /**
     * Metodo que añade un HashMap de anime al TopMap
     * 
     * @param llave Llave de los datos a ingresar
     * @param auxMap HashMap con los datos a ingresar
     * @return Resultado de la accion (Exito o Fracaso)
     */
    public HashMap<Integer, Anime> put(int llave, HashMap<Integer, Anime> auxMap)
    {
        return Top.put(llave, auxMap);
    }
    
    /**
     * Metodo que obtiene un anime del TopMap
     * 
     * @param llave Llave del dato a buscar
     * @return Los datos que pertenecen a la llave
     */
    public HashMap<Integer, Anime> get(int llave)
    {
        return Top.get(llave);
    }
    
    /**
     * Metodo que entrega los valores de llave-datos del TopMap
     * 
     * @return Los valores de llave-datos que hay en el treemap
     */
    public Set<Map.Entry<Integer, HashMap<Integer, Anime>>> entrySet()
    {
        return Top.entrySet();
    }
}
