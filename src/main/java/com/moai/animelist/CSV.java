package com.moai.animelist;
/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 */
import java.io.*;
import java.util.*;

public class CSV
{
    //Variables de instancia
    
    private BufferedReader file;
    private String currentLine;

    //Constructor
    
    public CSV(String name) throws FileNotFoundException
    {
      this.file =new BufferedReader(new FileReader("./"+name+".csv"));
    }
    
    public CSV()
    {

    }

    //Metodos/Funciones
    
    public String firstLine() throws IOException
    {
        return nextLine();
    }
    
    public String nextLine() throws IOException
    {
        this.currentLine =this.file.readLine();
        return(this.currentLine);
    }
    
    public String get_csvField(String line,int field)
    {
        Scanner s = new Scanner(line);
        int index =(0);
        s.useDelimiter(",|\\n");
        String output;
        while(s.hasNext())
        {
            output =(s.next());
            if((output.charAt(0))==('\"'))
            {
                while (true)
                {
                    output =(output+","+(s.next()));
                    if ((output.charAt((output.length())-1))==('\"'))
                    {
                        break;
                    }
                }
            }
            if (index==field)
            {
                return(output);
            }
            index =(index+1);
        }
        System.out.println("Campo "+field+" no Existe");
        return(null);
    }
    
    //sobrecarga ep2
    public String get_csvField(int field,String line)
    {
        Scanner s = new Scanner(line);
        int index =(0);
        s.useDelimiter(",|\\n");
        String output;
        while(s.hasNext())
        {
            output =(s.next());
            if((output.charAt(0))==('\"'))
            {
                while (true)
                {
                    output =(output+","+(s.next()));
                    if ((output.charAt((output.length())-1))==('\"'))
                    {
                        break;
                    }
                }
            }
            if (index==field)
            {
                return(output);
            }
            index =(index+1);
        }
        System.out.println("Campo "+field+" no Existe");
        return(null);
    }
}