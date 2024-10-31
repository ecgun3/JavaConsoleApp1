import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;


public class Main{

    public static void main(String[] args){     //Starting Screen

		clearConsole();
		System.out.println("""
    ____  __  ____  __  _  _    ____  ____  __ _  ___  ____
			(  __)/ _\\(_  _)(  )/ )( \\  (_  _)(  __)(  / )/ __)(  __)                                              
			 ) _)/    \\ )(   )( ) __ (    )(   ) _)  )  (( (__  ) _)                                               
			(__) \\_/\\_/(__) (__)\\_)(_/   (__) (____)(__\\_)\\___)(____)                                              
			 _  _  __    ___  __  ____    __ _   __   ____  _  _   __   __ _    __ _  __  __ _  ___  _  _  __      
			( \\/ )/ _\\  / __)(  )(__  )  (  / ) / _\\ (  _ \\/ )( \\ / _\\ (  ( \\  (  / )/  \\(  / )/ __)/ )( \\(  )     
			 )  //    \\( (_ \\ )(  / _/    )  ( /    \\ )   /) __ (/    \\/    /   )  ((  O ))  (( (_ \\) \\/ (/ (_/\\   
			(__/ \\_/\\_/ \\___/(__)(____)  (__\\_)\\_/\\_/(__\\_)\\_)(_/\\_/\\_/\\_)__)  (__\\_)\\__/(__\\_)\\___/\\____/\\____/   
			  __   _  _  ____  ____    __  ____  ____  _  _    _  _  _  _  ____   __   _  _  ____  ____  ____  __  
			 / _\\ ( \\/ )/ ___)(  __)  (  )(  _ \\(  __)( \\/ )  / )( \\/ )( \\(    \\ / _\\ / )( \\(  __)(  _ \\(    \\(  ) 
			/    \\ )  / \\___ \\ ) _)    )(  )   / ) _) / \\/ \\  ) __ () \\/ ( ) D (/    \\\\ \\/ / ) _)  )   / ) D ( )(  
			\\_/\\_/(__/  (____/(____)  (__)(__\\_)(____)\\_)(_/  \\_)(_/\\____/(____/\\_/\\_/ \\__/ (____)(__\\_)(____/(__) 
			 ____  ___  ____     ___  _  _  __ _   __   _  _  ____  __  __ _                                       
			(  __)/ __)(  __)   / __)/ )( \\(  ( \\ / _\\ ( \\/ )(    \\(  )(  ( \\                                      
			 ) _)( (__  ) _)   ( (_ \\) \\/ (/    //    \\ )  /  ) D ( )( /    /                                      
			(____)\\___)(____)   \\___/\\____/\\_)__)\\_/\\_/(__/  (____/(__)\\_)__)                                      
			 __  ____  ____  _  _     ___  _  _  __                                                               
			(  )(  _ \\(  __)( \\/ )   / __)/ )( \\(  )                                                              
			 )(  )   / ) _) / \\/ \\  ( (_ \\) \\/ (/ (_/\\                                                            
			(__)(__\\_)(____)\\_)(_/   \\___/\\____/\\____/                                                        
			""");
		
		menu();		
	}

    public static void clearConsole(){      //Cleaning Console
		System.out.println("Welcome to JavaBeat");
		
		System.out.println("\033[H\033[2J");
		
	}

    public static void menu(){	    //Main Menu
		Scanner input = new Scanner(System.in);
		String userInput;
		
		do{
			System.out.println("""
			[A] Statistical Information About An Array, 
			[B] Matrix Operations, 
			[C] Text Encryption/Decryption, 
			[D] Tic-tac-toe HotSeat, 
			[E] Terminate.

			Make a decision: """);

			userInput = input.nextLine();
			decision(userInput);

		} while( !(userInput.equals("E") || userInput.equals("e")) );

	}

    public static void decision(String userInput){      //Decision Part

		if(userInput.equals("A")||userInput.equals("a")){
			clearConsole();
			ArrayOperations();
		}

		else if(userInput.equals("B")||userInput.equals("b")){
			clearConsole();
			MatrixMenu();
		}
		else if(userInput.equals("C")||userInput.equals("c")){
			clearConsole();
            CaesarChip();
		}
		else if(userInput.equals("D")||userInput.equals("d")){
			clearConsole();
			tictac();
		}
		else if(userInput.equals("E")||userInput.equals("e")){
			clearConsole();
			System.exit(0);
		}
		else{
			clearConsole();
			System.out.println("Choice is invalid. Please make a valid choice!\n");
		}
	}

	static void back(int n){ 	//Back to main
		Scanner ink = new Scanner(System.in);
		String last = ink.nextLine();

        if((n==3)&&(last.equals("r")||last.equals("R")))
            tictac();

		if(last.equals("Y")||last.equals("y")){
			clearConsole();}
		else if(n==0){
			System.out.printf("(If you want to back Main Menu, press Y): ");
			back(0);
		}
		else if(n==1){
			System.out.printf("(If you want to back Matrix Operations Menu, press Y): ");
			back(1);
		}
        	else{
            System.out.println("(If you want to start game again, press R)");
            System.out.printf("(If you want to back Main Menu, press Y): ");
			back(3);
        }
	}

////////////// ARRAY OPERATIONS /////////////////
    	
	public static void ArrayOperations() {

     	Scanner scan = new Scanner(System.in);
        
        	String line;
        	int ArrayLength;
        
        	//Taking Array size from user as string, then converting it to int.
        	do
     	{

            System.out.print("Enter the size of array: ");
            line = scan.nextLine();

          } while(!arraySizeCheck(line));
        
        	ArrayLength = Integer.parseInt(line); //Array size should be integer
        	double Array[] = new double[ArrayLength];
        
        	//Taking Array elements from user as string, then converting them to double 
        	for(int i = 0; i < ArrayLength; i++)
          {
               do{

                    System.out.printf("Enter the Array[%d]: ", i);
                    line = scan.nextLine();

               } while(!arrayElementCheck(line));
               
			Array[i] = Double.parseDouble(line);
          }
        
		//print the array as string
		clearConsole();

		System.out.println(" The Array : " + Arrays.toString(Array));
		System.out.printf(" %-20s : %,.4f%n ", "The Median: ", Median(Array));
		System.out.printf("%-20s : %,.4f%n ", "The Arithmetic Mean: ", ArithmeticMean(Array));
		
		try {

			double GM = GeometricMean(Array);
			System.out.printf("%-20s : %,.4f%n ", "The Geometric Mean: ",GM);
		
		} catch(IllegalArgumentException e){
			System.out.println("The Geometric Mean: Calculation Is Not Possible");
		}
		
		System.out.printf("%-20s : %,.4f%n ", "The Harmonic Mean", Array.length/HarmonicMean(Array));
		System.out.printf("\n(If you want to back Main Menu, press Y): ");
		back(0);
     }

     static boolean arraySizeCheck(String str) { 		// check if the size is a positive integer value
		try {

			int test = Integer.parseInt(str); 
				
			if(test <= 0 || test >= Integer.MAX_VALUE){
				System.out.println("Please enter a positive Integer value!");
				return false;
			}
				
			return true;

		} catch(NumberFormatException e){	
			System.out.println("Please enter a positive Integer value!");
			return false;
		}
	}
	
	static boolean arrayElementCheck(String str) { 	//check if the element is a number
		try {
			Double.parseDouble(str);
			return true;
		}
		catch(NumberFormatException e){	
			System.out.println("Please enter a valid value!");
			return false;
		}
	}

	static void ArraySort(double [] Array) {	// Bubble sort
		boolean swap; // To check if there is any change or not
		int i, j;
		double temp;

		for (i = 0; i < Array.length - 1; i++){
			swap = false;
			for(j = 0; j < Array.length - i - 1; j++){
				if(Array[j] > Array[j+1]){

					temp = Array[j];
					Array[j] = Array[j+1];						
					Array[j+1] = temp;
						
					swap = true;
				}
			}

			if(swap == false)
				break;
		}
	}
	
	static double Median(double[] Array) {
	    double median;
	    
	    ArraySort(Array); 
	    
	    if(Array.length % 2 != 0) // if array size is odd
	    {
		median = Array[Array.length/2];
	    }						   
	    else //if array size is even 
	    {
	    	median = (Array[Array.length / 2] + Array[Array.length / 2 - 1]) / 2;
	    }
	    
	    return median;
	}
	
	static double ArithmeticMean(double[] Array) {
		double total = 0;
		
		for(int i = 0; i < Array.length; i++)
			total += Array[i];
		
		return total / Array.length;	
	}
	
	static double GeometricMean(double[] Array) { 
		double product = 1; // product of the array elements
		
		for(int i = 0; i < Array.length; i++){
			product *= Array[i];
        	}
        	
		
		if(product < 0) 
          	throw new IllegalArgumentException(); 
        
		return Math.pow(product, (double)1/Array.length); 
	}
	
	static double HarmonicMean(double[] Array) {
		double sum = 0;

    		for (double value : Array) 
		{
        		if (value == 0) 
            		throw new IllegalArgumentException("Array contains zero, harmonic mean is undefined.");
        		
			sum += 1 / value;
    		}

    		return Array.length / sum; 
	}

////////////// MATRIX OPERATIONS /////////////////

    public static void MatrixMenu(){
        Scanner input = new Scanner(System.in);
        String userInput; 

        do{
            System.out.printf("Welcome to The Matrix Operations...%n%n");
            System.out.printf(" [A] - Transpose Matrix %n [B] - Inverse Matrix %n [C] - Matrix Multiplication %n [D] - Element-wise Multiplication %n [E] - Return to the Main Menu %n%n Please enter the value to select operation: ");	
            userInput = input.nextLine();
            MatrixMenuDecision(userInput);
            // System.out.printf("\n(If you want to back Main Menu, press Y): ");
            // back(0);
        }
        while(!(userInput.equals("E")||userInput.equals("e")));
            // input.close();
    }

    public static void MatrixMenuDecision(String userInput){

		if(userInput.equals("A")||userInput.equals("a")){
			clearConsole();

			double mat[][] = transpose(matrixCreate(3));

			System.out.printf("%nYour Transposed Matrix: %n");
			printMatrix(mat);
			System.out.printf("\n(If you want to back Matrix Operations Menu, press Y): ");
			back(1);
		}
		else if(userInput.equals("B")||userInput.equals("b")){
			clearConsole();
			Inverse();
            System.out.printf("\n(If you want to back Matrix Operations Menu, press Y): ");
            back(1);
		}
		else if(userInput.equals("C")||userInput.equals("c")){
			 clearConsole();
			 MatrixMultiplication();
			 System.out.printf("\n(If you want to back Matrix Operations Menu, press Y): ");
			 back(1);

		}
		else if(userInput.equals("D")||userInput.equals("d")){
			clearConsole();
			elementwiseMatrixMultiplication();
			System.out.printf("\n(If you want to back Matrix Operations Menu, press Y): ");
			back(1);
		}
		else if(userInput.equals("E")||userInput.equals("e")){
			clearConsole();
			menu();
		}
		else{
			clearConsole();
			System.out.println("Choice is invalid. Please make a valid choice!\n");
		}
	}

    public static double[][] matrixCreate(int x){      //Matrix Creation


		Scanner input = new Scanner(System.in);
		String matrixInp;
		String row;
		String col;

		switch(x){

			case(1):
				do{

				System.out.printf("Enter row size of the %d. Matrix: ", x);
				row = input.nextLine();
				}while(!arraySizeCheck(row));

				do{
				System.out.printf("Enter column size of the %d. Matrix: ", x);
				col = input.nextLine();
				}while(!arraySizeCheck(col));
				break;

			case(2):
				do{
				System.out.printf("Enter row size of the %d. Matrix: ", x);
				row = input.nextLine();
				}while(!arraySizeCheck(row));


				do{
				System.out.printf("Enter column size of the %d. Matrix: ", x);
				col = input.nextLine();
				}while(!arraySizeCheck(col));
				break;

				case(3):
				do{
				System.out.print("Enter row size of the Matrix: ");
				row = input.nextLine();
				}while(!arraySizeCheck(row));

				do{
				System.out.print("Enter column size of the Matrix: ");
				col = input.nextLine();
				}while(!arraySizeCheck(col));
				break;

			default:
				do
				{
				System.out.print("Enter size of the Square Matrix: ");
				row = input.nextLine();
				col = row;
				}
				while(!arraySizeCheck(row));
				break;
		}

		int rowsize = Integer.parseInt(row);
		int colsize = Integer.parseInt(col);

		double Matrix[][] = new double[rowsize][colsize];

		for(int i=0; i<rowsize; i++)
			{
			for(int j=0; j<colsize; j++)
				{	
					do {
						System.out.printf("Enter the Matrix[%d][%d]: ", i,j);
						matrixInp = input.nextLine();
						}
					while(!arrayElementCheck(matrixInp));
					Matrix[i][j] = Double.parseDouble(matrixInp);
				}
			}
		System.out.printf("%nYour Matrix: %n");
		printMatrix(Matrix);
		// input.close();
		return Matrix;
	}

    static void printMatrix(int[][] mat){       //Printing Matrix

		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[0].length;j++)
			{
				System.out.printf("%d ", mat[i][j]);
			}
			System.out.printf("%n");
		}
	}

	static void printMatrix(double[][] mat){        //Printing Matrix

		for(int i=0; i<mat.length; i++)
		{
			for(int j=0; j<mat[0].length;j++)
			{
				System.out.printf("%,2f ", mat[i][j]);
			}
			System.out.printf("%n");
		}
	}

	static boolean arrayMatrixCheck(String str){

		try {
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException e){	
			System.out.println("Please enter an Integer value!");
			return false;
		}
	}

	public static double[][] transpose(double matrix[][]){

        double[][] newmat = new double[matrix[0].length][matrix.length];
		for(int i = 0; i<matrix[0].length ; i++){
			for(int j = 0; j<matrix.length ; j++){
				newmat[i][j]=matrix[j][i];
			}
		}
		return newmat;
	}

    public static void Inverse(){
		double[][] mat	= matrixCreate(2);

		// System.out.printf("determinant:%d%n%n%n",det(mat));
		double det=(double)det(mat);
		if(det==0){
			System.out.println("%nThis matrix cannot be inverted because its determinant is zero, please enter another matrix.%n");
			Inverse();
		}
		else{
			det=1/det;
			mat=transpose(adjointMatrix(mat));
			double[][] mat2 = new double[mat.length][mat.length];
			for(int i=0; i<mat.length ; i++){
				for(int j=0; j<mat.length; j++){
					double a = ((double)mat[i][j])*det;
					if(a==0)
						mat2[i][j]=0;
					else
						mat2[i][j]=a;
				}}
            System.out.println("\nInverse of the Matrix:\n");    
			printMatrix(mat2);
		}
	}
    public static double[][] submatrix(double[][] matrix,int m, int n){

		double[][] submat = new double[matrix.length-1][matrix.length-1];

		int subrow=0, subcol=0;

		for(int i=0; i<matrix.length ; i++){
			if(i==m)
				continue;
			subcol=0;
			for(int j=0; j<matrix.length; j++){
				if(j==n)
					continue;
				submat[subrow][subcol++]=matrix[i][j];
			}
			subrow++;	
		}

		return submat;
	}
	
	public static double det(double[][] matrix){
	
		if(matrix.length==2){
		return((matrix[0][0]*matrix[1][1])-(matrix[0][1]*matrix[1][0]));
		}
		else{
			int total = 0;
			for(int i=0; i<matrix.length; i++){
				if(i%2==0)
				total += matrix[0][i]*det(submatrix(matrix,0,i));
				else
				total -= matrix[0][i]*det(submatrix(matrix,0,i));
			}
			return total;
		}
	}

	public static double[][] adjointMatrix(double[][] matrix){

		double[][] adjmat = new double[matrix.length][matrix.length];

		if(matrix.length>2){
			for(int i=0; i<matrix.length ; i++){
				for(int j=0; j<matrix.length; j++){
					double a=det(submatrix(matrix,i,j));
					if(a==0)
						adjmat[i][j]=0;
					else
						adjmat[i][j] = a*((double)Math.pow(-1,i+j));
				}
			}
		}
		else{
			adjmat[0][0]=matrix[1][1];
			adjmat[0][1]=-matrix[0][1];
			adjmat[1][0]=-matrix[1][0];
			adjmat[1][1]=matrix[0][0];
		}

		return adjmat;
	}

	public static void MatrixMultiplication()
	{

		double mat1[][];
		double mat2[][];

		do{
			mat1 = matrixCreate(1);
			mat2 = matrixCreate(2);
			if (mat1 != null && mat2 != null && mat1[0].length != mat2.length)
				System.out.println("ERROR: The number of columns in the first matrix does not match the number of rows in the second matrix. Please try again.");
		}
		while(mat1[0].length != mat2.length);

		double resultmat[][] = new double[mat1.length][mat2[0].length];

		for(int i=0; i<mat1.length; i++)
			for(int j=0; j<mat2[0].length; j++)
				for(int k=0; k<mat1[0].length; k++)
				{
					resultmat[i][j] += mat1[i][k] * mat2[k][j]; 
				}
		
		System.out.println("\n...\n Your Multiplied Matrix is: \n");
		printMatrix(resultmat);
	}

	public static void elementwiseMatrixMultiplication()
	{

		double mat1[][];
		double mat2[][];
		do{
			mat1 = matrixCreate(1);
			mat2 = matrixCreate(2);
			if((mat1.length != mat2.length) || (mat1[0].length != mat2[0].length))
				System.out.println("ERROR: In the element wise multiplication, two matricies must be the same length as rows and cols");
		}
		while((mat1.length != mat2.length) || (mat1[0].length != mat2[0].length));

		double resultmat[][] = new double[mat1.length][mat1[0].length];

		for(int i=0; i<mat1.length; i++)
			for(int j=0; j<mat1[0].length; j++)
				{
					resultmat[i][j] = mat1[i][j] * mat2[i][j];
				}

				System.out.println("\n...\n Your Element-wise Multiplied Matrix is: \n");
			printMatrix(resultmat);
	}

////////////// ENCRYPTION - DECRYPTION //////////////////

public static void CaesarChip(){

	Scanner input = new Scanner(System.in);

	int choice;
	int shiftValue = 0;
   	boolean shiftVal;
	
	do{
	
		//Showing the menu 
		System.out.println("Welcome to The Encryption-Decryption Operations...\n\n[1] - Encryption\n[2] - Decryption\n[3] - Return to the Main Menu\n");

		System.out.print("Make a choice: ");

		while(!input.hasNextInt()) // loop to prevent user from entering character
		{
			System.out.println("Invalid input. Please enter an integer (1, 2, or 3).");
            	input.next(); // skip the invalid input 
            	System.out.print("Make a choice: ");
		}

		choice = input.nextInt();

		if (choice < 1 || choice > 3){
			System.out.println("Please make a choice in the given scale!");
			continue; 
		}

		switch (choice) {
			case 1:
				clearConsole();
				System.out.println("\nEncryption selected!");
			shiftVal = false;
 
				while (!shiftVal) {
						  
					System.out.print("Enter a 'shift' value between -26 and 26 (include): ");
					
				if(input.hasNextInt())
				{
					shiftValue = input.nextInt();

					if(shiftValue >= -26 && shiftValue <= 26)
					{
						if(shiftValue == 0)
						{
									System.out.println("Shift value is 0. No encryption will be performed.");
						}

						shiftVal = true; 
					}
					else 
					{
						System.out.println("The 'shift' value should be in the [-26,26] range.");
					}
				}
				else
				{
					System.out.println("Invalid input. Please enter an integer.");
					input.next();
				}
						  
				}
 
				input.nextLine();
 
				System.out.print("Enter the message to be encrypted: ");
				String message2Encrypt = input.nextLine();
 
				String encryptedMessage = encryption(shiftValue,message2Encrypt);
					 
				System.out.printf("\nKey Value: %d%nMessage: %s%nEncrypted Message: %s%n",shiftValue,message2Encrypt,encryptedMessage);
				//System.out.printf("\n(If you want to back Main Menu, press Y): ");
				//back(2);
				break;

			case 2:
				clearConsole();
				System.out.println("Decryption selected!");
				
				shiftVal = false;
 
				while (!shiftVal) 
				{
						  
					System.out.print("Enter a 'shift' value between -26 and 26 (include): ");
					
					if (input.hasNextInt()) 
					{
						shiftValue = input.nextInt();
							
						if (shiftValue >= -26 && shiftValue <= 26) 
						{
							if(shiftValue == 0)
							{
								System.out.print("Attention: Shift value is 0, no decryption will be performed!");
							}    
							
							shiftVal = true;
						}	    
						else 
						{
							System.out.println("The 'shift' value should be in the [-26,26] range.");
						}
					} 
					else 
					{
						System.out.println("Invalid input. Please enter an integer.");
						input.next();
					}  
				}
 
					input.nextLine();
 
					System.out.print("Enter the message to be decrypted: ");
					String message2Decrypt = input.nextLine();
 
					String DecryptedMessage = encryption((26-shiftValue),message2Decrypt);
					clearConsole();

					System.out.printf("key: %d%nMessage: %s%nDecrypted: %s%n",shiftValue,message2Decrypt,DecryptedMessage);
					//System.out.printf("\n(If you want to back Encryption-Decryption Menu, press Y): ");
					//back(2);
					break;
				case 3:
					System.out.println("Returning to main menu!");
					break;
		}
	}while (choice != 3);
		clearConsole();
		menu();
		input.close();
}

    public static String encryption(int key,String text){
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);

            if (Character.isLetter(c)){

                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char newChar = (char) ((c - base + key) % 26 + base);
                result.append(newChar);
                    
            }
            else 
                result.append(c); 
        }

        return result.toString();
    }
///////// TIC TAC TOE /////////////

    static Scanner input= new Scanner (System.in);//this should be static for access it from main function
    static int rows=3;
    static int cols=3;
    static char[][] board= new char[rows][cols];//new is required to determine the memory to be allocated.
    static char currentPlayer= 'X';
    static int movementCounter=0;//to check how many moves are made
    public static void tictac(){
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
