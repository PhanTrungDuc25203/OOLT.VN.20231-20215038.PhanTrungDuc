package hust.soict.hedspi.aims.screen.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddDVDScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private static JButton addButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDVDScreen frame = new AddDVDScreen();
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
	public AddDVDScreen() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Add DVD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel dvdId = new JLabel("ID");
		dvdId.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdId.setBounds(31, 27, 174, 40);
		contentPane.add(dvdId);
		
		JLabel dvdTitle = new JLabel("Title");
		dvdTitle.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdTitle.setBounds(31, 77, 174, 40);
		contentPane.add(dvdTitle);
		
		JLabel dvdCategory = new JLabel("Category");
		dvdCategory.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdCategory.setBounds(31, 127, 174, 40);
		contentPane.add(dvdCategory);
		
		JLabel dvdCost = new JLabel("Cost");
		dvdCost.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdCost.setBounds(31, 177, 174, 40);
		contentPane.add(dvdCost);
		
		JLabel dvdDirector = new JLabel("Director");
		dvdDirector.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdDirector.setBounds(31, 227, 174, 40);
		contentPane.add(dvdDirector);
		
		JLabel dvdLength = new JLabel("Length");
		dvdLength.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdLength.setBounds(31, 277, 174, 40);
		contentPane.add(dvdLength);
		
		textField = new JTextField();
		textField.setBounds(255, 27, 357, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 77, 357, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(255, 127, 357, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(255, 177, 357, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(255, 227, 357, 40);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(255, 277, 357, 40);
		contentPane.add(textField_5);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resetButton.addActionListener(new ResetAllDVDAddFormActionListener());
		resetButton.setBounds(31, 352, 143, 41);
		contentPane.add(resetButton);
		
		addButton = new JButton("ADD");
		addButton.addActionListener(new AddNewDVDToStoreActionListener());
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBounds(255, 352, 143, 41);
		contentPane.add(addButton);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBounds(469, 352, 143, 41);
		contentPane.add(cancelButton);

		
		
	}
	private class ResetAllDVDAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			
			AddDVDScreen.addButton.setEnabled(true);
		}
	}
	
	private class AddNewDVDToStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String tempStringID = textField.getText();
			int tempID = Integer.parseInt(tempStringID);
			String tempTitle = textField_1.getText();
			String tempCategory = textField_2.getText();
			String tempStringCost = textField_3.getText();
			float tempCost = Float.parseFloat(tempStringCost);
			String tempDirector = textField_4.getText();
			String tempStringLength = textField_5.getText();
			int tempLength = Integer.parseInt(tempStringLength);
			DigitalVideoDisc newDiscToStore = new DigitalVideoDisc(tempID, tempTitle, tempCategory, tempCost, tempDirector, tempLength);
			StoreManagerScreen.store.addMedia(newDiscToStore);
			StoreManagerScreen.store.print();
			
			AddDVDScreen.addButton.setEnabled(false);;
		}
	}
}
