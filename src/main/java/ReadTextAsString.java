/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.nio.file.*;; 
/**
 *
 * @author Kylian Salomon
 */
public class ReadTextAsString {
  public static String readFileAsString()throws Exception 
  { 
    String path="D:\\Documents\\ISEN_M1\\JAVA\\DunBlock\\src\\main\\java\\monster.txt";  
    String data = "";
    data = new String(Files.readAllBytes(Paths.get(path))); 
    return data; 
  } 
  
}
