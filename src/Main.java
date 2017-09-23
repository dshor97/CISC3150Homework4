import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);

        System.out.println("Pick an n for the n-Queen problem: ");
        int num = number.nextInt();

        nQueen(num);
    }
    public static void nQueen(int num) {
        Board[] solutions;
        int size = 0;
        int n = 1;
        ArrayList<Board> b = new ArrayList<Board>();
        Board board = new Board(num);
        for(int i =0;i< num;i++){
            b.add(addQueen(0,i,num,board));
        }
        size = b.size();
        solutions = new Board[size];
        solutions = b.toArray(solutions);
        b.clear();
        for(int i = 0; i<size; i++){
            System.out.println(solutions[i]);
        }
        System.out.println("Next");
        while(n < num){
            for(int i=0;i<solutions.length;i++){
                board = solutions[i];
                for(int j =0;j<num;j++){
                    if(board.board[n][j] >= 0 ){
                        b.add(addQueen(n,j,num,board));
                    }
                }
            }
            size = b.size();
            solutions = new Board[size];
            solutions = b.toArray(solutions);
            b.clear();
            n++;
            for(int i = 0; i<size; i++){
                System.out.println(solutions[i]);
            }
            System.out.println("Next");
        }
        for(int i = 0;i<solutions.length;i++){
            System.out.println(solutions[i]);
        }

    }

    public static void printBoard(int[][] board){
        for(int i = 0; i<board.length; i++){
            for(int j = 0;j<board.length;j++){
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
    public static void printBoard(Board b){
        printBoard(b.board);
    }
    public static Board addQueen(int x, int y,int size, Board board){
        int[][] temp = new int[size][size];
        board.board[x][y] = 1;
        for(int i = 0;i < size;i++){
            if(i!= y){
                board.board[x][i] -= 1;
            }
        }
        for(int i = 0;i < size;i++){
            if(i!= x){
                board.board[i][y] -= 1;
            }
        }
        int row1 = x, col1 = y;
        while(row1 > 0 && col1 > 0){
            --row1;
            --col1;
        }

        while(row1 < size && col1 < size){
            if(row1 != x && col1 != y) {
                board.board[row1++][col1++] -= 1;
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
                board.board[row2++][col2--] -= 1;
            }else{
                row2++;
                col2--;
            }
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                temp[i][j] = board.board[i][j];
            }
        }
        return new Board(temp);
    }
}

class Board {
    int[][] board;

    Board(int num) {
        board = new int[num][num];
    }

    Board(int[][] board) {
        int temp[][] = new int[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                temp[i][j] = board[i][j];
            }
        }
        this.board = temp;
    }

    public String toString() {
        String temp = new String();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    temp += "( " + i + ',' + j + " )";
                }
            }
        }
        return temp;
    }
}



