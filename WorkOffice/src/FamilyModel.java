
public class FamilyModel {
	private String name, surname, city, street, physicalfit, language, experience, physicalwork, info, employeeage,
			birthdate, phone, postcode, nrhouse, nrflat, phonetofamily, rate;

	private int id;

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

	public String getSurname() {
		return surname;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getPhysicalFit() {
		return physicalfit;
	}

	public String getLanguage() {
		return language;
	}

	public String getExperience() {
		return experience;
	}

	public String getPhysicalWork() {
		return physicalwork;
	}

	public String getInfo() {
		return info;
	}

	public String getEmployeeAge() {
		return employeeage;
	}

	public int getId() {
		return id;
	}

	public String getBirthDate() {
		return birthdate;
	}

	public String getPhone() {
		return phone;
	}

	public String getPostCode() {
		return postcode;
	}

	public String getHouseNr() {
		return nrhouse;
	}

	public String getFlatNr() {
		return nrflat;
	}

	public String getFamilyPhone() {
		return phonetofamily;
	}

	public String getRate() {
		return rate;
	}

}
