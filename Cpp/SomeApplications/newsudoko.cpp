#include <iostream>
#include <vector>
#include <limits>

using namespace std;

class SudokuSolver
{
public:
    virtual bool Solve() const = 0;      
    virtual void printBoard() const = 0; 
};

class SudokuBoard : public SudokuSolver
{
public:
   
    SudokuBoard(vector<vector<int>> &sudoko) : board(sudoko) {}

private:
    vector<vector<int>> &board; 
    vector<vector<int>> initialState = board;

public: 
    void printBoard() const override
    {
        for (int row = 0; row < 9; row++)
        {
            for (int col = 0; col < 9; col++)
            {
                if (col == 3 || col == 6)
                    cout << " | ";
                cout << board[row][col] << " ";
            }
            if (row == 2 || row == 5)
            {
                cout << endl;
                for (int i = 0; i < 9; i++)
                    cout << "---";
            }
            cout << endl;
        }
    }

    bool valid(int row, int column, int p) const
    {
        // check row wise

        for (int i = 0; i < 9; i++)
        {
            if (board[row][i] == p)
            {
                return false;
            }
        }

        // check column wise

        for (int j = 0; j < 9; j++)
        {
            if (board[j][column] == p)
            {
                return false;
            }
        }

        // checking in a box

        // row start index for that box  4,4
        int rs = row / 3 * 3;
        // row end will be rs +2  ex : 3 , 4 , 5(3+2);
        int cs = column / 3 * 3;
        // same for column

        for (int r_i = rs; r_i < rs + 3; r_i++)
        {
            for (int c_i = cs; c_i < cs + 3; c_i++)
            {
                if (board[r_i][c_i] == p)
                {
                    return false;
                }
            }
        }
        return true;
    }

    bool Solve() const override
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == 0)
                {
                    for (int k = 1; k < 10; k++)
                    {
                        if (valid(i, j, k))
                        {
                            board[i][j] = k;

                            // recursive call

                            if (Solve())
                            {
                                return true;
                            }

                            else
                            {
                                board[i][j] = 0;
                            }
                        }
                    }
                    return false; // if it checks and completes the for loop means it didn't find any correct match
                }
            }
        }
        return true; // just for conveying that this is bool return type (it doesn't matter as all the step happen before reaching here)
    }

    void playGame()
    {

        int row, col, num;
        while (true)
        {
            printBoard();
            cout << endl
                 << endl;
            cout << "Unable to solve? Enter -1 as row, col and num to view the solved sudoku." << endl;
            cout << "Enter row: ";

             if (!(cin >> row) || row < -1 || row > 8)
            {
               
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignore the remaining characters in the input buffer
                continue;
            }
            cout << "Enter column: ";
            if (!(cin >> col) || col < -1 || col > 8)
            {
                cout << "Invalid input. Please enter a valid column number (-1 to view the solved Sudoku)." << endl;
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                continue;
            }
            cout << "Enter number: ";
            if (!(cin >> num) || num < -1 || num > 9)
            {
                cout << "Invalid input. Please enter a valid number (-1 to view the solved Sudoku)." << endl;
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                continue;
            } 

            if (row == -1 || col == -1 || num == -1)
            {
                Solve();
                printBoard();
                cout << endl;
                cout << "Better luck next time!!!" << endl;
                return;
            }
            if (isSolvedCompletely())
                break;
            row--;
            col--;
            if (valid(row, col, num))
            {
                board[row][col] = num;
            }
            else
            {
                cout << "Invalid move. Try again." << endl;
            }
        }

        // Check if the user has solved it correctly or not
        bool solved = true;
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (board[i][j] == 0)
                {
                    solved = false;
                    break;
                }
            }
        }

        if (solved)
        {
            cout << "Congratulations! You have solved the puzzle." << endl;
            printBoard();
        }
        else
        {
            cout << "Puzzle not solved. Better luck next time." << endl;
        }
    }
    bool isSolvedCompletely()
    {
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 9; col++)
                if (board[row][col] == 0)
                    return false;

        return true;
    }

public:
    void resetBoard()
    {
        board = initialState; // Replace with your initial board data(value)
    }
};
int main()
{
    vector<vector<int>> sudoko = {
        {9, 5, 7, 0, 1, 3, 0, 8, 4},
        {4, 8, 3, 0, 5, 7, 1, 0, 6},
        {0, 1, 2, 0, 4, 9, 5, 3, 7},
        {1, 7, 0, 3, 0, 4, 9, 0, 2},
        {5, 0, 4, 9, 7, 0, 3, 6, 0},
        {3, 0, 9, 5, 0, 8, 7, 0, 1},
        {8, 4, 5, 7, 9, 0, 6, 1, 3},
        {0, 9, 1, 0, 3, 6, 0, 7, 5},
        {7, 0, 6, 1, 8, 5, 4, 0, 9}};

    SudokuBoard board(sudoko); // Create a SudokuBoard object

    cout << "\t\t\t<================================================================================>" << endl;
    cout << "\t\t\t|                        WELCOME TO SUDOKU Game!                                 |" << endl;
    cout << "\t\t\t|       Fill in the missing numbers(represented by 0) to solve the puzzle.       |" << endl;
    cout << "\t\t\t<================================================================================>" << endl;
    board.printBoard();

    // for(int i= 0; i< 9; i++){
    //     for(int j= 0; j< 9; j++)
    //         cout<<sudoko[i][j]<<" ";
    //         cout<<"\n";
    // }
    //
    cout << endl;
    while (true)
    {

        int choice;
        cout << endl
             << endl;
        cout << "\t\t[1] Solve the Sudoku" << endl;
        cout << "\t\t[2] Unable to solve? View the solved Sudoku" << endl;
        cout << "\t\t[3] Exit" << endl;
        cout << "\t\tEnter your choice: ";
        cout << endl;
        cin >> choice;

        switch (choice)
        {
        case 1:
            board.playGame();
            board.resetBoard();

            break;
        case 2:
            if (board.Solve())
            {
                cout << "Completely Solved Sudoku is: " << endl;
                cout << endl
                     << endl;
                board.printBoard();
                cout << endl;
                cout << "Better luck next time!!!" << endl;
                board.resetBoard();
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

            // if (row > 0 && row < 10   || col > 0 && col < 10 || num > 0 && num < 10 )
            // {
            //     continue;
            // }
            // else
            // {
            //     cout << "enter correct input";
            //     cin >> row;
            // }




            // try
            // {
            //     cin >> row >> col >> num
            // }
            // catch(exception)
            // {
            //     cout << e.what();
            // }
            // if (row > 0 && row < 10   || col > 0 && col < 10 || num > 0 && num < 10 )
            // {
            //     continue;
            // }
            // else
            // {
            //     cout << "enter correct input";
            //     cin >> row;
            // }