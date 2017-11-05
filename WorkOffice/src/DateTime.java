import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class DateTime {

	private WorkOfficeDAO dao;
	private ArrayList<LinkModel> linkList;
	private final Date today = new Date();
	private final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	private boolean equalsDays=false;
	private ExtendDateFrame extendFrame=null;

	public DateTime() {
		
		System.out.println(format.format(today)+"----- today");		
		checkLinkDateTo();
	}

	public void checkLinkDateTo() {

		dao = new WorkOfficeDAO();
		linkList = dao.getLinkList();
		Date dateTo;
		Object[] buttons= {" Extend date "," Delete "," Cancel "};

		for (int i = 0; i < linkList.size(); i++) {
			System.out.println(linkList.get(i).getDataTo());
				try {
					
					dateTo = format.parse(linkList.get(i).getDataTo());
					equalsDays=format.format(today).equals(format.format(dateTo));
					System.out.println(equalsDays);
						
					if(equalsDays==true) {
						
						int linkId=linkList.get(i).getId();
						String eName=linkList.get(i).geteName();
						String eSurname=linkList.get(i).geteSurname();
						String fName=linkList.get(i).getfName();
						String fSurname=linkList.get(i).getfSurname();
						
						int n = JOptionPane.showOptionDialog(null,
								eName+" "+eSurname+" ends up taking care of "+fName+" "+fSurname,
								"Expire date",
								JOptionPane.YES_NO_CANCEL_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								null,buttons,buttons[0]);
						
						System.out.println(n);
						
						if(n==0) {
							if(extendFrame==null) {
								extendFrame=new ExtendDateFrame(linkId);
								extendFrame.setVisible(true);
							}
							
						}
						
						if(n==1) {
							dao.deleteLinkData(linkId);
						}
						
						
						
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}		

		}

	}
	
	
	
}
