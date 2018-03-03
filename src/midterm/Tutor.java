package midterm;

public class Tutor {

	static int count = 0;
	int id;
	String firstName, lastName;
	String email;
	String teach;

	public Tutor(String firstName, String lastName, String email, String teach) {
		this.id = count++;

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.teach = teach;

	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeach() {
		return teach;
	}

	public void setTeach(String teach) {
		this.teach = teach;
	}
}
