import elearning.Administrator;
import elearning.Course;
import elearning.Student;
import elearning.Teacher;
import elearning.User;


public class TestEnroll3 {

	static User[] users = {new Student("Christina"), new Student("Paul"), 
		new Student("Virginia"), new Teacher("Romeo"), new Administrator("Maria"),
		new Student("Juliet")};
	static Course[] courses = {new Course("Intro to Java", "CS101", 100), new Course("Intro to SQL", "CS102", 100),
		new Course("Linux Essentials","CE101", 50), new Course("Web Application Development","CE203",100)};
	
	public static void main(String[] args) {
		for (User u: users){
			if (u instanceof Administrator){
				//Administrator admin = (Administrator)u;
				//admin.createCourse();
				((Administrator)u).createCourse();
			}
			for (Course c: courses){
				u.enroll(c);
			}
		}
		for (Course c: courses){
			c.printParticipants();
		}
	}

}
