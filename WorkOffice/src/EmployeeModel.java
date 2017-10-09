
public class EmployeeModel {
	
	private String name,surname,city,street,language,experience,physicalwork,birthdate,phone,postcode,
					nrhouse,nrflat,married,availability;
	private int id;
	
	public EmployeeModel (int id,String name,String surname,String birthdate,String phone,String city,String postcode,String street,String nrhouse,String nrflat,
			String language,String experience,String physicalwork,String married,String availability){
		
		this.id=id;
		this.name=name;
		this.surname=surname;
		this.birthdate=birthdate;
		this.phone=phone;
		this.city=city;
		this.postcode=postcode;
		this.street=street;
		this.nrhouse=nrhouse;
		this.nrflat=nrflat;
		this.language=language;
		this.experience=experience;
		this.physicalwork=physicalwork;
		this.married=married;
		this.availability=availability;
		
	}
	
	public String getMarried() {
        return married;
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
	    
	    public String getLanguage() {
	        return language;
	    }
	    
	    public String getExperience() {
	        return experience;
	    }
	    public String getPhysicalWork() {
	        return physicalwork;
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
	    
	    public String getAvailability() {
	    	return availability;
	    }
}
