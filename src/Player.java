public class Player
{
	private int ID;
	private String name;
	private int age;
	private int height;
	private int weight;
	private String position;
	private String team;

	public Player(int id, String name, int age, int h, int w, String pos, String team) {
		ID = id;
		this.name = name;
		this.age = age;
		height = h;
		weight = w;
		position = pos;
		this.team = team;
	}

	public int getId() {
		return(ID);
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return(name);
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

	public void setPosition(String pos) {
		position = pos;
	}

	public String getPosition() {
		return(position);
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeam() {
		return(team);
	}

	public String toString() {
		return("Jersey No.: " + ID + "\nName: " + name + "\nAge: " + age + "\nHeight: " + height + "\nWeight: " + weight + "\nPostion: " + position + "\nTeam: " + team);
	}

	public String getDetails() {
		return(ID + "@" + name + "@" + age + "@" + height + "@" + weight + "@" + position + "@" + team + "@players");
	}
}
