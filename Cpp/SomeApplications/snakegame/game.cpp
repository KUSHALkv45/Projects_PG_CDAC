#include <iostream>
// #include <unistd.h>

#include<conio.h>
#include <unistd.h>
// #include <winbase.h>  Sleep(50); in draw() ;


using namespace std ;

bool gameover ;


const int width = 40;
const int height = 40;

int x,y ;

int fruitx , fruity;

int score;

enum direction { STOP = 0 , LEFT  ,RIGHT , UP , DOWN } ;

direction dir;

int tailx[100] , taily[100];

int tailsize;

// setup function :

void setup()
{   
    // intializing the position for starting position
    gameover = false;
    dir = STOP;
   
    x = width/2;
    y = height/2;

    fruitx = rand() % width;
    fruity = rand() % height;

    score = 0;
}

void draw()
{
  system("cls"); 

//   border
   for (int i = 0; i <= width; i++) {
        cout << "#";
    }
    cout << endl;

    for (int i = 0; i < height; i++) {
        for (int j = 0; j <= width; j++) {
            if (j == 0 || j == width) {
                cout << "#";
            } else if (i == y && j == x) {
                cout << "O"; // Snake head
            } else if (i == fruity && j == fruitx) {
                cout << "F"; // Fruit
            } else {
              bool print = false;
              for(int k = 0; k< tailsize ; k++)
              {
                
                if(tailx[k] == j && taily[k] == i)
                {
                  print = true;
                   cout << "=" ;
                }
                
                
              }
              if(!print)
                {
                   cout << " "; // Empty space
                }
               
            }
        }
        cout << endl;
    }

    // Draw bottom border
    for (int i = 0; i <= width; i++) {
        cout << "#";
    }
    cout << endl;

    cout << " SCORE : " << score << endl ;

   
}

void input()
{
  if(_kbhit())
  {
    switch(_getch())
    {
      case 'a' :
      dir = LEFT;
      break;
       case 'w' :
      dir = UP;
      break;
       case 's' :
      dir = DOWN;
      break;
       case 'd' :
      dir = RIGHT;
      break;
       case 'x' :
     gameover = true;
      break;


    }
  }
}

void logic()
{
  int prevx = tailx[0];
  int prevy = taily[0];

  int prev2x ,  prev2y;
   
  tailx[0] = x;
  taily[0] = y;
  for(int i = 1 ; i < tailsize ; i++)
  {
    prev2x = tailx[i] ;
    prev2y = taily[i];
    
    tailx[i] = prevx;
    taily[i] = prevy;

    prevx = prev2x;
    prevy = prev2y;
  }
    switch(dir)
    {
        case LEFT :
        x--;
        break;
        case RIGHT :
        x++;
        break;
        case UP :
        y--;
        break;
        case DOWN :
        y++;
        break;
        default:
        break;
    }

    if(x > width || x < 0 || y > height || y < 0)
    {
      gameover = true;
    }
    for(int i = 0; i< tailsize ; i++)
    {
      if(tailx[i] == x and taily[i] == y)
      {
        gameover = true;
      }
    }
    if(x == fruitx && y == fruity)
    {
      score += 5;

      fruitx = rand() % width;
      fruity = rand() % height;

      tailsize++;
    }
}
int main()
{
  setup();

    while(!gameover)
    {
       
        draw();
        input();
        logic();
     
        //  sleep(100) ;
        
    }
    return 0;
}