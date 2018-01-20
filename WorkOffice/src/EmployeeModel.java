
public class EmployeeModel {

	private String name, surname, city, street, language, experience, physicalwork, 
			birthdate, phone, postcode, nrhouse, nrflat, married, availability;
	private int id;

	public EmployeeModel() {

	}

	public EmployeeModel(int id, String name, String surname, String birthdate, String phone, String city,
			String postcode, String street, String nrhouse, String nrflat, String language, String experience,
			String physicalwork, String married, String availability) {

		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthdate = birthdate;
		this.phone = phone;
		this.city = city;
		this.postcode = postcode;
		this.street = street;
		this.nrhouse = nrhouse;
		this.nrflat = nrflat;
		this.language = language;
		this.experience = experience;
		this.physicalwork = physicalwork;
		this.married = married;
		this.availability = availability;

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPhysicalwork() {
		return physicalwork;
	}

	public void setPhysicalwork(String physicalwork) {
		this.physicalwork = physicalwork;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getNrhouse() {
		return nrhouse;
	}

	public void setNrhouse(String nrhouse) {
		this.nrhouse = nrhouse;
	}

	public String getNrflat() {
		return nrflat;
	}

	public void setNrflat(String nrflat) {
		this.nrflat = nrflat;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
