
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class LinkFrame extends JFrame {

	private JPanel contentPane;
	private JTable employeeTable;
	private JTable familyTable;
	private WorkOfficeDAO dao;
	private ArrayList<EmployeeModel> empList;
	private ArrayList<FamilyModel> famList;
	private DefaultTableModel modelFam;
	private DefaultTableModel modelEmp;
	private InfoEmployeeFrame infoFrameEmpl;
	private InfoFamilyFrame infoFrameFam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LinkFrame frame = new LinkFrame();
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
	public LinkFrame() {
		setTitle("Powiaz");
		setBounds(100, 100, 1150, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

// ==============================================================================================================================================

		JPanel panelEmp = new JPanel();
		panelEmp.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelEmp.setBounds(12, 13, 540, 370);
		contentPane.add(panelEmp);
		SpringLayout sl_panelEmp = new SpringLayout();
		panelEmp.setLayout(sl_panelEmp);

		JLabel lblGuardian = new JLabel("Opiekuni");
		sl_panelEmp.putConstraint(SpringLayout.NORTH, lblGuardian, 13, SpringLayout.NORTH, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.WEST, lblGuardian, 242, SpringLayout.WEST, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.SOUTH, lblGuardian, 41, SpringLayout.NORTH, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.EAST, lblGuardian, 321, SpringLayout.WEST, panelEmp);
		lblGuardian.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelEmp.add(lblGuardian);

		JScrollPane scrollPaneEmp = new JScrollPane();
		sl_panelEmp.putConstraint(SpringLayout.NORTH, scrollPaneEmp, 80, SpringLayout.NORTH, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.WEST, scrollPaneEmp, 12, SpringLayout.WEST, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.SOUTH, scrollPaneEmp, 316, SpringLayout.NORTH, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.EAST, scrollPaneEmp, 528, SpringLayout.WEST, panelEmp);
		panelEmp.add(scrollPaneEmp);

		employeeTable = new JTable();
		employeeTable
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Surname", "City" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}

				});
		scrollPaneEmp.setViewportView(employeeTable);

		JButton btnEmploInfo = new JButton("Informacje");
		btnEmploInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int modelrow = employeeTable.convertRowIndexToModel(employeeTable.getSelectedRow());
				getInfoEmp(modelrow);
				infoFrameEmpl.setVisible(true);
			}
		});
		sl_panelEmp.putConstraint(SpringLayout.NORTH, btnEmploInfo, 329, SpringLayout.NORTH, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.WEST, btnEmploInfo, 12, SpringLayout.WEST, panelEmp);
		sl_panelEmp.putConstraint(SpringLayout.EAST, btnEmploInfo, 109, SpringLayout.WEST, panelEmp);
		panelEmp.add(btnEmploInfo);

// =========================================================================================================================================================

		JPanel panelFam = new JPanel();
		panelFam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelFam.setBounds(580, 13, 540, 370);
		contentPane.add(panelFam);
		panelFam.setLayout(null);

		JLabel lblFamilies = new JLabel("Rodziny");
		lblFamilies.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFamilies.setBounds(268, 13, 74, 25);
		panelFam.add(lblFamilies);

		JScrollPane scrollPaneFam = new JScrollPane();
		scrollPaneFam.setBounds(12, 80, 516, 236);
		panelFam.add(scrollPaneFam);

		familyTable = new JTable();
		familyTable
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Name", "Surname", "City" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPaneFam.setViewportView(familyTable);

		JButton btnFamInfo = new JButton("Informacje");
		btnFamInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int modelrow = familyTable.convertRowIndexToModel(familyTable.getSelectedRow());
				getInfoFam(modelrow);
				infoFrameFam.setVisible(true);
			}
		});
		btnFamInfo.setBounds(12, 329, 97, 25);
		panelFam.add(btnFamInfo);
		
// ===========================================================================================================================================================

		JButton btnLink = new JButton("Powiaz");
		btnLink.setBounds(12, 415, 97, 25);
		contentPane.add(btnLink);

		JButton btnClose = new JButton("Zamknij");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(1023, 415, 97, 25);
		contentPane.add(btnClose);

		populateEmpTable();
		populateFamTable();

	}
	
//=================================METHODS==================================================

	// Method populate Employee Table
	public void populateEmpTable() {
		dao = new WorkOfficeDAO();
		empList = dao.getEmployeeListList();
		modelEmp = (DefaultTableModel) employeeTable.getModel();
		Object[] tablerow = new Object[4];

		for (int i = 0; i < empList.size(); i++) {
			tablerow[0] = empList.get(i).getId();
			tablerow[1] = empList.get(i).getName();
			tablerow[2] = empList.get(i).getSurname();
			tablerow[3] = empList.get(i).getCity();
			modelEmp.addRow(tablerow);
		}
		System.out.println("Tablica Employee uzupelniona");
	}

	// Method populate Family Table
	public void populateFamTable() {
		dao = new WorkOfficeDAO();
		famList = dao.getFamilyList();
		modelFam = (DefaultTableModel) familyTable.getModel();
		Object[] tablerow = new Object[4];

		for (int i = 0; i < famList.size(); i++) {
			tablerow[0] = famList.get(i).getId();
			tablerow[1] = famList.get(i).getName();
			tablerow[2] = famList.get(i).getSurname();
			tablerow[3] = famList.get(i).getCity();
			modelFam.addRow(tablerow);
		}
		System.out.println("Tablica  Family uzupelniona");
	}

	// Selected row info Employee
	public void getInfoEmp(int modelrow) {

		infoFrameEmpl = new InfoEmployeeFrame();
		infoFrameEmpl.setName(empList.get(modelrow).getName());
		infoFrameEmpl.setSurname(empList.get(modelrow).getSurname());
		infoFrameEmpl.setPhone(empList.get(modelrow).getPhone());
		infoFrameEmpl.setBirthdate(empList.get(modelrow).getBirthDate());
		infoFrameEmpl.setCity(empList.get(modelrow).getCity());
		infoFrameEmpl.setStreet(empList.get(modelrow).getStreet());
		infoFrameEmpl.setPostCode(empList.get(modelrow).getPostCode());
		infoFrameEmpl.setHouseNr(empList.get(modelrow).getHouseNr());
		infoFrameEmpl.setFlatNr(empList.get(modelrow).getFlatNr());
		infoFrameEmpl.setLanguage(empList.get(modelrow).getLanguage());
		infoFrameEmpl.setMarried(empList.get(modelrow).getMarried());
		infoFrameEmpl.setPhysicalWork(empList.get(modelrow).getPhysicalWork());
		infoFrameEmpl.setExperience(empList.get(modelrow).getExperience());
		infoFrameEmpl.setAvailability(empList.get(modelrow).getAvailability());
	}

	// Selected row info
	public void getInfoFam(int modelrow) {

		infoFrameFam = new InfoFamilyFrame();

		infoFrameFam.setName(famList.get(modelrow).getName());
		infoFrameFam.setSurname(famList.get(modelrow).getSurname());
		infoFrameFam.setPhone(famList.get(modelrow).getPhone());
		infoFrameFam.setFamilyPhone(famList.get(modelrow).getFamilyPhone());
		infoFrameFam.setBirthdate(famList.get(modelrow).getBirthDate());
		infoFrameFam.setCity(famList.get(modelrow).getCity());
		infoFrameFam.setStreet(famList.get(modelrow).getStreet());
		infoFrameFam.setPostCode(famList.get(modelrow).getPostCode());
		infoFrameFam.setHouseNr(famList.get(modelrow).getHouseNr());
		infoFrameFam.setFlatNr(famList.get(modelrow).getFlatNr());
		infoFrameFam.setPhysicalFit(famList.get(modelrow).getPhysicalFit());
		infoFrameFam.setRate(famList.get(modelrow).getRate());
		infoFrameFam.setLanguage(famList.get(modelrow).getLanguage());
		infoFrameFam.setInfo(famList.get(modelrow).getInfo());
		infoFrameFam.setPhysicalWork(famList.get(modelrow).getPhysicalWork());
		infoFrameFam.setExperience(famList.get(modelrow).getExperience());
		infoFrameFam.setEmployeeAge(famList.get(modelrow).getEmployeeAge());
	}
}
