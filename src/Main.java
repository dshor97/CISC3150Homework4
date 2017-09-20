import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);

        System.out.println("Pick an n for the n-Queen problem: ");
        int num = number.nextInt();

        nQueen(num);
    }
    public static void nQueen(int num){
        int[][] board = new int[num][num];
        printBoard(board,num);
    }
    public static void printBoard(int[][] board, int num){
        for(int i = 0; i<num; i++){
            for(int j = 0;j<num;j++){
                if(board[i][j] == 0) {
                    System.out.print(" O ");
                }else if(board[i][j] < 0) {
                    System.out.print(" X ");
                }else{
                    System.out.print(" Q ");
                }
            }
            System.out.println();
        }
    }
    public static int[][] addQueen(int x, int y,int size){
        int[][] temp = new int[size][size];
        temp[x][y] += 1;
        for(int i = 0;i < size;i++){
            if(i!= y){
                temp[x][i] -= 1;
            }
        }
        for(int i = 0;i < size;i++){
            if(i!= x){
                temp[i][y] -= 1;
            }
        }
        return temp;
    }
}
