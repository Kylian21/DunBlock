/*
 * DunBlock JAVA project
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.*;; 
/**
 * Class to read the Monster.txt
 * @author Louis HARISMENDY & Kylian SALOMON
 */
public class ReadTextAsString {
    /**
     * Open and read the Monster.txt file.
     * @return the string readed in Monster.txt
     * @throws Exception when the file is not found
     */
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
