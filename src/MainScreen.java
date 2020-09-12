import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * Contains code to display conjugations for the user's chosen verb and tense
 * @author Neena Ugail
 * @version 2.0
 */
public class MainScreen {
	
	/**
	 * Displays the conjugations that the user has requested
	 * Displays a button giving the option to conjugate again
	 * @param verb: The verb that the user wants to conjugate
	 * @param tense: The user's chosen tense
	 */
	public static void createWindow(String verb, String tense) {
		
		JFrame frame = new JFrame("Verb Conjugator");
		frame.setSize(400, 350);
		
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		JTextArea conjugationText = new JTextArea(5, 20);
		
		String[] conjugations = new String[6];
		conjugations = SpanishVerbs.conjugate(verb, tense);
		String main = verb.substring(0, verb.length()-2);
		
		//Append each ending to the main part of the verb
		
		conjugationText.append("Yo: "+main+conjugations[0]+"\n");
		conjugationText.append("T\u00FA: "+main+conjugations[1]+"\n");
		conjugationText.append("\u00C9l/Ella/Usted: "+main+conjugations[2]+"\n");
		conjugationText.append("Nosotros: "+main+conjugations[3]+"\n");
		conjugationText.append("Vosotros: "+main+conjugations[4]+"\n");
		conjugationText.append("Ellos/Ellas/Ustedes: "+main+conjugations[5]);
		
		
		//When the againButton is pressed, the user will be taken back to the entry screen to conjugate again
		
		JButton againButton = new JButton("Conjugate Again");
		
		againButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				EntryScreen.createWindow();
			}
			
		});
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 20, 2, 40);
		panel.add(conjugationText, gbc);
		
		gbc.gridy = 1;
		panel.add(againButton, gbc);
		
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
