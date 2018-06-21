class BasketballTeam
{
	private String name;
	private String location;
	

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return(name);
	}

	public void setLocation(String loc) {
		location = loc;
	}

	public String getLocation() {
		return(location);
	}

	public String toString() {
		return("Name: " + name + ", Location: " + location);
	}

	public String getDetails() {
		return(name + "@" + location);
	}
}
