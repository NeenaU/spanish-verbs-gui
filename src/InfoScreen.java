import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 * Contains code that creates an information screen telling the user how to use the program
 * @author Neena Ugail
 * @version 2.0
 */
public class InfoScreen {
	
	/**
	 * Creates a text area and adds text to it, allowing the user to understand how to use the program
	 */
	public static void createWindow(){
		
		JFrame frame = new JFrame("Information");
		frame.setSize(400, 180);
		
		JTextArea information = new JTextArea(7, 20);
		information.setEditable(false);
		information.setLineWrap(true);
		information.setText("Welcome to the Spanish Verb Conjugator\n\n"
				+ "Enter a regular spanish verb ending in ar, er, or ir. Then enter a number corresponding to a tense:\n"
				+ "1) Present\n"
				+ "2) Preterite\n"
				+ "3) Imperfect\n"
				+ "4) Conditional\n"
				+ "5) Future\n");
		
		frame.add(information);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
}
