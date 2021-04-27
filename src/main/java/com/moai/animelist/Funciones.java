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

    public void agregarAnimu()
    {
        int mal_id; //myanimelist_id
        String name; //nombre
        String type; //tipo de anime (movie,tv,web-series,special,ova) ->Mapa
        int episodes; //cantidad de episodios
        String duration; //duracion
        String rating; //rating (calificacion de contenido) ->Mapa
        int year; //año lanzamiento ->Mapa
        String studio; //estudio animacion ->Mapa
        String genre; //genero anime ->Mapa
        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese ID,debe ser un numero sobre 37908, sin incluir este");
        do
        {
            mal_id =  sc.nextInt(); 
            sc.nextLine();
            if (animeExiste(mal_id))
            {
                System.out.println("ID invalido, por favor ingrese uno nuevo");
            }
        }
        while(animeExiste(mal_id));
        System.out.println("Por favor ingrese nombre");
        name  =  sc.nextLine();
        System.out.println("Por favor ingrese tipo");
        type =  sc.nextLine();
        System.out.println("Por favor ingrese episodio");
        episodes =  sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor ingrese la duracion del episodio");
        duration  =  sc.nextLine();
        System.out.println("Por favor ingrese el rating del anime");
        rating  =  sc.nextLine();
        System.out.println("Por favor ingrese año");
        year =  sc.nextInt();
        sc.nextLine();
        System.out.println("Por favor ingrese el estudio");
        studio  =  sc.nextLine();
        System.out.println("Por favor ingrese el genero");
        genre  =  sc.nextLine();
        Anime newanime = new Anime(mal_id,name,type,episodes,duration,rating,year,studio,genre);
        addAnime(newanime); //se guarda nuevo anime
    }

    public boolean animeExiste(int id)
    {
        Anime animu;
        for (int i = 0; i < catalogue.size(); i++)
        {
            animu = catalogue.get(i);
            if (animu.getMal_id() == id)
            {
                return true;
            }
        }
        return false;
    }
    
    public int addYear(String ano)
    {
        TreeMap<Integer, Anime> year = yearMap.get(ano);
        if (year == null)
        {
            year = new TreeMap<Integer, Anime>();
            yearMap.put(ano,year); 
            return(0);
        }
        else
        {
            return (-1);
        }
    }

    public Object[][] getYears()
    {
        int i =0;
        Object tabla[][] =new Object[yearMap.size()][1];
        for (Map.Entry mapElement : yearMap.entrySet()) 
        {
            int year = Integer.parseInt((String)mapElement.getKey());
            tabla[i][0]=year;
            i=(i+1);
        }
        return(tabla);
    }
    public void mostrarPorAnio()
    {
        TreeMap<Object,Object> year =  new TreeMap<Object,Object>();
        for (Map.Entry mapElement : yearMap.entrySet()) 
        {
            int anio = Integer.parseInt((String)mapElement.getKey());
            year.put(anio, anio);
        }
        year.forEach((key, value)->System.out.println("Año: " + value));
    }

    public Object[][] mostrarDel_ano(Object tabla[][],String ano)
    {
        TreeMap<Integer, Anime> pivoteAno = yearMap.get(ano);
        if (pivoteAno == null )
        {
            return tabla;
        }
        tabla =new Object[pivoteAno.size()][9];
        int i =0;
        for(Map.Entry<Integer, Anime> entry : pivoteAno.entrySet()) 
        {
            Anime anime= entry.getValue();
            tabla [i][0]=anime.getMal_id();
            tabla [i][1]=anime.getName();
            tabla [i][2]=anime.getType();
            tabla [i][3]=anime.getEpisodes();
            tabla [i][4]=anime.getDuration();
            tabla [i][5]=anime.getRating();
            tabla [i][6]=anime.getYear();
            tabla [i][7]=anime.getStudio();
            tabla [i][8]=anime.getGenre();
            i =(i+1);
        }
        return tabla;
    }
    /*public void menu()
    {
        int option =0;
        Scanner scInt = new Scanner(System.in);
        Scanner garbage = new Scanner(System.in);
        do
        {
            try
            {
                System.out.printf("Bienvenidos a Moai Anime List! :) \n\n");
                System.out.println("Por favor ingrese una opcion del 1 al 4");
                System.out.println("1: Agregar Anime");
                System.out.println("2: Agregar Año de publicacion del anime");
                System.out.println("3: Mostar Años");
                System.out.println("4: Buscar Anime por Años");
                System.out.println("Si desea salir, por favor ingrese un 0");
                option = scInt.nextInt();
                switch(option)
                {
                    case 1:
                    {
                        clrScr();
                        agregarAnimu();
                        System.out.println("Ingrese un caracter para volver al menu");
                        garbage.nextLine();
                        break;
                    }
                    case 2:
                    {
                        clrScr();
                        agregarAnio();
                        System.out.println("Ingrese un caracter para volver al menu");
                        garbage.nextLine();
                        break;
                    }
                    case 3:
                    {
                        clrScr();
                        mostrarPorAnio();
                        System.out.println("Ingrese un caracter para volver al menu");
                        garbage.nextLine();
                        break;
                    }
                    case 4: 
                    {
                        clrScr();
                        buscarPorAnio();
                        System.out.println("Ingrese un caracter para volver al menu");
                        garbage.nextLine();
                        break;
                    }
                    case 0: 
                    {
                        break;
                    }
                    default:
                    {
                        System.out.println("Ingrese una opcion valida por favor");
                        break;
                    }
                }       
            }
            catch(InputMismatchException e)
            {
                System.out.println("Ingrese opcion valida porfavor");
                option = 9;
                scInt.next();
            }   
        }
        while (option !=0);
        scInt.close();
    }
    
    public void clrScr()
    {
        try
        {
            if( System.getProperty( "os.name" ).startsWith( "Window" ) )
            {
                Runtime.getRuntime().exec("/c cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch(IOException e)
        {
            for(int i = 0; i < 10; i++)
            {
                System.out.printf("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        }
    }*/
}
