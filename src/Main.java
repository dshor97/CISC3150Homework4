import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);

        System.out.println("Pick an n for the n-Queen problem: ");
        int num = number.nextInt();

        nQueen(num);
    }
    public static void nQueen(int num){

    }



    public static void printBoard(int[][] board, int num){
        for(int i = 0; i<num; i++){
            for(int j = 0;j<num;j++){
                if(board[i][j] == 0) {
                    System.out.print(" O ");
                }else if(board[i][j] < 0) {
                    System.out.print(" x ");
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
        while(row1 > 0 && col1 > 0){
            --row1;
            --col1;
        }

        while(row1 < size && col1 < size){
            if(row1 != x && col1 != y) {
                a[row1++][col1++] -= 1;
            }else{
                row1++;
                col1++;
            }
        }

        int row2 = x,col2 = y;
        while(row2 > 0 && col2 < size -1){
            --row2;
            ++col2;
        }

        while(row2 < size && col2 >= 0){
            if(row2 != x && col2 != y) {
                a[row2++][col2--] -= 1;
            }else{
                row2++;
                col2--;
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp[i][j] = a[i][j];
            }
        }
        return temp;
    }
}
class Position{
    private int x;
    private int y;

    public String toString(Position position){
        String a = new String();
        a += "( " + x + "," + y + " )";
        return a;
    }
}
class Solutions{
    Position[] pos;
    int size;

    Solutions(int size){
        this.size = size;
        pos = new Position[size];
    }

    public String toString() {
        String a = new String();
        a += "Solution: \n";
        for(int i = 0; i<pos.length; i++){
            a += pos[i] + " ";
        }
        return a;
    }
}
