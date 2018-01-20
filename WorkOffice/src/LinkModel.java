
public class LinkModel {

	private String eName, eSurname, fName, fSurname, dataFrom, dataTo;
	private String eId, fId;
	private int id;

	public LinkModel() {

	}

	public LinkModel(int id, String eId, String eName, String eSurname, String fId, String fName, String fSurname,
			String dataFrom, String dataTo) {

		this.id = id;
		this.eId = eId;
		this.eName = eName;
		this.eSurname = eSurname;
		this.fId = fId;
		this.fName = fName;
		this.fSurname = fSurname;
		this.dataFrom = dataFrom;
		this.dataTo = dataTo;

	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteSurname() {
		return eSurname;
	}

	public void seteSurname(String eSurname) {
		this.eSurname = eSurname;
	}

	public String getfId() {
		return fId;
	}

	public void setfId(String fId) {
		this.fId = fId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getfSurname() {
		return fSurname;
	}

	public void setfSurname(String fSurname) {
		this.fSurname = fSurname;
	}

	public String getDataFrom() {
		return dataFrom;
	}

	public void setDataFrom(String dataFrom) {
		this.dataFrom = dataFrom;
	}

	public String getDataTo() {
		return dataTo;
	}

	public void setDataTo(String dataTo) {
		this.dataTo = dataTo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
