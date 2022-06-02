package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.Comparator;

public class OperationToProduct {
	

    //Create an console input from keyboard for Product
    public static Product createProduct(){
        Scanner in = new Scanner(System.in); 
        System.out.println("Enter product ID: ");
        String code = in.nextLine();
        System.out.println("Enter product title: ");
        String title = in.nextLine();
        System.out.println("Enter product quantity: ");
        Integer quantity = Integer.parseInt(in.nextLine());
        System.out.println("Enter product unit price: ");
        double price = Double.parseDouble(in.nextLine());

        return new Product(code,title,quantity,price);
    }

    
   
    
   
    // Read all products from file and save to Linked List
    public static void getAllItemsFromFile(String fileName,MyList<Product> list){
    	File file = new File(fileName); 
        try {
        	
       
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line ;
            while ((line = br.readLine())  != null)  {
                String[] arr = line.split("\\|");
                int quantity = Integer.parseInt(arr[2]);
                double price = Double.parseDouble(arr[3]);
                Product temp = new Product(arr[0],arr[1],quantity,price);
         
                list.insertToLast(temp);
                
                System.out.println(temp);
            }
  
            br.close();
            fr.close();
            System.out.println("Successfully!");
      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        

    }

    
    //Get all Product from file ans save to  Stack
    public static void getAllItemsFromFile(String fileName, MyStack<Product> stack){
    	File file = new File(fileName); 
        try {
        	
       
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line ;
            while ((line = br.readLine())  != null)  {
                String[] arr = line.split("\\|");
                int quantity = Integer.parseInt(arr[2]);
                double price = Double.parseDouble(arr[3]);
                Product temp = new Product(arr[0],arr[1],quantity,price);
         
                stack.push(temp);

            }
            
            // Reverse order
            while(!stack.isEmpty()) {
            	System.out.println(stack.pop());
            }
  
            br.close();
            fr.close();
            System.out.println("Successfully!");
      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
    
    //Get all Product from file ans save to Queue
    public static void getAllItemsFromFile(String fileName, MyQueue<Product> queue){
    
    	File file = new File(fileName); 
        try {
        	
       
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line ;
            while ((line = br.readLine())  != null)  {
                String[] arr = line.split("\\|");
                int quantity = Integer.parseInt(arr[2]);
                double price = Double.parseDouble(arr[3]);
                Product temp = new Product(arr[0],arr[1],quantity,price);
         
                queue.enqueue(temp);
               
                System.out.println(temp);
            }
  
            br.close();
            fr.close();
            System.out.println("Successfully!");
      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    // Add a new product into tail of Linked List - done
    public static void addLast(MyList<Product> list){
        Product temp = createProduct();
		list.insertToLast(temp);
		System.out.println("Successful!");
        
    }

    // Display info of all product on Linked list - done
    public static void displayAll(MyList<Product> list){
    	System.out.println("ID |  Title   | Quantity | price");
		System.out.println("--------------------------------");
    	list.traverse();
       
    }

    // Write all product of Linked List to file
    public static void writeAllItemsToFile(String fileName,MyList<Product> list){
  
    	try{
         
             FileWriter fw = new FileWriter(fileName);
             for(int i = 0; i < list.length(); i++) {
            	 Product p = list.getObject(i);
            	 fw.write(p.getBcode() + "|" + p.getTitle() + "|" + Integer.toString(p.getQuantity())+ "|" + Double.toString(p.getPrice()) + "\n");
             }
             fw.close();
             System.out.println("Successfully!");
           
       
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        

    }
   

    // Search first product by ID
    public static void searchByCode(MyList<Product> list){
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Id: ");
        String bcode = sc.nextLine();
        Node temp = list.head;
        while (temp!=null)
        {
            Product temp2 = (Product) temp.info;
            if(temp2.bcode.equals(bcode)) {
            	System.out.print("Result: ");
                System.out.println(temp2);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not found!");
        return;

        
    	
     
    }

    // Delete first element by ID
    public static void deleteByCode(MyList<Product> list){
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter Product Id: ");
    	String code = sc.nextLine();
    	
    	Node temp = list.head;
    	while(temp != null) {
    		Product temp2 = (Product) temp.info;
    		if(temp2.bcode.equals(code)) {
    			list.deleteElement(temp2);
    			System.out.println(temp2);
    			System.out.println("Deleted!");
    			return;
    		}
    		temp = temp.next;
    	}
    	System.out.println("Not found!");
    	return;


    }

    // Sort by ID
    public static void sortByCode(MyList<Product> list){
      list.sortQuick(list.head, list.tail);
    }



    // Convert to binary
    public static void convertToBinary(MyList<Product> list){
    
    	 for(int i = 0; i < list.length(); i++) {
    		 Product p = list.getObject(i);
    		 if(i < 1) {
    			 System.out.println("Quantity=" +p.getQuantity() + "=>"+ list.convertToBinary(p.getQuantity()));
    			 break;
    		 }
    			 
 	
    	 }
    
    }


}
