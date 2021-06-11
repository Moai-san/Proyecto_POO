package com.moai.animelist.modelo;

import java.util.*;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */
public class AniList
{
    private LinkedList<Anime> List;
    
    public AniList()
    {
        this.List = new LinkedList<Anime>();
    }
    //constructor copia
    public AniList(AniList toCopy)
    {
        this.List = toCopy.List;
    }
    
    public boolean add(Anime toadd)
    {
        return List.add(toadd);
    }
    
    public int size()
    {
        return List.size();
    }
    
    public Anime get(int i)
    {
        return List.get(i);
    }
    
    public Anime remove(int i)
    {
        return List.remove(i);
    }
}
