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
}
