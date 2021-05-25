package com.moai.animelist.controlador;

import java.io.*;

/**
 *
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public interface GeneraArchivos
{

    /**
     *
     * @throws IOException
     */
    public void crearArchivoExcel() throws IOException;

    /**
     *
     * @throws IOException
     */
    public void crearArchivoCSV() throws IOException;
}
