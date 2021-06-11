package com.moai.animelist.modelo;

import java.util.*;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */
public class TopMap
{
    private TreeMap<Integer, HashMap<Integer, Anime>> Top;
    
    public TopMap()
    {
        this.Top = new TreeMap<Integer,HashMap<Integer,Anime>>();
    }
    
    //constructor copia
    public TopMap(TopMap toCopy)
    {
        this.Top = toCopy.Top;
    }
    
    public Map.Entry<Integer, HashMap<Integer, Anime>> firstEntry()
    {
        return Top.firstEntry();
    }
    
    public HashMap<Integer, Anime> put(int llave, HashMap<Integer, Anime> auxMap)
    {
        return Top.put(llave, auxMap);
    }
    
    public HashMap<Integer, Anime> get(int llave)
    {
        return Top.get(llave);
    }
    
    public Set<Map.Entry<Integer, HashMap<Integer, Anime>>> entrySet()
    {
        return Top.entrySet();
    }
    
    
}
