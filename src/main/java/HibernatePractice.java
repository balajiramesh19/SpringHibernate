import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibernatePractice {

    Session session = null;

    public void createResourcesAndPractice() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(ClientLocationVisit.class).addAnnotatedClass(Client.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        this.session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
//        Write TO DB
        writeToDB();
//        read an entity from DB
        readFromDB();
//        delete an Entity from DB
        deleteEntityFromDB();
        transaction.commit();
        session.close();
    }


    private void writeToDB() {
        ClientLocationVisit clientLocationVisit = new ClientLocationVisit();
        clientLocationVisit.setClientVisitPeriod("30 days to 45 days");

        Employee employee = new Employee();
        employee.setEmp_age(4);
        employee.setEmp_name("Alexa-bot");
        employee.setClientLocationVisit(clientLocationVisit);

        Client client = new Client();
        client.setClientLocation("USA");
        client.setClientName("Amazon");


        clientLocationVisit.setEmployee(employee);
        this.session.save(client);
        this.session.save(employee);

    }

    private void readFromDB() {

        System.out.println("Reading from DB");

        Query q = session.createQuery("from  Employee");
        System.out.println(q.list().toString());

        q = session.createQuery("from Employee where employee_id=:id");
        q.setParameter("id", 9);
        System.out.println(q.list().get(0).toString());


    }


    private void deleteEntityFromDB() {

        Employee employee = (Employee) session.get(Employee.class, 9);
        session.delete(employee.getClientLocationVisit());
        session.save(employee);
        session.getTransaction().commit();
        Query q = session.createQuery("from Employee where employee_id=:id");
        q.setParameter("id", 9);
        System.out.println(q.list().get(0).toString());

    }


}
