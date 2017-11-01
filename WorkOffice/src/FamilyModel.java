

public class FamilyModel {
	private String name, surname, city, street, physicalfit, language, experience, physicalwork, info, employeeage,
			birthdate, phone, postcode, nrhouse, nrflat, phonetofamily, rate;

	private int id;
	
	public FamilyModel() {
		
	}
	public FamilyModel(int id, String name, String surname, String birthdate, String phone, String city,
			String postcode, String street, String nrhouse, String nrflat, String phonetofamily, String physicalfit,
			String rate, String info, String language, String experience, String physicalwork, String employeeage) {

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
		this.phonetofamily = phonetofamily;
		this.physicalfit = physicalfit;
		this.rate = rate;
		this.info = info;
		this.language = language;
		this.experience = experience;
		this.physicalwork = physicalwork;
		this.employeeage = employeeage;

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

	public String getPhysicalfit() {
		return physicalfit;
	}

	public void setPhysicalfit(String physicalfit) {
		this.physicalfit = physicalfit;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getEmployeeage() {
		return employeeage;
	}

	public void setEmployeeage(String employeeage) {
		this.employeeage = employeeage;
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

	public String getPhonetofamily() {
		return phonetofamily;
	}

	public void setPhonetofamily(String phonetofamily) {
		this.phonetofamily = phonetofamily;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

}
