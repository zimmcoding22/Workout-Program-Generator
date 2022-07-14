
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {

	static String SquatsWeakness = null;
	static String DeadsWeakness = null;
	static String BenchPressWeakness = null;
	static String clientName;
	static String clientEmail;
	static JButton b;

	
	public static void main(String[] args) throws Exception {
		inputs();
	}
	
	public static void inputs() throws Exception{
		boolean running = true;
		while (running) {
			final JPanel panel = new JPanel();
			final JTextField client = new JTextField(8);
			final JTextField email = new JTextField(30);
			
			b = new JButton("enter");
			b.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					clientName = client.getText();
					clientEmail = email.getText();
			        //System.out.println("the max deadlift: " + clientName);
				}
			});
			panel.add(new JLabel("Enter Client Name:"));
			panel.add(client);
			panel.add(new JLabel("Enter Client Email:"));
			panel.add(email);
			panel.add(b);
	        JOptionPane.showMessageDialog(null, panel, "Client Name", 1);
	        String[] choices = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
		    String input = (String) JOptionPane.showInputDialog(null, "Select Week",
		        "Choose Week", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
			ButtonGroup group1 = new ButtonGroup();
	        final JRadioButton StrengthMuscle = new JRadioButton("Strength/Muscle");
	        final JRadioButton Powerlifting = new JRadioButton("Powerlifting");
	        final JRadioButton Bodybuilding = new JRadioButton("Bodybuilding");
	        group1.add(StrengthMuscle);
	        group1.add(Powerlifting);
	        group1.add(Bodybuilding);
	        panel.add(StrengthMuscle);
	        panel.add(Powerlifting);
	        panel.add(Bodybuilding);
	       
	        //Choose Week
	        JOptionPane.showMessageDialog(null, panel, "Choose Routine Type", 3);
	        if (StrengthMuscle.isSelected()) {
	        	System.err.println("this routine hasn't been created yet");
	        } else if (Powerlifting.isSelected()) {
	        	  Powerlifting powerlift = new Powerlifting();
	        	//Weaknesses
		        final JPanel WeaknessPanel = new JPanel(new GridLayout(3,2));
		        JLabel SquatWeakness = new JLabel();
		        JLabel DeadliftWeakness = new JLabel();
		        JLabel BenchWeakness = new JLabel();
		        ButtonGroup SquatWeaknessButtons = new ButtonGroup();
		        final JRadioButton AboveHole = new JRadioButton("Above the hole");
		        final JRadioButton InHole = new JRadioButton("In the hole");
		        final JRadioButton SquatLockout = new JRadioButton("Lockout");
		        SquatWeaknessButtons.add(AboveHole);
		        SquatWeaknessButtons.add(InHole);
		        SquatWeaknessButtons.add(SquatLockout);
		        WeaknessPanel.add(AboveHole);
		        WeaknessPanel.add(InHole);
		        WeaknessPanel.add(SquatLockout);
		        WeaknessPanel.add(SquatWeakness = new JLabel("Squat"));
		        ButtonGroup DeadliftWeaknessButtons = new ButtonGroup();
		        final JRadioButton LockoutWeak = new JRadioButton("Very weak lockout");
		        final JRadioButton LockoutModerate = new JRadioButton("Moderate Lockout");
		        final JRadioButton OffFloor = new JRadioButton("Off the floor");
		        DeadliftWeaknessButtons.add(LockoutWeak);
		        DeadliftWeaknessButtons.add(LockoutModerate);
		        DeadliftWeaknessButtons.add(OffFloor);
		        WeaknessPanel.add(LockoutWeak);
		        WeaknessPanel.add(LockoutModerate);
		        WeaknessPanel.add(OffFloor);
		        WeaknessPanel.add(DeadliftWeakness = new JLabel("Deadlift"));
		        ButtonGroup BenchWeaknessButtons = new ButtonGroup();
		        final JRadioButton Chest = new JRadioButton("Chest");
		        final JRadioButton BenchLockout = new JRadioButton("Lockout");
		        final JRadioButton Middle = new JRadioButton("Middle");
		        BenchWeaknessButtons.add(Chest);
		        BenchWeaknessButtons.add(BenchLockout);
		        BenchWeaknessButtons.add(Middle);
		        WeaknessPanel.add(Chest);
		        WeaknessPanel.add(BenchLockout);
		        WeaknessPanel.add(Middle);
		        WeaknessPanel.add(BenchWeakness = new JLabel("Bench"));
		        JOptionPane.showMessageDialog(null, WeaknessPanel, "Choose Weaknesses", 3);	
		        if (InHole.isSelected()) {
		        	SquatsWeakness = "InHole";
		        } else if (AboveHole.isSelected()) {
		        	SquatsWeakness = "AboveHole";
		        } else {
		        	SquatsWeakness = "Lockout";			        
		        }
		        if (LockoutWeak.isSelected() || LockoutModerate.isSelected()) {
		        	DeadsWeakness = "LockoutWeak";
		        } else {
		        	DeadsWeakness = "OffFloor";			        
		        }
		        if (Chest.isSelected() || BenchLockout.isSelected()) {
		        	BenchPressWeakness = "Chest";
		        } else {
		        	BenchPressWeakness = "Middle";			        
		        }
		        Powerlifting powerlift2 = new Powerlifting(Integer.parseInt(input), SquatsWeakness, DeadsWeakness, BenchPressWeakness);	
		        powerlift2.CreateSheet();
		        
		        //Get Inputs
	    	    powerlift.setVisible(true);
	    	    
	    	    //Add new Client
		        JPanel panel4 = new JPanel();		      
		        final JRadioButton yes = new JRadioButton("Add Client");
		        final JRadioButton no = new JRadioButton("Quit");
				ButtonGroup group2 = new ButtonGroup();
				group2.add(yes);
		        group2.add(no);
		        panel4.add(yes);
		        panel4.add(no);
		        JavaMail mailer = new JavaMail(clientName, clientEmail);
			    mailer.sendMail("newExcel.xlsx");
		        JOptionPane.showMessageDialog(null, panel4, "Add new client", 3);
		        if (no.isSelected()) {
		        	running = false;
		        }
	        } else {
	        	System.err.println("this routine hasn't been created yet");
	          }
		}
	}
}
