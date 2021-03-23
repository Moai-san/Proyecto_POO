package com.moai.animelist;
/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 */

//import block

import java.io.*;
import java.util.*;
import com.moai.animelist.*;

public class Moai_AnimeList
{
    public void addAnime()
    {
        
    }
    //Main class
    public static void main(String[] args) throws FileNotFoundException,IOException
    {
        CSV animeList =new CSV("DB");
        Anime toAdd =new Anime();
        String linea =animeList.firstLine();
        toAdd.initAnime(animeList, linea);
        ArrayList<Anime> output =new ArrayList<Anime>();
        addTo_list(toAdd);
    }
}
