package hust.soict.hedspi.aims.screen.manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AddBookScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JButton addButton;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookScreen frame = new AddBookScreen();
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
	public AddBookScreen() {
		setForeground(new Color(0, 255, 255));
		setFont(new Font("Dialog", Font.PLAIN, 14));
		setTitle("Add Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 393);
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
		
		JLabel dvdDirector = new JLabel("Authors");
		dvdDirector.setFont(new Font("Tahoma", Font.PLAIN, 25));
		dvdDirector.setBounds(31, 227, 174, 40);
		contentPane.add(dvdDirector);
		
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
		
		JButton resetButton = new JButton("RESET");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resetButton.addActionListener(new ResetAllBookAddFormActionListener());
		resetButton.setBounds(31, 298, 143, 41);
		contentPane.add(resetButton);
		
		addButton = new JButton("ADD");
		addButton.addActionListener(new AddNewBookToStoreActionListener());
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addButton.setBounds(255, 298, 143, 41);
		contentPane.add(addButton);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBounds(464, 298, 143, 41);
		contentPane.add(cancelButton);
		
		JLabel lblNewLabel = new JLabel("Example: author1,author2,...");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(31, 265, 254, 13);
		contentPane.add(lblNewLabel);

		
		
	}
	private class ResetAllBookAddFormActionListener  implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			
			AddBookScreen.addButton.setEnabled(true);
		}
	}
	
	private class AddNewBookToStoreActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			String tempStringID = textField.getText();
			int tempID = Integer.parseInt(tempStringID);
			
			String tempTitle = textField_1.getText();
			
			String tempCategory = textField_2.getText();
			
			String tempStringCost = textField_3.getText();
			
			float tempCost = Float.parseFloat(tempStringCost);
			String tempDirector = textField_4.getText();
			
			System.out.println("Danh sách tác giả trong ArrayList:");
			List<String> authorList = splitAuthors(tempDirector);;
			Book newBookToStore = new Book(tempID, tempTitle, tempCategory, tempCost, authorList);
			StoreManagerScreen.store.addMedia(newBookToStore);
			StoreManagerScreen.store.print();
//			System.out.format("%10s%30s%20s%10s",newBookToStore.getId(),newBookToStore.getTitle(),newBookToStore.getCategory(), newBookToStore.getCost());
//			System.out.println(newBookToStore.toString());
//			System.out.println();
			AddBookScreen.addButton.setEnabled(false);
		}
	}
	private static ArrayList<String> splitAuthors(String authorsInput) {
        ArrayList<String> authorsList = new ArrayList<>();
        
        if (authorsInput != null && !authorsInput.isEmpty()) {
            String[] authorsArray = authorsInput.split(",");
            
            for (String author : authorsArray) {
                authorsList.add(author.trim());
            }
        }
        return authorsList;
    }
}
