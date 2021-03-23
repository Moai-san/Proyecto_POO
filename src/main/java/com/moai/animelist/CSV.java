package com.moai.animelist;
/**
 * 
 * @author moai-san (Leonardo Gonzalez)
 * 
 */
import java.io.*;
public class CSV
{
    private BufferedReader file;
    private String currentLine;

    //constructor
    
    public CSV(String name) throws FileNotFoundException
    {
        this.file =new BufferedReader(new FileReader("./"+name+".csv"));
    }
    
    public String firstLine() throws IOException
    {
        this.currentLine =this.file.readLine();
        return(this.currentLine);
    }
    
    public String nextLine() throws IOException
    {
        this.currentLine =this.file.readLine();
        return(this.currentLine);
    }
    
    public String get_csvField(String line,int field)
    {
        String output;
        output =new String();
        return(output);
    }
    
}
