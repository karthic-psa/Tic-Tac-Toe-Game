package tic;

public class BoardCreation {


public static void boardlayout(char[][] board)
{
  int row = board.length;
  int col = board[0].length;

  System.out.print("    ");
  for (int i = 0; i < col; i++)
    System.out.print(i + "   ");
  System.out.println();

  for (int i = 0; i < row; i++) {
    System.out.print(i + "  ");
    for (int j = 0; j < col; j++) {
      if (j != 0)
        System.out.print("|");
      System.out.print(" " + board[i][j] + " ");
    }

    System.out.println();

    if (i != (row - 1)) {
      System.out.print("   ");
      for (int j = 0; j < col; j++) {
        System.out.print("---");
      }
      System.out.println();
    }
  }
  System.out.println();
}
}