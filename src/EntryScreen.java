import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Contains code that allows the user to enter a verb and tense. Also displays information on how to use the program.
 * @author Neena Ugail
 * @version 2.0
 */
public class EntryScreen {
	
	static boolean validVerb;
	static boolean validTense;
	static boolean inputsValidated;
	static String verb;
	static String tense;
	
	/**
	 * Constructor used to set field values
	 */
	public EntryScreen() {
		validVerb = false;
		validTense = false;
		inputsValidated = false;
	}

	/**
	 * Creates all components used to enter a verb and tense
	 * Displays a button allowing the user to read information about how to use the program
	 */
	public static void createWindow() {
		
		JFrame frame = new JFrame("Verb Conjugator");
		frame.setSize(300, 300);
		
		JPanel panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel verbLabel = new JLabel("Verb");
		JTextField verbText = new JTextField(verb, 10);
		verbText.setText("");
		
		JLabel tenseLabel = new JLabel("Tense");
		JTextField tenseText = new JTextField(tense, 10);
		verbText.setText("");
		
		JButton confirmButton = new JButton("Confirm");
		JButton infoButton = new JButton("Information");
		
		JLabel warningVerb = new JLabel("You have entered an incorrect verb");
		warningVerb.setVisible(false);
		
		JLabel warningTense = new JLabel("You have entered an incorrect tense");
		warningTense.setVisible(false);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 20, 2, 40);
		panel.add(verbLabel, gbc);
		
		gbc.gridx = 1;
		panel.add(verbText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(tenseLabel, gbc);
		
		gbc.gridx = 1;
		panel.add(tenseText, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 1, 20);
		panel.add(confirmButton, gbc);
		
		gbc.gridy = 3;
		panel.add(infoButton, gbc);
		
		gbc.insets = new Insets(10, 30, 1, 20);
		gbc.gridy = 4;
		panel.add(warningVerb, gbc);
		
		gbc.gridy = 5;
		panel.add(warningTense, gbc);
		
		frame.getContentPane().add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		//The user has chosen their verb and tense - validate inputs
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				warningVerb.setVisible(false);
				warningTense.setVisible(false);
				
				verb = verbText.getText();
				tense = tenseText.getText();
				
				if (SpanishVerbs.validateVerb(verb)) {
					validVerb = true;
				}
				else {
					warningVerb.setVisible(true);
				}
				
				if (SpanishVerbs.validateTense(tense)) {
					validTense = true;	
				}
				else {
					warningTense.setVisible(true);
				}
				
			}
			
		});
		
		//When the infoButton is pressed, a new window will open with information
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoScreen.createWindow();
			}
			
		});
		
		//Open a new window to show conjugations
		while (inputsValidated == false) {
			System.out.print(" ");
			if (validVerb && validTense) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				inputsValidated = true;
				
				MainScreen.createWindow(verb, tense);
			}
		}
		
	}
	
	public static void main(String[] args) {
		createWindow();
	}
}
