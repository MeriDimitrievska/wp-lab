//package mk.ukim.finki.wp.lab.bootstrap;
//
//import mk.ukim.finki.wp.lab.model.Course;
//import mk.ukim.finki.wp.lab.model.Student;
//import mk.ukim.finki.wp.lab.model.Teacher;
//import mk.ukim.finki.wp.lab.model.enums.Type;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import javax.servlet.http.HttpSession;
//import javax.websocket.Session;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class DataHolder {
//    public static List<Student> students=new ArrayList<>();
//    public static List<Course> courses=new ArrayList<>();
//    public static List<HttpSession> sessions=new ArrayList<>();
//    public static List<Teacher> teachers=new ArrayList<>();
//
//    @PostConstruct
//    public void init()
//    {
//        teachers.add(new Teacher("Riste", "Stojanov"));
//        teachers.add(new Teacher("Ana", "Madevska Bogdanova"));
//        teachers.add(new Teacher("Igor", "Mishkovski"));
//        teachers.add(new Teacher("Goce", "Armenski"));
//        teachers.add(new Teacher("Magdalena", "Kostova"));
//        students.add(new Student("meri", "123", "Meri", "Dimitrievska"));
//        students.add(new Student("petko", "123", "Petko", "Petkovski"));
//        students.add(new Student("trajko", "123", "Trajko", "Trajkovski"));
//        students.add(new Student("nikola", "123", "Nikola", "Nikolovski"));
//        students.add(new Student("jovana", "123", "Jovana", "Jovanovska"));
//        List<Student> list1 = new ArrayList<>();
//        courses.add(new Course("Web Programming", "Third Year", list1, teachers.get(0), Type.MANDATORY));
//        List<Student> list2=new ArrayList<>();
//        list2.add(new Student("petko", "123", "Petko", "Petkovski"));
//        list2.add(new Student("trajko", "123", "Trajko", "Trajkovski"));
//        list2.add(new Student("nikola", "123", "Nikola", "Nikolovski"));
//        courses.add(new Course("OOP", "First Year", list2,  teachers.get(1), Type.SUMMER));
//        List<Student> list3=new ArrayList<>();
//        list3.add(new Student("meri", "123", "Meri", "Dimitrievska"));
//        list3.add(new Student("petko", "123", "Petko", "Petkovski"));
//        list3.add(new Student("trajko", "123", "Trajko", "Trajkovski"));
//        list3.add(new Student("jovana", "123", "Jovana", "Jovanovska"));
//        courses.add(new Course( "APS", "First Year", list3,  teachers.get(2), Type.ELECTIVE));
//        List<Student> list4=new ArrayList<>();
//        list4.add(new Student("nikola", "123", "Nikola", "Nikolovski"));
//        list4.add(new Student("jovana", "123", "Jovana", "Jovanovska"));
//        courses.add(new Course( "Web Design", "Second Year", list4,  teachers.get(3), Type.SUMMER));
//        courses.add(new Course( "Internet technologies", "Second Year", students,  teachers.get(4), Type.MANDATORY));
//    }
//}
