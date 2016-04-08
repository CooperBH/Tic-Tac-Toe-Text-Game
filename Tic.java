import java.util.Scanner;

public class Tic{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in); // Scanner object for taking input
		char[][] board = new char[][]{{'*','*','*'} , {'*','*','*'},{'*','*','*'}}; //Board in 2 dimensions
		boolean quit = false; //Quit bool, if true, quit
		int turn = 1;//The number turn it is
		
		while(quit == false){//Turn loop
			System.out.println();//Space, for neatness
			//System.out.println("Would you like to quit? Enter true or false. ");
			//quit = in.nextBoolean();//Quit check
			board = input(board, turn);//Input values into the board
			turn = turn + 1;// Add an integer to turn to indicate that the other player is having a turn
			
			display(board);//Display board
			
			System.out.println();// Space, for neatness
			
			quit = true;// Auto quit unless indicated that no solution was found
			
			quit = check(board, quit);//Check for solutions, if found, print winner, then quit
		}
	}
	
	static void display(char[][] board){//Display whole board
		for(char element: board[0]){
			System.out.print(element + " ");//Print
		}
		System.out.println();//Go to next line
		for(char element: board[1]){
			System.out.print(element + " ");//Print
		}
		
		System.out.println();//Go to next line
		for(char element: board[2]){
			System.out.print(element + " ");//Print
		}
	}
	
	static char[][] input(char[][] board, int turn){//Input on board
		Scanner in = new Scanner(System.in);
		
		int temp_x = 0;
		int temp_y = 0;
		do {
		System.out.println("What x coordinate do you want to input on? : ");//Ask for x coordinate
		temp_x = in.nextInt() - 1;
		System.out.println("What y coordinate do you want to input on? : ");//Ask for y coordinate
		temp_y = in.nextInt() - 1;
		} while(board[temp_y][temp_x] == 'X' || board[temp_y][temp_x] == 'O');
		
		if(turn % 2 == 0){
			board[temp_y][temp_x] = 'X';
		}
		else{
			board[temp_y][temp_x] = 'O';
		}
		
		return board;
	}
	
	static boolean check(char[][] board, boolean quit){//Check for solutions
		if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != '*'){//Top across
			System.out.println("You win!! 1");
		}
		else if(board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] != '*'){//Middle across
			System.out.println("You win!! 2");
		}
		else if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != '*'){//Bottom across
			System.out.println("You win!! 3");
		}
		
		else if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] != '*'){//Left vertical
			System.out.println("You win!! 4");
		}
		else if(board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] != '*'){//Middle vertical
			System.out.println("You win!! 5");
		}
		else if(board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] != '*'){//Right vertical
			System.out.println("You win!! 6");
		}
		
		else if(board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '*'){//Left to right diag 
			System.out.println("You win!! 7");
		}
		else if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '*'){//Right to left diag
			System.out.println("You win!! 8");
		}
		
		else {quit = false;}// See quit = true
		
		return quit;
	}
}