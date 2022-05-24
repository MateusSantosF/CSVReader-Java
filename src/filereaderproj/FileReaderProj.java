
package filereaderproj;

import interfaces.IPerson;
import model.FileReader;

/**
 *
 * @author mateus
 */
public class FileReaderProj {

    public static void main(String[] args) {
        
        /*
            CSV HEADER 
            id;firstName;LastName;Age;Departament;id;FirstName;LastName;Age;role
        
            Mateus Santos Ferreira - BV3008363
        */
        FileReader file = FileReader
                            .Configure()
                            .PathDirectory("src/database/list.csv")
                            .ReadFile()
                            .CreateList();
        
   
        for(IPerson p : file.getList()){
            System.out.println(p);
        }
    }
    
}
