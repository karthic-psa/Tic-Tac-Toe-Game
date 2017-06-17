package tic;

public class Winner {
	public static boolean DecideWinner(char[][] board, int move)
	  {
		  char symbol = ' ';
		  if (move%2 != 0) {
			  symbol = 'o'; // it was computer's move
		  }
		  else {
			  symbol = 'x'; // it was user's move
		  }
		int r = board.length;
	    int c = board[0].length;
	    int i, j;
	    boolean gameOver = false;

	    for (i = 0; i < r && !gameOver; i++) {  // checking row
	      for (j = 0; j < c; j++) {
	        if (board[i][j] != symbol)
	          break;
	      }
	      if (j == c)
	        gameOver = true;
	    }

	    for (j = 0; j < c && !gameOver; j++) {  // ckecking column
	      for (i = 0; i < r; i++) {
	        if (board[i][j] != symbol)
	          break;
	      }
	      if (i == r)
	        gameOver = true;
	    }

	    if (!gameOver) {  // checking the diagonal
	      for (i = 0; i < r; i++) {
	        if (board[i][i] != symbol)
	          break;
	      }
	      if (i == r)
	        gameOver = true;
	    }

	    if (!gameOver) {  //  Second diagonal check
	      for (i = 0; i < r; i++) {
	        if (board[i][r - 1 - i] != symbol)
	          break;
	      }
	      if (i == r)
	        gameOver = true;
	    }

	    return gameOver;
	  }
	  public static void restart(char[][] board)
	  {
	    for (int i = 0; i < board.length; i++)
	      for (int j = 0; j < board[0].length; j++)
	        board[i][j] = ' ';
	  }
	

}


