public class Player
{
	private final ID;
	private String firstName;
	private String lastName;
	private int age;
	private int height;
	private int weight;
	private String position;

	public Players(String id, String firstName, String lastName, int age, int h, int w, String pos) {
		ID = id;
		this.name = name;
		this.age = age;
		height = h;
		weight = w;
		position = pos;
	}

	public getId() {
		return(ID);
	}

	public void setFirstName(String fn) {
		firstName = fn;
	}

	public String getFirstName() {
		return(firstName);
	}

	public void setLastName(String ln) {
		lastName = ln;
	}

	public String getLastName() {
		return(lastName);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return(age);
	}

	public void setHeight(int h) {
		height = h;
	}

	public int getHeight() {
		return(height);
	}

	public void setWeight(int w) {
		weight = w;
	}

	public int getWeight() {
		return(weight);
	}

	public void setPosition(int pos) {
		position = pos;
	}

	public String getPosition() {
		return(position);
	}

	public String toString() {
		return("Jersey No.: " + ID + "\nName: " + firstName + lastName + "\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight + "\nPostion: " + position);
	}

	public String getDetails() {
		return(ID + "@" + firstName + "@" + lastName + "@" + age + "@" + height + "@" + weight + "@" + position + "@players");
	}
}
