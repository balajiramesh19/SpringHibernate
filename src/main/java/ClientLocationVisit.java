import javax.persistence.*;

@Entity
@Table(name = "client_loc_visit_details")
public class ClientLocationVisit {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cliLocVisitId;


    private String clientVisitPeriod;

    @OneToOne(targetEntity = Employee.class)
    private  Employee employee;


    public int getCliLocVisitId() {
        return cliLocVisitId;
    }

    public void setCliLocVisitId(int cliLocVisitId) {
        this.cliLocVisitId = cliLocVisitId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getClientVisitPeriod() {
        return clientVisitPeriod;
    }

    public void setClientVisitPeriod(String clientVisitPeriod) {
        this.clientVisitPeriod = clientVisitPeriod;
    }

    @Override
    public String toString() {
        return "ClientLocationVisit{" +
                "cliLocVisitId=" + cliLocVisitId +
                ", clientVisitPeriod='" + clientVisitPeriod + '\'' +

                '}';
    }
}
