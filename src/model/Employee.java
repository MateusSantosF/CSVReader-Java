
package model;

/**
 *
 * @author mateus
 */
public class Employee extends Person{
    
    private Employer employer;
    private String role;

    public Employee(Employer employer, String role) {
        this.employer = employer;
        this.role = role;
    }

    public Employee(Employer employer, String role, int id, String firstName, String lastName, int age) {
        super(id, firstName, lastName, age);
        this.employer = employer;
        this.role = role;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString(){
        return "Employer: " + employer.getFirstName() + " " + employer.getLastName() + "\n\t  Departament: " + employer.getDepartment()+"\n" 
                + "\t  Employee: " + getFirstName() + " " + getLastName() + "\n\t  Role: " + getRole() + "\n";
    }
    
}
