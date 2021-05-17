package com.moai.animelist.controlador;

/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 */

import java.io.*;
import com.moai.animelist.modelo.*;

public class User_Management
{
    private Funciones llamar =new Funciones();
    //creacion de usuario
    public String sign_up(String username, String password)
    {
        String ruta;//ruta
        ruta= ("User/"+username+".txt");
        //se intenta abrir archivo con el username ingresado
        try
        {
            BufferedReader user = new BufferedReader(new FileReader(ruta));
        }
        catch (FileNotFoundException e)
        {
            try
            {
                //se crea el archivo del usuario
                FileWriter user = new FileWriter(ruta);
                user.append(username+","+password);
                user.close();
                //se modifica la ruta para crear los archivos de la lista de favoritos del usuario
                ruta =("User/Fav/"+username+".csv");
                user =new FileWriter(ruta);
                user.close();
                //se modifica la ruta para crear los archivos de la lista de odiados del usuario
                ruta =("User/Hate/"+username+".csv");
                user =new FileWriter(ruta);
                user.close();
                //se modifica la ruta para crear los archivos de la lista de vistos del usuario
                ruta =("User/Watched/"+username+".csv");
                user =new FileWriter(ruta);
                user.close();
                return (username);//se retorna el nombre de usuario
            }
            catch (IOException a)
            {
                return (null);
            }
        }
        return (null);
    }
    
    //inicio de sesion
    public String log_me(String username, String password) throws IOException
    {
        String correctPassword;
        String ruta ="./User/"+username+".txt";
        CSV usar =new CSV();
        try
        {
            BufferedReader user =new BufferedReader(new FileReader(ruta));
            correctPassword =user.readLine();
            correctPassword =usar.get_csvField(correctPassword, 1);
            if (password.equals(correctPassword)==true)
            {
                return(username);//se retorna el nombre de usuario
            }
            return (null);
        }
        catch (FileNotFoundException e)
        {
            return (null);
        }
    }
    
    /*public void importUser_data(String username)
    {
        CSV auxCSV =new CSV();
        File dir =new File("./User/Fav");
        String fileNames [] =dir.list();
        //struct dirent *dp;
        File input;
        String line;
        String ruta;
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
                ruta=dir+open;
                input =fopen(ruta,"r");//se abre el archivo
                while(fgets(line,421,input) != NULL) //se crea cada anime del archivo y se importa al top
                {
                    field0 =Integer.parseInt(auxCSV.get_csvField(line,0));
                    field1 =auxCSV.get_csvField(line,1);
                    field2 =auxCSV.get_csvField(line,2);
                    field3 =Integer.parseInt(auxCSV.get_csvField(line,3));
                    field4 =auxCSV.get_csvField(line,4);
                    field5 =auxCSV.get_csvField(line,5);
                    field6 =Integer.parseInt(auxCSV.get_csvField(line,6));
                    field7 =auxCSV.get_csvField(line,7);
                    field8 =auxCSV.get_csvField(line,8);
                    Anime toAdd =new Anime(field0,field1,field2,field3,field4,field5,field6,field7,field8);
                    addTo_list(4,toAdd);
                }
                fclose(input);
            }
        }
        dir =new File("./User/Hate");// se cierra el directorio
        //lo mismo que recien, pero con los odiados
        fileNames =dir.list();
        for (String open : fileNames)//se recorre el directorio favoritos
        {
            if(open.endsWith(".csv"))//si el nombre del archivo finaliza en .csv
            {
                ruta=dir+open;
                input =fopen(ruta,"r");
                while(fgets(line,421,input) != NULL) //se crea cada anime del archivo y se importa al top
                {
                    field0 =Integer.parseInt(auxCSV.get_csvField(line,0));
                    field1 =auxCSV.get_csvField(line,1);
                    field2 =auxCSV.get_csvField(line,2);
                    field3 =Integer.parseInt(auxCSV.get_csvField(line,3));
                    field4 =auxCSV.get_csvField(line,4);
                    field5 =auxCSV.get_csvField(line,5);
                    field6 =Integer.parseInt(auxCSV.get_csvField(line,6));
                    field7 =auxCSV.get_csvField(line,7);
                    field8 =auxCSV.get_csvField(line,8);
                    Anime toAdd =new Anime(field0,field1,field2,field3,field4,field5,field6,field7,field8);
                    addTo_list(5,toAdd);
                }
                fclose(input);
            }
        }
        closedir(dir);
        return;
    }*/
}
