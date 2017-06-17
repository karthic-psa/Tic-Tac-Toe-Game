package tic;

import java.util.Scanner;

public class InsertSymbol {
	  public static Scanner ttt = new Scanner(System.in);
	 public static void UserInsertion(char[][] board)
	  {
	    System.out.println("Enter the row and column index numbers ");
	    int r = ttt.nextInt();
	    int c = ttt.nextInt();

	    while (board[r][c] != ' ') {
	      System.out.println("This cell is occupied. Enter another row and column index numbers ");
	      r = ttt.nextInt();
	      c = ttt.nextInt();
	    }
	    board[r][c] = 'x';
	  }

	  public static void ComputerInsertion(char[][] board, int level, int move)
	  {
		  int rIndex = 0;
			int cIndex = 0;
			int totalElements = 0;
		if (level == 1) { // random move`			
			do {
			totalElements = board.length*board[0].length;
			int index = (int)(Math.random()*totalElements);
			rIndex = (int)index/board.length;
	        cIndex = index%board.length;
			} while(board[rIndex][cIndex]!=' ');
			board[rIndex][cIndex] = 'o';
		}
		
		else if (level == 2) {
			boolean winTemp = false;
			char[][] boardTemp = new char[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
			      for (int j = 0; j < board[0].length; j++) {
			          boardTemp[i][j] = board[i][j];
			      }
			    }
			for (int i = 0; i < boardTemp.length; i++) { // checking if computer can win in the next move
			      for (int j = 0; j < boardTemp[0].length; j++) {
			    	  if (boardTemp[i][j] == ' ') {
			          boardTemp[i][j] = 'o';
			          for (int k=i; k < boardTemp.length; k++) {
			        	  for (int l =j+1; l<boardTemp[0].length; l++ ) {
			        		  boardTemp[k][l] = 'o';
			        		  Winner win1 = new Winner();
			        		  winTemp = win1.DecideWinner(boardTemp, move);
					          if (winTemp == true) {
					        	  board[i][j] = 'o';
					        	  return;
					          }
					          else 
					        	  break;
					          
			        	  }
			          } 
			        }
			      }
			    }
			if (winTemp == false) { // random move if computer cannot win in the next move
				do {
					totalElements = board.length*board[0].length;
					int index = (int)(Math.random()*totalElements);
					rIndex = (int)index/board.length;
			        cIndex = index%board.length;
					} while(board[rIndex][cIndex]!=' ');
					board[rIndex][cIndex] = 'o';
			}
		   
	   }
		
		else if (level == 3) {
			boolean winTemp = false;
			char[][] boardTemp = new char[board.length][board[0].length];
			for (int i = 0; i < board.length; i++) {
			      for (int j = 0; j < board[0].length; j++) {
			          boardTemp[i][j] = board[i][j];
			      }
			    }
			for (int i = 0; i < boardTemp.length; i++) { 
			      for (int j = 0; j < boardTemp[0].length; j++) {
			    	  if (boardTemp[i][j] == ' ') {
			          boardTemp[i][j] = 'o';
			          Winner win2 = new Winner();
			          winTemp = win2.DecideWinner(boardTemp, move);
			          if (winTemp == true) {
			        	  board[i][j] = 'o';
			        	  return;
			          }
			          else {
			        	  continue;
			          }
			        }
			      }
			    }
		}
	  }
}
