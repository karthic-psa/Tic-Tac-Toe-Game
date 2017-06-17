package tic;

import java.util.Scanner;
public class TicTacToe {
	
	  public static Scanner ttt = new Scanner(System.in);
	  
	  public static void main(String[] args)
	  {
		 //Initializing game variables.
		int insertion = 0;
		int Attempt = 0;
	    boolean validinputs = true;
	    BoardCreation bl = new BoardCreation();
	     do {
	            Attempt++;	
	            System.out.println("Welcome to Tic-Tac-Toe \n");
	            System.out.println("Specify the deficulty level. Enter numbers 1 for Easy, 2 for Medium and 3 for hard or press 0 to exit  \n");
	            int level = ttt.nextInt();
	            if(level==0) {
  	              validinputs=false;
  	              break;
                   }
	            else if(level>0&&level<=3){
	            System.out.println(" Enter board size \n");
	            final int size = ttt.nextInt();
	            if(size>0){
	            
	             
	            char[][] dimentions = new char[size][size];
	            bl.boardlayout(dimentions);
	            Winner w = new Winner();
	           
	            
	            
	            w.restart(dimentions);
	            
	            int InsertionsLeft = (size*size);
	            InsertSymbol i = new InsertSymbol();
	                               // Insertion starts
	          if (Attempt%2 != 0) { // User inserts first in every odd game 
	                              i.UserInsertion(dimentions); 
	                              insertion=1;
	                              }
	          else {
	        	 i.ComputerInsertion(dimentions, level, insertion);
	                insertion=2;
	              }
	           bl.boardlayout(dimentions);
	           InsertionsLeft--;
	    
	           boolean endofgame = false;
	           if (size == 1) { // User always wins when size = 1
    		   System.out.println("User won the game !");
    		 //  break;
    	     }
	         while (!endofgame && InsertionsLeft > 0) {
	    	
	           endofgame = w.DecideWinner(dimentions,(insertion-1)); // Checking if a winner is found

	           if (endofgame==true) {
	    	      if ((insertion-1)%2==0) { 
	    		        System.out.println("User won the game !");
	    		        break;
	    	           }
	    	      else if ((insertion-1)%2==1) {
	    		       System.out.println("Computer won the game !");
	    		        break;
	    	           }
	               }
	        
	           else {
	                if (insertion%2 != 0) // Computer plays odd numbered move
	                      i.ComputerInsertion(dimentions, level, insertion);
	                else
	                      i.UserInsertion(dimentions);
	        
	                      bl.boardlayout(dimentions);
	                      InsertionsLeft--;
	                      insertion++;
	                  }
	                }

	         if (InsertionsLeft==0 && !endofgame && size!=1) {
	    	     System.out.println("Match drawn !");
	    	     // break;
	             }
	            }
	            
	            else
	            	{
	            	System.out.println(" Enter a valid board size \n");
	            	}
	            	}
	            else {
	            	System.out.println(" Enter a valid difficulty level  \n");
	            	
	            	
	            }
	      } 
	   while(validinputs==true);
	     }
}
