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

	private JPanel contentPane;
	private JTextField filterField;
	private JTable table;
	private WorkOfficeDAO dao;
	private ArrayList<EmployeeModel> lista;
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
		setTitle("Lista pracownikow");
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnEdit = new JButton("Edytuj");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setEdit();
				employeeFrame.setVisible(true);
				
			}
		});
		
		JButton btnInfo = new JButton("Informacje");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int modelrow=table.convertRowIndexToModel(table.getSelectedRow());
				getInfo(modelrow);
				infoframe.setVisible(true);
				
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
		
		JLabel lblsearch = new JLabel("Wyszukaj:");
		lblsearch.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnCloseWindow = new JButton("Zamknij");
		btnCloseWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
		JButton btnDelete = new JButton("Usun");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnInfo)
							.addGap(18)
							.addComponent(btnEdit)
							.addGap(18)
							.addComponent(btnDelete)
							.addPreferredGap(ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
							.addComponent(btnCloseWindow))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblsearch, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(filterField, 327, 327, 327)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(filterField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblsearch))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInfo)
						.addComponent(btnEdit)
						.addComponent(btnCloseWindow)
						.addComponent(btnDelete))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {      },
			new String[] {"id", "imie", "nazwisko", "miasto"}) 
		{
			
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(0).setMaxWidth(25);
		scrollPane.setViewportView(table);
		
	//Initiate populate the ArrayList lista from database data.		
		
		populateTable();
		
		contentPane.setLayout(gl_contentPane);
		pack();
	}
	
//================================================================================================================================
	
	//Method populate Table	
		public void populateTable(){
			dao=new WorkOfficeDAO();
			lista=dao.getEmployeeListList();
			model=(DefaultTableModel) table.getModel();
			Object[]tablerow=new Object[4];
			
			for(int i=0;i<lista.size();i++){
				tablerow[0] = lista.get(i).getId();
				tablerow[1] = lista.get(i).getName();
				tablerow[2] = lista.get(i).getSurname();
				tablerow[3] = lista.get(i).getCity();
		        model.addRow(tablerow);
			}
			System.out.println("Tablica uzupelniona");
		}
		
	// Find user method
		public void findUser(String query){
			TableRowSorter<DefaultTableModel> trs=new TableRowSorter<DefaultTableModel>(model);
			table.setRowSorter(trs);
			trs.setRowFilter(RowFilter.regexFilter(query));
		}
		
	//Refresh jTable
		public void refreshTable() {
			lista=dao.getEmployeeListList();
			model=(DefaultTableModel) table.getModel();
			model.setRowCount(0);
			populateTable();
		}
		
	//Delete selected row
		public void deleteData() {
			dao=new WorkOfficeDAO();
			int delID=lista.get(table.convertRowIndexToModel(table.getSelectedRow())).getId();
			dao.deleteEmployeeData(delID);
			refreshTable();
		}
		
	// Set data in NewFamilyFrame
		public void setEdit(){
			employeeFrame=new NewEmployeeFrame();
			int modelrow=table.convertRowIndexToModel(table.getSelectedRow());
			
			employeeFrame.setId(lista.get(modelrow).getId());
			employeeFrame.setName(lista.get(modelrow).getName());
			employeeFrame.setSurname(lista.get(modelrow).getSurname());
			employeeFrame.setPhoneField(lista.get(modelrow).getPhone());
			employeeFrame.setBirthDate(lista.get(modelrow).getBirthDate());
			employeeFrame.setCityField(lista.get(modelrow).getCity());
			employeeFrame.setStreetField(lista.get(modelrow).getStreet());
			employeeFrame.setPostcodeField(lista.get(modelrow).getPostCode());
			employeeFrame.setHousNrField(lista.get(modelrow).getHouseNr());
			employeeFrame.setFlatNrField(lista.get(modelrow).getFlatNr());
			employeeFrame.setLanguage(lista.get(modelrow).getLanguage());
			employeeFrame.setPhysicalWork(lista.get(modelrow).getPhysicalWork());
			employeeFrame.setExperience(lista.get(modelrow).getExperience());
			employeeFrame.setMattied(lista.get(modelrow).getMarried());
			employeeFrame.setAvailability(lista.get(modelrow).getAvailability());
		}
		
 // Selected row info
		public void getInfo(int modelrow){
			
			infoframe=new InfoEmployeeFrame();
			
			infoframe.setName(lista.get(modelrow).getName());
			infoframe.setSurname(lista.get(modelrow).getSurname());
			infoframe.setPhone(lista.get(modelrow).getPhone());
			infoframe.setBirthdate(lista.get(modelrow).getBirthDate());
			infoframe.setCity(lista.get(modelrow).getCity());
			infoframe.setStreet(lista.get(modelrow).getStreet());
			infoframe.setPostCode(lista.get(modelrow).getPostCode());
			infoframe.setHouseNr(lista.get(modelrow).getHouseNr());
			infoframe.setFlatNr(lista.get(modelrow).getFlatNr());
			infoframe.setLanguage(lista.get(modelrow).getLanguage());
			infoframe.setMarried(lista.get(modelrow).getMarried());
			infoframe.setPhysicalWork(lista.get(modelrow).getPhysicalWork());
			infoframe.setExperience(lista.get(modelrow).getExperience());
			infoframe.setAvailability(lista.get(modelrow).getAvailability());			
			}
}

