import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
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
import javax.swing.JOptionPane;
import java.awt.Font;


/**
 * This class creating FamiliesList window and operate it.
 */

public class FamiliesList extends JDialog {

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
	 * Create the frame.
	 */
	public FamiliesList() {
		setResizable(false);

		setTitle("Family list");
		setLocation(420, 190);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if (row != -1) {
					setEdit(row);
				} else {
					JOptionPane.showMessageDialog(null, "No data selected.");
				}
			}
		});

		JButton btnInfo = new JButton("Information");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int row = table.getSelectedRow();
				if (row != -1) {
					getInfo(row);
				} else {
					JOptionPane.showMessageDialog(null, "No data selected.");
				}
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
				int row = table.getSelectedRow();
				if (row != -1) {
					int pane = JOptionPane.showConfirmDialog(null, "Do you want to delete the items?", "DELETE",
							JOptionPane.YES_NO_OPTION);
					if (pane == JOptionPane.YES_OPTION) {
						deleteData(row);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No data selected.");
				}
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
		table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "id", "Name", "Surname", "City" }) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);

		populateTable();

		contentPane.setLayout(gl_contentPane);
		pack();
	}

	// -----------------------METHODS-----------------------------------------------------

	// Method populate Table
	public void populateTable() {

		dao = new WorkOfficeDAO();
		lista = dao.getFamilyList();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] tablerow = new Object[4];

		for (int i = 0; i < lista.size(); i++) {
			tablerow[0] = lista.get(i).getId();
			tablerow[1] = lista.get(i).getName();
			tablerow[2] = lista.get(i).getSurname();
			tablerow[3] = lista.get(i).getCity();
			model.addRow(tablerow);
		}
		System.out.println("(FamiliesList) Table populated");
	}

	// Find user method
	public void findUser(String query) {

		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(query));
	}

	// Delete selected row
	public void deleteData(int row) {

		dao = new WorkOfficeDAO();
		int delID = lista.get(table.convertRowIndexToModel(row)).getId();
		dao.deleteData(delID);
		populateTable();
	}

	// Selected row info
	public void getInfo(int row) {

		int modelrow = table.convertRowIndexToModel(row);
		info = new InfoFamilyFrame();

		info.setName(lista.get(modelrow).getName());
		info.setSurname(lista.get(modelrow).getSurname());
		info.setPhone(lista.get(modelrow).getPhone());
		info.setFamilyPhone(lista.get(modelrow).getPhonetofamily());
		info.setBirthdate(lista.get(modelrow).getBirthdate());
		info.setCity(lista.get(modelrow).getCity());
		info.setStreet(lista.get(modelrow).getStreet());
		info.setPostCode(lista.get(modelrow).getPostcode());
		info.setHouseNr(lista.get(modelrow).getNrhouse());
		info.setFlatNr(lista.get(modelrow).getNrflat());
		info.setPhysicalFit(lista.get(modelrow).getPhysicalfit());
		info.setRate(lista.get(modelrow).getRate());
		info.setLanguage(lista.get(modelrow).getLanguage());
		info.setInfo(lista.get(modelrow).getInfo());
		info.setPhysicalWork(lista.get(modelrow).getPhysicalwork());
		info.setExperience(lista.get(modelrow).getExperience());
		info.setEmployeeAge(lista.get(modelrow).getEmployeeage());

		info.setVisible(true);
	}

	// Set data in NewFamilyFrame
	public void setEdit(int row) {

		int modelrow = table.convertRowIndexToModel(row);
		familyFrame = new NewFamilyFrame();

		familyFrame.setId(lista.get(modelrow).getId());
		familyFrame.setName(lista.get(modelrow).getName());
		familyFrame.setSurname(lista.get(modelrow).getSurname());
		familyFrame.setPhoneField(lista.get(modelrow).getPhone());
		familyFrame.setPhoneToFamilyField(lista.get(modelrow).getPhonetofamily());
		familyFrame.setBirthDate(lista.get(modelrow).getBirthdate());
		familyFrame.setCityField(lista.get(modelrow).getCity());
		familyFrame.setStreetField(lista.get(modelrow).getStreet());
		familyFrame.setPostcodeField(lista.get(modelrow).getPostcode());
		familyFrame.setHousNrField(lista.get(modelrow).getNrhouse());
		familyFrame.setFlatNrField(lista.get(modelrow).getNrflat());
		familyFrame.setPhysicalFit(lista.get(modelrow).getPhysicalfit());
		familyFrame.setRateField(lista.get(modelrow).getRate());
		familyFrame.setLanguagelvl(lista.get(modelrow).getLanguage());
		familyFrame.setInfoField(lista.get(modelrow).getInfo());
		familyFrame.setPhysicalWork(lista.get(modelrow).getPhysicalwork());
		familyFrame.setExperience(lista.get(modelrow).getExperience());
		familyFrame.setEmployeeAge(lista.get(modelrow).getEmployeeage());

		familyFrame.setVisible(true);
	}
}
