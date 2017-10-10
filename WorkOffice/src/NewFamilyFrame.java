import java.awt.EventQueue;
import javax.swing.JFrame;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewFamilyFrame extends JFrame
{
	private boolean insertProof=false;
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
	
	private JComboBox physicalFit;
	private JComboBox languagelvl;
	private JComboBox experience;
	private JComboBox employeeAge;
	private JComboBox physicalWork;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					NewFamilyFrame frame = new NewFamilyFrame();
					frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewFamilyFrame()
	{
		setTitle("Dodaj rodzine");
		//setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		
		JLabel label_5 = new JLabel("Adres zamieszkania:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		birthDateField = new JTextField();
		birthDateField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel label_10 = new JLabel("Informacje dodatkowe:");
		label_10.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblTelDoRodziny = new JLabel("Tel. do rodziny:");
		
		phoneToFamilyField = new JTextField();
		phoneToFamilyField.setColumns(10);
		
		JLabel lblOpisChoroby = new JLabel("Dodatkowe informacje:");
		
		infoField = new JTextField();
		infoField.setColumns(10);
		
		JLabel lblSprawnoFizyczna = new JLabel("Sprawnosc fizyczna:");
		
		physicalFit = new JComboBox();
		physicalFit.setModel(new DefaultComboBoxModel(new String[] {"", "chodzaca", "lezaca"}));
		
		JLabel lblStawka = new JLabel("Stawka:");
		
		rateField = new JTextField();
		rateField.setColumns(10);
		
		JLabel lblEutyg = new JLabel("EUR/tyg.");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_10, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
							.addGap(155))
						.addComponent(lblOpisChoroby)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblSprawnoFizyczna)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(physicalFit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTelDoRodziny)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(phoneToFamilyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(infoField, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStawka)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rateField, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEutyg)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_10)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelDoRodziny)
						.addComponent(phoneToFamilyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSprawnoFizyczna)
						.addComponent(physicalFit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStawka)
						.addComponent(rateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEutyg))
					.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
					.addComponent(lblOpisChoroby)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(infoField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblImie = new JLabel("Imie:");
		
		nameField = new JTextField();
		nameField.setColumns(10);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		
		surnameField = new JTextField();
		surnameField.setColumns(10);
		
		JLabel lblDataUrodzenia = new JLabel("Data urodzenia:");
		
		JLabel lblTelefon = new JLabel("telefon:");
		
		JLabel lblMiejscowo = new JLabel("Miejscowosc");
		
		JLabel lblNewLabel = new JLabel("Kod pocztowy:\r\n");
		
		JLabel lblUlica = new JLabel("ulica:");
		
		JLabel lblNrdomu = new JLabel("nr.domu:");
		
		JLabel lblNrmieszkania = new JLabel("nr.mieszkania:");
		
		JButton btnSave = new JButton("Zapisz");
		
		
		
		
		JButton btnClose = new JButton("Zamknij");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(62)
									.addComponent(cityField, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))))
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMiejscowo))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUlica)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(323)
									.addComponent(lblNrdomu)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(housNrField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
								.addComponent(streetField, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblNrmieszkania)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(flatNrField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblImie)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(nameField, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addComponent(lblDataUrodzenia)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(birthDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNazwisko)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(44)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblTelefon)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
										.addComponent(postcodeField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSave)
							.addPreferredGap(ComponentPlacement.RELATED, 520, Short.MAX_VALUE)
							.addComponent(btnClose)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImie)
						.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNazwisko)
						.addComponent(surnameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTelefon)
						.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataUrodzenia)
						.addComponent(birthDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMiejscowo)
						.addComponent(cityField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(postcodeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUlica)
						.addComponent(streetField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNrdomu)
						.addComponent(housNrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNrmieszkania)
						.addComponent(flatNrField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 278, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnSave))
					.addContainerGap())
		);
		
		JLabel lblWymaganiaOdOpiekunki = new JLabel("Wymagania od opiekunki:");
		lblWymaganiaOdOpiekunki.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel label_11 = new JLabel("j.niemiecki:");
		
		languagelvl = new JComboBox();
		languagelvl.setModel(new DefaultComboBoxModel(new String[] {"", "slaby", "sredni", "dobry"}));
		
		JLabel label_14 = new JLabel("doswiadczenie:");
		
		experience = new JComboBox();
		experience.setModel(new DefaultComboBoxModel(new String[] {"", "male", "duze"}));
		
		JLabel label_13 = new JLabel("praca fizyczna:");
		
		JLabel lblWiekOpiekunki = new JLabel("wiek opiekunki:");
		
		employeeAge = new JComboBox();
		employeeAge.setModel(new DefaultComboBoxModel(new String[] {"", "<25", "25>35", "35>45", "45>55", ">55"}));
		
		physicalWork = new JComboBox();
		physicalWork.setModel(new DefaultComboBoxModel(new String[] {"", "TAK", "NIE"}));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWymaganiaOdOpiekunki)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblWiekOpiekunki)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(employeeAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_11)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(languagelvl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(label_13)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(physicalWork, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
								.addComponent(label_14)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(experience, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWymaganiaOdOpiekunki)
					.addGap(41)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(languagelvl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_14)
						.addComponent(experience, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_13)
						.addComponent(physicalWork, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWiekOpiekunki)
						.addComponent(employeeAge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(55))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
				
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(id==0){
				saveData();
				System.out.println("ID wynosi 0-zapisuje");
				}else{
					System.out.println("id pracownika to="+id);
					updateData();		
				}
			}
		});
		pack();
	}
	
//Method to update data
	public void updateData(){
		dao=new WorkOfficeDAO();
		
		dao.updateData(id,nameField.getText(),surnameField.getText(),birthDateField.getText(),
				phoneField.getText(),cityField.getText(),postcodeField.getText(),
				streetField.getText(),housNrField.getText(),flatNrField.getText(),
				phoneToFamilyField.getText(),physicalFit.getSelectedItem().toString(),
				rateField.getText(),infoField.getText(),languagelvl.getSelectedItem().toString(),
				experience.getSelectedItem().toString(),physicalWork.getSelectedItem().toString(),
				employeeAge.getSelectedItem().toString());	
	}
	
//	Save data
	public void saveData(){
		dao=new WorkOfficeDAO();
		dao.ifTablesExist();
		
		insertProof=dao.insertData(nameField.getText(),surnameField.getText(),birthDateField.getText(),
				phoneField.getText(),cityField.getText(),postcodeField.getText(),
				streetField.getText(),housNrField.getText(),flatNrField.getText(),
				phoneToFamilyField.getText(),physicalFit.getSelectedItem().toString(),
				rateField.getText(),infoField.getText(),languagelvl.getSelectedItem().toString(),
				experience.getSelectedItem().toString(),physicalWork.getSelectedItem().toString(),
				employeeAge.getSelectedItem().toString());	
		dao.showTable();
	
		if(insertProof==true){
			JOptionPane.showMessageDialog(null, "Family added");
			clearFields();
		    }
		else{
				JOptionPane.showMessageDialog(null, "Error with insert family do data base");
			}
	}
	
// Method to clear all fields in Family frame class.
	
public void clearFields(){
	
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
	 
	 physicalFit.setSelectedItem("");
	 languagelvl.setSelectedItem("");
	 experience.setSelectedItem("");
	 employeeAge.setSelectedItem("");
	 physicalWork.setSelectedItem("");
	}

// Set textFields and combo box.

public void setId(int id){
	this.id=id;
}

public void setName(String name){
	nameField.setText(name);
}

public void setSurname(String surname){
	surnameField.setText(surname);
}
public void setBirthDate(String birthDate){
	birthDateField.setText(birthDate);
}

public void setPhoneField(String phone){
	phoneField.setText(phone);
}
public void setCityField(String city){
	cityField.setText(city);
}

public void setPostcodeField(String postcode){
	postcodeField.setText(postcode);
}
public void setStreetField(String street){
	streetField.setText(street);
}

public void setHousNrField(String housNr){
	housNrField.setText(housNr);
}
public void setFlatNrField(String flatNr){
	flatNrField.setText(flatNr);
}

public void setPhoneToFamilyField(String phoneToFamily){
	phoneToFamilyField.setText(phoneToFamily);
}
public void setPhysicalFit(String physicalFitA){
	physicalFit.setSelectedItem(physicalFitA);
}

public void setRateField(String rate){
	rateField.setText(rate);
}
public void setInfoField(String info){
	infoField.setText(info);
}

public void setLanguagelvl(String language){
	languagelvl.setSelectedItem(language);
}
public void setExperience(String experienceA){
	experience.setSelectedItem(experienceA);
}

public void setPhysicalWork(String physicalWorkA){
	physicalWork.setSelectedItem(physicalWorkA);
}
public void setEmployeeAge(String employeeAgeA){
	employeeAge.setSelectedItem(employeeAgeA);
}





 



}
