package com.moai.animelist.vista;

import java.io.*;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public interface GeneraArchivosStrategy
{
    /**
     * Metodo de creacion de archivo Excel
     * 
     * @throws IOException Error de I/O
     */
    public void crearArchivoExcel() throws IOException;

    /**
     * Metodo de creacion de archivo CSV
     * 
     * @throws IOException Error de I/O
     */
    public void crearArchivoCSV() throws IOException;
}
