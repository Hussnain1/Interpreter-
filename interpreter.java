package lab2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class interpreter {
	
	static HashMap<String,Integer> hashmap;
	static int length=0;
	
	interpreter() {
		hashmap = new HashMap<String, Integer>();
		
		
	}
	public static void readFromFile(String path) {
		BufferedReader reader = null;
		try {
			  
			String line;												//This variable will help in reading lines one by one
			reader = new BufferedReader(new FileReader(path));		//Path of my file
			while ((line = reader.readLine()) != null) {
				
				
				String[] row = line.split("\n");					//Separating lines on the basis of "\n"
				 
				length = row.length;								//Taking length of each row
				for (int j=0; j < length; j++) {	
					if(row[j].contains("let")) {
			    		  if(row[j].contains("==")) {
			    			  System.out.println("Incorrect declaraton!!!\n");
			    			  break;
			    		  }
			    		  String[] letline = row[j].split(" ");
			    		  int length1 = letline.length;
			    		  for(int i=0;i<length1;i++) {
			    			  String regex = "[0-9]+";
			    			  if(letline[1].matches(regex) || letline[3].matches("[a-zA-z]+")) {
			    				  System.out.println("Incorrect declaration!!!");
			    				  System.out.println();
			    				  break;
			    				  
			    			  }
			    			  else {
			    			  int element = Integer.parseInt(letline[3]);
			    			  
			    			  hashmap.put(letline[1], element);
			    			  initialization(letline[1]);
			    			  break;
			    		  }
			    			  }
			    	  }
			    	   	
			    	
			    	
			    	  if(row[j].contains("print")) {
			    		     String[] printline = row[j].split(" ");
				    		  int length1 = printline.length;
				    		  for(int i=0;i<length1;i++) {
				    			  if(hashmap.containsKey(printline[1])) {
				    			  printfunction(printline[1]);
				    			  break;
				    			  
				    		  }
				    			  else {
				    				  System.out.println("***Variable you are trying to print is not present in file***");
				    				  break;
				    			  }
				    			  
				    		  }
				    		 
			    	}
			    	  
			    	  else if (!row[j].contains("let") && !row[j].contains("print")) {
			    		   String[] operationline = row[j].split(" ");
			    		  operationfunc(operationline[0], operationline[3], operationline[2],operationline[4]);
			    			
			    		  
			    		 
			    	  
			    	  
			    	  }
			    	 
				}
				
				
				
			 			  
			  		
			}
			
			 
					
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
	}
	
	public static void initialization(String value) {
		System.out.println("***Declaration***");
		Integer value1 = hashmap.get(value);
		System.out.println(value +"="+ value1); 
		System.out.println("Declaration Done!!!!");
		System.out.println();
	}
	
	
	public static void printfunction(String value) {
		System.out.println("***Printing***");
		Integer value1 = hashmap.get(value);
		System.out.println(value +"="+ value1); 
		System.out.println("Printing Done!!!!");
		System.out.println();
	}
	
	public static void operationfunc(String save, String operator, String value, String value1) {
		System.out.println("***Operation***");
		if (operator.equals("+")) {
		Integer element1 = hashmap.get(value1);
		if(element1==null) {
	
		int element = Integer.parseInt(value1);
		Integer value2 = hashmap.get(value);
		if(value2==null) {
			int element2 = Integer.parseInt(value);
			int sum = element2 + element;
			hashmap.put(save, sum);
			System.out.println("Expected Sum " + sum);
			System.out.println("Actual Sum " + sum);
			System.out.println("Success"); 
			
		}
		else {
		int sum = value2 + element;
		hashmap.put(save, sum);
		System.out.println("Expected Sum " + sum);
		System.out.println("Actual Sum " + sum);
		System.out.println("Success");  
		
		}
	}
		
		
		else {
				
				Integer value2 = hashmap.get(value);
				if(value2==null) {
					int element2 = Integer.parseInt(value);
					int sum = element2 + element1;
					hashmap.put(save, sum);
					System.out.println("Expected Sum " + sum);
					System.out.println("Actual Sum " + sum);
					System.out.println("Success"); 
					
				}
				else {
				int sum = value2 + element1;
				hashmap.put(save, sum);
				System.out.println("Expected Sum " + sum);
				System.out.println("Actual Sum " + sum);
				System.out.println("Success"); 
				
				}
			}
				
			
		
		}	
		
		if (operator.equals("-")) {
			Integer element1 = hashmap.get(value1);
			if(element1==null) {
			int element = Integer.parseInt(value1);
			Integer value2 = hashmap.get(value);
			if(value2==null) {
				int element2 = Integer.parseInt(value);
				int sub = element2 - element;
				hashmap.put(save, sub);
				System.out.println("Expected Answer " + sub);
				System.out.println("Actual Answer " + sub);
				System.out.println("Subtraction Success");
				
			}
			else {
			int sub = value2 - element;
			hashmap.put(save, sub);
			System.out.println("Expected Answer " + sub);
			System.out.println("Actual Answer " + sub);
			System.out.println("Subtraction Success");
			
			}
		}
			
			
			else {
					
					Integer value2 = hashmap.get(value);
					if(value2==null) {
						int element2 = Integer.parseInt(value);
						int sub = element2 - element1;
						hashmap.put(save, sub);
						System.out.println("Expected Answer " + sub);
						System.out.println("Actual Answer " + sub);
						System.out.println("Subtraction Success"); 
						
					}
					else {
					int sub = value2 - element1;
					hashmap.put(save, sub);
					System.out.println("Expected Answer " + sub);
					System.out.println("Actual Answer " + sub);
					System.out.println("Subtraction Success");
					
					}
				}
					
				
			
			}	
		
		
		if (operator.equals("*")) {
			Integer element1 = hashmap.get(value1);
			if(element1==null) {
			int element = Integer.parseInt(value1);
			Integer value2 = hashmap.get(value);
			if(value2==null) {
				int element2 = Integer.parseInt(value);
				int mul = element2 * element;
				hashmap.put(save, mul);
				System.out.println("Expected Answer " + mul);
				System.out.println("Actual Answer " + mul);
				System.out.println("Multiplication Success"); 
				
			}
			else {
			int mul = value2 * element;
			hashmap.put(save, mul);
			System.out.println("(mul) " + save + " = " + mul); 
			
			}
		}
			
			
			else {
					
					Integer value2 = hashmap.get(value);
					if(value2==null) {
						int element2 = Integer.parseInt(value);
						int mul = element2 * element1;
						hashmap.put(save, mul);
						System.out.println("Expected Answer " + mul);
						System.out.println("Actual Answer " + mul);
						System.out.println("Multiplication Success"); 
						
					}
					else {
					int mul = value2 * element1;
					hashmap.put(save, mul);
					System.out.println("Expected Answer " + mul);
					System.out.println("Actual Answer " + mul);
					System.out.println("Multiplication Success"); 
					
					}
				}
					
				
			
			}	
		
		if (operator.equals("/")) {
			Integer element1 = hashmap.get(value1);
			if(element1==null) {
			int element = Integer.parseInt(value1);
			Integer value2 = hashmap.get(value);
			if(value2==null) {
				int element2 = Integer.parseInt(value);
				int div = element2 / element;
				hashmap.put(save, div);
				System.out.println("Expected Answer " + div);
				System.out.println("Actual Answer " + div);
				System.out.println("Division Success");  
				
			}
			else {
			int div = value2 / element;
			hashmap.put(save, div);
			System.out.println("Expected Answer " + div);
			System.out.println("Actual Answer " + div);
			System.out.println("Division Success");  
			
			}
		}
			
			
			else {
					
					Integer value2 = hashmap.get(value);
					if(value2==null) {
						int element2 = Integer.parseInt(value);
						int div = element2 / element1;
						hashmap.put(save, div);
						System.out.println("Expected Answer " + div);
						System.out.println("Actual Answer " + div);
						System.out.println("Division Success");  
						
					}
					else {
					int div = value2 / element1;
					hashmap.put(save, div);
					System.out.println("Expected Answer " + div);
					System.out.println("Actual Answer " + div);
					System.out.println("Division Success");  
					
					}
				}
					
				
			
			}
	
		System.out.println("Operation Done!!!!");
		System.out.println();
	
	}
	
	
	
	

}
