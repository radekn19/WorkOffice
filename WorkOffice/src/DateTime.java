import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.management.timer.Timer;
import javax.swing.JOptionPane;

public class DateTime {

	private WorkOfficeDAO dao;
	private ArrayList<LinkModel> linkList;
	private final Date today = new Date();
	private final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	private boolean checker=false;

	public DateTime() {
		
		System.out.println(format.format(today)+"----- today");		
		checkDateTo();
	}

	public void checkDateTo() {

		dao = new WorkOfficeDAO();
		linkList = dao.getLinkList();
		Date dateTo;
		Object[] buttons= {"Delete","Extend date","Cancel"};

		for (int i = 0; i < linkList.size(); i++) {
			System.out.println(linkList.get(i).getDataTo());
				try {
					
					dateTo = format.parse(linkList.get(i).getDataTo());
					checker=format.format(today).equals(format.format(dateTo));
					System.out.println(checker);
					
					if(checker==true) {
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
					}
					
				} catch (ParseException e) {
					e.printStackTrace();
				}		

		}

	}
	
	
	
}
