package hust.soict.hedspi.aims.screen.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.ScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

import javax.swing.JButton;

public class AddCDScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JButton addButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private int rowCount=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCDScreen frame = new AddCDScreen();
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
	public AddCDScreen() {
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Add ComPactDisc");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLabel = new JLabel("ID");
		idLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		idLabel.setBounds(10, 23, 174, 40);
		contentPane.add(idLabel);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		titleLabel.setBounds(10, 73, 174, 40);
		contentPane.add(titleLabel);
		
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		categoryLabel.setBounds(10, 123, 174, 40);
		contentPane.add(categoryLabel);
		
		JLabel costLabel = new JLabel("Cost");
		costLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		costLabel.setBounds(10, 173, 174, 40);
		contentPane.add(costLabel);
		
		JLabel artistLabel = new JLabel("Artist");
		artistLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		artistLabel.setBounds(10, 273, 174, 40);
		contentPane.add(artistLabel);
		
		JLabel trackLabel = new JLabel("Track");
		trackLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		trackLabel.setBounds(10, 223, 174, 40);
		contentPane.add(trackLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(229, 23, 404, 40);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(229, 73, 404, 40);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(229, 123, 404, 40);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(229, 173, 404, 40);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(229, 223, 404, 40);
		contentPane.add(textField_4);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Title", "Length"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(229, 273, 404, 224);
		contentPane.add(scrollPane);
		
		JButton resetButton = new JButton("RESET");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.addActionListener(new ResetAllDVDAddFormActionListener());
		resetButton.setBounds(10, 419, 174, 34);
		contentPane.add(resetButton);
		
		addButton = new JButton("ADD");
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.addActionListener(new addNewCDToStore());
		addButton.setBounds(10, 375, 174, 34);
		contentPane.add(addButton);
		
		JButton addRowButton = new JButton("ADD ROW");
		addRowButton.addActionListener(new addARowForInput());
		addRowButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addRowButton.setBounds(10, 331, 174, 34);
		contentPane.add(addRowButton);
		
		JButton cancelButton_1 = new JButton("CANCEL");
		cancelButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton_1.setBounds(10, 463, 174, 34);
		contentPane.add(cancelButton_1);
		
		JLabel lblNewLabel = new JLabel("Please add a row first!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 308, 174, 13);
		contentPane.add(lblNewLabel);

	}
	
	private class addARowForInput implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			model_table.addRow(new Object[] {null,null});
			rowCount++;
		}
	}
	
	private class ResetAllDVDAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			int i_row = table.getRowCount();
			for( int i = 0 ; i < rowCount ; i++ ) {				
				model_table.setValueAt("",i,0 );
				model_table.setValueAt("",i,1 );
			}
			AddCDScreen.addButton.setEnabled(true);
		}
	}
	
	private class addNewCDToStore implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String tempStringID = textField.getText();
			int tempID = Integer.parseInt(tempStringID);
			String tempTitle = textField_1.getText();
			String tempCategory = textField_2.getText();
			String tempStringCost = textField_3.getText();
			float tempCost = Float.parseFloat(tempStringCost);
			String tempArtist = textField_4.getText();
			
			List<Track> tempTrackList = new ArrayList<Track>();
			DefaultTableModel model_table = (DefaultTableModel) table.getModel();
			for( int i = 0 ; i < rowCount; i++ ) {				
				String tempTrackTitle = table.getValueAt(i, 0)+"";
				String tempStringTrackLength   = table.getValueAt(i, 1)+"";
				int tempLength = Integer.parseInt(tempStringTrackLength);
				tempTrackList.add(new Track(tempTrackTitle, tempLength));
			}

			System.out.println(tempTrackList);
			CompactDisc newCDToStore = new CompactDisc(tempID, tempTitle, tempCategory, tempCost, tempArtist, tempTrackList);
			StoreManagerScreen.store.addMedia(newCDToStore);
			StoreManagerScreen.store.print();
//			System.out.format("%10s%30s%20s%10s",newCDToStore.getId(),newCDToStore.getTitle(),newCDToStore.getCategory(), newCDToStore.getCost());
//			System.out.println(newCDToStore.toString());
//			System.out.println();
			AddCDScreen.addButton.setEnabled(false);
		}
	}
}
