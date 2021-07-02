package com.moai.animelist.modelo;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class Anime
{
    //Variables de instancia
    
    private int mal_id; //myanimelist_id
    private String name; //nombre
    private String type; //tipo de anime (movie,tv,web-series,special,ova) ->Mapa
    private int episodes; //cantidad de episodios
    private String duration; //duracion
    private String rating; //rating (calificacion de contenido) ->Mapa
    private int year; //año lanzamiento ->Mapa
    private String studio; //estudio animacion ->Mapa
    private String genre; //genero anime ->Mapa

    //Getters

    /**
     * Metodo getter que obtiene la ID de un anime
     * 
     * @return Id del anime
     */
    public int getMal_id()
    {
        return mal_id;
    }

    /**
     * Metodo getter que obtiene el Nombre de un anime
     * 
     * @return Nombre del anime
     */
    public String getName()
    {
        return name;
    }

    /**
     * Metodo getter que obtiene el Tipo de un anime
     * 
     * @return Tipo de anime
     */
    public String getType()
    {
        return type;
    }

    /**
     * Metodo getter que obtiene los Episodios de un anime
     * 
     * @return Episodios del anime
     */
    public int getEpisodes()
    {
        return episodes;
    }

    /**
     * Metodo getter que obtiene la Duracion de un anime
     * 
     * @return Duracion de capitulos
     */
    public String getDuration()
    {
        return duration;
    }

    /**
     * Metodo getter que obtiene el Rating de un anime
     * 
     * @return Rating del anime
     */
    public String getRating()
    {
        return rating;
    }

    /**
     * Metodo getter que obtiene el Año de un anime
     * 
     * @return Año de emision
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Metodo getter que obtiene el Estudio de un anime
     * 
     * @return Estudio(s) de animacion
     */
    public String getStudio()
    {
        return studio;
    }

    /**
     * Metodo getter que obtiene el Genero de un anime
     * 
     * @return Genero(s) del anime
     */
    public String getGenre()
    {
        return genre;
    }

    //Setters

    /**
     * Metodo setter que ingresa la ID de un anime
     * 
     * @param mal_id Id del anime
     */
    public void setMal_id(int mal_id)
    {
        this.mal_id = mal_id;
    }

    /**
     * Metodo setter que ingresa el Nombre de un anime
     * 
     * @param name Nombre del anime
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Metodo setter que ingresa el Tipo de un anime
     * 
     * @param type Tipo de anime
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * Metodo setter que ingresa los Episodios de un anime
     * 
     * @param episodes Episodios del anime
     */
    public void setEpisodes(int episodes)
    {
        this.episodes = episodes;
    }

    /**
     * Metodo setter que ingresa la Duracion de un anime
     * 
     * @param duration Duracion de capitulos
     */
    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    /**
     * Metodo setter que ingresa el Rating de un anime
     * 
     * @param rating Rating del anime
     */
    public void setRating(String rating)
    {
        this.rating = rating;
    }

    /**
     * Metodo setter que ingresa el Año de un anime
     * 
     * @param year Año de emision
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     * Metodo setter que ingresa el Estudio de un anime
     * 
     * @param studio Estudio(s) de animacion
     */
    public void setStudio(String studio)
    {
        this.studio = studio;
    }

    /**
     * Metodo setter que ingresa el Genero de un anime
     * 
     * @param genre Genero(s) del anime
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    //Constructor

    /**
     * Constructor de la clase Anime, usada para instanciar una variable usando una base de datos
     * 
     * @param animeList Archivo de base de datos CSV 
     * @param linea Linea del CSV
     */
    public Anime(CSV animeList,String linea)
    {
        
        this.setMal_id(Integer.parseInt(animeList.get_csvField(linea,0)));
        this.setName(animeList.get_csvField(linea,1));
        this.setType(animeList.get_csvField(linea,2));
        this.setEpisodes(Integer.parseInt(animeList.get_csvField(linea,3)));
        this.setDuration(animeList.get_csvField(linea,4));
        this.setRating(animeList.get_csvField(linea,5));
        this.setYear(Integer.parseInt(animeList.get_csvField(linea,6)));
        this.setStudio(animeList.get_csvField(linea,7));
        this.setGenre(animeList.get_csvField(linea,8));
    }
    
    /**
     * Constructor de la clase Anime, usada para instanciar una variable usando variables
     * 
     * @param mal_id Id del anime
     * @param name Nombre del anime
     * @param type Tipo de anime
     * @param episodes Episodios del anime
     * @param duration Duracion de capitulos
     * @param rating Rating del anime
     * @param year Año de emision
     * @param studio Estudio(s) de animacion
     * @param genre Genero(s) del anime
     */
    public Anime(int mal_id,String name,String type,int episodes,String duration,String rating,int year,String studio,String genre)
    {
        this.mal_id = mal_id;
        this.name = name;
        this.type = type;
        this.episodes = episodes;
        this.duration = duration;
        this.rating = rating;
        this.year = year;
        this.studio = studio;
        this.genre = genre;
    }

    /**
     * Constructor de la clase Anime, usada para instanciar una variable usando una Estructura Anime
     * 
     * @param toCopy Estructura Anime
     */
    public Anime(Anime toCopy)
    {
        this.setMal_id(toCopy.getMal_id());
        this.setName(toCopy.getName());
        this.setType(toCopy.getType());
        this.setEpisodes(toCopy.getEpisodes());
        this.setDuration(toCopy.getDuration());
        this.setRating(toCopy.getRating());
        this.setYear(toCopy.getYear());
        this.setStudio(toCopy.getStudio());
        this.setGenre(toCopy.getGenre());
    }
}
