package com.moai.animelist;
/**
 * 
 * @author moai-san (Leonardo Gonzalez)
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

    public int getMal_id()
    {
        return mal_id;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getEpisodes()
    {
        return episodes;
    }

    public String getDuration()
    {
        return duration;
    }

    public String getRating()
    {
        return rating;
    }

    public int getYear()
    {
        return year;
    }

    public String getStudio()
    {
        return studio;
    }

    public String getGenre()
    {
        return genre;
    }

    //Setters

    public void setMal_id(int mal_id)
    {
        this.mal_id = mal_id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setEpisodes(int episodes)
    {
        this.episodes = episodes;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public void setStudio(String studio)
    {
        this.studio = studio;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }
    
    //Constructor
    
    public Anime(int id,int episodes,int year,String name,String type,String duration,String rating,String studio,String genre)
    {
        this.mal_id =id;
        this.name =name;
        this.type =type;
        this.episodes =episodes;
        this.duration =duration;
        this.rating =rating;
        this.year =year;
        this.studio =studio;
        this.genre =genre;
    }
}
