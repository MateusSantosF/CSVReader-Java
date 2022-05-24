package model;

import interfaces.ICreateList;
import interfaces.IDirectory;
import interfaces.IFile;
import interfaces.IPerson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class FileReader implements IDirectory, IFile, ICreateList {

    private String pathFile;
    private File file;
    private List<IPerson> list;

    private FileReader() {
    }

    public static IDirectory Configure() {
        return new FileReader();
    }

    @Override
    public IFile PathDirectory(String path) {
        this.pathFile = path;
        return this;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    @Override
    public ICreateList ReadFile() {
        this.file = new File(pathFile);
        return this;
    }

    @Override
    public FileReader CreateList() {

        java.io.FileReader reader;
        BufferedReader buffer;
        list = new ArrayList<>();

        if (file.exists()) {
            try {
                reader = new java.io.FileReader(file);
                buffer = new BufferedReader(reader);
               
                //Skip firstLine CSV
                buffer.readLine();
                String line = "";
                while ( ( line = buffer.readLine()) != null) {
                    String[] data = line.split(";");
                    if(data.length == 10){
                        list.add(createPerson(data));
                    }
                   
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        System.out.println("List Size: " + list.size());
        return this;
    }
    
    private IPerson createPerson(String[] data){
         
        int idEmployer = Integer.parseInt(data[0]);
        String firstNameEmployer = data[1];
        String lastNameEmployer = data[2];
        int ageEmployer = Integer.parseInt(data[3]);
        String departament = data[4];
        int idEmployee = Integer.parseInt(data[5]);     
        String firstNameEmployee = data[6];
        String lastNameEmployee = data[7];
        int ageEmployee =  Integer.parseInt(data[8]);
        String role = data[9];
        
        Employer employer = new Employer(departament, idEmployee, firstNameEmployer, lastNameEmployer, ageEmployer);
        Employee employee = new Employee(employer, role, idEmployee, firstNameEmployee, lastNameEmployee, ageEmployee);
        
        return employee;
    }
    
    public List<IPerson> getList(){
        return list;
    }

}
