
public class LinkModel {
	
	private String eId,eName,eSurname,fId,fName,fSurname,dataFrom,dataTo;
	private int id;

	public LinkModel(int id,String eId, String eName, String eSurname,
            		 		String fId, String fName, String fSurname,
            		 		String dataFrom, String dataTo){
		
		this.id=id;
		this.eId=eId;
		this.eName=eName;
		this.eSurname=eSurname;
		this.fId=fId;
		this.fName=fName;
		this.fSurname=fSurname;
		this.dataFrom=dataFrom;
		this.dataTo=dataTo;


	}
	public int getId() {
		return id;
	}
	
	public String getEid() {
		return eId;
	}

	public String getEname() {
		return eName;
	}

	public String getEsurname() {
		return eSurname;
	}

	public String getFid() {
		return fId;
	}

	public String getFName() {
		return fName;
	}

	public String getFsurname() {
		return fSurname;
	}

	public String getFromDate() {
		return dataFrom;
	}

	public String getToDate() {
		return dataTo;
	}

	
}
