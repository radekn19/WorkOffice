

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class InfoEmployeeFrame extends JFrame {

	private JPanel contentPane;
	private JLabel setname, setsurname, setphone, setbirthdate, setcity, setpostcode, setstreet, sethousenr, setflatnr,
			setphysicalwork, setlanguage, setmarried, setexperience, setavailability;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoEmployeeFrame frame = new InfoEmployeeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InfoEmployeeFrame() {
		setTitle("Informacje");
		setBounds(100, 100, 450, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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

		JLabel lblhousenr = new JLabel("House nr.: ");
		lblhousenr.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblhousenr.setBounds(10, 91, 85, 14);
		panel.add(lblhousenr);

		JLabel lblNrmieszkania = new JLabel("Flat nr.: ");
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

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(10, 240, 414, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblInformacjeDodatkowe = new JLabel("Add information");
		lblInformacjeDodatkowe.setBounds(144, 11, 130, 14);
		panel_1.add(lblInformacjeDodatkowe);

		JLabel lblphysicalwork = new JLabel("Physical work:");
		lblphysicalwork.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblphysicalwork.setBounds(10, 142, 121, 14);
		panel_1.add(lblphysicalwork);

		JLabel lblavailability = new JLabel("Availability");
		lblavailability.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblavailability.setBounds(10, 115, 162, 14);
		panel_1.add(lblavailability);

		setphysicalwork = new JLabel("");
		setphysicalwork.setBounds(181, 142, 93, 14);
		panel_1.add(setphysicalwork);

		setlanguage = new JLabel("");
		setlanguage.setBounds(181, 34, 93, 14);
		panel_1.add(setlanguage);

		JLabel lblmarried = new JLabel("Married");
		lblmarried.setBounds(10, 88, 96, 14);
		panel_1.add(lblmarried);
		lblmarried.setFont(new Font("Verdana", Font.PLAIN, 11));

		setmarried = new JLabel("");
		setmarried.setBounds(181, 88, 93, 14);
		panel_1.add(setmarried);

		JLabel lbllanguage = new JLabel("Language:");
		lbllanguage.setBounds(10, 34, 93, 14);
		panel_1.add(lbllanguage);
		lbllanguage.setFont(new Font("Verdana", Font.PLAIN, 11));

		JLabel lblexperience = new JLabel("Experience:");
		lblexperience.setBounds(10, 61, 93, 14);
		panel_1.add(lblexperience);
		lblexperience.setFont(new Font("Verdana", Font.PLAIN, 11));

		setexperience = new JLabel("");
		setexperience.setBounds(181, 61, 93, 14);
		panel_1.add(setexperience);

		setavailability = new JLabel("");
		setavailability.setBounds(184, 114, 90, 16);
		panel_1.add(setavailability);

		JButton btnclose = new JButton("Close");
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnclose.setBounds(169, 443, 89, 23);
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
		setphone.setBounds(127, 86, 91, 14);
		contentPane.add(setphone);

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

	public void setPhysicalWork(String physicalwork) {
		this.setphysicalwork.setText(physicalwork);
	}

	public void setAvailability(String availability) {
		this.setavailability.setText(availability);
	}

	public void setLanguage(String language) {
		this.setlanguage.setText(language);
	}

	public void setMarried(String married) {
		this.setmarried.setText(married);
	}

	public void setExperience(String experience) {
		this.setexperience.setText(experience);
	}

}
