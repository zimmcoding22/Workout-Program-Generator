import java.io.*;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;


public class poiTest {

	private int Week;
	private String SQUATREPS;
	private String[] SQUATARRAY;
	private String[] PullUpSetsReps;
	private String DeadsWeakness;
	private String[] DeadliftWeight; 
	private String[] DeadliftRepsArray;
	private String[] BenchPressWeight;
	private String BenchPressWeakness;
	private String[] DipsSetsReps;
	private String[] BenchReps;
	private String OHPWeight;
	private String OHPReps;
	
	//need constructors for other routines as well
	
	public poiTest(int Week, String SQUATREPS, String[] SQUATARRAY, String[] PullUpSetsReps
			, String[] DeadliftRepsArray, String DeadsWeakness, String[] DeadliftWeight, 
			String[] BenchPressWeight, String BenchPressWeakness, String[] DipsSetsReps,  
			String[] BenchReps, String OHPWeight, String OHPReps) {
		this.SQUATREPS = SQUATREPS;
		this.SQUATARRAY = SQUATARRAY;
		this.Week = Week;
		this.PullUpSetsReps = PullUpSetsReps;
		this.DeadsWeakness = DeadsWeakness;
		this.DeadliftWeight = DeadliftWeight;
		this.DeadliftRepsArray = DeadliftRepsArray;
		this.BenchPressWeight = BenchPressWeight;
		this.BenchPressWeakness = BenchPressWeakness;
		this.DipsSetsReps = DipsSetsReps;
		this.BenchReps = BenchReps;
		this.OHPWeight = OHPWeight;
		this.OHPReps = OHPReps;
	}
	
	@SuppressWarnings("deprecation")
	public void SpreadSheet() throws Exception {
		
		   System.out.println("poitest class " + DeadsWeakness);

		  XSSFWorkbook workbook = new XSSFWorkbook();
	      XSSFSheet spreadsheet = workbook.createSheet("cellstyle");
	      
	    //set style for first row
	      XSSFCellStyle style2 = workbook.createCellStyle();
	      style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	      style2.setFillForegroundColor(IndexedColors.BLACK.getIndex());
	      style2.setAlignment(CellStyle.ALIGN_CENTER);
          style2.setVerticalAlignment(CellStyle.ALIGN_FILL);
          style2.setBorderLeft(XSSFCellStyle.BORDER_THIN);             
          style2.setBorderRight(XSSFCellStyle.BORDER_THIN);            
          style2.setBorderTop(XSSFCellStyle.BORDER_THIN);              
          style2.setBorderBottom(XSSFCellStyle.BORDER_THIN);
	      XSSFFont font2 = workbook.createFont();
	      font2.setColor(IndexedColors.RED.getIndex());
	      font2.setBold(true);
	      style2.setFont(font2);
	      
	      //set style for second-fifth row
	      XSSFCellStyle style1 = workbook.createCellStyle();
	      style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	      style1.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	      style1.setAlignment(CellStyle.ALIGN_CENTER);
          style1.setVerticalAlignment(CellStyle.ALIGN_FILL);
          style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);             
          style1.setBorderRight(XSSFCellStyle.BORDER_THIN);            
          style1.setBorderTop(XSSFCellStyle.BORDER_THIN);              
          style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
	      XSSFFont font = workbook.createFont();
	      font.setColor(IndexedColors.BLACK.getIndex());
	      style1.setFont(font);
	      
	    //set column widths	      
	      spreadsheet.setColumnWidth(0,6000);
	      spreadsheet.setColumnWidth(1,2000);
	      spreadsheet.setColumnWidth(2,3500);
	      spreadsheet.setColumnWidth(3,2000);
	      spreadsheet.setColumnWidth(4,3500);
	      
	      //Squat
	      XSSFRow row = spreadsheet.createRow((short) 0);
	      XSSFRow row2 = spreadsheet.createRow((short) 1);
	      XSSFRow row3 = spreadsheet.createRow((short) 2);
	      XSSFRow row4 = spreadsheet.createRow((short) 3);
	      XSSFRow row5 = spreadsheet.createRow((short) 4);
	      XSSFRow row6 = spreadsheet.createRow((short) 5);

	      //Deadlift
	      XSSFRow row8 = spreadsheet.createRow((short) 7);
	      XSSFRow row9 = spreadsheet.createRow((short) 8);
	      XSSFRow row10 = spreadsheet.createRow((short) 9);
	      XSSFRow row11 = spreadsheet.createRow((short) 10);
	      XSSFRow row12 = spreadsheet.createRow((short) 11);
	      XSSFRow row13 = spreadsheet.createRow((short) 12);

	      //Bench
	      XSSFRow row15 = spreadsheet.createRow((short) 14);
	      XSSFRow row16 = spreadsheet.createRow((short) 15);
	      XSSFRow row17 = spreadsheet.createRow((short) 16);
	      XSSFRow row18 = spreadsheet.createRow((short) 17);
	      XSSFRow row19 = spreadsheet.createRow((short) 18);
	      XSSFRow row20 = spreadsheet.createRow((short) 19);

	      //XSSFRow row6 = spreadsheet.createRow((short) 5);
	      
	      //Squat Routines
	      //first row
	      XSSFCell rcell = (XSSFCell) row.createCell((short) 0);
	      XSSFCell rcell2 = (XSSFCell) row.createCell((short) 1);
	      XSSFCell rcell3 = (XSSFCell) row.createCell((short) 2);
	      XSSFCell rcell4 = (XSSFCell) row.createCell((short) 3);
	      XSSFCell rcell5 = (XSSFCell) row.createCell((short) 4);
//	      XSSFCell rcell6 = (XSSFCell) row.createCell((short) 5);
//	      XSSFCell rcell7 = (XSSFCell) row.createCell((short) 6);
//	      XSSFCell rcell8 = (XSSFCell) row.createCell((short) 7);
	      
	      //second row
	      XSSFCell r2cell = (XSSFCell) row2.createCell((short) 0);
	      XSSFCell r2cell2 = (XSSFCell) row2.createCell((short) 1);
	      XSSFCell r2cell3 = (XSSFCell) row2.createCell((short) 2);
	      XSSFCell r2cell4 = (XSSFCell) row2.createCell((short) 3);
	      XSSFCell r2cell5 = (XSSFCell) row2.createCell((short) 4);
//	      XSSFCell r2cell6 = (XSSFCell) row2.createCell((short) 5);
//	      XSSFCell r2cell7 = (XSSFCell) row2.createCell((short) 6);
//	      XSSFCell r2cell8 = (XSSFCell) row2.createCell((short) 7);

	      //third row
	      
	      XSSFCell r3cell = (XSSFCell) row3.createCell((short) 0);
	      XSSFCell r3cell2 = (XSSFCell) row3.createCell((short) 1);
	      XSSFCell r3cell3 = (XSSFCell) row3.createCell((short) 2);
	      XSSFCell r3cell4 = (XSSFCell) row3.createCell((short) 3);
	      XSSFCell r3cell5 = (XSSFCell) row3.createCell((short) 4);
//	      XSSFCell r3cell6 = (XSSFCell) row3.createCell((short) 5);
//	      XSSFCell r3cell7 = (XSSFCell) row3.createCell((short) 6);
//	      XSSFCell r3cell8 = (XSSFCell) row3.createCell((short) 7);
	      
	      //fourth row
	      XSSFCell r4cell = (XSSFCell) row4.createCell((short) 0);
	      XSSFCell r4cell2 = (XSSFCell) row4.createCell((short) 1);
	      XSSFCell r4cell3 = (XSSFCell) row4.createCell((short) 2);
	      XSSFCell r4cell4 = (XSSFCell) row4.createCell((short) 3);
	      XSSFCell r4cell5 = (XSSFCell) row4.createCell((short) 4);
//	      XSSFCell r4cell6 = (XSSFCell) row4.createCell((short) 5);
//	      XSSFCell r4cell7 = (XSSFCell) row4.createCell((short) 6);
//	      XSSFCell r4cell8 = (XSSFCell) row4.createCell((short) 7);

	      //fifth row
	      XSSFCell r5cell = (XSSFCell) row5.createCell((short) 0);
	      XSSFCell r5cell2 = (XSSFCell) row5.createCell((short) 1);
	      XSSFCell r5cell3 = (XSSFCell) row5.createCell((short) 2);
	      XSSFCell r5cell4 = (XSSFCell) row5.createCell((short) 3);
	      XSSFCell r5cell5 = (XSSFCell) row5.createCell((short) 4);
//	      XSSFCell r5cell6 = (XSSFCell) row5.createCell((short) 5);
//	      XSSFCell r5cell7 = (XSSFCell) row5.createCell((short) 6);
//	      XSSFCell r5cell8 = (XSSFCell) row5.createCell((short) 7);
//	      
	      //sixth row
//	      XSSFCell r6cell = (XSSFCell) row6.createCell((short) 0);
//	      XSSFCell r6cell2 = (XSSFCell) row6.createCell((short) 1);
//	      XSSFCell r6cell3 = (XSSFCell) row6.createCell((short) 2);
//	      XSSFCell r6cell4 = (XSSFCell) row6.createCell((short) 3);
//	      XSSFCell r6cell5 = (XSSFCell) row6.createCell((short) 4);
//	      XSSFCell r6cell6 = (XSSFCell) row6.createCell((short) 5);
//	      XSSFCell r6cell7 = (XSSFCell) row6.createCell((short) 6);
//	      XSSFCell r6cell8 = (XSSFCell) row6.createCell((short) 7);

	   	          
	      //first row
	      row.setHeight((short)400);
	      rcell.setCellStyle(style2);
	      rcell.setCellValue("Squat Excercises");
	      rcell2.setCellStyle(style2);
          rcell2.setCellValue("Week");
	      rcell3.setCellStyle(style2);
	      rcell3.setCellValue("Reps");
	      rcell4.setCellStyle(style2);
	      rcell4.setCellValue("Sets");
	      rcell5.setCellStyle(style2);
	      rcell5.setCellValue("Weight");
//	      rcell6.setCellStyle(style2);
//	      rcell6.setCellValue("Sets");
//	      rcell7.setCellStyle(style2);
//	      rcell7.setCellValue("Weight");
//	      rcell8.setCellStyle(style2);

	      //second row
	      row2.setHeight((short)600);
	      r2cell.setCellStyle(style1);
	      r2cell.setCellValue("Back Squat");
	      r2cell2.setCellStyle(style1);
          r2cell2.setCellValue(Week);
	      r2cell3.setCellStyle(style1);
	      r2cell3.setCellValue(SQUATREPS);
	      r2cell4.setCellStyle(style1);
	      r2cell4.setCellValue("3-4");
	      r2cell5.setCellStyle(style1);
	      r2cell5.setCellValue(SQUATARRAY[0]);
//	      r2cell6.setCellStyle(style1);
//	      r2cell6.setCellValue("x");
//	      r2cell7.setCellStyle(style1);
//	      r2cell7.setCellValue("x");
//	      r2cell8.setCellStyle(style1);
	      
	      //third row
	      row3.setHeight((short)600);
	      r3cell.setCellStyle(style1);
	      r3cell.setCellValue("Pause Squat");
	      r3cell2.setCellStyle(style1);
          r3cell2.setCellValue(Week);
	      r3cell3.setCellStyle(style1);
	      r3cell3.setCellValue(SQUATREPS);
	      r3cell4.setCellStyle(style1);
	      r3cell4.setCellValue("3-4");
	      r3cell5.setCellStyle(style1);
	      r3cell5.setCellValue(SQUATARRAY[1]);
//	      r3cell6.setCellStyle(style1);
//	      r3cell6.setCellValue("x");
//	      r3cell7.setCellStyle(style1);
//	      r3cell7.setCellValue("x");
//	      r3cell8.setCellStyle(style1);
	      
	      //fourth row
	      row4.setHeight((short)600);
	      r4cell.setCellStyle(style1);
	      r4cell.setCellValue("Front Squat");
	      r4cell2.setCellStyle(style1);
          r4cell2.setCellValue(Week);
	      r4cell3.setCellStyle(style1);
	      r4cell3.setCellValue(SQUATREPS);
	      r4cell4.setCellStyle(style1);
	      r4cell4.setCellValue("3-4");
	      r4cell5.setCellStyle(style1);
	      r4cell5.setCellValue(SQUATARRAY[2]);
//	      r4cell6.setCellStyle(style1);
//	      r4cell6.setCellValue("x");
//	      r4cell7.setCellStyle(style1);
//	      r4cell7.setCellValue("x");
//	      r4cell8.setCellStyle(style1);
	      
	      //fifth row
	      row5.setHeight((short)600);
	      r5cell.setCellStyle(style1);
	      r5cell.setCellValue("Stiff Legged Deadlift");
	      r5cell2.setCellStyle(style1);
          r5cell2.setCellValue(Week);
	      r5cell3.setCellStyle(style1);
	      r5cell3.setCellValue(SQUATREPS);
	      r5cell4.setCellStyle(style1);
	      r5cell4.setCellValue("3-4");
	      r5cell5.setCellStyle(style1);
	      r5cell5.setCellValue(SQUATARRAY[3]);
//	      r5cell6.setCellStyle(style1);
//	      r5cell6.setCellValue("x");
//	      r5cell7.setCellStyle(style1);
//	      r5cell7.setCellValue("x");
//	      r5cell8.setCellStyle(style1);
	      
	      //sixth row
	      row6.setHeight((short)600);
//	      r6cell.setCellStyle(style1);
//	      r6cell.setCellValue("x");
//	      r6cell2.setCellStyle(style1);
//          r6cell2.setCellValue(Week);
//	      r6cell3.setCellStyle(style1);
//	      r6cell3.setCellValue(SQUATREPS);
//	      r6cell4.setCellStyle(style1);
//	      r6cell4.setCellValue("3-4");
//	      r6cell5.setCellStyle(style1);
//	      r6cell5.setCellValue("x");
//	      r6cell6.setCellStyle(style1);
//	      r6cell6.setCellValue("x");
//	      r6cell7.setCellStyle(style1);
//	      r6cell7.setCellValue("x");
//	      r6cell8.setCellStyle(style1);

	    //Deadlift Routines
	      //first row
	      XSSFCell r8cell = (XSSFCell) row8.createCell((short) 0);
	      XSSFCell r8cell2 = (XSSFCell) row8.createCell((short) 1);
	      XSSFCell r8cell3 = (XSSFCell) row8.createCell((short) 2);
	      XSSFCell r8cell4 = (XSSFCell) row8.createCell((short) 3);
	      XSSFCell r8cell5 = (XSSFCell) row8.createCell((short) 4);
//	      XSSFCell rcell6 = (XSSFCell) row.createCell((short) 5);
//	      XSSFCell rcell7 = (XSSFCell) row.createCell((short) 6);
//	      XSSFCell rcell8 = (XSSFCell) row.createCell((short) 7);
	      
	      //second row
	      XSSFCell r9cell = (XSSFCell) row9.createCell((short) 0);
	      XSSFCell r9cell2 = (XSSFCell) row9.createCell((short) 1);
	      XSSFCell r9cell3 = (XSSFCell) row9.createCell((short) 2);
	      XSSFCell r9cell4 = (XSSFCell) row9.createCell((short) 3);
	      XSSFCell r9cell5 = (XSSFCell) row9.createCell((short) 4);
//	      XSSFCell rcell6 = (XSSFCell) row2.createCell((short) 5);
//	      XSSFCell r2cell7 = (XSSFCell) row2.createCell((short) 6);
//	      XSSFCell r2cell8 = (XSSFCell) row2.createCell((short) 7);

	      //third row
	      XSSFCell r10cell = (XSSFCell) row10.createCell((short) 0);
	      XSSFCell r10cell2 = (XSSFCell) row10.createCell((short) 1);
	      XSSFCell r10cell3 = (XSSFCell) row10.createCell((short) 2);
	      XSSFCell r10cell4 = (XSSFCell) row10.createCell((short) 3);
	      XSSFCell r10cell5 = (XSSFCell) row10.createCell((short) 4);
//	      XSSFCell r3cell6 = (XSSFCell) row3.createCell((short) 5);
//	      XSSFCell r3cell7 = (XSSFCell) row3.createCell((short) 6);
//	      XSSFCell r3cell8 = (XSSFCell) row3.createCell((short) 7);
	      
	      //fourth row
	      XSSFCell r11cell = (XSSFCell) row11.createCell((short) 0);
	      XSSFCell r11cell2 = (XSSFCell) row11.createCell((short) 1);
	      XSSFCell r11cell3 = (XSSFCell) row11.createCell((short) 2);
	      XSSFCell r11cell4 = (XSSFCell) row11.createCell((short) 3);
	      XSSFCell r11cell5 = (XSSFCell) row11.createCell((short) 4);
//	      XSSFCell r4cell6 = (XSSFCell) row4.createCell((short) 5);
//	      XSSFCell r4cell7 = (XSSFCell) row4.createCell((short) 6);
//	      XSSFCell r4cell8 = (XSSFCell) row4.createCell((short) 7);

	      //fifth row
	      XSSFCell r12cell = (XSSFCell) row12.createCell((short) 0);
	      XSSFCell r12cell2 = (XSSFCell) row12.createCell((short) 1);
	      XSSFCell r12cell3 = (XSSFCell) row12.createCell((short) 2);
	      XSSFCell r12cell4 = (XSSFCell) row12.createCell((short) 3);
	      XSSFCell r12cell5 = (XSSFCell) row12.createCell((short) 4);
//	      XSSFCell r5cell6 = (XSSFCell) row5.createCell((short) 5);
//	      XSSFCell r5cell7 = (XSSFCell) row5.createCell((short) 6);
//	      XSSFCell r5cell8 = (XSSFCell) row5.createCell((short) 7);
//	      
	      //sixth row
	      XSSFCell r13cell = (XSSFCell) row13.createCell((short) 0);
	      XSSFCell r13cell2 = (XSSFCell) row13.createCell((short) 1);
	      XSSFCell r13cell3 = (XSSFCell) row13.createCell((short) 2);
	      XSSFCell r13cell4 = (XSSFCell) row13.createCell((short) 3);
	      XSSFCell r13cell5 = (XSSFCell) row13.createCell((short) 4);
//	      XSSFCell r6ell6 = (XSSFCell) row6.createCell((short) 5);
//	      XSSFCell r6cell7 = (XSSFCell) row6.createCell((short) 6);
//	      XSSFCell r6cell8 = (XSSFCell) row6.createCell((short) 7);

	   	          
	      //first row
	      row8.setHeight((short)400);
	      r8cell.setCellStyle(style2);
	      r8cell.setCellValue("Deadlift Excercises");
	      r8cell2.setCellStyle(style2);
          r8cell2.setCellValue("Week");
	      r8cell3.setCellStyle(style2);
	      r8cell3.setCellValue("Reps");
	      r8cell4.setCellStyle(style2);
	      r8cell4.setCellValue("Sets");
	      r8cell5.setCellStyle(style2);
	      r8cell5.setCellValue("Weight");
//	      rcell6.setCellStyle(style2);
//	      rcell6.setCellValue("Sets");
//	      rcell7.setCellStyle(style2);
//	      rcell7.setCellValue("Weight");
//	      rcell8.setCellStyle(style2);

	      //second row
	      row9.setHeight((short)600);
	      r9cell.setCellStyle(style1);
	      r9cell.setCellValue("Regular Deadlift");
	      r9cell2.setCellStyle(style1);
          r9cell2.setCellValue(Week);
	      r9cell3.setCellStyle(style1);
	      r9cell3.setCellValue(DeadliftRepsArray[0]);
	      r9cell4.setCellStyle(style1);
	      r9cell4.setCellValue("3-4");
	      r9cell5.setCellStyle(style1);
	      r9cell5.setCellValue(DeadliftWeight[0]);
//	      r2cell6.setCellStyle(style1);
//	      r2cell6.setCellValue("x");
//	      r2cell7.setCellStyle(style1);
//	      r2cell7.setCellValue("x");
//	      r2cell8.setCellStyle(style1);
	      
	      //third row
	      row10.setHeight((short)600);
	      r10cell.setCellStyle(style1);
	      if (DeadsWeakness == "OffFloor") {
	    	  r10cell.setCellValue("Deficit Deadlift");
	      } else {
	    	  r10cell.setCellValue("Paused Deadlift");
	      }
	      r10cell2.setCellStyle(style1);
          r10cell2.setCellValue(Week);
	      r10cell3.setCellStyle(style1);
	      r10cell3.setCellValue(DeadliftRepsArray[1]);
	      r10cell4.setCellStyle(style1);
	      r10cell4.setCellValue("3-4");
	      r10cell5.setCellStyle(style1);
	      r10cell5.setCellValue(DeadliftWeight[1]);
//	      r9cell6.setCellStyle(style1);
//	      r9cell6.setCellValue("x");
//	      r3cell7.setCellStyle(style1);
//	      r3cell7.setCellValue("x");
//	      r3cell8.setCellStyle(style1);
	      
	      //fourth row
	      row11.setHeight((short)600);
	      r11cell.setCellStyle(style1);
	      if (DeadsWeakness == "OffFloor") {
	    	  r11cell.setCellValue("Stiff-legged Deadlift");
	      } else {
	    	  r11cell.setCellValue("Romanian Deadlift");
	      }
	      r11cell2.setCellStyle(style1);
          r11cell2.setCellValue(Week);
	      r11cell3.setCellStyle(style1);
	      r11cell3.setCellValue(DeadliftRepsArray[2]);
	      r11cell4.setCellStyle(style1);
	      r11cell4.setCellValue("3-4");
	      r11cell5.setCellStyle(style1);
	      r11cell5.setCellValue(DeadliftWeight[2]);
//	      r4cell6.setCellStyle(style1);
//	      r4cell6.setCellValue("x");
//	      r4cell7.setCellStyle(style1);
//	      r4cell7.setCellValue("x");
//	      r4cell8.setCellStyle(style1);
	      
	      //fifth row
	      if (DeadsWeakness == "LockoutWeak" || DeadsWeakness == "LockoutModerate" ) {
		      row12.setHeight((short)600);
		      r12cell.setCellStyle(style1);
		      r12cell.setCellValue("Pull Ups");
		      r12cell2.setCellStyle(style1);
	          r12cell2.setCellValue(Week);
		      r12cell3.setCellStyle(style1);
		      r12cell3.setCellValue(PullUpSetsReps[1]);
		      r12cell4.setCellStyle(style1);
		      r12cell4.setCellValue(PullUpSetsReps[0]);
		      r12cell5.setCellStyle(style1);
		      r12cell5.setCellValue("bodyweight");
	//	      r5cell6.setCellStyle(style1);
	//	      r5cell6.setCellValue("x");
	//	      r5cell7.setCellStyle(style1);
	//	      r5cell7.setCellValue("x");
	//	      r5cell8.setCellStyle(style1);
	      } else {
	    	  row12.setHeight((short)600);
		      r12cell.setCellStyle(style1);
		      r12cell.setCellValue("Pendlay Row");
		      r12cell2.setCellStyle(style1);
	          r12cell2.setCellValue(Week);
		      r12cell3.setCellStyle(style1);
		      r12cell3.setCellValue(DeadliftRepsArray[3]);
		      r12cell4.setCellStyle(style1);
		      r12cell4.setCellValue("3-4");
		      r12cell5.setCellStyle(style1);
		      r12cell5.setCellValue(DeadliftWeight[3]);
	//	      r5cell6.setCellStyle(style1);
	//	      r5cell6.setCellValue("x");
	//	      r5cell7.setCellStyle(style1);
	//	      r5cell7.setCellValue("x");
	//	      r5cell8.setCellStyle(style1);
		      
		    //sixth row
		      row13.setHeight((short)600);
		      r13cell.setCellStyle(style1);
		      r13cell.setCellValue("Pull Ups");
		      r13cell2.setCellStyle(style1);
	          r13cell2.setCellValue(Week);
		      r13cell3.setCellStyle(style1);
		      r13cell3.setCellValue(PullUpSetsReps[1]);
		      r13cell4.setCellStyle(style1);
		      r13cell4.setCellValue(PullUpSetsReps[0]);
		      r13cell5.setCellStyle(style1);
		      r13cell5.setCellValue("bodyweight");
//		      r6cell6.setCellStyle(style1);
//		      r6cell6.setCellValue("x");
//		      r6cell7.setCellStyle(style1);
//		      r6cell7.setCellValue("x");
//		      r6cell8.setCellStyle(style1);		      
	      }
	      
	      
	    //Bench Routines
	      //first row
	      XSSFCell r15cell = (XSSFCell) row15.createCell((short) 0);
	      XSSFCell r15cell2 = (XSSFCell) row15.createCell((short) 1);
	      XSSFCell r15cell3 = (XSSFCell) row15.createCell((short) 2);
	      XSSFCell r15cell4 = (XSSFCell) row15.createCell((short) 3);
	      XSSFCell r15cell5 = (XSSFCell) row15.createCell((short) 4);
//	      XSSFCell rcell6 = (XSSFCell) row.createCell((short) 5);
//	      XSSFCell rcell7 = (XSSFCell) row.createCell((short) 6);
//	      XSSFCell rcell8 = (XSSFCell) row.createCell((short) 7);
	      
	      //second row
	      XSSFCell r16cell = (XSSFCell) row16.createCell((short) 0);
	      XSSFCell r16cell2 = (XSSFCell) row16.createCell((short) 1);
	      XSSFCell r16cell3 = (XSSFCell) row16.createCell((short) 2);
	      XSSFCell r16cell4 = (XSSFCell) row16.createCell((short) 3);
	      XSSFCell r16cell5 = (XSSFCell) row16.createCell((short) 4);
//	      XSSFCell r2ell6 = (XSSFCell) row2.createCell((short) 5);
//	      XSSFCell r2cell7 = (XSSFCell) row2.createCell((short) 6);
//	      XSSFCell r2cell8 = (XSSFCell) row2.createCell((short) 7);

	      //third row
	      XSSFCell r17cell = (XSSFCell) row17.createCell((short) 0);
	      XSSFCell r17cell2 = (XSSFCell) row17.createCell((short) 1);
	      XSSFCell r17cell3 = (XSSFCell) row17.createCell((short) 2);
	      XSSFCell r17cell4 = (XSSFCell) row17.createCell((short) 3);
	      XSSFCell r17cell5 = (XSSFCell) row17.createCell((short) 4);
//	      XSSFCell r153cell6 = (XSSFCell) row3.createCell((short) 5);
//	      XSSFCell r3cell7 = (XSSFCell) row3.createCell((short) 6);
//	      XSSFCell r3cell8 = (XSSFCell) row3.createCell((short) 7);
	      
	      //fourth row
	      XSSFCell r18cell = (XSSFCell) row18.createCell((short) 0);
	      XSSFCell r18cell2 = (XSSFCell) row18.createCell((short) 1);
	      XSSFCell r18cell3 = (XSSFCell) row18.createCell((short) 2);
	      XSSFCell r18cell4 = (XSSFCell) row18.createCell((short) 3);
	      XSSFCell r18cell5 = (XSSFCell) row18.createCell((short) 4);
//	      XSSFCell r4cell6 = (XSSFCell) row4.createCell((short) 5);
//	      XSSFCell r4cell7 = (XSSFCell) row4.createCell((short) 6);
//	      XSSFCell r4cell8 = (XSSFCell) row4.createCell((short) 7);

	      //fourth row
	      XSSFCell r19cell = (XSSFCell) row19.createCell((short) 0);
	      XSSFCell r19cell2 = (XSSFCell) row19.createCell((short) 1);
	      XSSFCell r19cell3 = (XSSFCell) row19.createCell((short) 2);
	      XSSFCell r19cell4 = (XSSFCell) row19.createCell((short) 3);
	      XSSFCell r19cell5 = (XSSFCell) row19.createCell((short) 4);
//	      XSSFCell r5cell6 = (XSSFCell) row5.createCell((short) 5);
//	      XSSFCell r5cell7 = (XSSFCell) row5.createCell((short) 6);
//	      XSSFCell r5cell8 = (XSSFCell) row5.createCell((short) 7);
//	      
	      //sixth row
	      XSSFCell r20cell = (XSSFCell) row20.createCell((short) 0);
	      XSSFCell r20cell2 = (XSSFCell) row20.createCell((short) 1);
	      XSSFCell r20cell3 = (XSSFCell) row20.createCell((short) 2);
	      XSSFCell r20cell4 = (XSSFCell) row20.createCell((short) 3);
	      XSSFCell r20cell5 = (XSSFCell) row20.createCell((short) 4);
//	      XSSFCell r6cell6 = (XSSFCell) row6.createCell((short) 5);
//	      XSSFCell r6cell7 = (XSSFCell) row6.createCell((short) 6);
//	      XSSFCell r6cell8 = (XSSFCell) row6.createCell((short) 7);

	   	          
	      //first row
	      row15.setHeight((short)400);
	      r15cell.setCellStyle(style2);
	      r15cell.setCellValue("Bench Excercises");
	      r15cell2.setCellStyle(style2);
          r15cell2.setCellValue("Week");
	      r15cell3.setCellStyle(style2);
	      r15cell3.setCellValue("Reps");
	      r15cell4.setCellStyle(style2);
	      r15cell4.setCellValue("Sets");
	      r15cell5.setCellStyle(style2);
	      r15cell5.setCellValue("Weight");
//	      rcell6.setCellStyle(style2);
//	      rcell6.setCellValue("Sets");
//	      rcell7.setCellStyle(style2);
//	      rcell7.setCellValue("Weight");
//	      rcell8.setCellStyle(style2);

	      //second row
	      row16.setHeight((short)600);
	      r16cell.setCellStyle(style1);
	      r16cell.setCellValue("Regular Bench");
	      r16cell2.setCellStyle(style1);
          r16cell2.setCellValue(Week);
	      r16cell3.setCellStyle(style1);
	      r16cell3.setCellValue(BenchReps[0]);
	      r16cell4.setCellStyle(style1);
	      r16cell4.setCellValue("2-3");
	      r16cell5.setCellStyle(style1);
	      r16cell5.setCellValue(BenchPressWeight[0]);
//	      r2cell6.setCellStyle(style1);
//	      r2cell6.setCellValue("x");
//	      r2cell7.setCellStyle(style1);
//	      r2cell7.setCellValue("x");
//	      r2cell8.setCellStyle(style1);
	      
	      //third row
	      row17.setHeight((short)600);
	      r17cell.setCellStyle(style1);
	      r17cell.setCellValue("Close Grip Bench");
	      r17cell2.setCellStyle(style1);
          r17cell2.setCellValue(Week);
	      r17cell3.setCellStyle(style1);
	      r17cell3.setCellValue(BenchReps[1]);
	      r17cell4.setCellStyle(style1);
	      r17cell4.setCellValue("2-3");
	      r17cell5.setCellStyle(style1);
	      r17cell5.setCellValue(BenchPressWeight[1]);
//	      r3cell6.setCellStyle(style1);
//	      r3cell6.setCellValue("x");
//	      r3cell7.setCellStyle(style1);
//	      r3cell7.setCellValue("x");
//	      r3cell8.setCellStyle(style1);
	      
	      //fourth row
	      row18.setHeight((short)600);
	      r18cell.setCellStyle(style1);
	      r18cell.setCellValue("Touch and Go Bench");
	      r18cell2.setCellStyle(style1);
          r18cell2.setCellValue(Week);
	      r18cell3.setCellStyle(style1);
	      r18cell3.setCellValue(BenchReps[2]);
	      r18cell4.setCellStyle(style1);
	      r18cell4.setCellValue("2-3");
	      r18cell5.setCellStyle(style1);
	      r18cell5.setCellValue(BenchPressWeight[2]);
//	      r4cell6.setCellStyle(style1);
//	      r4cell6.setCellValue("x");
//	      r4cell7.setCellStyle(style1);
//	      r4cell7.setCellValue("x");
//	      r4cell8.setCellStyle(style1);
	      
	      //fifth row
	      
	      if (BenchPressWeakness == "Chest" || BenchPressWeakness == "BenchLockout") {
		      row19.setHeight((short)600);
		      r19cell.setCellStyle(style1);
		      r19cell.setCellValue("Dips");
		      r19cell2.setCellStyle(style1);
	          r19cell2.setCellValue(Week);
		      r19cell3.setCellStyle(style1);
		      r19cell3.setCellValue(DipsSetsReps[1]);
		      r19cell4.setCellStyle(style1);
		      r19cell4.setCellValue(DipsSetsReps[0]);
		      r19cell5.setCellStyle(style1);
		      r19cell5.setCellValue("bodyweight");
	//	      r5cell6.setCellStyle(style1);
	//	      r5cell6.setCellValue("x");
	//	      r5cell7.setCellStyle(style1);
	//	      r5cell7.setCellValue("x");
	//	      r5cell8.setCellStyle(style1);
	      } else {
	    	  
	    	  row19.setHeight((short)600);
		      r19cell.setCellStyle(style1);
		      r19cell.setCellValue("Standing OHP");
		      r19cell2.setCellStyle(style1);
	          r19cell2.setCellValue(Week);
		      r19cell3.setCellStyle(style1);
		      r19cell3.setCellValue(OHPReps);
		      r19cell4.setCellStyle(style1);
		      r19cell4.setCellValue("2-4");
		      r19cell5.setCellStyle(style1);
		      r19cell5.setCellValue(OHPWeight);
	//	      r5cell6.setCellStyle(style1);
	//	      r5cell6.setCellValue("x");
	//	      r5cell7.setCellStyle(style1);
	//	      r5cell7.setCellValue("x");
	//	      r5cell8.setCellStyle(style1);
	    	 
		      //sixth row
		      row20.setHeight((short)600);
		      r20cell.setCellStyle(style1);
		      r20cell.setCellValue("Dips");
		      r20cell2.setCellStyle(style1);
	          r20cell2.setCellValue(Week);
		      r20cell3.setCellStyle(style1);
		      r20cell3.setCellValue(DipsSetsReps[1]);
		      r20cell4.setCellStyle(style1);
		      r20cell4.setCellValue(DipsSetsReps[0]);
		      r20cell5.setCellStyle(style1);
		      r20cell5.setCellValue("bodyweight");
	//	      r6cell6.setCellStyle(style1);
	//	      r6cell6.setCellValue("x");
	//	      r6cell7.setCellStyle(style1);
	//	      r6cell7.setCellValue("x");
	//	      r6cell8.setCellStyle(style1);
		      
	        }

	      String file = "newExcel.xlsx";
	      workbook.write(new FileOutputStream(file));
//	      JavaMail mailer = new JavaMail();
//	      mailer.sendMail(file);
		  workbook.close();	
		  System.out.println("running");
		
	}
}
