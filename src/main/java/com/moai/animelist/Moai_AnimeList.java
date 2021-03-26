package com.moai.animelist;
/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 */

//import block

import java.io.*;
import com.moai.animelist.*;

public class Moai_AnimeList
{
    
    //Main class
    public static void main(String[] args) throws FileNotFoundException,IOException
    {
        Funciones funcion =new Funciones();
        funcion.importCatalogue();
    }
}
