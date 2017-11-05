import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewFamilyFrame extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private WorkOfficeDAO dao;
	private int id;

	private JTextField cityField;
	private JTextField postcodeField;
	private JTextField housNrField;
	private JTextField flatNrField;
	private JTextField streetField;
	private JTextField birthDateField;
	private JTextField phoneField;
	private JTextField phoneToFamilyField;
	private JTextField infoField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField rateField;

	private JComboBox physicalFitBox;
	private JComboBox languagelvlBox;
	private JComboBox experienceBox;
	private JComboBox workerAgeBox;
	private JComboBox physicalWorkBox;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewFamilyFrame frame = new NewFamilyFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public NewFamilyFrame() {
		setResizable(false);
		setTitle("Family");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setModal(true);
		setLocation(450, 230);
		setContentPane(contentPane);

		cityField = new JTextField();
		cityField.setColumns(10);

		postcodeField = new JTextField();
		postcodeField.setColumns(10);

		housNrField = new JTextField();
		housNrField.setColumns(10);

		flatNrField = new JTextField();
		flatNrField.setColumns(10);

		streetField = new JTextField();
		streetField.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));

		birthDateField = new JTextField();
		birthDateField.setColumns(10);

		phoneField = new JTextField();
		phoneField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblMoreInformation = new JLabel("More information:");
		lblMoreInformation.setFont(new Font("Tahoma", Font.ITALIC, 14));

		JLabel lblPhoneToFamily = new JLabel("Phone to family:");

		phoneToFamilyField = new JTextField();
		phoneToFamilyField.setColumns(10);

		JLabel lblInformation = new JLabel("Information:");

		infoField = new JTextField();
		infoField.setColumns(10);

		JLabel lblSprawnoFizyczna = new JLabel("Physical fit:");

		physicalFitBox = new JComboBox();
		physicalFitBox.setModel(new DefaultComboBoxModel(new String[] {"", "MOVING", "LYING"}));

		JLabel lblRate = new JLabel("Rate:");

		rateField = new JTextField();
		rateField.setColumns(10);

		JLabel lblEutyg = new JLabel("EUR/week");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblMoreInformation, GroupLayout.DEFAULT_SIZE, 153,
												Short.MAX_VALUE)
										.addGap(155))
								.addComponent(lblInformation)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblSprawnoFizyczna)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(physicalFitBox,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblPhoneToFamily)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(phoneToFamilyField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(infoField, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblRate)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(rateField, GroupLayout.PREFERRED_SIZE, 43,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(lblEutyg)))
						.addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap().addComponent(lblMoreInformation).addGap(27)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPhoneToFamily).addComponent(
						phoneToFamilyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(39)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblSprawnoFizyczna)
						.addComponent(physicalFitBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblRate)
						.addComponent(rateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEutyg))
				.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE).addComponent(lblInformation)
				.addPreferredGap(ComponentPlacement.RELATED).addComponent(infoField, GroupLayout.PREFERRED_SIZE,
						GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(28)));
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblName = new JLabel("Name:");

		nameField = new JTextField();
		nameField.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");

		surnameField = new JTextField();
		surnameField.setColumns(10);

		JLabel lblBirthDate = new JLabel("Date of birth:");

		JLabel lblPhone = new JLabel("Phone:");

		JLabel lblCity = new JLabel("City:");

		JLabel lblPostCode = new JLabel("Post Code:");

		JLabel lblStreet = new JLabel("Street:");

		JLabel lblHouseNr = new JLabel("House nr.:");

		JLabel lblFlatNr = new JLabel("Flat nr.:");

		JButton btnSave = new JButton("Save");

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(panel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(62).addComponent(
												cityField, GroupLayout.PREFERRED_SIZE, 105,
												GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblCity))
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap().addComponent(lblStreet)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addGap(323)
												.addComponent(lblHouseNr).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(housNrField, GroupLayout.PREFERRED_SIZE, 30,
														GroupLayout.PREFERRED_SIZE))
										.addComponent(streetField, GroupLayout.PREFERRED_SIZE, 313,
												GroupLayout.PREFERRED_SIZE))
								.addGap(18).addComponent(lblFlatNr).addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(flatNrField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(33)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblName)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(nameField,
														GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(10)
												.addComponent(lblBirthDate).addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(birthDateField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblSurname)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														surnameField, GroupLayout.PREFERRED_SIZE, 121,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup().addGap(44)
												.addComponent(lblPostCode).addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
																.addComponent(lblPhone)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(phoneField, GroupLayout.PREFERRED_SIZE,
																		101, GroupLayout.PREFERRED_SIZE))
														.addComponent(postcodeField, GroupLayout.PREFERRED_SIZE, 52,
																GroupLayout.PREFERRED_SIZE)))))
						.addGroup(Alignment.TRAILING,
								gl_contentPane.createSequentialGroup().addContainerGap().addComponent(btnSave)
										.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
										.addComponent(btnClose)))
				.addContainerGap()));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblName)
										.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSurname).addComponent(surnameField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblPhone)
										.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblBirthDate).addComponent(birthDateField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblAddress, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCity)
										.addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPostCode).addComponent(postcodeField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblStreet)
												.addComponent(streetField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblHouseNr)
												.addComponent(housNrField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblFlatNr)
												.addComponent(flatNrField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(25)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 278, Short.MAX_VALUE))
								.addGap(18).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnClose).addComponent(btnSave))
								.addContainerGap()));

		JLabel lblRequirements = new JLabel("Requirements:");
		lblRequirements.setFont(new Font("Tahoma", Font.ITALIC, 14));

		JLabel lblLanguage = new JLabel("Language:");

		languagelvlBox = new JComboBox();
		languagelvlBox.setModel(new DefaultComboBoxModel(new String[] {"", "LOW", "MEDIUM", "HIGH"}));

		JLabel lblExperience = new JLabel("Experience:");

		experienceBox = new JComboBox();
		experienceBox.setModel(new DefaultComboBoxModel(new String[] { "", "LOW", "HIGH" }));

		JLabel lblPhysicalWork = new JLabel("Physical work:");

		JLabel lblWorkerAge = new JLabel("Worker age:");

		workerAgeBox = new JComboBox();
		workerAgeBox.setModel(new DefaultComboBoxModel(new String[] { "", "<25", "25>35", "35>45", "45>55", ">55" }));

		physicalWorkBox = new JComboBox();
		physicalWorkBox.setModel(new DefaultComboBoxModel(new String[] { "", "YES", "NO" }));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addComponent(lblRequirements)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblWorkerAge)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(workerAgeBox, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblLanguage)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(languagelvlBox,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblPhysicalWork)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														physicalWorkBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGroup(Alignment.LEADING,
												gl_panel_1.createSequentialGroup().addComponent(lblExperience)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(experienceBox, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(149, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addContainerGap().addComponent(lblRequirements).addGap(41)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblLanguage, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
								.addComponent(languagelvlBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(33)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblExperience)
								.addComponent(experienceBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblPhysicalWork)
								.addComponent(physicalWorkBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(31)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblWorkerAge)
								.addComponent(workerAgeBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(55)));
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (id == 0) {
					checkFields();
				} else {
					updateFamily();
				}
			}
		});
		pack();
	}
	
//====================================================================================================================================================================
	
	//Check that the name and surname fields are empty.
		public void checkFields() {
			if(nameField.getText().equals("")||surnameField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"Field name and surname must be filled.");
			}
			else {
				insertFamily();
			}
		}
	// Method to update data

	public void updateFamily() {
		dao= new WorkOfficeDAO();
		FamilyModel fam=new FamilyModel();
		
		fam.setName(nameField.getText());
		fam.setSurname(surnameField.getText());
		fam.setBirthdate(birthDateField.getText());
		fam.setPhone(phoneField.getText());
		fam.setCity(cityField.getText());
		fam.setPostcode(postcodeField.getText());
		fam.setStreet(streetField.getText());
		fam.setNrhouse(housNrField.getText());
		fam.setNrflat(flatNrField.getText());
		fam.setPhonetofamily(phoneToFamilyField.getText());
		fam.setPhysicalfit(physicalFitBox.getSelectedItem().toString());
		fam.setRate(rateField.getText());
		fam.setInfo(infoField.getText());
		fam.setLanguage(languagelvlBox.getSelectedItem().toString());
		fam.setExperience(experienceBox.getSelectedItem().toString());
		fam.setPhysicalwork(physicalWorkBox.getSelectedItem().toString());
		fam.setEmployeeage(workerAgeBox.getSelectedItem().toString());
		
		dao.updateData(fam, id);
	}

	// Insert new family data

	public void insertFamily() {
		
		dao= new WorkOfficeDAO();
		FamilyModel fam=new FamilyModel();
		
		fam.setName(nameField.getText());
		fam.setSurname(surnameField.getText());
		fam.setBirthdate(birthDateField.getText());
		fam.setPhone(phoneField.getText());
		fam.setCity(cityField.getText());
		fam.setPostcode(postcodeField.getText());
		fam.setStreet(streetField.getText());
		fam.setNrhouse(housNrField.getText());
		fam.setNrflat(flatNrField.getText());
		fam.setPhonetofamily(phoneToFamilyField.getText());
		fam.setPhysicalfit(physicalFitBox.getSelectedItem().toString());
		fam.setRate(rateField.getText());
		fam.setInfo(infoField.getText());
		fam.setLanguage(languagelvlBox.getSelectedItem().toString());
		fam.setExperience(experienceBox.getSelectedItem().toString());
		fam.setPhysicalwork(physicalWorkBox.getSelectedItem().toString());
		fam.setEmployeeage(workerAgeBox.getSelectedItem().toString());
		
		dao.insertDataFamily(fam);
		clearFields();
		
	}
	
	// Method to clear all fields in Family frame class.

	public void clearFields() {

		cityField.setText("");
		postcodeField.setText("");
		housNrField.setText("");
		flatNrField.setText("");
		streetField.setText("");
		birthDateField.setText("");
		phoneField.setText("");
		phoneToFamilyField.setText("");
		infoField.setText("");
		nameField.setText("");
		surnameField.setText("");
		rateField.setText("");

		physicalFitBox.setSelectedItem("");
		languagelvlBox.setSelectedItem("");
		experienceBox.setSelectedItem("");
		workerAgeBox.setSelectedItem("");
		physicalWorkBox.setSelectedItem("");
	}

	// Set textFields and combo box.

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		nameField.setText(name);
	}

	public void setSurname(String surname) {
		surnameField.setText(surname);
	}

	public void setBirthDate(String birthDate) {
		birthDateField.setText(birthDate);
	}

	public void setPhoneField(String phone) {
		phoneField.setText(phone);
	}

	public void setCityField(String city) {
		cityField.setText(city);
	}

	public void setPostcodeField(String postcode) {
		postcodeField.setText(postcode);
	}

	public void setStreetField(String street) {
		streetField.setText(street);
	}

	public void setHousNrField(String housNr) {
		housNrField.setText(housNr);
	}

	public void setFlatNrField(String flatNr) {
		flatNrField.setText(flatNr);
	}

	public void setPhoneToFamilyField(String phoneToFamily) {
		phoneToFamilyField.setText(phoneToFamily);
	}

	public void setPhysicalFit(String physicalFitA) {
		physicalFitBox.setSelectedItem(physicalFitA);
	}

	public void setRateField(String rate) {
		rateField.setText(rate);
	}

	public void setInfoField(String info) {
		infoField.setText(info);
	}

	public void setLanguagelvl(String language) {
		languagelvlBox.setSelectedItem(language);
	}

	public void setExperience(String experienceA) {
		experienceBox.setSelectedItem(experienceA);
	}

	public void setPhysicalWork(String physicalWorkA) {
		physicalWorkBox.setSelectedItem(physicalWorkA);
	}

	public void setEmployeeAge(String employeeAgeA) {
		workerAgeBox.setSelectedItem(employeeAgeA);
	}

}
