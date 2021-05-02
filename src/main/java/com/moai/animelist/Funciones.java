package com.moai.animelist;
/**
 *
 * @author moai
 */

import java.io.*;
import java.util.*;
import com.moai.animelist.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

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
    
    public Anime buscarAnime(int id)
    {
        Anime animu;
        
        for (int i = 0; i < catalogue.size(); i++)
        {
            animu = catalogue.get(i); 
            if (animu.getMal_id() == id)
            {
                return animu;
            }
        }
        
        return null;
    }
    
    public int eliminarAnime(String stringID)
    {
        int id = Integer.parseInt(stringID);
        return eliminarAnimeColecciones(id);
    }
    
    public int eliminarAno(String ano)
    {
        /* Se crea una variable treeMap que contenga los animes del año a eliminar
        y una LinkedList con las id de esos animes.*/
        TreeMap<Integer, Anime> year = yearMap.get(ano);
        LinkedList <Integer> id = new LinkedList<Integer>();
        
        if (year == null) return (-1);
        
        // Se navega a traves del treeMap de animes y se guarda las id en la LinkedList
        for(Map.Entry<Integer, Anime> entry : year.entrySet()) 
        {
            int key = entry.getKey();
            id.add(key);
        }
        
        /*El ciclo for llama a el metodo de eliminacion de anime en las colecciones del programa,
        el cual elimina los animes del año seleccionado*/
        for (int i = 0; i < id.size(); i++)
        {
            eliminarAnimeColecciones(id.get(i));
        }
        
        // Con los animes eliminados de las colecciones se elimina la clave del año
        yearMap.remove(ano);

        return 0;
    }
    
    public int modificarAno(String viejo, String nuevo)
    {
        TreeMap<Integer, Anime> year = yearMap.get(viejo);
        if (year == null) return (-1);
        int largo =year.size();
        Anime aniArray[] =new Anime[largo];
        int i =0;
        for(Map.Entry<Integer, Anime> entry : year.entrySet())
        {
            Anime a=new Anime(entry.getValue());
            aniArray[i] =a;
            aniArray[i].setYear(Integer.parseInt(nuevo));
            i++;
        }
        eliminarAno(viejo);
        for(i=0;i<largo;i++)
        {
            addAnime(aniArray[i]);
        }
        return (0);
    }
    
    public int eliminarAnimeColecciones(int id)
    {
        boolean encontrado = false;
        Anime animu = null;
        for (int i = 0; i < catalogue.size(); i++)
        {
            animu = catalogue.get(i);
            if (animu.getMal_id() == id)
            {
                catalogue.remove(i);
                encontrado = true;
                break;
            }
        }
        if(animu == null || encontrado == false)
        {
            return (-1);
        }
    
        //Obtenemos el treemap de tipos, y lo eliminamos
        TreeMap<Integer, Anime> type = typeMap.get(animu.getType());
        type.remove(id);
        
        //Obtenemos el treemap de generos, y lo eliminamos
        TreeMap<Integer, Anime> genre = genreMap.get(animu.getGenre());
        genre.remove(id);
        
        //Obtenemos el treemap de años, y lo eliminamos
        TreeMap<Integer, Anime> year = yearMap.get(String.valueOf(animu.getYear()));
        year.remove(id);
        
        return 0;
    }
    
    public int modificarID(String stringAnimeID, String stringNuevoID)
    { 
        int animeID = Integer.parseInt(stringAnimeID);
        int nuevoID = Integer.parseInt(stringNuevoID);
        Anime animu = buscarAnime(animeID);

        //si es que el ID nuevo ya está ocupado por otro anime se retorna -1
        if(buscarAnime(nuevoID) != null) return (-1);
        
        //si el dato no existe retorna -1
        if(eliminarAnimeColecciones(animeID) == -1 || animu == null) return (-1);
        
        /*Si es que ninguno de los casos anteriores sucedió, siginifica que:
        -hay un anime con el id entregado
        -el nuevo id no está tomado por ningun otro anime
        por lo tanto se procede a volver a agregar el dato a todas las colecciones
        ya que fue eliminado por contar con la clave antigua en los treemaps*/
        
        //lo volvemos a agregar en todas las colecciones
        animu.setMal_id(nuevoID);
        addAnime(animu);
        
        return 0;
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
        
        if (pivoteAno == null)
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
    
    public void crearArchivoExcel() throws IOException
    {
        // Se crean las variables de libro (excel), plantilla (con nombre Animes), columna y fila de el excel (celdas).
        XSSFWorkbook libro = new XSSFWorkbook();
        XSSFSheet plantilla = libro.createSheet("Animes");
        XSSFRow columna;
        XSSFCell fila;
        
        // Ciclo que se mueve a travez de las columnas
        for (int i = 0; i < catalogue.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes y la columna del excel
            Anime animu = catalogue.get(i);
            columna = plantilla.createRow(i);
            
            // Ciclo que se mueve a travez de las filas
            for (int j = 0; j < 9; j++)
            {
                /* Se crea la fila de la columna y se guarda el valor que 
                corresponde en cada fila mediante el switch*/
                fila = columna.createCell(j);
                
                switch(j)
                {
                    case 0:
                    {
                        fila.setCellValue(animu.getMal_id());
                        break;
                    }
                    case 1:
                    {
                        fila.setCellValue(animu.getName());
                        break;
                    }
                    case 2:
                    {
                        fila.setCellValue(animu.getType());
                        break;
                    }
                    case 3:
                    {
                        fila.setCellValue(animu.getEpisodes());
                        break;
                    }
                    case 4:
                    {
                        fila.setCellValue(animu.getDuration());
                        break;
                    }
                    case 5:
                    {
                        fila.setCellValue(animu.getRating());
                        break;
                    }
                    case 6:
                    {
                        fila.setCellValue(animu.getYear());
                        break;
                    }
                    case 7:
                    {
                        fila.setCellValue(animu.getStudio());
                        break;
                    }
                    case 8:
                    {
                        fila.setCellValue(animu.getGenre());
                        break;
                    }
                }
            }
        }
        
        // Se crea el excel con el nombre Moai_AnimeList_Excel y los datos de la variable libro
        FileOutputStream excel = new FileOutputStream("Moai_AnimeList_Excel.xlsx");
        libro.write(excel);
    }
    
    public void crearArchivoCSV() throws IOException
    {
        // Se crea el CSV con el nombre Moai_AnimeList_CSV
        FileWriter line = new FileWriter("Moai_AnimeList_CSV.csv");
        
        // Ciclo que se mueve por las columnas
        for (int i = 0; i < catalogue.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime animu = catalogue.get(i);
            
            for (int j = 0; j < 9; j++)
            {
                /*Se guarda los valores con comas mediante el uso de switch 
                y el ciclo for que se mueve por las filas*/
                switch(j)
                {
                    case 0:
                    {
                        line.append(Integer.toString(animu.getMal_id()));
                        line.append(",");
                        break;
                    }
                    case 1:
                    {
                        line.append(animu.getName());
                        line.append(",");
                        break;
                    }
                    case 2:
                    {
                        line.append(animu.getType());
                        line.append(",");
                        break;
                    }
                    case 3:
                    {
                        line.append(Integer.toString(animu.getEpisodes()));
                        line.append(",");
                        break;
                    }
                    case 4:
                    {
                        line.append(animu.getDuration());
                        line.append(",");
                        break;
                    }
                    case 5:
                    {
                        line.append(animu.getRating());
                        line.append(",");
                        break;
                    }
                    case 6:
                    {
                        line.append(Integer.toString(animu.getYear()));
                        line.append(",");
                        break;
                    }
                    case 7:
                    {
                        line.append(animu.getStudio());
                        line.append(",");
                        break;
                    }
                    case 8:
                    {
                        line.append(animu.getGenre());
                        line.append("\n");
                        break;
                    }
                }
            }
        }
        line.flush();
        line.close();
    }
}