package persons;

public class Person implements java.io.Serializable {

	protected String name;
	protected String surname;

  public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
  }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

  public String toString() {
    return name + " " + surname;
  }
}
