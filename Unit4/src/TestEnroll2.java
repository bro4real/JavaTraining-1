import elearning.Course;
import elearning.Teacher;

public class TestEnroll2 {

	public static void main(String[] args) {
		Course c1 = new Course("Intro to Java", "CS101", 100);
		Teacher t1 = new Teacher("Cristina");
		t1.enroll(c1);
		c1.printParticipants();
	}

}
