import java.util.Scanner;
public class tictac{
    static Scanner input= new Scanner (System.in);//this should be static for access it from main function
    static int rows=3;
    static int cols=3;
    static char[][] board= new char[rows][cols];//new is required to determine the memory to be allocated.
    static char currentPlayer= 'X';
    static int movementCounter=0;//to check how many moves are made
    public static void main(String[] args){
        initializeBoard();
        while(true){//If there are cells that not empty user should make a move
            printBoard();
            System.out.println(currentPlayer+"'s turn. Where do you want the character?");//coordinates for the movement
            //movement should be in a function
            int newCoordinatx= input.nextInt();
            int newCoordinaty= input.nextInt();
            if(newCoordinatx<0 ||newCoordinatx>2 ||newCoordinaty<0 ||newCoordinaty>2){
                System.out.println("\033[H\033[2J");//clear console command
                System.out.println("This move can not be done. Coordinates should be in range 0-2");
            }
            else if(!isempty(newCoordinatx,newCoordinaty)){
                System.out.println("\033[H\033[2J");//clear console command
                System.out.println("This move can not be done. Choose an empty cell to move");
            }
            else{
            System.out.println("\033[H\033[2J");//clear console command
            board[newCoordinatx][newCoordinaty]=currentPlayer;//if this cell is empty the move can be done
            movementCounter++;
                if(winner()){
                    System.out.println("\033[H\033[2J");//clear console command
                    printBoard();
                    System.out.println("Game is over. The winner is "+ currentPlayer);
                    System.out.println(movementCounter+" moves made");
                    break;
                }
                else if (noMoveLeft()){
                    System.out.println("No more moves to play, draw!");
                    break;
                }
                else{
                currentPlayer= (currentPlayer=='X')?'O':'X';//changing players
                }
            }
        }
    }
    public static void printBoard(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();//new line
        }
    }
    public static void initializeBoard(){
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                board[i][j]= '_';
            }
        }
    }
    static boolean isempty(int a,int b){
        if (board[a][b]=='_'){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean noMoveLeft(){
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='_'){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean winner(){
        for(int i=0;i<3;i++){
            if(board[0][i]==board[1][i]&& board[1][i]==board[2][i]&&board[2][i]==currentPlayer){ //up to down check
                return true;
            }
        }
        for(int i=0;i<3;i++){
            if(board[i][0]==board[i][1]&& board[i][1]==board[i][2]&&board[i][2]==currentPlayer){ //down to up check
                return true;
            }
        }
        if(board[0][0]==board[1][1]&& board[1][1]==board[2][2]&&board[2][2]==currentPlayer){ //diagonal check
            return true;
        }
        if(board[0][2]==board[1][1]&& board[1][1]==board[2][0]&&board[2][0]==currentPlayer){ //diagonal check
            return true;
        }
        return false;
    }
}