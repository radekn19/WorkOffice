import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FamiliesList extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private WorkOfficeDAO dao;
	private ArrayList<FamilyModel> lista;

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
					FamiliesList frame = new FamiliesList();
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
	public FamiliesList()
	{
		
		setTitle("Lista rodzin");
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSearch = new JButton("Szukaj");
		
		JButton btnEdit = new JButton("Edytuj");
		
		JButton btnInfo = new JButton("Informacje");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getInfo();	
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnInfo)
							.addPreferredGap(ComponentPlacement.RELATED, 258, Short.MAX_VALUE)
							.addComponent(btnEdit))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnSearch)
							.addGap(16)
							.addComponent(textField, 327, 327, 327)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearch)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInfo)
						.addComponent(btnEdit))
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {      },
			new String[] {"id", "imie", "nazwisko", "miasto"}) 
		{
			
			private static final long serialVersionUID = 1L;
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
		dao=new WorkOfficeDAO();	
		lista=dao.getFamilyList();
		
		populateTabel();
		
		contentPane.setLayout(gl_contentPane);
		pack();
	}
	
//Method populate Table	
	public void populateTabel(){
		
		
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		Object[]tablerow=new Object[4];
		
		for(int i=0;i<lista.size();i++){
			tablerow[0] = lista.get(i).getId();
			tablerow[1] = lista.get(i).getName();
			tablerow[2] = lista.get(i).getSurname();
			tablerow[3] = lista.get(i).getCity();
	        model.addRow(tablerow);
	        System.out.println(i);
		}
		System.out.println("Tablica uzupe³niona");
	}
	
// Selected row info
	public void getInfo(){
		
		int row=table.getSelectedRow();
		InfoFamilyFrame info=new InfoFamilyFrame();
		
		info.setName(lista.get(row).getName());
		info.setSurname(lista.get(row).getSurname());
		info.setPhone(lista.get(row).getPhone());
		info.setFamilyPhone(lista.get(row).getFamilyPhone());
		info.setBirthdate(lista.get(row).getBirthDate());
		info.setCity(lista.get(row).getCity());
		info.setStreet(lista.get(row).getStreet());
		info.setPostCode(lista.get(row).getPostCode());
		info.setHouseNr(lista.get(row).getHouseNr());
		info.setFlatNr(lista.get(row).getFlatNr());
		info.setPhysicalFit(lista.get(row).getPhysicalFit());
		info.setRate(lista.get(row).getRate());
		info.setLanguage(lista.get(row).getLanguage());
		info.setInfo(lista.get(row).getInfo());
		info.setPhysicalWork(lista.get(row).getPhysicalWork());
		info.setExperience(lista.get(row).getExperience());
		info.setEmployeeAge(lista.get(row).getEmployeeAge());
	
	    info.setVisible(true);

		
			
		}
	
	
}
