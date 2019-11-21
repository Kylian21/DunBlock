/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;; 
/**
 *
 * @author Kylian Salomon
 */
public class ReadTextAsString {
  public static String readFileAsString()throws Exception 
  { 
    String data = "";  
    
    try{
        File file = new File("src/main/java/monster.txt");
        String path= file.getAbsolutePath();
        data = new String(Files.readAllBytes(Paths.get(path)));
    }
    catch(FileNotFoundException e){
        System.out.println("e");
        System.out.println("UNABLE TO FOUND YOUR PATH, CHECK MONSTER.TXT ");
    }
    return data; 
  } 
  
}
