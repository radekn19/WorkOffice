
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.Label;
import com.toedter.calendar.JDateChooser;

/**
 * 
 * This class creating Link window and populate it.
 * 
 */

public class LinkFrame extends JDialog {

	private static final long serialVersionUID = 1L;
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
	private SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	private String fromDate = null;
	private String toDate = null;

	/**
	 * Create the frame.
	 */
	public LinkFrame() {
		setResizable(false);
		setTitle("Link");
		setBounds(100, 100, 1150, 550);
		setLocation(250, 200);
		setModal(true);
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

		JLabel lblGuardian = new JLabel("Workers");
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
		employeeTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		employeeTable.getColumnModel().getColumn(0).setMinWidth(30);
		employeeTable.getColumnModel().getColumn(0).setMaxWidth(80);
		employeeTable.setAutoCreateRowSorter(true);
		scrollPaneEmp.setViewportView(employeeTable);

		JButton btnEmploInfo = new JButton("Information");
		btnEmploInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int row = employeeTable.getSelectedRow();
				if (row != -1) {

					getInfoEmp();
					infoFrameEmpl.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Data not selected.");
				}
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

		JLabel lblFamilies = new JLabel("Families");
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
		familyTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		familyTable.getColumnModel().getColumn(0).setMinWidth(30);
		familyTable.getColumnModel().getColumn(0).setMaxWidth(80);
		familyTable.setAutoCreateRowSorter(true);
		scrollPaneFam.setViewportView(familyTable);

		JButton btnFamInfo = new JButton("Information");
		btnFamInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = familyTable.getSelectedRow();

				if (row != -1) {
					getInfoFam();
					infoFrameFam.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null, "Data not selected.");
				}
			}
		});
		btnFamInfo.setBounds(12, 329, 97, 25);
		panelFam.add(btnFamInfo);

		// ===========================================================================================================================================================

		Label labelFrom = new Label("From");
		labelFrom.setBounds(12, 401, 70, 24);
		contentPane.add(labelFrom);

		JDateChooser dateChooserFrom = new JDateChooser();
		dateChooserFrom.setBounds(88, 403, 131, 22);
		contentPane.add(dateChooserFrom);

		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(241, 409, 38, 16);
		contentPane.add(lblTo);

		JDateChooser dateChooserTo = new JDateChooser();
		dateChooserTo.setBounds(281, 403, 131, 22);
		contentPane.add(dateChooserTo);

		JButton btnLink = new JButton("Link");
		btnLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (dateChooserFrom.getDate() == null || dateChooserTo.getDate() == null
						|| familyTable.getSelectedRow() == -1 || employeeTable.getSelectedRow() == -1) {

					JOptionPane.showMessageDialog(null, "Date or rows not selected.");
				} else {
					fromDate = date.format(dateChooserFrom.getDate());
					toDate = date.format(dateChooserTo.getDate());
					insertLinkRows(fromDate, toDate);
				}
			}
		});
		btnLink.setBounds(12, 465, 97, 25);
		contentPane.add(btnLink);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(1023, 465, 97, 25);
		contentPane.add(btnClose);

		populateEmpTable();
		populateFamTable();

	}

	// =================================METHODS==================================================

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
		System.out.println("(LinkFrame) Employee table populated");
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
		System.out.println("(LinkFrame) Family table populated");
	}

	// Selected row info Employee
	public void getInfoEmp() {

		int modelrow = employeeTable.convertRowIndexToModel(employeeTable.getSelectedRow());
		infoFrameEmpl = new InfoEmployeeFrame();

		infoFrameEmpl.setName(empList.get(modelrow).getName());
		infoFrameEmpl.setSurname(empList.get(modelrow).getSurname());
		infoFrameEmpl.setPhone(empList.get(modelrow).getPhone());
		infoFrameEmpl.setBirthdate(empList.get(modelrow).getBirthdate());
		infoFrameEmpl.setCity(empList.get(modelrow).getCity());
		infoFrameEmpl.setStreet(empList.get(modelrow).getStreet());
		infoFrameEmpl.setPostCode(empList.get(modelrow).getPostcode());
		infoFrameEmpl.setHouseNr(empList.get(modelrow).getNrhouse());
		infoFrameEmpl.setFlatNr(empList.get(modelrow).getNrflat());
		infoFrameEmpl.setLanguage(empList.get(modelrow).getLanguage());
		infoFrameEmpl.setMarried(empList.get(modelrow).getMarried());
		infoFrameEmpl.setPhysicalWork(empList.get(modelrow).getPhysicalwork());
		infoFrameEmpl.setExperience(empList.get(modelrow).getExperience());
		infoFrameEmpl.setAvailability(empList.get(modelrow).getAvailability());
	}

	// Selected row info Family
	public void getInfoFam() {

		int modelrow = familyTable.convertRowIndexToModel(familyTable.getSelectedRow());
		infoFrameFam = new InfoFamilyFrame();

		infoFrameFam.setName(famList.get(modelrow).getName());
		infoFrameFam.setSurname(famList.get(modelrow).getSurname());
		infoFrameFam.setPhone(famList.get(modelrow).getPhone());
		infoFrameFam.setFamilyPhone(famList.get(modelrow).getPhonetofamily());
		infoFrameFam.setBirthdate(famList.get(modelrow).getBirthdate());
		infoFrameFam.setCity(famList.get(modelrow).getCity());
		infoFrameFam.setStreet(famList.get(modelrow).getStreet());
		infoFrameFam.setPostCode(famList.get(modelrow).getPostcode());
		infoFrameFam.setHouseNr(famList.get(modelrow).getNrhouse());
		infoFrameFam.setFlatNr(famList.get(modelrow).getNrflat());
		infoFrameFam.setPhysicalFit(famList.get(modelrow).getPhysicalfit());
		infoFrameFam.setRate(famList.get(modelrow).getRate());
		infoFrameFam.setLanguage(famList.get(modelrow).getLanguage());
		infoFrameFam.setInfo(famList.get(modelrow).getInfo());
		infoFrameFam.setPhysicalWork(famList.get(modelrow).getPhysicalwork());
		infoFrameFam.setExperience(famList.get(modelrow).getExperience());
		infoFrameFam.setEmployeeAge(famList.get(modelrow).getEmployeeage());
	}

	// Link and save selected rows into DataBase
	public void insertLinkRows(String dateFrom, String dateTo) {

		dao = new WorkOfficeDAO();

		int empRow = employeeTable.convertRowIndexToModel(employeeTable.getSelectedRow());
		int famRow = familyTable.convertRowIndexToModel(familyTable.getSelectedRow());

		dao.insertLinkData(empList.get(empRow).getId(), empList.get(empRow).getName(), empList.get(empRow).getSurname(),
				famList.get(famRow).getId(), famList.get(famRow).getName(), famList.get(famRow).getSurname(), dateFrom,
				dateTo);

		dao.showLinkTable();

	}
}
