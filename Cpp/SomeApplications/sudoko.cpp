// first solve a matrix with its solve function.
// then printing that grid in a good way ..

// if time permits implement hard , easy modes with ncurses after eval (if possi) ..

#include<iostream>
#include <vector>
using namespace std;

void printBoard(vector<vector<int>> &sudoko) {

   
    for (int row = 0; row < 9; row++){
      for (int col = 0; col < 9; col++){
         if(col == 3 || col == 6)
            cout << " | ";
         cout << sudoko[row][col] <<" ";
      }
      if(row == 2 || row == 5){
         cout << endl;
         for(int i = 0; i<9; i++)
            cout << "---";
      }
      cout << endl;
   }
}

// p - placed element
 bool valid(vector<vector<int>> &sudoko , int row , int column , int p)
 {
    // check row wise

    for(int i = 0 ;  i < 9 ; i++)
    {
        if(sudoko[row][i] == p)
        {
            return false;
        }
    }

    // check column wise

    for(int j = 0 ;  j < 9 ; j++)
    {
        if(sudoko[j][column] == p)
        {
            return false;
        }
    }

    // checking in a box

    // row start index for that box 
    int rs = row/3 * 3 ;
    // row end will be rs +2  ex : 3 , 4 , 5(3+2);
    int cs = column/3 * 3 ;
    // same for column

    for(int r_i = rs ; r_i < rs + 3 ; r_i++)
    {
        for(int c_i = cs ; c_i < cs + 3 ; c_i++)
        {
            if(sudoko[r_i][c_i] == p)
            {
                return false;
            }
        }
    }
    return true;
    
 }
 bool Solve(vector<vector<int>> &sudoko)
{
   for(int i = 0 ; i < 9 ; i++)
   {
    for(int j = 0 ; j < 9 ; j++)
    {
        if(sudoko[i][j] == 0)
        {
            for(int k = 1 ; k < 10 ; k++)
            {
                if(valid(sudoko,i,j,k))
                {
                    sudoko[i][j] = k ;

                    // recursive call 

                    if(Solve(sudoko))
                    {
                        return true;
                    }

                    else
                    {
                        sudoko[i][j] = 0;
                    }
                }
            }
            return false; // if it checks and completes the for loop means it didn't find any correct match
        }
    }
   }
   return true; // just for conveying that this is bool return type (it doesn't matter as all the step happen before reaching here)
}
bool isSolvedCompletely(vector<vector<int>> &dummy)
{
    for (int row = 0; row < 9; row++)
        for (int col = 0; col < 9; col++)
            if (dummy[row][col] == 0)
                return false;

    return true;
}
void playGame(vector<vector<int>> &dummy)
{
      int ch;
    int row, col, num;
    while(true){
        printBoard(dummy);
        cout << endl << endl;
        cout << "Unable to solve? Enter -1 as row, col and num to view the solved sudoku."<<endl;
        cout << "Enter row: ";
        cin >> row;
        cout << "Enter column: ";
        cin >> col;
        cout << "Enter number: ";
        cin >> num;

        if(row == -1 || col == -1 || num == -1){
           Solve(dummy);
            printBoard(dummy);
            cout << endl;
            cout << "Better luck next time!!!" << endl;
            return;
        }
        if (isSolvedCompletely(dummy))
            break;
        row--;
        col--;
        if (valid(dummy, row, col, num)) {
            dummy[row][col] = num;
           
            
        }
        else
        {
         cout <<"Invalid move. Try again." << endl;
        }
    

    }

    // Check if the user has solved it correctly or not
    bool solved = true;
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (dummy[i][j] == 0) {
                solved = false;
                break;
            }
        }
    }

    if (solved) {
        cout << "Congratulations! You have solved the puzzle." << endl;
        printBoard(dummy);
        
    }
    else {
        cout << "Puzzle not solved. Better luck next time." << endl;
    }


}
int main()
{
    //    system("color BO");
  
  vector<vector<int>>sudoko 
    {
    {9, 5, 7, 0, 1, 3, 0, 8, 4},
    {4, 8, 3, 0, 5, 7, 1, 0, 6},
    {0, 1, 2, 0, 4, 9, 5, 3, 7},
    {1, 7, 0, 3, 0, 4, 9, 0, 2},
    {5, 0, 4, 9, 7, 0, 3, 6, 0},
    {3, 0, 9, 5, 0, 8, 7, 0, 1},
    {8, 4, 5, 7, 9, 0, 6, 1, 3},
    {0, 9, 1, 0, 3, 6, 0, 7, 5},
    {7, 0, 6, 1, 8, 5, 4, 0, 9}
};

vector<vector<int>>dummy
    {
    {9, 5, 7, 0, 1, 3, 0, 8, 4},
    {4, 8, 3, 0, 5, 7, 1, 0, 6},
    {0, 1, 2, 0, 4, 9, 5, 3, 7},
    {1, 7, 0, 3, 0, 4, 9, 0, 2},
    {5, 0, 4, 9, 7, 0, 3, 6, 0},
    {3, 0, 9, 5, 0, 8, 7, 0, 1},
    {8, 4, 5, 7, 9, 0, 6, 1, 3},
    {0, 9, 1, 0, 3, 6, 0, 7, 5},
    {7, 0, 6, 1, 8, 5, 4, 0, 9}
};
 // system("cls");
    cout << "\t\t\t<================================================================================>" << endl;
    cout << "\t\t\t|                        WELCOME TO SUDOKU Game!                                 |" << endl;
    cout << "\t\t\t|       Fill in the missing numbers(represented by 0) to solve the puzzle.       |" << endl;
    cout << "\t\t\t<================================================================================>" << endl;
   printBoard(dummy);
   

    // for(int i= 0; i< 9; i++){
    //     for(int j= 0; j< 9; j++)
    //         cout<<sudoko[i][j]<<" ";
    //         cout<<"\n";
    // }
    // 
    cout<<endl;
   while (true) {

        int choice;
        cout << endl << endl;
        cout << "\t\t[1] Solve the Sudoku" << endl;
        cout << "\t\t[2] Unable to solve? View the solved Sudoku" << endl;
        cout << "\t\t[3] Exit" << endl;
        cout << "\t\tEnter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                playGame(dummy);
                dummy = sudoko;
                break;
            case 2:
                if (Solve(sudoko))
                {
                    cout << "Completely Solved Sudoku is: "<< endl;
                    cout << endl << endl;
                    for (int row = 0; row < 9; row++){
                        for (int col = 0; col < 9; col++){
                            if(col == 3 || col == 6)
                                cout << " | ";
                            cout << sudoko[row][col] <<" ";
                        }
                        if(row == 2 || row == 5){
                            cout << endl;
                            for(int i = 0; i<9; i++)
                                cout << "---";
                        }
                        cout << endl;
                    }
                    sudoko = dummy;
                    cout << endl;
                    cout << "Better luck next time!!!" << endl;
                }
                else
                    cout << "No solution found" << endl;
                break;
            case 3:
                exit(0);
            default:
                cout << "Invalid choice" << endl;
      
     }
   }
     
    return 0;


   }
  