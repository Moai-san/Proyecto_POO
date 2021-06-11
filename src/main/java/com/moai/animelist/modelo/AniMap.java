package com.moai.animelist.modelo;

import java.util.*;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */
@SuppressWarnings("unchecked")
public class AniMap
{
    private HashMap<Object, TreeMap<Integer, Anime>> Map;
    
    /**
     *
     */
    public AniMap()
    {
        this.Map = new HashMap<Object, TreeMap<Integer, Anime>>();
    }
    
    /**
     *
     * @param datoAnime Llave de los datos a ingresar
     * @param arbol Treemap con los datos a ingresar
     * @return Resultado de la accion (Exito o Fracaso)
     */
    public TreeMap<Integer, Anime> put(String datoAnime, TreeMap arbol)
    {
        return Map.put(datoAnime, arbol);
    }
    
    /**
     *
     * @param datoAnime Llave del dato a buscar
     * @return Los datos que pertenecen a la llave
     */
    public TreeMap<Integer, Anime> get(String datoAnime)
    {
        return Map.get(datoAnime);
    }
    
    /**
     *
     * @return El tamaño del mapa (pares de llaves-datos que hay)
     */
    public int size()
    {
        return Map.size();
    }
    
    /**
     *
     * @return Los valores de llave-datos que hay en el mapa
     */
    public Set<Map.Entry<Object, TreeMap<Integer, Anime>>> entrySet()
    {
        return Map.entrySet();
    }
    
    /**
     *
     * @param dato Llave del mapa a eliminar
     * @return El treemap con el dato eliminado
     */
    public TreeMap<Integer, Anime> remove(String dato)
    {
        return Map.remove(dato);
    }
}
