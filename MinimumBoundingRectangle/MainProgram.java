package MinimumBoundingRectangle;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;


public class MainProgram {

	public static void main(String[] args) {
		//http://www.spoj.com/problems/HS12MBR/
		ArrayList<Circle> circles = new ArrayList<Circle>(); 
		ArrayList<Point> points = new ArrayList<Point>(); 
		ArrayList<Line> lines = new ArrayList<Line>(); 
		Scanner scan = new Scanner(System.in);
		int testCases = 0;
		int shapeCount = 0;		
		String currentInput;
		String[] parts;
		int x  = 0;
		int x2 = 0;
		int y = 0;
		int y2 = 0;
		int r = 0; 
		
		testCases = scan.nextInt();
		
		for(int i = 0; i < testCases; i++){		
			shapeCount = scan.nextInt();	
			scan.nextLine();
			for(int count = 0; count < shapeCount; count++){
				currentInput = scan.nextLine();					
				parts = currentInput.split(" ");
								
				switch(parts[0]){
				case "c" : 
					x = Integer.parseInt(parts[1]);
					y = Integer.parseInt(parts[2]);
					r = Integer.parseInt(parts[3]);
					Circle currentCircle = new Circle(x, y, r);
					circles.add(currentCircle);
					break;
				case "l" :
					x = Integer.parseInt(parts[1]);
					y = Integer.parseInt(parts[2]);
					x2 = Integer.parseInt(parts[3]);
					y2 = Integer.parseInt(parts[4]);
					Line currentline = new Line(x, y, x2, y2);
					lines.add(currentline);					
					break;
				case "p" :
					x = Integer.parseInt(parts[1]);
					y = Integer.parseInt(parts[2]);
					Point currentPoint = new Point(x, y);
					points.add(currentPoint);
					break; 						
				}
				
			};			
		};						
		
		if(!points.isEmpty()){
			pastePoint(points);
		};
		if(!circles.isEmpty()){
			pasteCircle(circles);
		};
		if(!lines.isEmpty()){
			pasteLane(lines);
		};								
	}
	
	public static void pasteCircle(ArrayList<Circle> circles){
		int maxX1 =  1000;
		int maxX2 =  -1000;
		int maxY1 =  1000;
		int maxY2 = -1000;
		for(int c = 0; c < circles.size(); c++){
			
			int currentMaxX1 = circles.get(c).getX() - circles.get(c).getR();			
			int currentMaxY1 = circles.get(c).getY() - circles.get(c).getR();
			int currentMaxX2 = circles.get(c).getX() + circles.get(c).getR() ;			
			int currentMaxY2 = circles.get(c).getY() + circles.get(c).getR();
			
			if(currentMaxX1 < maxX1 ){
				maxX1 = currentMaxX1;					
			};			
			if(currentMaxY1 < maxY1 ){
				maxY1 = currentMaxY1;					
			}
			if(currentMaxX2 > maxX2 ){
				maxX2 = currentMaxX2;					
			};			
			if(currentMaxY2 > maxY2 ){
				maxY2 = currentMaxY2;					
			}			
			
		};
		System.out.println(maxX1 + " " + maxY1 + " " + " " + maxX2 + " " +  maxY2);
	};
	
	public static void pastePoint(ArrayList<Point> points){
		int maxX1 = 0;
		int maxX2 = 0;
		int maxY1 = 0;
		int maxY2 = 0;
		
		for(int p = 0; p < points.size(); p++){
			int currentX1 = points.get(p).getX();
			int currentY1 = points.get(p).getY();
			if (currentX1 != maxX1){
				maxX1 = currentX1;
				maxX2 = maxX1;
			}
			if(currentY1 != maxY1){
				maxY1 = currentY1;
				maxY2 = maxY1;
			};
		};
		System.out.println(maxX1 + " " + maxY1 + " " + " " + maxX2 + " " +  maxY2);
	};
	
	public static void pasteLane(ArrayList<Line> lines){
		int maxX1 = 1000;
		int maxX2 = -1000;
		int maxY1 = 1000;
		int maxY2 = -1000;
		
		for(int p = 0; p < lines.size(); p++){
			int currentX1 = lines.get(p).getX();
			int currentY1 = lines.get(p).getY();
			int currentX2 = lines.get(p).getX2();
			int currentY2 = lines.get(p).getY2();
			
			if (currentX1 < maxX1){
				maxX1 = currentX1;				
			}
			if(currentY1 < maxY1){
				maxY1 = currentY1;			
			};
			if (currentX2 > maxX2){
				maxX2 = currentX2;				
			}
			if(currentY2 > maxY2){
				maxY2 = currentY2;				
			};
		};
		System.out.println(maxX1 + " " + maxY1 + " " + " " + maxX2 + " " +  maxY2);		
	};

}
