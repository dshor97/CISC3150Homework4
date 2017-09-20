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

        board = addQueen(1,1,num,board);

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
        System.out.println();
    }
    public static int[][] addQueen(int x, int y,int size, int a [][]){
        int[][] temp = new int[size][size];
        a[x][y] = 1;
        for(int i = 0;i < size;i++){
            if(i!= y){
                a[x][i] -= 1;
            }
        }
        for(int i = 0;i < size;i++){
            if(i!= x){
                a[i][y] -= 1;
            }
        }
        int row1 = x, col1 = y;
        while(row1 > 0 || col1 > 0){
            --row1;
            --col1;
        }

        System.out.println(row1 + " " + col1);

        while(row1 < size && col1 < size){
            if(row1 != x && col1 != y) {
                a[row1++][col1++] -= 1;
            }else{
                row1++;
                col1++;
            }
        }

        //copy a into temp
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }
}
