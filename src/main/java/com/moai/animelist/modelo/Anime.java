package com.moai.animelist.modelo;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 * 
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
     *
     * @return Id del anime
     */
    public int getMal_id()
    {
        return mal_id;
    }

    /**
     *
     * @return Nombre del anime
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return Tipo de anime
     */
    public String getType()
    {
        return type;
    }

    /**
     *
     * @return Episodios del anime
     */
    public int getEpisodes()
    {
        return episodes;
    }

    /**
     *
     * @return Duracion de capitulos
     */
    public String getDuration()
    {
        return duration;
    }

    /**
     *
     * @return Rating del anime
     */
    public String getRating()
    {
        return rating;
    }

    /**
     *
     * @return Año de emision
     */
    public int getYear()
    {
        return year;
    }

    /**
     *
     * @return Estudio(s) de animacion
     */
    public String getStudio()
    {
        return studio;
    }

    /**
     *
     * @return Genero(s) del anime
     */
    public String getGenre()
    {
        return genre;
    }

    //Setters

    /**
     *
     * @param mal_id Id del anime
     */
    public void setMal_id(int mal_id)
    {
        this.mal_id = mal_id;
    }

    /**
     *
     * @param name Nombre del anime
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     *
     * @param type Tipo de anime
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     *
     * @param episodes Episodios del anime
     */
    public void setEpisodes(int episodes)
    {
        this.episodes = episodes;
    }

    /**
     *
     * @param duration Duracion de capitulos
     */
    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    /**
     *
     * @param rating Rating del anime
     */
    public void setRating(String rating)
    {
        this.rating = rating;
    }

    /**
     *
     * @param year Año de emision
     */
    public void setYear(int year)
    {
        this.year = year;
    }

    /**
     *
     * @param studio Estudio(s) de animacion
     */
    public void setStudio(String studio)
    {
        this.studio = studio;
    }

    /**
     *
     * @param genre Genero(s) del anime
     */
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    //Constructor

    /**
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
