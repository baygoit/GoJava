package home.timaPeaceWorld.GoJava2.basics;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorldView {
	private Sentence run = new Sentence();
	private ArrayList<ButtonsProperties> list = new ArrayList<ButtonsProperties>();
	private ArrayList<JButton> arrayOfJButtons = new ArrayList<>();
	
	private JPanel panelForJButtons;
	private JFrame mainFrame;
	
	public HelloWorldView() {
		list.add(new ButtonsProperties("Say Hello World in English ", "Hello World and have a good day.", "en"));
		list.add(new ButtonsProperties("Say Hello World in Russian", "Привет Мир. Хорошего тебе настроения.", "ru"));
		list.add(new ButtonsProperties("Say Hello World in German", "Hallo Welt. Haben Sie eine gute Stimmung.", "de"));
		list.add(new ButtonsProperties("Say Hello World in French  ", "Bonjour Le Monde. Avoir une bonne humeur.", "fr"));
	}

	public void startProcessing() {
		createPanel();
		createButtons();
		addButtonsToPanel();
		createFrame();
	}
	
	private void createPanel() {
		panelForJButtons = new JPanel();
		panelForJButtons.setLayout(new BoxLayout(panelForJButtons, BoxLayout.Y_AXIS));
		panelForJButtons.setBackground(Color.DARK_GRAY);
	}
	
	private void createButtons() {	
		for (final ButtonsProperties b : list) {
			JButton jb = new JButton();
			jb.setText(b.getTitleOfButtons());
			jb.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					run.say(b.getSentence(), b.getLanguage());
				}
			});
			arrayOfJButtons.add(jb);
		}
	}

	private void addButtonsToPanel() {
		for (JButton jButton : arrayOfJButtons) {
			panelForJButtons.add(jButton);
		}
	}
	
	private void createFrame() {
		mainFrame = new JFrame("Speaking Hello World");
		mainFrame.setContentPane(panelForJButtons);
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}
}