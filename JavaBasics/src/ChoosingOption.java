import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,"Do you want to change the first class ticket?");
		JOptionPane.showMessageDialog(null,"You've chosen: " + (option == JOptionPane.YES_OPTION ?"I do":"i don't"));
		
		
		Object[] options= {"I do","I don't"};
		int n = JOptionPane.showOptionDialog(null,"Are you play guitar?","My quesion",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
		System.exit(0);
	}
}
