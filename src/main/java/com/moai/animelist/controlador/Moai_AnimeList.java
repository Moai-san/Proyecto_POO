package com.moai.animelist.controlador;

import com.moai.animelist.vista.*;
import java.io.*;

/**
 * @author moai-san (Leonardo Gonzalez)
 * @author nlago (Nicolás Lagos)
 * @author maca (Macarena Troncoso)
 */

public class Moai_AnimeList
{
    /**
     * Metodo principal del programa
     * 
     * @param args[] Argumentos de entrada del main
     * @throws FileNotFoundException Error de archivo no encontrado
     * @throws IOException Error de I/O
     */  
    public static void main(String args[])throws FileNotFoundException,IOException
    {
        //<editor-fold defaultstate="collapsed" desc=" Seteo del aspecto de las ventanas y botones ">
        /*
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Menu_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Log_in_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarFiltrados_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddAnime_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarAnos_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(UserLists_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddYear_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_FiltradoDoble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(VentanaMostrarAnimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Menu_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Log_in_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarFiltrados_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddAnime_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarAnos_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(UserLists_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddYear_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_FiltradoDoble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(VentanaMostrarAnimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Menu_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Log_in_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarFiltrados_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddAnime_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarAnos_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(UserLists_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddYear_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_FiltradoDoble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(VentanaMostrarAnimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Menu_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Log_in_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarFiltrados_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddAnime_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(ListarAnos_Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(UserLists_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(AddYear_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_FiltradoDoble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_EliminarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAnime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(Ventana_ModificarAno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            java.util.logging.Logger.getLogger(VentanaMostrarAnimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Log_in_Window login =new Log_in_Window();
        login.setVisible(true);
    }
}
