import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoFamilyFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel setname, setsurname, setphone, setfamilyphone, setbirthdate, setcity, setpostcode, setstreet,
			sethousenr, setflatnr, setphysicalfit, setrate, setinfo, setlanguage, setphysicalwork, setexperience,
			setemployeeage;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					InfoFamilyFrame frame = new InfoFamilyFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public InfoFamilyFrame() {
		setResizable(false);
		setTitle("Family information");

		setBounds(100, 100, 450, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setModal(true);
		setLocation(450, 230);
		contentPane.setLayout(null);

		JLabel lblname = new JLabel("Name:");
		lblname.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblname.setBounds(10, 11, 107, 14);
		contentPane.add(lblname);

		JLabel lblsurname = new JLabel("Surname:");
		lblsurname.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblsurname.setBounds(10, 36, 107, 14);
		contentPane.add(lblsurname);

		JLabel lblbirthdate = new JLabel("Date of birth:");
		lblbirthdate.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblbirthdate.setBounds(10, 61, 107, 14);
		contentPane.add(lblbirthdate);

		JLabel lblphone = new JLabel("Phone:");
		lblphone.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblphone.setBounds(10, 86, 64, 14);
		contentPane.add(lblphone);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 111, 414, 118);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(176, 11, 46, 14);
		panel.add(lblAddress);

		JLabel lblcity = new JLabel("City:");
		lblcity.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblcity.setBounds(10, 41, 85, 14);
		panel.add(lblcity);

		JLabel lblpostcode = new JLabel("Post Code:");
		lblpostcode.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblpostcode.setBounds(207, 41, 90, 14);
		panel.add(lblpostcode);

		JLabel lblstreet = new JLabel("Street:");
		lblstreet.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblstreet.setBounds(10, 66, 85, 14);
		panel.add(lblstreet);

		JLabel lblhousenr = new JLabel("House nr.:");
		lblhousenr.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblhousenr.setBounds(10, 91, 85, 14);
		panel.add(lblhousenr);

		JLabel lblNrmieszkania = new JLabel("Flat nr.:");
		lblNrmieszkania.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblNrmieszkania.setBounds(207, 91, 90, 14);
		panel.add(lblNrmieszkania);

		setcity = new JLabel("");
		setcity.setToolTipText("");
		setcity.setBounds(105, 42, 92, 14);
		panel.add(setcity);

		setstreet = new JLabel("");
		setstreet.setBounds(105, 67, 299, 14);
		panel.add(setstreet);

		setpostcode = new JLabel("");
		setpostcode.setBounds(307, 42, 97, 14);
		panel.add(setpostcode);

		sethousenr = new JLabel("");
		sethousenr.setBounds(105, 92, 92, 14);
		panel.add(sethousenr);

		setflatnr = new JLabel("");
		setflatnr.setBounds(307, 92, 97, 14);
		panel.add(setflatnr);

		JLabel lblfamilyphone = new JLabel("Phone to family:");
		lblfamilyphone.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblfamilyphone.setBounds(185, 86, 95, 14);
		contentPane.add(lblfamilyphone);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 240, 414, 110);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblInformacjeDodatkowe = new JLabel("Information");
		lblInformacjeDodatkowe.setBounds(144, 11, 130, 14);
		panel_1.add(lblInformacjeDodatkowe);

		JLabel lblphysicalfit = new JLabel("Physicalfit:");
		lblphysicalfit.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblphysicalfit.setBounds(10, 34, 121, 14);
		panel_1.add(lblphysicalfit);

		JLabel lblrate = new JLabel("Rate:");
		lblrate.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblrate.setBounds(220, 34, 56, 14);
		panel_1.add(lblrate);

		JLabel lblinfo = new JLabel("Add Information:");
		lblinfo.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblinfo.setBounds(114, 59, 162, 14);
		panel_1.add(lblinfo);

		setphysicalfit = new JLabel("");
		setphysicalfit.setBounds(137, 35, 73, 14);
		panel_1.add(setphysicalfit);

		setrate = new JLabel("");
		setrate.setBounds(286, 35, 73, 14);
		panel_1.add(setrate);

		setinfo = new JLabel("");
		setinfo.setBounds(10, 85, 394, 14);
		panel_1.add(setinfo);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(10, 361, 414, 110);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblRequirements = new JLabel("Requirements");
		lblRequirements.setBounds(128, 11, 159, 14);
		panel_2.add(lblRequirements);

		JLabel lbllanguage = new JLabel("Language:");
		lbllanguage.setFont(new Font("Verdana", Font.PLAIN, 11));
		lbllanguage.setBounds(10, 43, 93, 14);
		panel_2.add(lbllanguage);

		JLabel lblexperience = new JLabel("Experience:");
		lblexperience.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblexperience.setBounds(10, 68, 93, 14);
		panel_2.add(lblexperience);

		JLabel plpphysicalwork = new JLabel("Physical work:");
		plpphysicalwork.setFont(new Font("Verdana", Font.PLAIN, 11));
		plpphysicalwork.setBounds(191, 43, 96, 14);
		panel_2.add(plpphysicalwork);

		JLabel lblemployeeage = new JLabel("Age:");
		lblemployeeage.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblemployeeage.setBounds(191, 68, 96, 14);
		panel_2.add(lblemployeeage);

		setlanguage = new JLabel("");
		setlanguage.setBounds(113, 44, 68, 14);
		panel_2.add(setlanguage);

		setexperience = new JLabel("");
		setexperience.setBounds(113, 69, 68, 14);
		panel_2.add(setexperience);

		setphysicalwork = new JLabel("");
		setphysicalwork.setBounds(297, 44, 107, 14);
		panel_2.add(setphysicalwork);

		setemployeeage = new JLabel("");
		setemployeeage.setBounds(297, 69, 107, 14);
		panel_2.add(setemployeeage);

		JButton btnclose = new JButton("Close");
			btnclose.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
		btnclose.setBounds(172, 482, 89, 23);
		contentPane.add(btnclose);

		setname = new JLabel("");
		setname.setBounds(127, 12, 153, 14);
		contentPane.add(setname);

		setsurname = new JLabel("");
		setsurname.setBounds(127, 37, 153, 14);
		contentPane.add(setsurname);

		setbirthdate = new JLabel("");
		setbirthdate.setBounds(127, 62, 153, 14);
		contentPane.add(setbirthdate);

		setphone = new JLabel("");
		setphone.setBounds(84, 87, 91, 14);
		contentPane.add(setphone);

		setfamilyphone = new JLabel("");
		setfamilyphone.setBounds(290, 87, 95, 14);
		contentPane.add(setfamilyphone);

	}

	public void setName(String name) {
		this.setname.setText(name);
	}

	public void setSurname(String surname) {
		this.setsurname.setText(surname);
	}

	public void setPhone(String phone) {
		this.setphone.setText(phone);
	}

	public void setFamilyPhone(String familyphone) {
		this.setfamilyphone.setText(familyphone);
	}

	public void setBirthdate(String birthdate) {
		this.setbirthdate.setText(birthdate);
	}

	public void setCity(String city) {
		this.setcity.setText(city);
	}

	public void setPostCode(String postcode) {
		this.setpostcode.setText(postcode);
	}

	public void setHouseNr(String housenr) {
		this.sethousenr.setText(housenr);
	}

	public void setStreet(String street) {
		this.setstreet.setText(street);
	}

	public void setFlatNr(String flatnr) {
		this.setflatnr.setText(flatnr);
	}

	public void setPhysicalFit(String physicalfit) {
		this.setphysicalfit.setText(physicalfit);
	}

	public void setRate(String rate) {
		this.setrate.setText(rate);
	}

	public void setInfo(String info) {
		this.setinfo.setText(info);
	}

	public void setLanguage(String language) {
		this.setlanguage.setText(language);
	}

	public void setPhysicalWork(String physicalwork) {
		this.setphysicalwork.setText(physicalwork);
	}

	public void setExperience(String experience) {
		this.setexperience.setText(experience);
	}

	public void setEmployeeAge(String employeeage) {
		this.setemployeeage.setText(employeeage);
	}

}
