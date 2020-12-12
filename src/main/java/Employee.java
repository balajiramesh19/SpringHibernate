import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @PrimaryKeyJoinColumn
    private int employee_id;
    private String emp_name;
    private int emp_age;
    @OneToOne(targetEntity = ClientLocationVisit.class,cascade=CascadeType.ALL)
    private ClientLocationVisit clientLocationVisit;

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public int getEmp_age() {
        return emp_age;
    }

    public void setEmp_age(int emp_age) {
        this.emp_age = emp_age;
    }

    public ClientLocationVisit getClientLocationVisit() {
        return clientLocationVisit;
    }

    public void setClientLocationVisit(ClientLocationVisit clientLocationVisit) {
        this.clientLocationVisit = clientLocationVisit;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_age=" + emp_age +
                ", clientLocationVisit=" + clientLocationVisit +
                '}';
    }
}
