/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moai.animelist.vista;

import com.moai.animelist.controlador.GeneraArchivos;
import com.moai.animelist.modelo.*;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author moai
 */
public class ReportAnime implements GeneraArchivos
{
    private AniList catalogue;

    public ReportAnime(AniList list_toUse)
    {
        this.catalogue = new AniList(list_toUse);
    }
    /**
     *
     * @throws IOException Error de I/O
     */
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
    
    /**
     *
     * @param animu Estructura Anime
     * @param line Linea de escritura de Archivo
     * @throws IOException Error de I/O
     */
    public void writeAnime_intoCSV(Anime animu, FileWriter line) throws IOException
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
    
    /**
     *
     * @throws IOException Error de I/O
     */
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
//</editor-fold>
}
