import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UserPerson extends Bettor {
	private final static String VERIFYNAMES = "[A-Za-z\\-]{2,}";
	private int id;
	private String firstName;
	private String lastName;
	private Date bornDate;

	public Person() {

	}

	public Person(String firstName, String lastName, Date bornDate) throws BadParametersException {
		Date now = new Date(System.currentTimeMillis());
		if(bornDate.after(now)) {
			throw new BadParametersException("User's borndate is invalid");
			this.firstName=firstName;
			this.lastName=lastName;
			this.bornDate=bornDate;
		}
		if (!(this.hasValidName())) {
			throw new BadParametersException("User's firstname and/or lastname are invalid");
		}
	}

	public void setFirstName(String firstName) throws BadParametersException, ClassNotFoundException, SQLException {
		if (!firstName.matches(VERIFYNAMES)) {
			throw new BadParametersException();
			this.firstName=firstName;
			UserPersonDAO.update(this);
		}
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setLastName(String lastName) throws BadParametersException, ClassNotFoundException, SQLException {
		if (!lastName.matches(VERIFYNAMES)) {
			throw new BadParametersException();
			this.lastName=lastName;
			UserPersonDAO.update(this);
		}
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setBornDate(Date bornDate) throws ClassNotFoundException, BadParametersException, SQLException {
		Date now = new Date(System.currentTimeMillis());
		if(bornDate.after(now)){
			throw new BadParametersException("Bettor's borndate is invalid");
			this.bornDate=bornDate;
			UserPersonDAO.update(this);
		}
	}

	public Date getBornDate() {
		return this.bornDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public boolean hasValidName () {
		return firstName.matches(VERIFYNAMES) && lastName.matches(VERIFYNAMES);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		else if (!(other instanceof UserPerson)) {
			return false;
		}
		UserPerson bettor = (UserPerson) other;
			return (this.firstName.equals(bettor.getFirstName()) &&
			this.lastName.equals(bettor.getLastName()) &&
			this.getBornDate().getTime() == bettor.getBornDate().getTime());
	}

	public String toString(){
		String date = new SimpleDateFormat("dd-MM-yyyy").format(this.bornDate);
		return(this.firstName + "," + this.lastName + "," + date);
	}

	@Override
	public void addMember(Bettor member)
		throws ExistingBettorException, BadParametersException {
			throw new UnsupportedOperationException();
	}

	@Override
	public void deleteMember(Bettor member)
		throws BadParametersException, ExistingBettorException {
			throw new UnsupportedOperationException();
	}
}
