import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);

        int num = number.nextInt();

        nQueen(num);
    }
    public static void nQueen(int num){

    }
}
class Board{
    private int [][] board;
    public Board(int n){
        board = new int[n][n];
    }
}
