import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);

        System.out.println("Pick an n for the n-Queen problem: ");
        int num = number.nextInt();

        nQueen(num);
    }
    public static void nQueen(int num) {
        Queue<Board> que = new LinkedList<Board>();
        ArrayList<Board> solutions = new ArrayList<Board>();
        que.add(new Board(num);
        int i = 0;
        while(i<num){
            Board b = que.remove();
            for(int j=0;j<num;j++){
                
            }
        }


    }

}
class Board{
    int[][] board;

    Board(int num){
        board = new int[num][num];
    }
    Board(int[][] board){
        int temp[][] = new int[board.length][board.length];
        for(int i =0; i<board.length; i++){
            for(int j = 0; j<board.length; j++){
                temp[i][j] = board[i][j];
            }
        }
        this.board = temp;
    }
    public void printBoard(int[][] board){
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

    public Board addQueen(int x, int y,int size, int a [][]){
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
        return new Board(temp);
    }
}

