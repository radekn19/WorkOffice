import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class NewEmployeeFrame extends JFrame {
	
	private WorkOfficeDAO dao;
	private JPanel contentPane;
	private boolean insertProof=false;
	
	private int id;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField birthDateField;
	private JTextField streetField;
	private JTextField cityField;
	private JTextField postCodeField;
	private JTextField houseNrField;
	private JTextField flatNrField;
	private JTextField phoneField;
	private JTextField availabilityField;
	
	private JComboBox<String> languageBox;
	private JComboBox<String> experienceBox;
	private JComboBox<String> marriedBox;
	private JComboBox<String> physicalWorkBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewEmployeeFrame frame = new NewEmployeeFrame();
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
	public NewEmployeeFrame() {
		setTitle("Opiekun");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
		
JLabel lblName = new JLabel("Imie:");
		
		JLabel lblSurname = new JLabel("Nazwisko:");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		
		JLabel lblBirthDate = new JLabel("Data urodzenia:\r\n");
		
		birthDateField = new JTextField();
		birthDateField.setColumns(10);
		
		JLabel lblAdresZamieszkania = new JLabel("Adres zamieszkania:");
		lblAdresZamieszkania.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblStreet = new JLabel("ulica:");
		
		streetField = new JTextField();
		streetField.setColumns(10);
		
		JLabel lblCity = new JLabel("Miejscowo\u015Bc:");
		
		cityField = new JTextField();
		cityField.setColumns(10);
		
		JLabel lblPostCode = new JLabel("Kod pocztowy:");
		
		postCodeField = new JTextField();
		postCodeField.setColumns(10);
		
		JLabel lblHouseNr = new JLabel("nr. domu:");
		
		houseNrField = new JTextField();
		houseNrField.setColumns(10);
		
		JLabel lblFlatNr = new JLabel("nr.mieszkania:");
		
		flatNrField = new JTextField();
		flatNrField.setColumns(10);
		
		JLabel lblPhone = new JLabel("telefon:");
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnSave = new JButton("Zapisz");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id==0){
					insertData();
					System.out.println("ID wynosi 0-zapisuje");
					}else{
						System.out.println("id pracownika to="+id);
						updateData();		
					}
			}
		});
		
		JButton btnClose = new JButton("Zamknij");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblCity)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(cityField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblPostCode)
											.addGap(10)
											.addComponent(postCodeField, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblHouseNr)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(houseNrField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblFlatNr)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(flatNrField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblStreet)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(streetField, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAdresZamieszkania)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblSurname)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblBirthDate)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(birthDateField, 0, 0, Short.MAX_VALUE)
									.addGap(22)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblPhone)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
							.addComponent(btnClose))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
					.addGap(14))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSurname)
						.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBirthDate)
						.addComponent(birthDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhone)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(lblAdresZamieszkania)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPostCode)
						.addComponent(postCodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHouseNr)
								.addComponent(houseNrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFlatNr)
								.addComponent(flatNrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStreet)
							.addComponent(streetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnClose))
					.addContainerGap())
		);
		
		JLabel lblInformacjeDodatkowe = new JLabel("Informacje dodatkowe:");
		lblInformacjeDodatkowe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblLanguage = new JLabel("j.niemiecki:");
		
		languageBox = new JComboBox<String>();
		languageBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "slaby", "sredni", "dobry"}));
		
		JLabel lblPchysicalWork = new JLabel("praca fizyczna:");
		
		JLabel lblMarried = new JLabel("m\u0119\u017Cata/\u017Conaty:");
		
		JLabel lblExperience = new JLabel("do\u015Bwiadczenie:");
		
		experienceBox = new JComboBox<String>();
		experienceBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "male", "duze"}));
		
		JLabel lblavAvilability = new JLabel("dost\u0119pny/a od:");
		
		availabilityField = new JTextField();
		availabilityField.setColumns(10);
		
		marriedBox = new JComboBox<String>();
		marriedBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "TAK", "NIE"}));
		
		physicalWorkBox = new JComboBox<String>();
		physicalWorkBox.setModel(new DefaultComboBoxModel<String>(new String[] {"", "TAK", "NIE"}));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInformacjeDodatkowe)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblLanguage)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(languageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblMarried)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(marriedBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(71)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblPchysicalWork)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(physicalWorkBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblExperience)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(experienceBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblavAvilability)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(availabilityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformacjeDodatkowe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLanguage)
						.addComponent(languageBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblExperience)
						.addComponent(experienceBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarried)
						.addComponent(lblPchysicalWork)
						.addComponent(marriedBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(physicalWorkBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblavAvilability)
						.addComponent(availabilityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		pack();
	}
	
// Insert data do database.
	public void insertData() {
		dao=new WorkOfficeDAO();
		dao.ifEmpTablesExist();
		
		insertProof=dao.insertDataEmp(nameField.getText(),surnameField.getText(),birthDateField.getText(),
				phoneField.getText(),cityField.getText(),postCodeField.getText(),streetField.getText(),
				houseNrField.getText(),flatNrField.getText(),languageBox.getSelectedItem().toString(),
				experienceBox.getSelectedItem().toString(),physicalWorkBox.getSelectedItem().toString(),
				marriedBox.getSelectedItem().toString(),availabilityField.getText());
		
		if(insertProof==true){
			JOptionPane.showMessageDialog(null, "Employee added");
			clearFields();
			dao.showEmployeeTable();
		    }
		else{
				JOptionPane.showMessageDialog(null, "Error with insert employee do data base");
			}
		
	}
	
//Method to update data
		public void updateData(){
			dao=new WorkOfficeDAO();
			
			dao.updateEmployeeData(id,nameField.getText(),surnameField.getText(),birthDateField.getText(),
					phoneField.getText(),cityField.getText(),postCodeField.getText(),streetField.getText(),
					houseNrField.getText(),flatNrField.getText(),languageBox.getSelectedItem().toString(),
					experienceBox.getSelectedItem().toString(),physicalWorkBox.getSelectedItem().toString(),
					marriedBox.getSelectedItem().toString(),availabilityField.getText());		
		}
		
//Clear fields.
		public void clearFields() {
			
			  nameField.setText("");
			  surnameField.setText("");
			  birthDateField.setText("");
			  streetField.setText("");
			  cityField.setText("");
			  postCodeField.setText("");
			  houseNrField.setText("");
			  flatNrField.setText("");
			  phoneField.setText("");
			  availabilityField.setText("");
			
			  languageBox.setSelectedItem("");
			  experienceBox.setSelectedItem("");
			  marriedBox.setSelectedItem("");
			  physicalWorkBox.setSelectedItem("");
		}
	
//Get and set fields.
	
	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
		
	public String getName() {
		return nameField.getText();
	}
	public void setName(String name){
		nameField.setText(name);
	}
		
	public String getSurname() {
		return surnameField.getText();
	}
	public void setSurname(String surname){
		surnameField.setText(surname);
	}
		
	public String getBirthDate() {
		return birthDateField.getText();
	}
	public void setBirthDate(String birthDate){
		birthDateField.setText(birthDate);
	}
		
	public String getPhone() {
		return phoneField.getText();
	}		
	public void setPhoneField(String phone){
		phoneField.setText(phone);
	}
	public String getCity() {
		return cityField.getText();
	}		
	public void setCityField(String city){
		cityField.setText(city);
	}
	public String getPostCode() {
		return postCodeField.getText();
	}		
	public void setPostcodeField(String postcode){
		postCodeField.setText(postcode);
	}
		
	public String getStreet() {
		return streetField.getText();
	}		
	public void setStreetField(String street){
		streetField.setText(street);
	}

	public String getHouseNr() {
		return houseNrField.getText();
	}
	public void setHousNrField(String housNr){
		houseNrField.setText(housNr);
	}
	
	public String getFlatNr() {
		return flatNrField.getText();
	}
	public void setFlatNrField(String flatNr){
		flatNrField.setText(flatNr);
	}
	
	public String getAvailability() {
		return availabilityField.getText();
	}
	public void setAvailability(String availability){
		availabilityField.setText(availability);
	}
	
	public String getPhysicalWork() {
		return physicalWorkBox.getSelectedItem().toString();
	}
	public void setPhysicalWork(String physicalFit){
		physicalWorkBox.setSelectedItem(physicalFit);
	}

	public String getLanguage() {
		return languageBox.getSelectedItem().toString();
	}
	public void setLanguage(String language){
		languageBox.setSelectedItem(language);
	}
	
	public String getExperience() {
		return experienceBox.getSelectedItem().toString();
	}
	public void setExperience(String experience){
		experienceBox.setSelectedItem(experience);
	}

	public String getMarried() {
		return marriedBox.getSelectedItem().toString();
	}
	public void setMattied(String married){
		marriedBox.setSelectedItem(married);
	}
	
}
