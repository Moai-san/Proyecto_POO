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
  //Variables de instancia

  private LinkedList<Anime> catalogue =new LinkedList<Anime>(); //Lista doblemente enlazada
  //Tablas Hash con Arboles anidados, que contendran animes filtrados por genero, tipo y año
  private HashMap<Object, TreeMap<Integer, Anime>> genreMap =new HashMap<Object, TreeMap<Integer, Anime>>();
  private HashMap<Object, TreeMap<Integer, Anime>> yearMap =new HashMap<Object, TreeMap<Integer, Anime>>();
  private HashMap<Object, TreeMap<Integer, Anime>> typeMap =new HashMap<Object, TreeMap<Integer, Anime>>();
  
  //Constructor

  public Funciones()
  {

  }

  //Metodos

  //Añade anime (se ira modificando segun se creen estructuras de datos nuevas, por ahora solo ingresa al catalogo
  public void addAnime(Anime toAdd)
  {
    //se inicializan los 3 arboles como el resultado de la busqueda con clave respectiva (cada nodo del hashmap debe contener un arbol con sus respectivos anime segun filtro)
    TreeMap<Integer, Anime> type = typeMap.get(toAdd.getType());
    TreeMap<Integer, Anime> genre = genreMap.get(toAdd.getGenre());
    TreeMap<Integer, Anime> year = yearMap.get(String.valueOf(toAdd.getYear()));

    //Añadir a HashMap de tipos
    if ((typeMap.get(toAdd.getType()))==null) //si no se encontró un arbol para la clave dentro de la tabla hash, se crea uno, se inicializa, y una vez con el anime dentro, se introduce a la tabla
    {
      type = new TreeMap<Integer, Anime>();
      type.put((toAdd.getMal_id()), toAdd);
      typeMap.put((toAdd.getType()), type);
    }
    else//del contrario, solo se inserta
    {
      type.put((toAdd.getMal_id()), toAdd);
    }
    
    //Añadir a HashMap de años
    if ((yearMap.get(String.valueOf(toAdd.getYear())))==null) //si no se encontró un arbol para la clave dentro de la tabla hash, se crea uno, se inicializa, y una vez con el anime dentro, se introduce a la tabla
    {
      year = new TreeMap<Integer, Anime>();
      year.put((toAdd.getMal_id()), toAdd);
      yearMap.put((String.valueOf(toAdd.getYear())), year);
    }
    else//del contrario, solo se inserta
    {
      year.put((toAdd.getMal_id()), toAdd);
    }
    
    //Añadir a HashMap de generos
    if ((genreMap.get(toAdd.getGenre()))==null) //si no se encontró un arbol para la clave dentro de la tabla hash, se crea uno, se inicializa, y una vez con el anime dentro, se introduce a la tabla
    {
      CSV pivoteGetCSV = new CSV();
      genre = new TreeMap<Integer, Anime>();
      genre.put((toAdd.getMal_id()), toAdd);
      String generos =(toAdd.getGenre());
      generos =(generos.substring(1,((generos.length())-1)));
      for (int i = 0; i < 10; i++)//se subdivide el string en cada genero y luego se ingresa el anime a todas las listas filtradas que corresponda
      {
        if (pivoteGetCSV.get_csvField(generos, i)==null)//si el string recortado es nulo, se rompe el bucle para no generar errores
        {
          break;
        }
        else//sinó
        {
          if ((genreMap.get (pivoteGetCSV.get_csvField(generos,i)))!=null)//se busca el filtro con el genero respectivo, de estar, solo se inserta el dato
          {
            TreeMap<Integer, Anime> genreAux =genreMap.get(pivoteGetCSV.get_csvField(generos,i));
            genreAux.put((toAdd.getMal_id()), toAdd);
          }
          else//de no estar, se crea un arbol, y se ingresa el dato
          {
            TreeMap<Integer, Anime> genre2 =new TreeMap<Integer, Anime>();
            genreMap.put(pivoteGetCSV.get_csvField(generos, i), genre2);
          }
        }
      }
      genreMap.put((toAdd.getGenre()), genre);
    }
    else//del contrario, solo se inserta
    {
      genre.put((toAdd.getMal_id()), toAdd);
      CSV pivoteGetCSV = new CSV();
      String generos =(toAdd.getGenre());
      generos =(generos.substring(1,((generos.length())-1)));
      for (int i = 0; i < 10; i++)//se subdivide el string en cada genero y luego se ingresa el anime a todas las listas filtradas que corresponda
      {
        if (pivoteGetCSV.get_csvField(generos, i)==null)//si el string recortado es nulo, se rompe el bucle para no generar errores
        {
          break;
        }
        else//sinó
        {
          if ((genreMap.get (pivoteGetCSV.get_csvField(generos,i)))!=null)//se busca el filtro con el genero respectivo, de estar, solo se inserta el dato
          {
            TreeMap<Integer, Anime> genreAux =genreMap.get(pivoteGetCSV.get_csvField(generos,i));
            genreAux.put((toAdd.getMal_id()), toAdd);
          }
          else//de no estar, se crea un arbol, y se ingresa el dato
          {
            TreeMap<Integer, Anime> genre2 =new TreeMap<Integer, Anime>();
            genreMap.put(pivoteGetCSV.get_csvField(generos, i), genre2);
          }
        }
      }
    }
    
    
    //Añadir al catalogo
    catalogue.add(toAdd);
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
        if(linea.equals(""))
        {
            break;
        }
        toAdd =new Anime(animeCSV, linea);
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
        if(linea.equals(""))
        {
            break;
        }
        toAdd =new Anime(animeCSV, linea);
        this.addAnime(toAdd);
    }
  }
  
  public void chupaloJava()
  {
    TreeMap a =yearMap.get("1970");
    System.out.println(a.size());
    Collection c = a.values();
    Iterator itr = c.iterator();
    Anime k;
    //iterate through TreeMap values iterator
    while(itr.hasNext()==true)
    {
      k=(Anime)itr.next();
      System.out.println(k.getName());
    } 
  }
}
