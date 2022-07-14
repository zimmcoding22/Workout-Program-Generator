import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Powerlifting extends JFrame {
  /**
	 * class used for creation of all powerlifting routines
	 */
   private static final long serialVersionUID = 1L;
	  JPanel panel = new JPanel(new GridLayout(4,2));
	  JTextField maxDeadlift = new JTextField(5);
	  JTextField maxPullups = new JTextField(5);  
	  JTextField maxBench = new JTextField(5);
	  JTextField maxDips = new JTextField(5);
	  JTextField maxSquat = new JTextField(5);
	  JTextField maxOHP = new JTextField(5);
	  JButton b;
	  static int DeadliftMax = 0;
	  static int PullUpMax = 0;
	  static int BenchMax = 0;
	  static int DipMax = 0;
	  static int SquatMax = 0;
	  static int OHPMax = 0;
	  static int Week;
	  static String SquatsWeakness;
	  static String DeadsWeakness;
	  static String BenchPressWeakness;
	  static int REPS;
	  static String[] array = new String[4];
  

   //get powerlifting inputs
   public Powerlifting() throws Exception {
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   b = new JButton("calculate");
	   b.addActionListener(new ActionListener() {
    	   public void actionPerformed(ActionEvent e) {
		DeadliftMax = Integer.parseInt(maxDeadlift.getText());
		System.out.println("the max deadlift: " + DeadliftMax);
		PullUpMax = Integer.parseInt(maxPullups.getText());
		System.out.println("the max pullup is: " + PullUpMax);
		BenchMax = Integer.parseInt(maxBench.getText());
		System.out.println("the max bench: " + BenchMax);
		DipMax = Integer.parseInt(maxDips.getText());
		System.out.println("the max dips: " + DipMax);
		SquatMax = Integer.parseInt(maxSquat.getText());
		System.out.println("the max squat: " + SquatMax);
		OHPMax = Integer.parseInt(maxOHP.getText());
		System.out.println("the max OHP is: " + OHPMax);
	   }
    	});
	panel.add(new JLabel("Enter max deadlift:"));
	panel.add(maxDeadlift);
	panel.add(new JLabel("Enter max pullups:"));
	panel.add(maxPullups);
	panel.add(new JLabel("Enter max bench:"));
	panel.add(maxBench);
	panel.add(new JLabel("Enter max dips:"));
	panel.add(maxDips);
	panel.add(new JLabel("Enter max squat:"));
	panel.add(maxSquat);
	panel.add(new JLabel("Enter max OHP:"));
	panel.add(maxOHP);
	panel.add(b);

        JOptionPane.showMessageDialog(null, panel, "Fill in values", 2);
   
   }
   //sets given weaknesses. Both of these instructors are invoked in main
   public Powerlifting(int Week, String SquatsWeakness, String DeadsWeakness, String BenchPressWeakness) {
	   Powerlifting.Week = Week;
	   Powerlifting.SquatsWeakness = SquatsWeakness;
	   Powerlifting.DeadsWeakness = DeadsWeakness;
	   Powerlifting.BenchPressWeakness = BenchPressWeakness;	   
   }
   //data fields passed into excel sheet
   public void CreateSheet() throws Exception {
	   poiTest Spreadsheet = new poiTest(Week, SquatReps(), SquatCalculation(Week, SquatMax, SquatsWeakness)
			   , PullUps(), DeadliftReps(), DeadsWeakness, DeadliftCalculation(), BenchCalculation(), BenchPressWeakness,
			   Dips(), BenchReps(), OHPWeight(), OHPReps());
		Spreadsheet.SpreadSheet();
   }
   
	private static String SquatReps() {
		String REPS;	
		if (Week == 1 || Week == 2) {
			REPS = Double.toString(8);
			return REPS;
		} else if (Week == 3 || Week == 4 || Week == 5) {
			REPS = Double.toString(5);
			return REPS;
		} else if (Week == 6 || Week ==7 || Week == 8) {
			REPS = Double.toString(3);
			return REPS;
		} else if (Week == 9 || Week == 10 || Week == 11) {
			REPS = Double.toString(2);
			return REPS;
		} else {
		    REPS = "3-5";
		    return REPS;
		}
	}  
   private static String[] DeadliftCalculation() {
	   if (DeadsWeakness == "LockoutWeak" || DeadsWeakness == "LockoutModerate") {
		   double d = Week - 1;
		   String[] DeadliftWeight = new String[3];
		   double increment = 15;
		   double decrement = 25;
		   double decrement2 = 20;
		   double x = remainder(DeadliftMax * .5);
		   DeadliftWeight[0] = Double.toString(x + (d * increment));
		   double zero = Double.parseDouble(DeadliftWeight[0]);
		   DeadliftWeight[1] = Double.toString(zero - decrement);
		   double one = Double.parseDouble(DeadliftWeight[1]);
	       DeadliftWeight[2] = Double.toString(one - decrement2);
		   return DeadliftWeight;
	   } else {
		   String[] DeadliftWeight = new String[4];
		   double d = Week - 1;
		   double increment = 15;
		   double decrement = 35;
		   double decrement2 = 20;
		   double decrement3 = 25; 
		   double x = remainder(DeadliftMax * .5);
		   DeadliftWeight[0] = Double.toString(x + (d * increment));
		   double zero = Double.parseDouble(DeadliftWeight[0]);
		   DeadliftWeight[1] = Double.toString(zero - decrement);
		   double one = Double.parseDouble(DeadliftWeight[1]);
	       DeadliftWeight[2] = Double.toString(one - decrement2);
		   double two = Double.parseDouble(DeadliftWeight[2]);
	       DeadliftWeight[3] = Double.toString(two - decrement3);
		   return DeadliftWeight;
	   }	   
	   
   }
   private static String[] DeadliftReps() {
	   if (DeadsWeakness == "LockoutWeak" || DeadsWeakness == "LockoutModerate") {
		   String[] DeadliftRepsArray = new String[3];
		   if (Week == 1 || Week == 2) {
			   DeadliftRepsArray[0] = Double.toString(8);
			   DeadliftRepsArray[1] = Double.toString(8);
			   DeadliftRepsArray[2] = Double.toString(10);
			   return DeadliftRepsArray;
		   } else if (Week == 3 || Week == 4 || Week == 5) {
			   DeadliftRepsArray[0] = Double.toString(5);
			   DeadliftRepsArray[1] = Double.toString(5);
			   DeadliftRepsArray[2] = Double.toString(5);
			   return DeadliftRepsArray;
		   } else if (Week == 6 || Week == 7 || Week == 8) {
			   DeadliftRepsArray[0] = Double.toString(3);
			   DeadliftRepsArray[1] = Double.toString(3);
			   DeadliftRepsArray[2] = Double.toString(3);
			   return DeadliftRepsArray;
		   } else {
			   DeadliftRepsArray[0] = Double.toString(2);
			   DeadliftRepsArray[1] = Double.toString(2);
			   DeadliftRepsArray[2] = Double.toString(2);
			   return DeadliftRepsArray;
		   }
	   } else {
		   String[] DeadliftRepsArray = new String[4];
		   if (Week == 1 || Week == 2) {
			   DeadliftRepsArray[0] = Double.toString(8);
			   DeadliftRepsArray[1] = Double.toString(8);
			   DeadliftRepsArray[2] = Double.toString(8);
			   DeadliftRepsArray[3] = Double.toString(10);
			   return DeadliftRepsArray;
		   } else if (Week == 3 || Week == 4 || Week == 5) {
			   DeadliftRepsArray[0] = Double.toString(5);
			   DeadliftRepsArray[1] = Double.toString(5);
			   DeadliftRepsArray[2] = Double.toString(5);
			   DeadliftRepsArray[3] = Double.toString(8);
			   return DeadliftRepsArray;
		   } else if (Week == 6 || Week == 7 || Week == 8) {
			   DeadliftRepsArray[0] = Double.toString(3);
			   DeadliftRepsArray[1] = Double.toString(3);
			   DeadliftRepsArray[2] = Double.toString(3);
			   DeadliftRepsArray[3] = Double.toString(5);
			   return DeadliftRepsArray;
		   } else {
			   DeadliftRepsArray[0] = Double.toString(2);
			   DeadliftRepsArray[1] = Double.toString(2);
			   DeadliftRepsArray[2] = Double.toString(2);
			   DeadliftRepsArray[3] = Double.toString(5);
			   return DeadliftRepsArray;
		   }
	   }
   }
   
   private static String[] PullUps() {
	   String[] PullUpRepsSets = new String[2];
	   if (PullUpMax == 0 || PullUpMax == 1) {
		   PullUpRepsSets[0] = "3-5 5 sec neg";
	       PullUpRepsSets[1] = "2-4";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 2 || PullUpMax == 3) {
		   PullUpRepsSets[0] = "4-8";
	       PullUpRepsSets[1] = "2-4";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 4) {
		   PullUpRepsSets[0] = "4-8";
	       PullUpRepsSets[1] = "1-2";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 5) {
		   PullUpRepsSets[0] = "4-8";
	       PullUpRepsSets[1] = "1-3";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 6 || PullUpMax == 7) {
		   PullUpRepsSets[0] = "5-8";
	       PullUpRepsSets[1] = "2-4";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 8 || PullUpMax == 9) {
		   PullUpRepsSets[0] = "5-8";
	       PullUpRepsSets[1] = "3-5";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 10) {
		   PullUpRepsSets[0] = "5-8";
	       PullUpRepsSets[1] = "4-6";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 11 || PullUpMax == 12) {
		   PullUpRepsSets[0] = "4-6";
	       PullUpRepsSets[1] = "4-7";
		   return PullUpRepsSets;
	   } else if (PullUpMax == 13 || PullUpMax == 14) {
		   PullUpRepsSets[0] = "4-5";
	       PullUpRepsSets[1] = "5-8";
		   return PullUpRepsSets;
	   } else {
		   PullUpRepsSets[0] = "3-4";
	       PullUpRepsSets[1] = "10";
		   return PullUpRepsSets;
	   }
   }
  //powerlifting algorithms 
   
   private static String[] CondenseSquat(String Weakness, int SquatMax, int Week) {
	   double increment = 0;
	   double increment2 = 0;
	   switch (Week) {
	   case 3:
		   increment = 25;
		   increment2 = 30;
		   break;
	   case 4:
		   increment = 40;
		   increment2 = 45;
		   break;
	   case 5:
		   increment = 55;
		   increment2 = 60;
		   break;
	   case 6:
		   increment = 70;
		   increment2 = 75;
		   break;
	   case 7:
		   increment = 85;
		   increment2 = 90;
		   break;
	   case 8:
		   increment = 100;
		   increment2 = 105;
		   break;
	   case 9:
		   increment = 115;
		   increment2 = 120;
		   break;
	   case 10:
		   increment = 130;
		   increment2 = 135;
		   break;
	   case 11:
		   increment = 145;
		   increment2 = 150;
		   break;
	   default: 
	   }
	   double R1C5 = 0;
	   if (Weakness == "InHole") {
		   R1C5 = (remainder(SquatMax * .5)) + increment;
		   String x = Double.toString(R1C5);
		   array[0] = x;
	   } else {
		   R1C5 = (remainder(SquatMax * .5)) + increment2;
		   String x = Double.toString(R1C5);
		   array[0] = x;
	   }
	   double R2C5 = 0;
	   if (Weakness == "InHole") {
		   R2C5 = R1C5 - 20;
		   String x2 = Double.toString(R2C5);
		   array[1] = x2;
	   } else {
		   R2C5 = R1C5 - 25;
		   String x2 = Double.toString(R2C5);
		   array[1] = x2;
	   }
	   double R3C5 = 0;
	   if (Weakness == "InHole") {
		   R3C5 = R2C5 - 15;
		   String x3 = Double.toString(R3C5);
		   array[2] = x3;
	   } else if (Weakness == "AboveHole") {
		   R3C5 = R2C5 - 20;
		   String x3 = Double.toString(R3C5);
		   array[2] = x3;
	   } else {
		   R3C5 = R2C5 - 30;
		   String x3 = Double.toString(R3C5);
		   array[2] = x3;
	   }
	   double R4C5 = 0;
	   if (Weakness == "InHole") {
		   R4C5 = R3C5;
		   String x4 = Double.toString(R4C5);
		   array[3] = x4;
	   } else if (Weakness == "AboveHole") {
		   R4C5 = R3C5 + 10;
		   String x4 = Double.toString(R4C5);
		   array[3] = x4;
	   } else {
		   R4C5 = R3C5 + 20;
		   String x4 = Double.toString(R4C5);
		   array[3] = x4;
	   }
	   return array;
   }
   private static String[] SquatCalculation(int Week, int SquatMax, String Weakness) {
	   switch (Week) {
	   case 1: 
		   double R1C5 = remainder(SquatMax * .5);
		   String x = Double.toString(R1C5);
		   array[0] = x;
		   double R2C5 = 0;
		   if (Weakness == "InHole") {			  		 
			   R2C5 = R1C5 - 20;
			   String x2 = Double.toString(R2C5);
			   array[1] = x2;
		   } else {
			   R2C5 = R1C5 - 25;
			   String x2 = Double.toString(R2C5);
			   array[1] = x2; 
		   } 
		   double R3C5 = 0;
		   if ((Weakness == "InHole") || (Weakness == "AboveHole")) {
			   R3C5 = R2C5 - 20;
			   String x3 = Double.toString(R3C5);
			   array[2] = x3;
		   } else {
			   R3C5 = R2C5 - 30;
			   String x3 = Double.toString(R3C5);
			   array[2] = x3;
		   }
		   double R4C5 = 0;
		   if (Weakness == "InHole") {
			   R4C5 = R3C5;
			   String x4 = Double.toString(R4C5);
			   array[3] = x4;
		   } else if (Weakness == "AboveHole") {
			   R4C5 = R3C5 + 10;
			   String x4 = Double.toString(R4C5);
			   array[3] = x4;
		   } else {
			   R4C5 = R3C5 + 20;
			   String x4 = Double.toString(R4C5);
			   array[3] = x4;
		   }
		   return array;
	   case 2: 
		   double R1C52 = (remainder(SquatMax * .5)) + 15;
		   String x5 = Double.toString(R1C52);
		   array[0] = x5;
		   double R2C52 = 0;
		   if (Weakness == "InHole") {
			   R2C52 = R1C52 - 20;
			   String x6 = Double.toString(R2C52);
			   array[1] = x6;
		   } else {
			   R2C52 = R1C52 - 25;
			   String x6 = Double.toString(R2C52);
			   array[1] = x6;  
		   }
		   double R3C52 = 0;
		   if (Weakness == "Lockout") {
			   R3C52 = R2C52 - 30;
			   String x7 = Double.toString(R3C52);
			   array[2] = x7;
		   } else {
			   R3C52 = R2C52 - 20;
			   String x7 = Double.toString(R3C52);
			   array[2] = x7;
		   }
		   double R4C52 = 0;
		   if (Weakness == "InHole") {			   		   
			   R4C52 = R3C52;
			   String x8 = Double.toString(R4C52);
			   array[3] = x8;
		   } else if (Weakness == "AboveHole") {
			   R4C52 = R3C52 + 10;
			   String x8 = Double.toString(R4C52);
			   array[3] = x8;
		   } else {
			   R4C52 = R3C52 + 20;
			   String x8 = Double.toString(R4C52);
			   array[3] = x8;
		   }
		   return array;  		   
	   case 3: 
		   return(CondenseSquat(Weakness, SquatMax, 3));
	   case 4:
		   return(CondenseSquat(Weakness, SquatMax, 4));
	   case 5:
		   return(CondenseSquat(Weakness, SquatMax, 5));
	   case 6:
		   return(CondenseSquat(Weakness, SquatMax, 6));
	   case 7:
		   return(CondenseSquat(Weakness, SquatMax, 7));
	   case 8: 
		   return(CondenseSquat(Weakness, SquatMax, 8));
	   case 9: 
		   return(CondenseSquat(Weakness, SquatMax, 9));
	   case 10:
		   return(CondenseSquat(Weakness, SquatMax, 10));
	   case 11:
		   return(CondenseSquat(Weakness, SquatMax, 11));
	   case 12:
		   double R1C512 = (remainder(SquatMax * .5));
		   String x34 = Double.toString(R1C512);
		   array[0] = x34;
		   double R2C512 = R1C512 - 30;
		   String x35 = Double.toString(R2C512);
		   array[1] = x35;
		   double R3C512 = R2C512 - 20;
		   String x36 = Double.toString(R3C512);
		   array[2] = x36;
		   array[3] = null;
		   return array;
	   default:
		   return array;		  
	   }
   }
     
   private static String[] BenchCalculation() {
	   double d = Week - 1;
	   double decrement = 25;
	   double decrement2 = 30;
	   double decrement3 = 35;
	   double decrement4 = 40;
	   double increment;
	   double x = remainder(BenchMax * .58);
	   if (BenchPressWeakness == "Chest" || BenchPressWeakness == "BenchLockout") {	
		   String[] BenchWeight = new String[3];
		   if (Week == 1) {
			   increment = 0;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else if (Week == 2) {
			   increment = 10;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else if (Week == 3) {
			   increment = 25;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else if (Week == 11) {
			   increment = 100;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else {
			   increment = 10;
			   BenchWeight[0] = Double.toString((x+5) + (d * increment));
			   double zero = Double.parseDouble(BenchWeight[0]);
			   BenchWeight[1] = Double.toString(zero - decrement);
			   double one = Double.parseDouble(BenchWeight[1]);
			   BenchWeight[2] = Double.toString(one - decrement2);
		   }   
		   return BenchWeight;
	   } else {
		   String[] BenchWeight = new String[4];
		   if (Week == 1) {
			   increment = 0;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else if (Week == 2){
			   increment = 10;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else if (Week == 3) {
			   increment = 25;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else if (Week == 11) {
			   increment = 100;
			   CondenseBench(x, increment, decrement, decrement2, decrement3, BenchWeight);
		   } else {
			   increment = 10;
			   BenchWeight[0] = Double.toString((x+5) + (d * increment));
			   double zero = Double.parseDouble(BenchWeight[0]);
			   BenchWeight[1] = (Double.toString(zero - decrement4) + " - " + Double.toString(zero - decrement2));
			   double one = zero - decrement;
			   BenchWeight[2] = (Double.toString(one - decrement4) + " - " + Double.toString(one - decrement2));
			   double two = one - decrement;
			   BenchWeight[3] = (Double.toString(two - decrement2)); 
		   }
		   return BenchWeight;
	    }	   
   }
  
   private static String[] CondenseBench(double x, double increment, double decrement, double decrement2, double decrement3, String[] BenchWeight) {
	   if (BenchPressWeakness == "Chest" || BenchPressWeakness == "BenchLockout") {
		   BenchWeight[0] = Double.toString(x + increment);
		   double zero = Double.parseDouble(BenchWeight[0]);
		   BenchWeight[1] = Double.toString(zero - decrement);
		   double one = Double.parseDouble(BenchWeight[1]);
		   if (Week == 1 || Week == 2) {
			   BenchWeight[2] = Double.toString(one - decrement);
		   } else {
			   BenchWeight[2] = Double.toString(one - decrement2);
		   }
		   return BenchWeight;
	   } else { 
		   if (Week == 1 || Week == 2) {
			   BenchWeight[0] = Double.toString(x + increment);
			   double zero = Double.parseDouble(BenchWeight[0]);
			   BenchWeight[1] = (Double.toString(zero - decrement3) + " - " + Double.toString(zero - decrement));
			   double one = zero - decrement;
			   BenchWeight[2] = (Double.toString(one - decrement3) + " - " + Double.toString(one - decrement));
			   double two = one - decrement;
			   BenchWeight[3] = (Double.toString(two - decrement2)); 
			   return BenchWeight;
		   } else {
			   BenchWeight[0] = Double.toString(x + increment);
			   double zero = Double.parseDouble(BenchWeight[0]);
			   BenchWeight[1] = (Double.toString(zero - (decrement3 + 5)) + " - " + Double.toString(zero - (decrement + 5)));
			   double one = zero - decrement;
			   BenchWeight[2] = (Double.toString(one - (decrement3 + 5)) + " - " + Double.toString(one - (decrement + 5)));
			   double two = one - decrement;
			   BenchWeight[3] = (Double.toString(two - decrement2)); 
			   return BenchWeight;
		   }
	   }
	   
   }
   
   private static String[] Dips() {
	   String[] DipsRepsSets = new String[2];
	   if (DipMax == 0 || DipMax == 1) {
		   DipsRepsSets[0] = "1-3 5 sec neg";
	       DipsRepsSets[1] = "2-4";
		   return DipsRepsSets;
	   } else if (DipMax == 2 || DipMax == 3) {
		   DipsRepsSets[0] = "2-5";
	       DipsRepsSets[1] = "1";
		   return DipsRepsSets;
	   } else if (DipMax == 4) {
		   DipsRepsSets[0] = "2-5";
	       DipsRepsSets[1] = "1-2";
		   return DipsRepsSets;
	   } else if (DipMax == 5) {
		   DipsRepsSets[0] = "2-5";
	       DipsRepsSets[1] = "1-3";
		   return DipsRepsSets;
	   } else if (DipMax == 6 || DipMax == 7) {
		   DipsRepsSets[0] = "3-5";
	       DipsRepsSets[1] = "2-4";
		   return DipsRepsSets;
	   } else if (DipMax == 8 || DipMax == 9) {
		   DipsRepsSets[0] = "3-5";
	       DipsRepsSets[1] = "3-5";
		   return DipsRepsSets;
	   } else if (DipMax == 10) {
		   DipsRepsSets[0] = "3-5";
	       DipsRepsSets[1] = "4-6";
		   return DipsRepsSets;
	   } else if (DipMax == 11 || DipMax == 12) {
		   DipsRepsSets[0] = "2-4";
	       DipsRepsSets[1] = "4-7";
		   return DipsRepsSets;
	   } else if (DipMax == 13 || DipMax == 14) {
		   DipsRepsSets[0] = "3-5";
	       DipsRepsSets[1] = "4-8";
		   return DipsRepsSets;
	   } else {
		   DipsRepsSets[0] = "3-4";
	       DipsRepsSets[1] = "10";
		   return DipsRepsSets;
	   }
   }
   private static String[] DipReps() {
	   if (BenchPressWeakness == "Chest" || DeadsWeakness == "BenchLockout") {
		   String[] DipRepsArray = new String[3];
		   if (Week == 1 || Week == 2) {
			   DipRepsArray[0] = Double.toString(8);
			   DipRepsArray[1] = Double.toString(8);
			   DipRepsArray[2] = Double.toString(15);
			   return DipRepsArray;
		   } else if (Week == 3 || Week == 4 || Week == 5) {
			   DipRepsArray[0] = Double.toString(5);
			   DipRepsArray[1] = Double.toString(5);
			   DipRepsArray[2] = Double.toString(15);
			   return DipRepsArray;
		   } else if (Week == 6 || Week == 7) {
			   DipRepsArray[0] = Double.toString(3);
			   DipRepsArray[1] = Double.toString(5);
			   DipRepsArray[2] = Double.toString(12);
			   return DipRepsArray;
		   } else if (Week == 8) {
			   DipRepsArray[0] = Double.toString(3);
			   DipRepsArray[1] = Double.toString(3);
			   DipRepsArray[2] = Double.toString(10);
			   return DipRepsArray;
		   } else if (Week == 9 || Week == 10 || Week == 11) {
			   DipRepsArray[0] = Double.toString(2);
			   DipRepsArray[1] = Double.toString(2);
			   DipRepsArray[2] = Double.toString(8);
			   return DipRepsArray;
		   } else {
			   return DipRepsArray;
		   }
	   } else {
		   String[] DipRepsArray = new String[4];
		   if (Week == 1) {
			   DipRepsArray[0] = Double.toString(8);
			   DipRepsArray[1] = Double.toString(8);
			   DipRepsArray[2] = Double.toString(15);
			   DipRepsArray[3] = "10-12";
			   return DipRepsArray;
		   } else if (Week == 2) {
			   DipRepsArray[0] = Double.toString(8);
			   DipRepsArray[1] = Double.toString(5);
			   DipRepsArray[2] = Double.toString(15);
			   DipRepsArray[3] = "10-12";
			   return DipRepsArray;
		   } else if (Week == 3 || Week == 4 || Week == 5) {
			   DipRepsArray[0] = Double.toString(5);
			   DipRepsArray[1] = Double.toString(5);
			   DipRepsArray[2] = Double.toString(15);
			   DipRepsArray[3] = "8-10";
			   return DipRepsArray;
		   } else if (Week == 6 || Week == 7) {
			   DipRepsArray[0] = Double.toString(3);
			   DipRepsArray[1] = Double.toString(5);
			   DipRepsArray[2] = Double.toString(12);
			   DipRepsArray[3] = "6-8";
			   return DipRepsArray;
		   } else if (Week == 8) {
			   DipRepsArray[0] = Double.toString(3);
			   DipRepsArray[1] = Double.toString(3);
			   DipRepsArray[2] = Double.toString(10);
			   DipRepsArray[3] = "6-8";
			   return DipRepsArray;
		   } else if (Week == 9 || Week == 10 || Week == 11) {
			   DipRepsArray[0] = Double.toString(2);
			   DipRepsArray[1] = Double.toString(2);
			   DipRepsArray[2] = Double.toString(8);
			   DipRepsArray[3] = "4-6";
			   return DipRepsArray;
		   } else {
			   return DipRepsArray;
		   }
	   }
   }
   
   
   private static String[] BenchReps() {   
		   String[] BenchReps = new String[3];
		   if (Week == 1 || Week == 2) {
			   BenchReps[0] = "8";
			   BenchReps[1] = "8";
			   BenchReps[2] = "15";
			   return BenchReps;
		   } else if (Week == 3 || Week == 4 || Week == 5) {
			   BenchReps[0] = "5";
			   BenchReps[1] = "5";
			   BenchReps[2] = "15";
			   return BenchReps;
		   } else if (Week == 6 || Week == 7) {
			   BenchReps[0] = "3";
			   BenchReps[1] = "5";
			   BenchReps[2] = "12";
			   return BenchReps;
		   } else if (Week == 8) {
			   BenchReps[0] = "3";
			   BenchReps[1] = "3";
			   BenchReps[2] = "10";
			   return BenchReps;
		   } else if (Week == 9 || Week == 10 || Week == 11) {
			   BenchReps[0] = "2";
			   BenchReps[1] = "2";
			   BenchReps[2] = "8";
			   return BenchReps;
		   }
		   return BenchReps;
	   }
   
   private static String OHPWeight() {
	   String OHPWeight;
	   double d = Week - 1;
	   double x = remainder(OHPMax * .4);
	   OHPWeight = Double.toString(x + (5 * d));
	   return OHPWeight;
   }
   
   private static String OHPReps() {
	   String DipReps = "";
	   if (Week == 1 || Week == 2) {
		   DipReps = "10-12";
		   return DipReps;
	   } else if (Week == 3 || Week == 4 || Week == 5) {
		   DipReps = "8-10";
		   return DipReps;
	   } else if (Week == 6 || Week == 7 || Week == 8) {
		   DipReps = "6-8";
		   return DipReps;
	   } else if (Week == 9 || Week == 10 || Week == 11) {
		   DipReps = "4-6";
		   return DipReps;
	   } else {
		   return DipReps;
	   }
   }
   private static double remainder(double x) {
		double value = x;
		double result = x % 5;
		if (result == 0) {
			value = x;
		} else {
			if (result <= 2.99) {
				value = x - result;
			} else {
				value = x + (5 - result);
			}
		}
		return value;		
	} 
}
