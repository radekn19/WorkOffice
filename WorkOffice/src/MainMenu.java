import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JMenuBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;

public class MainMenu
{

	private JFrame frmWorkOffice;

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
					MainMenu window = new MainMenu();
					window.frmWorkOffice.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmWorkOffice = new JFrame();
		frmWorkOffice.setTitle("WORK OFFICE");
		frmWorkOffice.setBounds(100, 100, 900, 600);
		frmWorkOffice.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_table = new JPanel();
		
		JPanel panel_worker = new JPanel();
		panel_worker.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JPanel panel_family = new JPanel();
		panel_family.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnGetWorker = new JButton("Przypisz pracownika");
		GroupLayout groupLayout = new GroupLayout(frmWorkOffice.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panel_worker, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(panel_family, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
					.addGap(16))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGetWorker)
					.addContainerGap(745, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_family, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_worker, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnGetWorker)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(panel_table, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel lblWorker = new JLabel("Pracownik");
		lblWorker.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNewEmployee = new JButton("Nowy pracownik");
		btnNewEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				NewEmployeeFrame eFrame=new NewEmployeeFrame();
				eFrame.setVisible(true);
			}
		});
		
		JButton btnEmployeeList = new JButton("Lista pracownikow");
		btnEmployeeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmployeeList employeeList=new EmployeeList();
				employeeList.setVisible(true);
				
			}
		});
		GroupLayout gl_panel_worker = new GroupLayout(panel_worker);
		gl_panel_worker.setHorizontalGroup(
			gl_panel_worker.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_worker.createSequentialGroup()
					.addGroup(gl_panel_worker.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_worker.createSequentialGroup()
							.addGap(173)
							.addComponent(lblWorker))
						.addGroup(gl_panel_worker.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewEmployee))
						.addGroup(gl_panel_worker.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnEmployeeList)))
					.addContainerGap(172, Short.MAX_VALUE))
		);
		gl_panel_worker.setVerticalGroup(
			gl_panel_worker.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_worker.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWorker)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewEmployee)
					.addGap(18)
					.addComponent(btnEmployeeList)
					.addContainerGap(179, Short.MAX_VALUE))
		);
		panel_worker.setLayout(gl_panel_worker);
		
		JLabel lblFamily = new JLabel("Rodzina");
		lblFamily.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JButton btnNFamily = new JButton("Nowa rodzina");
		btnNFamily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewFamilyFrame nff= new NewFamilyFrame();
				nff.setVisible(true);
			
			}
		});
		
		JButton btnListaRodzin = new JButton("Lista rodzin");
		btnListaRodzin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FamiliesList flist= new FamiliesList();
				flist.setVisible(true);
			}
		});
		GroupLayout gl_panel_family = new GroupLayout(panel_family);
		gl_panel_family.setHorizontalGroup(
			gl_panel_family.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_family.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNFamily)
					.addContainerGap(313, Short.MAX_VALUE))
				.addGroup(gl_panel_family.createSequentialGroup()
					.addGap(179)
					.addComponent(lblFamily, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
					.addGap(176))
				.addGroup(gl_panel_family.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnListaRodzin)
					.addContainerGap(321, Short.MAX_VALUE))
		);
		gl_panel_family.setVerticalGroup(
			gl_panel_family.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_family.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFamily, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNFamily)
					.addGap(18)
					.addComponent(btnListaRodzin)
					.addGap(186))
		);
		panel_family.setLayout(gl_panel_family);
		frmWorkOffice.getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frmWorkOffice.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFile.add(mntmExit);

		
	}
}
