import java.util.Scanner;
public class tictac{
    static Scanner input= new Scanner (System.in);//this should be static for access it from main function
    static int rows=3;
    static int cols=3;
    static char[][] board= new char[rows][cols];//new is required to determine the memory to be allocated.
    static char currentPlayer= 'X';
    static int movementCounter=0;//to check how many moves are made
    public static void main(String[] args){
        System.out.println("\033[H\033[2J");
        initializeBoard();
        while(true){//If there are cells that not empty user should make a move
            printBoard();
            System.out.println(currentPlayer+"'s turn. Where do you want to put character?");//coordinates for the movement

            //movement should be in a function
            String move;
            do{
            move = input.nextLine();
            }while(!validMove(move));
            int nextMove = Integer.parseInt(move);

            if(!isempty(nextMove)){
                System.out.println("\033[H\033[2J");//clear console command
                System.out.println("This move can not be done. Choose an empty cell to move");
            }
            else{
            System.out.println("\033[H\033[2J");//clear console command
            makeMove(nextMove);//if the cell is empty the move can be done
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

    static boolean validMove(String str){
		try {
			int test = Integer.parseInt(str);
			if(test <= 0 || test > 9){
                System.out.println("Please enter a value between 1 and 9!");
				return false;
            }
			return true;
		}
		catch(NumberFormatException e){	
			System.out.println("Please enter a value between 1 and 9!");
			return false;
		}
	}

    public static void printBoard(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if (j==0 || j==1){
                System.out.print(board[i][j]+" | ");    
                }
                else if(j==2){
                    System.out.print(board[i][j]);
                }
            }
            System.out.println();//new line
            if(i!=2){
            System.out.println("- + - + -");
            }
            else{
                System.out.println();
            }
        }
    }
    public static void initializeBoard(){
        char num='1';
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                board[i][j]= num;
                num++;
            }
        }
    }
    static boolean isempty(int nextmove){
        /*1 00 2 01 3 02
          4 10 5 11 6 12
          7 20 8 21 8 22
        */
        int rows=(nextmove-1)/3;
        int cols=(nextmove-1)%3;
        if (board[rows][cols]!='X'&&board[rows][cols]!='O'){
            return true;
        }
        else{
            return false;
        }
    }
    static boolean noMoveLeft(){
        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]!='X'&&board[i][j]!='O'){
                    return false;
                }
            }
        }
        return true;
    }
    static void makeMove(int nextMove){
        int move=nextMove;
        switch(move){
            case 1:
            board[0][0]=currentPlayer;
            break;
            case 2:
            board[0][1]=currentPlayer;
            break;
            case 3:
            board[0][2]=currentPlayer;
            break;
            case 4:
            board[1][0]=currentPlayer;
            break;
            case 5:
            board[1][1]=currentPlayer;
            break;
            case 6:
            board[1][2]=currentPlayer;
            break;
            case 7:
            board[2][0]=currentPlayer;
            break;
            case 8:
            board[2][1]=currentPlayer;
            break;
            case 9:
            board[2][2]=currentPlayer;
            break;
            default:
            System.out.println("This move can not be done. Coordinates should be in range 1-9");
        }
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