package com.moai.animelist.controlador;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 */

import com.moai.animelist.modelo.CSV;
import com.moai.animelist.modelo.Anime;
import java.io.*;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class Funciones implements Reportable
{
    //Variables de instancia
    //Catalogo sin filtrar
    private LinkedList<Anime> catalogue =new LinkedList<Anime>();
    //Listas de usuario
    private LinkedList<Anime> watched =new LinkedList<Anime>();
    private LinkedList<Anime> faved =new LinkedList<Anime>();
    private LinkedList<Anime> hated =new LinkedList<Anime>();
    //Tops a nivel aplicacion
    private TreeMap<Integer,HashMap<Integer,Anime>> most_faved;
    private TreeMap<Integer,HashMap<Integer,Anime>> most_hated;
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
        //se crea treemap para obtener los animes de ese año y tambien para tener el largo del array que se usa
        TreeMap<Integer, Anime> year = yearMap.get(viejo);
        //si el treemap es nulo, el año no existe, por lo que se retorna -1, que es nuestro "flag de error"
        if (year == null) return (-1);
        int largo =year.size();
        Anime aniArray[] =new Anime[largo];
        int i =0;
        //se recorre el treemap y se rellena el arreglo de animes, modificando el año en cada uno de ellos
        for(Map.Entry<Integer, Anime> entry : year.entrySet())
        {
            Anime a=new Anime(entry.getValue());
            aniArray[i] =a;
            aniArray[i].setYear(Integer.parseInt(nuevo));
            i++;
        }
        //se elimina el año que se deseaba modificar, y luego, se insetan todos los anime con el año ya modificado, lo cual en  caso de existir ya el año, se agregarian al arbol de ese año
        //y en caso de no existir, se crearia un arbol nuevo
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
        Integer array[] =new Integer[yearMap.size()];
        for (Map.Entry mapElement : yearMap.entrySet()) 
        {
            int year = Integer.parseInt((String)mapElement.getKey());
            array[i]=year;
            i=(i+1);
        }
        Arrays.sort(array);
        for(i=0;i<yearMap.size();i++)
        {
            tabla[i][0]=array[i];
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

    public Object[][] mostrarPor_filtro(Object tabla[][],String filtro, int a)
    {
        int i;
        switch(a)
        {
            case 0:
                TreeMap<Integer, Anime> pivoteAno = yearMap.get(filtro);
        
                if (pivoteAno == null)
                {
                    return tabla;
                }
                tabla =new Object[pivoteAno.size()][9];
                i = 0;

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
                
            case 1:
                TreeMap<Integer, Anime> pivoteType = typeMap.get(filtro);
        
                if (pivoteType == null)
                {
                    return tabla;
                }
                tabla =new Object[pivoteType.size()][9];
                i = 0;

                for(Map.Entry<Integer, Anime> entry : pivoteType.entrySet()) 
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
                
            case 2:
                TreeMap<Integer, Anime> pivoteGenre = genreMap.get(filtro);
        
                if (pivoteGenre == null)
                {
                    return tabla;
                }
                tabla =new Object[pivoteGenre.size()][9];
                i = 0;

                for(Map.Entry<Integer, Anime> entry : pivoteGenre.entrySet()) 
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
                    i = (i+1);
                }

                return tabla;
        }
        
        return tabla;
    }
    
    @Override
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
    
    public void writeAnime_intoCSV(Anime animu, FileWriter line)throws IOException
    {
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
    
    @Override
    public void crearArchivoCSV() throws IOException
    {
        // Se crea el CSV con el nombre Moai_AnimeList_CSV
        FileWriter line = new FileWriter("Moai_AnimeList_CSV.csv");
        // Ciclo que se mueve por las columnas
        for (int i = 0; i < catalogue.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime animu = catalogue.get(i);
            writeAnime_intoCSV(animu,line);
        }
        line.flush();
        line.close();
    }
    
    //modificacion datos usuario para persistencia
    //exportar listas del usuario (para no perder los datos despues de ejecutar)
    public void export_userData(String username) throws IOException
    {
        FileWriter output;
        String ruta;
        ruta =("./User/Fav/");
        assertFolder_andCreate_ifFalse(ruta);
        ruta =(ruta+username+".csv");
        output =new FileWriter(ruta);
        for (int i = 0; i < watched.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime aux =faved.get(i);
            writeAnime_intoCSV(aux,output);
        }
        output.flush();
        output.close();
        ruta =("./User/Hate/");
        assertFolder_andCreate_ifFalse(ruta);
        ruta =(ruta+username+".csv");
        output =new FileWriter(ruta);
        for (int i = 0; i < watched.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime aux =hated.get(i);
            writeAnime_intoCSV(aux,output);
        }
        output.flush();
        output.close();
        ruta =("./User/Watched/");
        assertFolder_andCreate_ifFalse(ruta);
        ruta =(ruta+username+".csv");
        output =new FileWriter(ruta);
        for (int i = 0; i < watched.size(); i++)
        {
            // Se crea una variable anime con los datos correspondientes
            Anime aux =watched.get(i);
            writeAnime_intoCSV(aux,output);
        }
        output.flush();
        output.close();
    }
    
    public void assertFolder_andCreate_ifFalse(String dir)
    {
        File directory=new File(dir);
        if (directory.exists()!=true)
        {
            directory.mkdirs();
        }
    }
    
    //retorna un array de 2 object, donde la primera casilla es el numero de gente que lo tiene en su lista, y la casilla 2 es el anime,
    //en caso de no estar en ninguna lista, retorna null
    public Object[] searchFrom_globalList(int option, int id)//buscar dentro de tops
    {
        //declaraciones
        TreeMap<Integer,HashMap<Integer,Anime>> lista;
        //si opcion ingresada por user es 1, se busca en favoritos
        if (option==1)
        {
            lista =most_faved;
        }
        else//sinó en odiados
        {
            lista =most_hated;
        }
        for(Map.Entry<Integer,HashMap<Integer,Anime>> forSearch : lista.entrySet()) 
        {
            Anime aux =forSearch.getValue().get(id);
            if(aux!=null)
            {
                Object output[] =new Object[]{forSearch.getKey(),aux};
                return output;
            }
        }
        return(null);
    }
    
    public void addTo_Top(int option, Anime toAdd)
    {
        switch (option)
        {
            case 0://top favoritos
            {
                Object positionNode[] =searchFrom_globalList(1,toAdd.getMal_id());
                HashMap<Integer,Anime> topush;
                if (positionNode==null)
                {
                    topush =most_faved.firstEntry().getValue();
                    if (topush!=null)
                    {
                        topush.put(toAdd.getMal_id(),toAdd);
                    }
                    else
                    {
                        int key =1;
                        topush =new HashMap<Integer,Anime>();
                        topush.put(toAdd.getMal_id(),toAdd);
                        most_faved.put(key, topush);
                    }
                }
                else
                {
                    int key = (int)(positionNode[0]);
                    key =(key+1);
                    topush =most_faved.get(positionNode[0]);
                    Anime aux = (Anime)positionNode[1];
                    topush.remove(aux.getMal_id());
                    topush =most_faved.get(key);
                    if (topush!=null)
                    {
                        topush.put(toAdd.getMal_id(), toAdd);
                    }
                    else
                    {
                        topush =new HashMap<Integer,Anime>();
                        topush.put(toAdd.getMal_id(),toAdd);
                        most_faved.put(key, topush);
                    }
                }
                break;
            }
            case 1://top odiados
            {
                Object positionNode[] =searchFrom_globalList(2,toAdd.getMal_id());
                HashMap<Integer,Anime> topush;
                if (positionNode==null)
                {
                    topush =most_hated.firstEntry().getValue();
                    if (topush!=null)
                    {
                        topush.put(toAdd.getMal_id(),toAdd);
                    }
                    else
                    {
                        int key =1;
                        topush =new HashMap<Integer,Anime>();
                        topush.put(toAdd.getMal_id(),toAdd);
                        most_hated.put(key, topush);
                    }
                }
                else
                {
                    int key = (int)(positionNode[0]);
                    key =(key+1);
                    topush =most_hated.get(positionNode[0]);
                    Anime aux = (Anime)positionNode[1];
                    topush.remove(aux.getMal_id());
                    topush =most_hated.get(key);
                    if (topush!=null)
                    {
                        topush.put(toAdd.getMal_id(), toAdd);
                    }
                    else
                    {
                        topush =new HashMap<Integer,Anime>();
                        topush.put(toAdd.getMal_id(),toAdd);
                        most_hated.put(key, topush);
                    }
                }
                break;
            }
        }
    }
    public void addTo_userList(int option, Anime toAdd)
    {
        switch (option) //si opcion es 0, se añade a vistos, si es 1 se añade a favoritos, si es 2 se añade a odiados.
        {
            case 0:
            {
                watched.add(toAdd);
                break;
            }
            case 1:
            {
                faved.add(toAdd);
                break;
            }
            case 2:
            {
                hated.add(toAdd);
                break;
            }
        }
    }
    public void importUser_data(String username) throws FileNotFoundException, IOException
    {
        //CSV auxCSV =new CSV();
        File dir =new File("./User/Fav");
        String fileNames [] =dir.list();
        String line;
        String ruta;
        //campos del csv
        int field0;
        String field1;
        String field2;
        int field3;
        String field4;
        String field5;
        int field6;
        String field7;
        String field8;
        for (String open : fileNames)//se recorre el directorio favoritos
        {
            if(open.endsWith(".csv"))//si el nombre del archivo finaliza en .csv
            {
                ruta=dir.getPath()+open;
                CSV input =new CSV(ruta);//se abre el archivo
                while(true)
                {
                    line =(null);
                    line =input.nextLine();
                    field0 =Integer.parseInt(input.get_csvField(line,0));
                    field1 =input.get_csvField(line,1);
                    field2 =input.get_csvField(line,2);
                    field3 =Integer.parseInt(input.get_csvField(line,3));
                    field4 =input.get_csvField(line,4);
                    field5 =input.get_csvField(line,5);
                    field6 =Integer.parseInt(input.get_csvField(line,6));
                    field7 =input.get_csvField(line,7);
                    field8 =input.get_csvField(line,8);
                    if(line.equals(""))
                    {
                        break;
                    }
                    Anime toAdd =new Anime(field0,field1,field2,field3,field4,field5,field6,field7,field8);
                    addTo_Top(0,toAdd);
                    if(open.equals(username))
                    {
                        addTo_userList(1,toAdd);
                    }
                }
                input.close();
            }
        }
        dir =new File("./User/Hate");
        //lo mismo que recien, pero con los odiados
        fileNames =dir.list();
        for (String open : fileNames)//se recorre el directorio odiados
        {
            if(open.endsWith(".csv"))//si el nombre del archivo finaliza en .csv
            {
                ruta=dir.getPath()+open;
                CSV input =new CSV(ruta);//se abre el archivo
                while(true)
                {
                    line =(null);
                    line =input.nextLine();
                    field0 =Integer.parseInt(input.get_csvField(line,0));
                    field1 =input.get_csvField(line,1);
                    field2 =input.get_csvField(line,2);
                    field3 =Integer.parseInt(input.get_csvField(line,3));
                    field4 =input.get_csvField(line,4);
                    field5 =input.get_csvField(line,5);
                    field6 =Integer.parseInt(input.get_csvField(line,6));
                    field7 =input.get_csvField(line,7);
                    field8 =input.get_csvField(line,8);
                    if(line.equals(""))
                    {
                        break;
                    }
                    Anime toAdd =new Anime(field0,field1,field2,field3,field4,field5,field6,field7,field8);
                    addTo_Top(1,toAdd);
                    if(open.equals(username))
                    {
                        addTo_userList(2,toAdd);
                    }
                }
                input.close();
            }
        }
        dir =new File("./User/");
        //lo mismo que recien, pero con los odiados
        fileNames =dir.list();
        for (String open : fileNames)//se recorre el directorio odiados
        {
            if (open.startsWith(username))
            {
                ruta=dir.getPath()+open;
                CSV input =new CSV(ruta);//se abre el archivo
                while(true)
                {
                    line =(null);
                    line =input.nextLine();
                    field0 =Integer.parseInt(input.get_csvField(line,0));
                    field1 =input.get_csvField(line,1);
                    field2 =input.get_csvField(line,2);
                    field3 =Integer.parseInt(input.get_csvField(line,3));
                    field4 =input.get_csvField(line,4);
                    field5 =input.get_csvField(line,5);
                    field6 =Integer.parseInt(input.get_csvField(line,6));
                    field7 =input.get_csvField(line,7);
                    field8 =input.get_csvField(line,8);
                    if(line.equals(""))
                    {
                        input.close();
                        return;
                    }
                    Anime toAdd =new Anime(field0,field1,field2,field3,field4,field5,field6,field7,field8);
                    addTo_userList(0,toAdd);
                }
            }
        }
    }
}