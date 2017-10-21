import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class FamiliesList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filterField;
	private JTable table;
	private WorkOfficeDAO dao;
	private ArrayList<FamilyModel> lista;
	private DefaultTableModel model;
	private NewFamilyFrame familyFrame;
	private InfoFamilyFrame info;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FamiliesList frame = new FamiliesList();
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
	public FamiliesList() {

		setTitle("Family list");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEdit();
				familyFrame.setVisible(true);
			}
		});

		JButton btnInfo = new JButton("Information");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getInfo();
				info.setVisible(true);
			}
		});

		filterField = new JTextField();
		filterField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent arg0) {
				findUser(filterField.getText());
			}
		});
		filterField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblsearch = new JLabel("Search:");
		lblsearch.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnCloseWindow = new JButton("Close");
		btnCloseWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnInfo).addGap(18)
										.addComponent(btnEdit).addGap(18).addComponent(btnDelete)
										.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
										.addComponent(btnCloseWindow))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblsearch, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(filterField, 327, 327, 327)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(filterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblsearch))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnInfo)
								.addComponent(btnEdit).addComponent(btnCloseWindow).addComponent(btnDelete))
						.addContainerGap()));

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Name", "Surname", "City"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMaxWidth(25);
		scrollPane.setViewportView(table);

		// Initiate populate the ArrayList lista from database data.
		dao = new WorkOfficeDAO();
		lista = dao.getFamilyList();
		populateTable();

		contentPane.setLayout(gl_contentPane);
		pack();
	}

	// -----------------------ALL CLASS
	// METHOD-----------------------------------------------------

	// Method populate Table
	public void populateTable() {

		model = (DefaultTableModel) table.getModel();
		Object[] tablerow = new Object[4];

		for (int i = 0; i < lista.size(); i++) {
			tablerow[0] = lista.get(i).getId();
			tablerow[1] = lista.get(i).getName();
			tablerow[2] = lista.get(i).getSurname();
			tablerow[3] = lista.get(i).getCity();
			model.addRow(tablerow);
		}
		System.out.println("Table populated");
	}

	// Refresh jTable
	public void refreshTable() {
		lista = dao.getFamilyList();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		populateTable();
	}

	// Delete selected row
	public void deleteData() {
		dao = new WorkOfficeDAO();
		int delID = lista.get(table.convertRowIndexToModel(table.getSelectedRow())).getId();
		dao.deleteData(delID);
		refreshTable();

	}

	// Selected row info
	public void getInfo() {

		int modelrow = table.convertRowIndexToModel(table.getSelectedRow());
		info = new InfoFamilyFrame();

		info.setName(lista.get(modelrow).getName());
		info.setSurname(lista.get(modelrow).getSurname());
		info.setPhone(lista.get(modelrow).getPhone());
		info.setFamilyPhone(lista.get(modelrow).getFamilyPhone());
		info.setBirthdate(lista.get(modelrow).getBirthDate());
		info.setCity(lista.get(modelrow).getCity());
		info.setStreet(lista.get(modelrow).getStreet());
		info.setPostCode(lista.get(modelrow).getPostCode());
		info.setHouseNr(lista.get(modelrow).getHouseNr());
		info.setFlatNr(lista.get(modelrow).getFlatNr());
		info.setPhysicalFit(lista.get(modelrow).getPhysicalFit());
		info.setRate(lista.get(modelrow).getRate());
		info.setLanguage(lista.get(modelrow).getLanguage());
		info.setInfo(lista.get(modelrow).getInfo());
		info.setPhysicalWork(lista.get(modelrow).getPhysicalWork());
		info.setExperience(lista.get(modelrow).getExperience());
		info.setEmployeeAge(lista.get(modelrow).getEmployeeAge());
	}

	// Find user method
	public void findUser(String query) {
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(query));
	}

	// Set data in NewFamilyFrame
	public void setEdit() {
		familyFrame = new NewFamilyFrame();
		int modelrow = table.convertRowIndexToModel(table.getSelectedRow());

		familyFrame.setId(lista.get(modelrow).getId());
		familyFrame.setName(lista.get(modelrow).getName());
		familyFrame.setSurname(lista.get(modelrow).getSurname());
		familyFrame.setPhoneField(lista.get(modelrow).getPhone());
		familyFrame.setPhoneToFamilyField(lista.get(modelrow).getFamilyPhone());
		familyFrame.setBirthDate(lista.get(modelrow).getBirthDate());
		familyFrame.setCityField(lista.get(modelrow).getCity());
		familyFrame.setStreetField(lista.get(modelrow).getStreet());
		familyFrame.setPostcodeField(lista.get(modelrow).getPostCode());
		familyFrame.setHousNrField(lista.get(modelrow).getHouseNr());
		familyFrame.setFlatNrField(lista.get(modelrow).getFlatNr());
		familyFrame.setPhysicalFit(lista.get(modelrow).getPhysicalFit());
		familyFrame.setRateField(lista.get(modelrow).getRate());
		familyFrame.setLanguagelvl(lista.get(modelrow).getLanguage());
		familyFrame.setInfoField(lista.get(modelrow).getInfo());
		familyFrame.setPhysicalWork(lista.get(modelrow).getPhysicalWork());
		familyFrame.setExperience(lista.get(modelrow).getExperience());
		familyFrame.setEmployeeAge(lista.get(modelrow).getEmployeeAge());
	}
}
