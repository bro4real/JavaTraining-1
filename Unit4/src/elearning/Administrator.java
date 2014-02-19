package elearning;

public class Administrator extends User{

	public Administrator(String string) {
		username = string;
	}

	@Override
	public void enroll(Course course) {
		System.out.println("Enrolling administrator "+ username + " to course \"" + course.name + "\"");
		
	}

}
