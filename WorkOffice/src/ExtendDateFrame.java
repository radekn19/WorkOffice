import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ExtendDateFrame extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JDateChooser dateChooser = new JDateChooser();
	private WorkOfficeDAO dao;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ExtendDateFrame dialog = new ExtendDateFrame();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ExtendDateFrame(int linkId) {
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setBackground(Color.GRAY);
		setTitle("Extend date");
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblExtendDateTo = new JLabel("Extend date to:");
		lblExtendDateTo.setBounds(12, 31, 111, 16);
		contentPanel.add(lblExtendDateTo);
		
		dateChooser.setBounds(135, 25, 105, 22);
		contentPanel.add(dateChooser);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(dateChooser.getDate()!=null) {
							
							dao=new WorkOfficeDAO();
							SimpleDateFormat format=new SimpleDateFormat("dd-MM-yyyy");
							String dates=format.format(dateChooser.getDate());
							dao.extendDateTo(linkId, dates);
							setVisible(false);
						}
					
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
	}
	
	
}
