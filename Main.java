/**
 * **Main Class**
 * 
 * This class serves as the entry point for the program, providing a 
 * user-friendly interface to various mathematical and game 
 * functionalities. 
 * It offers options for:
 *
 * - **Array Operations:** Statistical calculations on arrays, such as 
 * mean, median, and standard deviation.
 * - **Matrix Operations:** Matrix manipulations like transposition, 
 * inversion, and multiplication.
 * - **Text Encryption/Decryption:** Caesar cipher encryption and decryption.
 * - **Tic-Tac-Toe:** A classic two-player game.
 *
 * @author Group1
 * @version 5
 * @since 2024-10-31
 */

import java.util.Scanner; // Used to get math input
import java.util.Arrays; // Used for array manuplation functions
import java.lang.Math; // Used for math funcitons


public class Main{

	/**
	 * Main method. This is the starting point of the program, displaying the 
	* welcome screen and initiating the main menu.
	* 
	* @param args command-line arguments (not used in this program)
	*/
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

	/**
	 * Clears the console screen by printing ANSI escape sequences. 
	* This method is specific to terminals that support ANSI escape codes.
	*/
	public static void clearConsole(){      //Cleaning Console

		System.out.println("\033[H\033[2J");
	
	}

	/**
	 * Displays the main menu to the user, offering options for array 
	 * statistics, matrix operations, text encryption/decryption, 
	 * tic-tac-toe, and program termination. It prompts the user 
	 * for a choice and validates the input. The menu continues to 
	 * display until the user chooses to exit.
	 */
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

	/**
	 * Directs the program flow based on the user's menu choice. 
	 * Cleans the console and calls the appropriate function 
	 * according to the user's input.
	 *
	 * @param userInput The user's choice, a single character representing 
	 *                   a menu option (A, B, C, D, or E).
	 */
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

	/**
	 * Allows to return to the previous menu or repeat the action. The user can enter 'r' or 'R' to return to the 
	 * previous operation or 'Y' or 'y' to return to the main menu.
	 * 
	 * If the user inputs an invalid option, the method will prompt them to 
	 * either repeat the operation or return to the main menu.
	 *
	 * @param n An integer that indicates which operation or menu to return to. 
	 *          Each number corresponds to a specific operation:
	 *          0 - Array operations
	 *          1 - Matrix transpose
	 *          2 - Matrix inverse
	 *          3 - Matrix multiplication
	 *          4 - Element-wise matrix multiplication
	 *          7 - Tic Tac Toe game
	 * 
	 * @param str A string message indicating the operation that can be repeated 
	 *            if the user chooses to do so.
	 */
	static void back(int n, String str) { 	//Back to main
	
		Scanner ink = new Scanner(System.in);
		String last = ink.nextLine();

	
		if(last.equals("r")||last.equals("R")){
			if(n==0){
				clearConsole();
				ArrayOperations();
			}
			else if(n==1)
				MatrixMenuDecision("A");
			else if(n==2)
				MatrixMenuDecision("b");
			else if(n==3)
				MatrixMenuDecision("c");
			else if(n==4)
				MatrixMenuDecision("d");
			else if(n==5)
				choicee(1);
			else if(n==6)
				choicee(2);
			else if(n==7)
				tictac();
		}
		else
		{
			if(last.equals("Y")||last.equals("y")){
				clearConsole();
			}
			else{
				System.out.println("\n(If you want to " + str +", press R)");
				System.out.printf("(If you want to back menu, press Y): ");
				back(n,str);//function call itself because no valid character entered
			}
		}

	}

////////////// ARRAY OPERATIONS /////////////////

	/**
	 * Provides functionalities for array operations, including:
	 *  - Taking user input for array size and elements.
	 *  - Validating user input to ensure positive integer values for size 
	 *    and numeric values for elements.
	 *  - Calculating and displaying the following statistics:
	 *      - Median
	 *      - Arithmetic Mean (Average)
	 *      - Geometric Mean (if applicable)
	 *      - Harmonic Mean (if applicable, throws exception for zero elements)
	 *  - Offers the option to return to the main menu.
	 *
	 * @throws IllegalArgumentException if the geometric mean calculation 
	 *         encounters negative product or if the harmonic mean encounters 
	 *         a zero element in the array.
	 */
	public static void ArrayOperations() {

		Scanner scan = new Scanner(System.in);
		
		String line;
		int ArrayLength;
		int n = 0;
		
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
			
			if(Array[i]==-0)
				Array[i]=0;
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

		try {
			
			double harmonicMean = HarmonicMean(n, Array);
			System.out.printf("%-20s : %,.4f%n ", "The Harmonic Mean", Array.length / harmonicMean);
		
		} catch (IllegalArgumentException e) {
			System.out.printf("%-20s : %s%n ", "The Harmonic Mean", e.getMessage());
		}	  

		System.out.println("\n(If you want to do another Array Operation, press R)");
		System.out.printf("(If you want to back menu, press Y): ");
		back(0,"do another Array Operation");
	}

	/**
	 * Validates the user input for array size. Ensures the input is a 
	 * positive integer value less than the maximum allowed integer value.
	 *
	 * @param str the input string to check
	 * @return true if the input is a valid positive integer, false otherwise.
	 */
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
	
	/**
	 * Validates the user input for array elements. Ensures the input is 
	 * a valid numeric value.
	 *
	 * @param str the input string to check
	 * @return true if the input is a valid double numeric value, false otherwise.
	 */
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

	/**
	 * Sorts the given array using the bubble sort algorithm.
	 *
	 * @param Array the array to be sorted
	*/
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
	
	/**
	 * Calculates and returns the median of the given array. Sorts the array 
	 * first and then retrieves the middle element (or the average of the two 
	 * middle elements for even-sized arrays).
	 *
	 * @param Array the array of elements
	 * @return the median value of the array
	 */
	static double Median(double[] Array) {
		double median;
		
		ArraySort(Array); 
		
		if(Array.length % 2 != 0) // if array size is odd
		{
			median = Array[Array.length / 2];
		}						   
		else //if array size is even 
		{
			median = (Array[Array.length / 2] + Array[Array.length / 2 - 1]) / 2;
		}
		
		return median;
	}
	
	/**
	 * Calculates and returns the arithmetic mean (average) of the given array.
	 *
	 * @param Array the array of elements
	 * @return the arithmetic mean (average) value of the array
	 */
	static double ArithmeticMean(double[] Array) {
		double total = 0;
		
		for(int i = 0; i < Array.length; i++)
			total += Array[i];
		
		return total / Array.length;	
	}
	
	/**
	 * Calculates and returns the geometric mean of the given array. Throws an 
	 * IllegalArgumentException if the product of the array elements is negative.
	 *
	 * @param Array the array of elements
	 * @return the geometric mean of the array
	 * @throws IllegalArgumentException if the product of the array elements is negative
	 */
	static double GeometricMean(double[] Array) { 
		double product = 1; // product of the array elements
		
		for(int i = 0; i < Array.length; i++){
			product *= Array[i];
		}
			
		if(product < 0) //because geometric mean cannot be calculated for negative values
			throw new IllegalArgumentException(); 
		
		return Math.pow(product, (double)1/Array.length); 
	}
	
	/**
	 * Recursively calculates the harmonic mean of the elements in the given array.
	 * 
	 * @param n the index of the element to be processed in the recursive function
	 * @param Array the array of elements
	 * @return the harmonic mean of the array
	 * @throws IllegalArgumentException if any element of the array is zero
	 */
	static double HarmonicMean(int n, double[] Array) {
		// Throw an exception if the array has an element which is 0 
		if (Array[n] == 0) {
			throw new IllegalArgumentException("Harmonic mean is undefined because an element of the array is 0.");
		}
		
		if ((n + 1) == Array.length) 
			return (1 / Array[n]); // Return n if its the last element
		else 
			return ((1 / Array[n++]) + HarmonicMean(n, Array)); // After the zero check, return the current value and increment n. Then call itself to do calculation for next element of array.
		
	}

////////////// MATRIX OPERATIONS /////////////////

	/**
	 * Displays a menu for matrix operations, allowing the user to select
	 * from various matrix operations such as transposing, inverting, 
	 * multiplying, or performing element-wise multiplication on matrices.
	 * The menu will continuously prompt the user until they choose to 
	 * return to the main menu by entering 'E' or 'e'.
	 *
	 * <p>This method uses a loop to handle user input and calls 
	 * {@link #MatrixMenuDecision(String)} to execute the selected operation.</p>
	 */
	public static void MatrixMenu(){
		
		Scanner input = new Scanner(System.in);
		String userInput; 

		do{
			System.out.printf("Welcome to The Matrix Operations...%n%n");
			System.out.printf(" [A] - Transpose Matrix %n [B] - Inverse Matrix %n [C] - Matrix Multiplication %n [D] - Element-wise Multiplication %n [E] - Return to the Main Menu %n%n Please enter the value to select operation: ");	
			
			userInput = input.nextLine();
			
			MatrixMenuDecision(userInput);

		} while(!(userInput.equals("E")||userInput.equals("e"))); // the loop iterates until user enter E or E
	}


		/**
	 * Handles the user's selection for matrix operations in the matrix menu. 
	 * The user can choose from various operations, including transposing a 
	 * matrix, calculating its inverse, performing matrix multiplication, 
	 * and element-wise multiplication.
	 * 
	 * If the user enters an invalid option, the method will prompt the user 
	 * to make a valid choice.
	 *
	 * @param userInput The user's choice for the matrix operation, expected 
	 *                  to be a single character indicating the desired 
	 *                  operation. Valid inputs include 'A', 'B', 'C', 'D', 
	 *                  and 'E'.
	 *
	 * @see #transpose(double[][]) for transposing matrices.
	 * @see #Inverse() for calculating the inverse of a matrix.
	 * @see #MatrixMultiplication() for performing multiplication on matrices.
	 * @see #elementwiseMatrixMultiplication() for element-wise 
	 *      multiplication of matrices.
	 * @see #clearConsole() for clearing the console display.
	 * @see #menu() for returning to the main menu.
	 */
	public static void MatrixMenuDecision(String userInput){

		if(userInput.equals("A")||userInput.equals("a")){ // call Transpose function and print it
			clearConsole();

			double mat[][] = transpose(matrixCreate(1));

			System.out.printf("%nYour Transposed Matrix: %n");
			printMatrix(mat);

			System.out.println("\n(If you want to do another Transpose Operation, press R): ");
			System.out.printf("(If you want to back menu, press Y): ");
			back(1,"do another Transpose Operation");
		}
		else if(userInput.equals("B") || userInput.equals("b")){ // call Inverse function
			clearConsole();
			Inverse();
				
			System.out.println("\n(If you want to do another Inverse Operation, press R): ");
			System.out.printf("(If you want to back menu, press Y): ");
			back(2,"do another Inverse Operation");
		}
		else if(userInput.equals("C") || userInput.equals("c")){ // call Matrix Multiplication function
			clearConsole();
			MatrixMultiplication();
			
			System.out.println("\n(If you want to do another Multiplication Operation, press R): ");
			System.out.printf("(If you want to back menu, press Y): ");
			back(3,"do another Multiplication Operation");
		}
		else if(userInput.equals("D") || userInput.equals("d")){ // call element wise multiplication matrix
			clearConsole(); 
			elementwiseMatrixMultiplication();
			
			System.out.println("\n(If you want to do another Element Wise Multiplication Operation, press R): ");
			System.out.printf("(If you want to back menu, press Y): ");
			back(4,"do another Element Wise Multiplication Operation");
		}
		else if(userInput.equals("E") || userInput.equals("e")){ // call Main menu function to return
			clearConsole();
			menu();
		} 
		else{ // If the user enters an input other than these options
			clearConsole();
			System.out.println("Choice is invalid. Please make a valid choice!\n");
		}
	}

	// Global variables
	private static String row; //these values are global to use again these values
	private static String col;

	/**
	 * Creates a matrix based on user-defined row and column sizes. 
	 * The method prompts the user to input the size of the matrix 
	 * and the elements of the matrix. It validates the input to 
	 * ensure that the sizes are valid integers and that the elements 
	 * are numeric.
	 * 
	 * The user can specify different types of matrices:
	 * 1. A rectangular matrix (input for rows and columns).
	 * 2. A matrix with a specified number of rows and equal columns.
	 * 3. A square matrix (the same number for rows and columns).
	 * 
	 * @param x An integer indicating the type of matrix to create:
	 *          1 - Rectangular matrix
	 *          2 - Matrix with equal rows and columns
	 *          3 - Square matrix
	 * 
	 * @return A 2D array of doubles representing the created matrix.
	 */
	public static double[][] matrixCreate(int x)  //Matrix Creation function
	{     
		Scanner input = new Scanner(System.in);
		
		String matrixInp;

		switch(x){

			case(1):// ask for row and column size of the Matrix to user
				do{

					System.out.print("Enter row size of the Matrix: ");
					row = input.nextLine();
				} while(!arraySizeCheck(row));

				do{
					System.out.print("Enter column size of the Matrix: ");
					col = input.nextLine();
				} while(!arraySizeCheck(col));
				break;

			case(2):// column size of the last created matrix is ​​used for row size and ask for only column size of the Matrix to user
				row = col;
				do{
					System.out.print("Enter column size of the Matrix: ");
					col = input.nextLine();
				} while(!arraySizeCheck(col));
				break;

			case(3)://only ask for one size, row and col size will be the same
				do{
					System.out.print("Enter size of the Square Matrix: ");
					row = input.nextLine();
					col = row;
				} while(!arraySizeCheck(row));
				break;

			default://row and column sizes of the last created matrix is ​​used again
				break;
		}

		int rowsize = Integer.parseInt(row);//change sizes of the matrix to integer
		int colsize = Integer.parseInt(col);

		double Matrix[][] = new double[rowsize][colsize];

		for(int i=0; i<rowsize; i++)
		{
			for(int j=0; j<colsize; j++)
			{	
				do {
					System.out.printf("Enter the Matrix[%d][%d]: ", i,j);//fill the matrix with entered values
					matrixInp = input.nextLine();
				} while(!arrayElementCheck(matrixInp));
				
				Matrix[i][j] = Double.parseDouble(matrixInp);
				
				if(Matrix[i][j]==-0)
					Matrix[i][j]=0;
			}
		}
		System.out.printf("%nYour Matrix: %n");
		printMatrix(Matrix);
		// input.close();
		return Matrix;
	}

	
	/**
	 * Prints a matrix of doubles to the console in a formatted manner.
	 * Each element of the matrix is printed with a space in between,
	 * and each row is printed on a new line. The elements are formatted 
	 * to two decimal places.
	 *
	 * @param mat A 2D array of doubles representing the matrix to be printed.
	 */
	static void printMatrix(double[][] mat){	//Printing Double Matrix

		for(int i = 0; i < mat.length; i++)
		{
			for(int j = 0; j < mat[0].length; j++)
			{
				System.out.printf("%.2f ", mat[i][j]);
			}
			System.out.printf("%n");
		}
	}

	/**
	 * Checks if the given string can be parsed as an integer.
	 *
	 * @param str the string to be checked
	 * @return true if the string is a valid integer, false otherwise
	 */
	static boolean arrayMatrixCheck(String str) 
	{
		try {
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException e){	
			System.out.println("Please enter an Integer value!");
			return false;
		}
	}

	/**
	 * Transposes the given matrix.
	 *
	 * @param matrix the matrix to be transposed
	 * @return a new matrix that is the transpose of the input matrix
	 */
	public static double[][] transpose(double matrix[][])
	{

		double[][] newmat = new double[matrix[0].length][matrix.length];
		for(int i = 0; i<matrix[0].length ; i++){
			for(int j = 0; j<matrix.length ; j++){
				newmat[i][j]=matrix[j][i];
			}
		}
		return newmat;
	}

	/**
	 * Calculates the inverse of a matrix.
	 * If the determinant is zero, prompts the user for a new matrix.
	 */
	public static void Inverse()
	{
		double[][] mat	= matrixCreate(3);

		// System.out.printf("determinant:%d%n%n%n",det(mat));
		double det=(double)det(mat);//store determinant of the matrix, if it is zero ask for another matrix
		if(det==0)
		{
			System.out.println("\nThis matrix cannot be inverted because its determinant is zero, please enter another matrix.\n");
			Inverse();
		}
		else 
		{
			det = 1 / det;
			mat = transpose(adjointMatrix(mat));//take transpose of adjoint matrix
			double[][] mat2 = new double[mat.length][mat.length];
			for(int i = 0; i < mat.length ; i++)
			{
				for(int j = 0; j < mat.length; j++)
				{
					double a = ((double)mat[i][j])*det;//multiply element of transposed adjoint matrix and 1/determinant
					if(a == 0)//Sets equal to zero to avoid negative zero (-0.00)
						mat2[i][j]=0;
					else
						mat2[i][j]=a;
				}
			}
			
			System.out.println("\nInverse of the Matrix:\n");    
			printMatrix(mat2);
		}
	}

	/**
	 * Creates a submatrix by removing the specified row and column from the original matrix.
	 *
	 * @param matrix the original matrix
	 * @param m the row to be removed
	 * @param n the column to be removed
	 * @return the submatrix resulting from removing the specified row and column
	 */
	public static double[][] submatrix(double[][] matrix,int m, int n)
	{
		double[][] submat = new double[matrix.length-1][matrix.length-1];//create one size smaller matrix

		int subrow=0, subcol=0;

		for(int i=0; i<matrix.length ; i++)
		{
			if(i==m)//if current row equal to row which will deleted, skip
				continue;
			subcol=0;//sets equal column indext to 0 at beginning of every row
			
			for(int j=0; j<matrix.length; j++)
			{
				if(j==n)//if current column equal to column which will deleted, skip
					continue;
				submat[subrow][subcol++]=matrix[i][j];
			}
			
			subrow++;//increases index of row
		}

		return submat;
	}
	
	/**
	 * Calculates the determinant of a given matrix.
	 * Calculates the determinant of a given matrix.
	 * Calcule determinat of (n-1)*(n-1) matrix to find determinant of n*n matrix until 
	 * n-1 is equal to 2 by calling itself recursively.
	 *
	 * @param matrix the matrix for which the determinant is to be calculated
	 * @return the determinant of the matrix
	 */
	public static double det(double[][] matrix)
	{
		if(matrix.length==2){//if matrix length equal to 2*2 calculate determinant, else calls itself and divides the matrix into small pieces of 2*2 
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

	/**
	 * Calculates the adjoint of a given matrix.
	 *
	 * @param matrix the matrix for which the adjoint is to be calculated
	 * @return the adjoint matrix
	 */
	public static double[][] adjointMatrix(double[][] matrix){

		double[][] adjmat = new double[matrix.length][matrix.length];

		if(matrix.length>2){//creates a matrix which full with determinants of the submatrices
			for(int i=0; i<matrix.length ; i++){
				for(int j=0; j<matrix.length; j++){
					double a=det(submatrix(matrix,i,j));
					if(a==0)//Sets equal to zero to avoid negative zero (-0.00)
						adjmat[i][j]=0;
					else
						adjmat[i][j] = a*((double)Math.pow(-1,i+j));//if sum of row and column size is odd, multiply with -1
				}
			}
		}
		else{//swaps values for taking adjoint of 2*2 matrix
			adjmat[0][0]=matrix[1][1];
			adjmat[0][1]=-matrix[0][1];
			adjmat[1][0]=-matrix[1][0];
			adjmat[1][1]=matrix[0][0];
		}

		return adjmat;
	}

	/**
	 * Multiplies two matrices.
	 * The number of columns in the first matrix must equal the number of rows in the second matrix.
	 */
	public static void MatrixMultiplication()
	{

		double mat1[][];
		double mat2[][];

		System.out.println("Matrix 1:");//ask for creating 2 matrix to multiply
		mat1 = matrixCreate(1);
		System.out.println("\nMatrix 2 (the row size is equal to column size of the Matrix 1):");
		mat2 = matrixCreate(2);//won't ask for row size of the second matrix because it is equal to column size of the first matrix
		
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

	/**
	 * Performs element-wise multiplication of two matrices.
	 * Both matrices must have the same dimensions.
	 */
	public static void elementwiseMatrixMultiplication()
	{

		double mat1[][];
		double mat2[][];
		
		System.out.println("Matrix 1:");//ask for creating 2 matrix to multiply
		mat1 = matrixCreate(1);
		System.out.println("\nMatrix 2 (have same row and column size with Matrix 1):");
		mat2 = matrixCreate(4);//won't ask for row and column size of the second matrix because they are equal to row and column size of the first matrix
		
		double resultmat[][] = new double[mat1.length][mat1[0].length];

		for(int i=0; i<mat1.length; i++)
			for(int j=0; j<mat1[0].length; j++)
			{
				resultmat[i][j] = mat1[i][j] * mat2[i][j];//multiply elements which are at the same index
			}

		System.out.println("\n...\n Your Element-wise Multiplied Matrix is: \n");
		printMatrix(resultmat);
	}

////////////// ENCRYPTION - DECRYPTION //////////////////

	/**
	 * Displays a menu for Caesar cipher encryption and decryption operations,
	 * allowing the user to choose either operation, specify a shift value, and
	 * enter a message to encrypt or decrypt.
	 *
	 * <p>This method continuously displays the menu until the user chooses to
	 * return to the main menu. 
	 * 
	 * @see #choicee(int)
	 */
	public static void CaesarChip()
	{
		Scanner input = new Scanner(System.in);
	
		int choice;
		
		do {
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
			choicee(choice);
	
			if (choice < 1 || choice > 3)
			{
				clearConsole();
				System.out.println("Please make a choice in the given scale!");
				continue; 
			}
	
			
		} while (choice != 3); 
			
		clearConsole();
		menu();
		input.close();
	}

	/**
	 * This method handles input validation, checking for valid
	 * integer inputs for both menu choices and shift values. The method also calls
	 * {@code encryption} to perform the actual encryption and decryption processes
	 * based on the user's shift value.</p>
	 *
	 * @param choice
	 * 
	 * @see #encryption(int, String)
	 */
	public static void choicee(int choice)
	{
		int shiftValue = 0;
		boolean shiftVal;
		
		switch (choice)
		{
			case 1: // Case to encrypting the message
				clearConsole();
				System.out.println("Encryption selected!");
				
				shiftVal = false; //Shift value validation flag

				while (!shiftVal) // To force the value be in range
				{
						
					System.out.print("Enter a 'shift' value between -26 and 26 (include): ");
					
					if(input.hasNextInt()) // Check if the value is integer
					{
						shiftValue = input.nextInt();

						if(shiftValue >= -26 && shiftValue <= 26)
						{
							if(shiftValue == 0)
							{
								System.out.println("Shift value is 0. No encryption will be performed.");
							}
							shiftVal = true; // Valid shift value entered
						}
						else 
						{
							System.out.println("The 'shift' value should be in the [-26,26] range.");
						}
					}
					else
					{
						System.out.println("Invalid input. Please enter an integer.");
						input.next(); //Skip invalid input
					}	  
				}

				// Clear the newline char of Scanner obj taht remains in the input after an integer entered
				input.nextLine(); 

				System.out.print("Enter the message to be encrypted: ");
				String message2Encrypt = input.nextLine();

				String encryptedMessage = encryption(shiftValue,message2Encrypt);
					
				System.out.printf("\nKey Value: %d%nMessage: %s%nEncrypted Message: %s%n",shiftValue,message2Encrypt,encryptedMessage);
				System.out.printf("\n(If you want to do another Encryption Operation, press R): ");
				System.out.printf("\n(If you want to back menu, press Y): ");
				back(5,"to do another Encryption Operation"); // allow user to repeat or go back
				break;

			case 2: // Case to decrypting the message
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

				// Decrypt the message by reversing the shift
				//This operation reverses the shifting direction and decrypts the message
				String DecryptedMessage = encryption((26-shiftValue),message2Decrypt);
				clearConsole();

				System.out.printf("key: %d%nMessage: %s%nDecrypted: %s%n",shiftValue,message2Decrypt,DecryptedMessage);
				System.out.printf("\n(If you want to do another Decryption Operation, press R): ");
				System.out.printf("\n(If you want to back menu, press Y): ");
				back(6,"to do another Decryption Operation");
				break;
			
			case 3:
				System.out.println("Returning to main menu!");
				break;
		}
	}

	/**
 	 * Encrypts the given text using the Caesar cipher with a specified shift key.
	 * Each letter in the text is shifted within the alphabet, while non-letter
	 * characters remain unchanged.
	 *
	 * @param key  The shift value for the cipher, from -26 to 26. Positive values
	 *             shift right, negative values shift left.
	 * @param text The input text to be encrypted, containing any characters.
	 * @return The encrypted text with letters shifted by the specified key.
	 */
	public static String encryption(int key,String text){
		
		/*
		* String objects are immutable. Each time a character is added, a new String object is created.
		* Using StringBuffer (mutable) we can insert characters directly and modify the same object         
		*/
		StringBuffer result = new StringBuffer();

		if(key<0)//if shift value is negative, adding 26 to stay in range
			key = key + 26;
	
		for(int i = 0; i < text.length(); i++)
		{
			char c = text.charAt(i); // Get the current character
	
			if (Character.isLetter(c)){
				/*
				* Determine the base character for the shift (either 'a' or 'A')
				* Base --> 'a' if it is a lowercase letter
				* Base --> 'A' if it is an uppercase letter.
				*/
				char base = Character.isLowerCase(c) ? 'a' : 'A';
	
				/* 
				* Obtain a new encrypted character by shifting the letter 
				* With using c - base, we find the rank of the character according to the base 
				* The 'key', which is the amount of scrolling, is added to this and cyclic scrolling is achieved within 26 letters with 26%.
				* By summing the shifted value with 'base', we obtain the encrypted character in its Unicode base.
				*/
				char newChar = (char) ((c - base + key) % 26 + base);
	
				// Append the new character (shifted) to the result
				result.append(newChar);
				
			}
			else  // If the character is not a letter append to result
				result.append(c); 
		}
	
		// Convert the StringBuffer to a String
		return result.toString();
	}
///////// TIC TAC TOE /////////////

	private static Scanner input= new Scanner (System.in);
	private static int rows=3;
	private static int cols=3;
	private static char[][] board = new char[rows][cols];
	private static char currentPlayer= 'X';

	/**
	 * Starts the Tic Tac Toe game, handling player turns and game logic.
	 * 
	 * This method initializes the game board and enters a loop that allows players to make moves 
	 * until there is a winner or the game ends in a draw. It prompts the current player for input,
	 * validates the move, and updates the board accordingly. The method also switches players after 
	 * each valid move. When a winner is determined or no moves are left, it displays the game outcome 
	 * and prompts the user for further action (to restart the game or return to the menu).
	 */
	public static void tictac(){
		int movementCounter=0;//Movement counter keeps track of the moves in the game.
		clearConsole();//The clearconsole function clears the terminal, making it look clean and tidy.
		initializeBoard();//Initializes the board to be used in the game with the initializeboard function.
		while(true){
			printBoard();
			System.out.println(currentPlayer+"'s turn. Where do you want to put character?");

			String move;//The 'move' string is defined to hold the move the user wants to make.
			
			do{
				move = input.nextLine();
			} while(!validMove(move));//The user's location input is taken until a valid location input (1-9) is received from the user. The current value received is kept in the 'move' variable
		
			int nextMove = Integer.parseInt(move);

			if(!isempty(nextMove)){//If the cell whose location is entered is not empty, you will be prompted for entry again.
				clearConsole();
				System.out.println("This move can not be done. Choose an empty cell to move");
			}
			else {
				clearConsole();
				makeMove(nextMove);//if the cell is empty the move can be done
				movementCounter++;
				
				if(winner()){// winner function is called to check if there is a winner.
					clearConsole();
					printBoard();//The final state of the board where the user enters his move is displayed on the terminal.
					
					System.out.println("Game is over. The winner is "+ currentPlayer);//If there is a winner, it is stated that the last user who made the move won and the game ends.
					System.out.println(movementCounter+" moves made");//number of moves is displayed
					
					break;
				}
				else if (noMoveLeft()){//If there is no winner, it is checked whether there is any empty cells on the board.
					System.out.println("No more moves to play, draw!");
					break;
				}
				else{
					currentPlayer= (currentPlayer=='X')?'O':'X';//If there is no winner and there are empty spaces on the board, the next player moves on.
				}
			}
		}
		
		System.out.println("\n(If you want to start game again, press R): ");
		System.out.printf("(If you want to back menu, press Y): ");
		
		back(7,"start game again");
	}

	/**
	 * Validates the user's move input.
	 *
	 * @param str the user input as a String
	 * @return true if the move is valid, false otherwise
	 */
		static boolean validMove(String str){//Checks whether the value entered by the user is within the valid range
		try {
			int test = Integer.parseInt(str);
			
			if(test <= 0 || test > 9){
				System.out.println("Please enter a value between 1 and 9!");
				return false;
			}
			
			return true;
		}
		catch(NumberFormatException e){	//if entered value is not valid throw an exception
			System.out.println("Please enter a value between 1 and 9!");
			return false;
		}
	}

	/**
	 * Prints the current state of the Tic Tac Toe board.
	 */
	public static void printBoard(){//Prints the current state of the Tic Tac Toe board.
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

	/**
	 * Initializes the game board with numbers 1 to 9.
	 */
	public static void initializeBoard(){// Initializes the game board with numbers 1 to 9.
		char num='1';
		for(int i=0;i<rows;i++){
			for (int j=0;j<cols;j++){
				board[i][j]= num;
				num++;
				}
		}
	}

	/**
	 * Checks if the specified cell is empty.
	 *
	 * @param nextMove the move number (1-9) to check
	 * @return true if the cell is empty, false otherwise
	 */
	static boolean isempty(int nextmove){//Checks whether the cell coordinate received from the user is empty.
		/*1 00 2 01 3 02
		4 10 5 11 6 12
		7 20 8 21 8 22
		*/
		int rows=(nextmove-1)/3;//The coordinate values ​​on the created board are from 1 to 9. I divided it into row and col coordinates and did the operations.
		int cols=(nextmove-1)%3;
		
		if (board[rows][cols]!='X'&&board[rows][cols]!='O'){//Check if there is 'X' or 'O' in row and col values
				return true;
		}
		else{
				return false;
		}
	}

	/**
	 * Checks if there are no moves left on the board.
	 *
	 * @return true if no moves left, false otherwise
	 */
	static boolean noMoveLeft(){// Checks if there are no moves left on the board.
		
		for (int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(board[i][j]!='X'&&board[i][j]!='O')
				{
					return false;
				}
			}
		}
		
		return true;//If all cells are full, there is no move to make.
	}

	/**
	 * Makes a move on the board for the current player.
	 *
	 * @param nextMove the move number (1-9)
	 */
	static void makeMove(int nextMove)//Move is made to the coordinate received from the user
	{
		int rows=(nextMove-1)/3;
		int cols=(nextMove-1)%3;  
		board[rows][cols]=currentPlayer;
	}

	/**
	 * Checks if the current player has won the game.
	 *
	 * @return true if the current player is the winner, false otherwise
	 */
	static boolean winner()
	{
		for(int i=0;i<3;i++)
		{
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