import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;

public class NewWorkerFrame
{

	private JFrame frmNowyPracownik;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void NewWorkerScreen()
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					NewWorkerFrame window = new NewWorkerFrame();
					window.frmNowyPracownik.setVisible(true);
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
	public NewWorkerFrame()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmNowyPracownik = new JFrame();
		frmNowyPracownik.setTitle("Nowy pracownik");
		frmNowyPracownik.setBounds(100, 100, 470, 450);
		
		JLabel lblImie = new JLabel("Imie:");
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblDataUrodzenia = new JLabel("Data urodzenia:\r\n");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblAdresZamieszkania = new JLabel("Adres zamieszkania:");
		lblAdresZamieszkania.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblUlica = new JLabel("ulica:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblMiejscowoc = new JLabel("Miejscowo\u015Bc:");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblKodPocztowy = new JLabel("Kod pocztowy:");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblMieszkanie = new JLabel("nr. domu:");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNrmieszkania = new JLabel("nr.mieszkania:");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblTelefon = new JLabel("telefon:");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnZamknij = new JButton("Zamknij");
		
		JButton btnZapisz = new JButton("Zapisz");
		GroupLayout groupLayout = new GroupLayout(frmNowyPracownik.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblMiejscowoc)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblKodPocztowy)
											.addGap(10)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(10)
											.addComponent(lblMieszkanie)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNrmieszkania)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblUlica)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 83, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAdresZamieszkania)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblImie)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNazwisko)
									.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDataUrodzenia)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_2, 0, 0, Short.MAX_VALUE)
									.addGap(22)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblTelefon)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addComponent(btnZapisz)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnZamknij))
							.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblImie)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNazwisko)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDataUrodzenia)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefon)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addComponent(lblAdresZamieszkania)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMiejscowoc)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKodPocztowy)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMieszkanie)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNrmieszkania)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUlica)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnZapisz)
						.addComponent(btnZamknij))
					.addContainerGap())
		);
		
		JLabel lblInformacjeDodatkowe = new JLabel("Informacje dodatkowe:");
		lblInformacjeDodatkowe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		
		JLabel lblJniemiecki = new JLabel("j.niemiecki:");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"s\u0142aby", "\u015Bredni", "dobry"}));
		
		JLabel lblPracaFizyczna = new JLabel("praca fizyczna:");
		
		JCheckBox chckbxTak = new JCheckBox("TAK");
		
		JLabel lblMattaonaty = new JLabel("m\u0119\u017Cata/\u017Conaty:");
		
		JLabel lblDowiadczenie = new JLabel("do\u015Bwiadczenie:");
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ma\u0142e", "du\u017Ce"}));
		
		JCheckBox chckbxTak_1 = new JCheckBox("TAK");
		
		JLabel lblNewLabel = new JLabel("dost\u0119pny/a od:");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
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
											.addComponent(lblJniemiecki)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblMattaonaty)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(chckbxTak_1)))
									.addGap(63)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lblPracaFizyczna)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(chckbxTak))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblDowiadczenie)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(78, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInformacjeDodatkowe)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblJniemiecki)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDowiadczenie)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMattaonaty)
						.addComponent(chckbxTak_1)
						.addComponent(lblPracaFizyczna)
						.addComponent(chckbxTak))
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frmNowyPracownik.getContentPane().setLayout(groupLayout);
	}
}
