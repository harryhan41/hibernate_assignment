package util;

import com.itlize.entity.Department;
import com.itlize.entity.Employee;
import net.bytebuddy.matcher.ElementMatcher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.ObjectOutputStream;
import java.util.List;


public class Crud {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try(factory){
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            // get
//            int id = 1;
//            Employee employee = session.get(Employee.class, id);
//            System.out.println(employee);
//            Department department = session.get(Department.class,id);
//            System.out.println(department);


            // load
//            int id = 2;
//            Employee employee = session.load(Employee.class, id);
//            System.out.println(employee);


//             add
//            session.save(employee);
//            Department department = new Department("tech");
//            session.save(department);

//              Department department = session.get(Department.class, 5);
//            Employee employee = session.get(Employee.class, 4);
//            Employee employee = new Employee(4, "tj", 27);
//              Employee employee = new Employee("joel", 56);
//              employee.setDepartment(department);
//              session.saveOrUpdate(employee);
//              System.out.println(employee);

//            Department department = session.get(Department.class, 1);
//            employee.setDepartment(department);


            // delete
//            Department department = session.get(Department.class, 5);
//            session.delete(department);
            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);
//            session.createQuery("delete from Department where id=5").executeUpdate();



            // update
//            Employee e2 = new Employee(4,"tj", 27);
//            session.update(e2);

            // get all records
//            String hql = "from Employee";
//            List<Employee> list = session.createQuery(hql).list();
//            for (Employee e: list) {
//                System.out.println(e);
//            }

            // procedure
//            Query query = session.createSQLQuery(
//                    "Call GetById(:id)")
//                    .addEntity(Employee.class)
//                    .setParameter("id", "3");
//
//            List result = query.list();
//            for (Object o : result) {
//                Employee e = (Employee) o;
//                System.out.println(e);
//            }

            // criteria
//            CriteriaQuery<Employee> cq = session.getCriteriaBuilder().createQuery(Employee.class);
//            cq.from(Employee.class);
//            List<Employee> list = session.createQuery(cq).getResultList();
//            list.forEach(e -> System.out.println(e));


            session.getTransaction().commit();
            System.out.println("Done!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
