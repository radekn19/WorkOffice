

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class EmployeeList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField filterField;
	private JTable table;
	private WorkOfficeDAO dao;
	private ArrayList<EmployeeModel> worker;
	private DefaultTableModel model;
	private NewEmployeeFrame employeeFrame;
	private InfoEmployeeFrame infoframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeList frame = new EmployeeList();
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
	public EmployeeList() {
		setTitle("Workers list");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setEdit();
				
			}
		});

		JButton btnInfo = new JButton("Information");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getInfo();
				
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

		JLabel lblSearch = new JLabel("Search:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row!=-1) {
					int pane=JOptionPane.showConfirmDialog(null,"Do you want to delete the items?","DELETE", JOptionPane.YES_NO_OPTION);
					if(pane==JOptionPane.YES_OPTION) {
						deleteData(row);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "No field selected.");
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
										.addComponent(btnClose))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 73,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(filterField, 327, 327, 327)))
						.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(filterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSearch))
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnInfo)
								.addComponent(btnEdit).addComponent(btnClose).addComponent(btnDelete))
						.addContainerGap()));

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "Name", "Surname", "City"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(80);
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);

		// Initiate populate the ArrayList lista from database data.

		populateTable();

		contentPane.setLayout(gl_contentPane);
		pack();
	}

// ===================================== METHODS ==========================================================================================

	// Method populate Table
	public void populateTable() {
		dao = new WorkOfficeDAO();
		worker = dao.getEmployeeListList();
		model = (DefaultTableModel) table.getModel();
		Object[] tablerow = new Object[4];

		for (int i = 0; i < worker.size(); i++) {
			tablerow[0] = worker.get(i).getId();
			tablerow[1] = worker.get(i).getName();
			tablerow[2] = worker.get(i).getSurname();
			tablerow[3] = worker.get(i).getCity();
			model.addRow(tablerow);
		}
		System.out.println("Tablica uzupelniona");
	}

	// Find user method
	public void findUser(String query) {
		TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(model);
		table.setRowSorter(trs);
		trs.setRowFilter(RowFilter.regexFilter(query));
	}

	// Refresh jTable
	public void refreshTable() {
		worker = dao.getEmployeeListList();
		model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		populateTable();
	}

	// Delete selected row
	public void deleteData(int row) {
		int delID = worker.get(table.convertRowIndexToModel(row)).getId();
		dao = new WorkOfficeDAO();
		dao.deleteEmployeeData(delID);
		refreshTable();
	}

	// Set data in NewFamilyFrame
	public void setEdit() {
		int modelrow = table.convertRowIndexToModel(table.getSelectedRow());
		if(modelrow!=-1) {
		employeeFrame = new NewEmployeeFrame();
		
		employeeFrame.setId(worker.get(modelrow).getId());
		employeeFrame.setName(worker.get(modelrow).getName());
		employeeFrame.setSurname(worker.get(modelrow).getSurname());
		employeeFrame.setPhoneField(worker.get(modelrow).getPhone());
		employeeFrame.setBirthDate(worker.get(modelrow).getBirthdate());
		employeeFrame.setCityField(worker.get(modelrow).getCity());
		employeeFrame.setStreetField(worker.get(modelrow).getStreet());
		employeeFrame.setPostcodeField(worker.get(modelrow).getPostcode());
		employeeFrame.setHousNrField(worker.get(modelrow).getNrhouse());
		employeeFrame.setFlatNrField(worker.get(modelrow).getNrflat());
		employeeFrame.setLanguage(worker.get(modelrow).getLanguage());
		employeeFrame.setPhysicalWork(worker.get(modelrow).getPhysicalwork());
		employeeFrame.setExperience(worker.get(modelrow).getExperience());
		employeeFrame.setMattied(worker.get(modelrow).getMarried());
		employeeFrame.setAvailability(worker.get(modelrow).getAvailability());
		
		employeeFrame.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "No field selected.");
		}
	}

	// Selected row info
	public void getInfo() {
		int modelrow = table.convertRowIndexToModel(table.getSelectedRow());
		if(modelrow!=-1) {
		infoframe = new InfoEmployeeFrame();

		infoframe.setName(worker.get(modelrow).getName());
		infoframe.setSurname(worker.get(modelrow).getSurname());
		infoframe.setPhone(worker.get(modelrow).getPhone());
		infoframe.setBirthdate(worker.get(modelrow).getBirthdate());
		infoframe.setCity(worker.get(modelrow).getCity());
		infoframe.setStreet(worker.get(modelrow).getStreet());
		infoframe.setPostCode(worker.get(modelrow).getPostcode());
		infoframe.setHouseNr(worker.get(modelrow).getNrhouse());
		infoframe.setFlatNr(worker.get(modelrow).getNrflat());
		infoframe.setLanguage(worker.get(modelrow).getLanguage());
		infoframe.setMarried(worker.get(modelrow).getMarried());
		infoframe.setPhysicalWork(worker.get(modelrow).getPhysicalwork());
		infoframe.setExperience(worker.get(modelrow).getExperience());
		infoframe.setAvailability(worker.get(modelrow).getAvailability());
		
		infoframe.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "No field selected.");
		}
	}
}
