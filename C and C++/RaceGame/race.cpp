#include <ncurses.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>

#include "graphics.h"
#include "gridfont.h"
#include "race.h"

static int mx = 0, my = 0;
static int health = 3;
static int points = 0;
static int fps = 10;
static float dt = 1.0/fps;
static int us = 1000 * 1000 * dt;

// Screen wird gecleared
void screen_setup()
{
  initscr();
  curs_set(FALSE);
  noecho();
}

// Startscreen wird generiert
void startscreen()
{
  clear();
  colors();
  getmaxyx(stdscr, my, mx);
  
  // Race Logo & Aliencar Animation
  start_animation();
  
  // Starttext des Spiels
  const char start[] = "press s to start the race";
  int len = strlen(start);
  attrset(A_BOLD | A_BLINK);
  mvprintw(my/2, mx/2 - len/2, start);
  attrset(A_NORMAL);
  
  // Quit Text
  move(my-2, 1);
  printw("press q to quit");
  
  // Help Text
  move(my-2, mx-17);
  printw("press h for help");
  
  // Colored Frame -> blaue Umrandung
  color_set(4, NULL);
  border(ACS_VLINE, ACS_VLINE, ACS_HLINE, ACS_HLINE, ACS_ULCORNER, ACS_URCORNER,              ACS_LLCORNER, ACS_LRCORNER);
  color_set(1, NULL);
  
  // Menüoptionen im Startscreen
  while (int ch = getch())
    {
      if (tolower(ch) == 'q') break;
      if (tolower(ch) == 's') game_loop();
      if (tolower(ch) == 'h') helpscreen();
    }
}

// Helpscreen -> erklärt das Spiel & die Steuerung
void helpscreen()
{
  clear();
  
  const char w1[] = "WELCOME to RACE";
  int w1len = strlen(w1);
  color_set(6, NULL);
  mvprintw(3, mx/2 - w1len/2, w1);
  color_set(1, NULL);

  const char w2[] = "follow the aliens and bring back the MULTIGUN";
  int w2len = strlen(w2);
  mvprintw(4, mx/2 - w2len/2, w2);

  const char w3[] = "dodge the BULLETS, your HEALTH is 3";
  int w3len = strlen(w3);
  mvprintw(5, mx/2 - w3len/2, w3);

  const char w4[] = "the SCORE depends on the time";
  int w4len = strlen(w4);
  mvprintw(6, mx/2 - w4len/2, w4);

  const char w5[] = "the longer you SURVIVE, the higher is your SCORE ";
  int w5len = strlen(w5);
  mvprintw(7, mx/2 - w5len/2, w5);

  const char c[] = "controls:";
  int clen = strlen(c);
  color_set(6, NULL);
  mvprintw(9, mx/2 - clen/2, c);
  color_set(1, NULL);

  const char w[] = "press the key 'w' for up";
  int wlen = strlen(w);
  mvprintw(10, mx/2 - wlen/2, w);

  const char a[] = "press the key 'a' for left";
  int alen = strlen(a);
  mvprintw(11, mx/2 - alen/2, a);

  const char s[] = "press the key 's' for down";
  int slen = strlen(s);
  mvprintw(12, mx/2 - slen/2, s);
  
  const char d[] = "press the key 'd' for right";
  int dlen = strlen(d);
  mvprintw(13, mx/2 - dlen/2, d);

  const char q[] = "press 'q' to pause the game";
  int qlen = strlen(q);
  mvprintw(14, mx/2 - qlen/2, q);
  
  const char y[] = "YES, it is that simple";
  int ylen = strlen(y);
  mvprintw(15, mx/2 - ylen/2, y);

  const char f[] = "have FUN!";
  int flen = strlen(f);
  attrset(A_BOLD | A_BLINK);
  mvprintw(17, mx/2 - flen/2, f);
  attrset(A_NORMAL);

  // Quit Text
  move(my-2, 1);
  color_set(3, NULL);
  printw("press q to quit");
  color_set(1, NULL);

  // Colored Frame -> blaue Umrandung
  color_set(4, NULL);
  border(ACS_VLINE, ACS_VLINE, ACS_HLINE, ACS_HLINE, ACS_ULCORNER, ACS_URCORNER,              ACS_LLCORNER, ACS_LRCORNER);
  color_set(1, NULL);

  while(1)
    {
      int ch = getch();
      if (ch != EOF)
	{
	  if (tolower(ch) == 'q')
	    {
	      startscreen();
	      break;
	    }
       	}
    }
}

// Game Loop wird generiert
void game_loop()
{
  timeout(0);

  // Aufbau des Spiels
  while(1)
    {
      clear();
      draw_track();
      draw_cactus();
      draw_car();
      draw_bullet();
      draw_points();
      draw_health();
      
      if (health <= 0)
	{
	  game_over();
	  break;
        }
      
      refresh();
      usleep(us);
      
      // Mit q wird der Game Loop beendet und man landet im Startscreen
      int ch = getch();
      if (ch != EOF)
	{
	  if (tolower(ch) == 'q')
	    {
	      startscreen();
	      break;
	    }
	}
    }
}

// Game Over wird generiert
void game_over()
{ 
  clear();

  // Game Over Text mit gridfont
  const char gameover[] = "GAME OVER";
  init_grid_font();
  color_set(2, NULL);
  draw_grid_text(10, 18, gameover);
  color_set(1, NULL);

  // Anzeige des erreichten Scores
  move(my/2 + 2, mx/2 - 8);
  printw("Your Highscore: %d", points);
  
  // Quit Text
  move(my-2, 1);
  color_set(3, NULL);
  printw("press q to quit the game");
  color_set(1, NULL);
  
  refresh();
  usleep(us);
}

// Farben werden generiert
void colors()
{
  start_color();
  
  init_pair(1, COLOR_GREEN, COLOR_BLACK);
  init_pair(2, COLOR_RED, COLOR_BLACK);
  init_pair(3, COLOR_WHITE, COLOR_BLACK);
  init_pair(4, COLOR_BLUE, COLOR_BLACK);
  init_pair(5, COLOR_YELLOW, COLOR_BLACK);
  init_pair(6, COLOR_MAGENTA, COLOR_BLACK);
  init_pair(7, COLOR_CYAN, COLOR_BLACK);
}

// Startanimation wird generiert
void start_animation()
{
  // Startkoordinaten des Race Logos
  float rx = 15 , ry = 6;
  float drx = 20;
  
  // Race-Sprite
  const char race[] =
    " *******                            \n"                            
    "/**////**                           \n"                         
    "/**   /**   ******    *****   ***** \n"
    "/*******   //////**  **///** **///**\n"
    "/**///**    ******* /**  // /*******\n"
    "/**  //**  **////** /**   **/**//// \n"
    "/**   //**//********//***** //******\n"
    "//     //  ////////  /////   ////// \n";
  
  // Startkoordinaten des Aliencars
  float cx = mx , cy = 18;
  float dcx = 34;
  
  // Aliencar-Sprite
  const char alien_car[] =
    "                                  @                   \n"
    "               (__)    (__) _____/                    \n"
    "            /| (oo) _  (oo)/----/_____    *           \n"
    "  _o\\______/_|\\_\\/_/_|__\\/|____|//////== *- *  * -\n"
    " /_________   \\   00 |   00 |       /== -* * -       \n"
    "[_____/^^\\_____\\_____|_____/^^\\_____]     *- * -   \n"
    "      \\__/                 \\__/                     \n";
  
  // Animationsablauf
  for (int i = 0; i < 12; i++)
    {
      clear();
      rx += drx * dt;
      color_set(5, NULL);
      draw_sprite(ry, rx, race);
      color_set(1, NULL);
      cx -= dcx * dt;
      color_set(2, NULL);
      draw_sprite(cy, cx, alien_car);
      color_set(1, NULL);
      refresh();
      usleep(us);
    }
}

// Spielfigur -> Car
// AussehenG und Eigenschaften des Cars
void draw_car()
{
  // Startkoordinaten der Spielfigur
  static float cx = mx/2 , cy = my-4;
  // Geschwindigkeit
  static float dcx = 4, dcy = 2;
  
  // Spielfigur-Sprite
  const char car[] =
    "  ......   \n"       
    " (  '`' )  \n"      
    "(o\\..../o)\n"     
    "  #    #   \n";
  draw_sprite(cy, cx, car);
  
  // Bewegungssteuerung der Spielfigur
  int c = getch();
  while (getch() != EOF) {}
  switch (c)
    {
    case 'd':
      cx += dcx;
      break;
    case 'a':
      cx -= dcx;
      break;
    case 'w':
      cy -= dcy;
      break;
    case 's':
      cy += dcy;
      break;
    default:
      break;
    }			      
}

// Aussehen und Eigenschaften der Bullet -> Enemie
void draw_bullet()
{
  // Startkoordinaten der Bullet
  static float cx = mx/2 , cy = 2;
  // Geschwindigkeit der Bullet
  static float dcx = 10, dcy = 10;
  
  // Hinzufügen der ersten Bullet
  color_set(2, NULL);
  mvaddch(cy, cx, '*');
  color_set(1, NULL);

  // Hinzufügen der der restlichen Bullets, bei unterschieldicher Punktzahl
  // Bullet wir je bei höherer Punktzahl 'größer'
  if (points > 50)
    {
      color_set(2, NULL);
      mvaddch(cy - 3, cx, '*');
      color_set(1, NULL);
    }
  if (points > 100)
    {
      color_set(2, NULL);
      mvaddch(cy, cx - 3, '*');
      color_set(1, NULL);
    }
  if (points > 150)
    {
      color_set(2, NULL);
      mvaddch(cy + 3, cx, '*');
      color_set(1, NULL);
    }
  if (points > 200)
    {
      color_set(2, NULL);
      mvaddch(cy, cx + 3, '*');
      color_set(1, NULL);
    }
  if (points > 300)
    {
      color_set(2, NULL);
      mvaddch(cy, cx + 6, '*');
      mvaddch(cy + 6, cx, '*');
      mvaddch(cy, cx - 6, '*');
      mvaddch(cy - 6, cx, '*');
      color_set(1, NULL);
    }

  // Animation der Bullet
  cx += dcx * dt;
  cy += dcy * dt;

  // Kollision der Bullet mit dem Track
  int mask = A_CHARTEXT | A_ALTCHARSET;
  if (points < 250)
    {
      if (dcx < 0)
	{
	  int ch = mvinch(cy, cx-1) & mask;
	  if (ch != ' ' && ch != '-' && ch != '|') dcx = -dcx;
	}
      if (dcx > 0)
	{
	  int ch = mvinch(cy, cx+1) & mask;
	  if (ch != ' ' && ch != '-' && ch != '|') dcx = -dcx;
	}
      if (dcy < 0)
	{
	  int ch = mvinch(cy-1, cx) & mask;
	  if (ch != ' ' && ch != '-' && ch != '|') dcy = -dcy;
	}
      if (dcy > 0)
	{
	  int ch = mvinch(cy+1, cx) & mask;
	  if (ch != ' ' && ch != '-' && ch != '|') dcy = -dcy;
	}
    }
  // Restliche Kollision mit dem Bildschirmrand
  else
    {
      if (cx >= mx-1) dcx = -dcx;
      else if (cx <= 0) dcx = -dcx;
      if (cy >= my-1) dcy = -dcy;
      else if (cy <= 0) dcy = -dcy;
    }

  // Kollision der Bullet mit dem Car
  // Bei der Kollision verliert die Spielfigur eins von drei Leben
  int ch = mvinch(cy+1, cx) & mask;
  if (ch == '.') health--;
}

// Aussehen und Eigenschaften des Tracks 
void draw_track()
{
  const char track[] =
    "##-                                 -## \n"
    "##-               |                 -## \n"
    "##-                                 -## \n";
  
  for (int i = 0; i < 8; i++)
    {
      color_set(3, NULL);
      draw_sprite(i * 3 + 2, 35, track);
      color_set(1, NULL);
    }
}

// Aussehen und Eigenschaften der Kakteen
void draw_cactus()
{
  // Cactus-Sprite
  const char cactus[] =
    "  |  \n"
    "(_|_)\n"
    "  |  \n";
  draw_sprite(10,15, cactus);
  draw_sprite(18,5, cactus);
  draw_sprite(5,7, cactus);
  draw_sprite(22,75, cactus);
  draw_sprite(15,65, cactus);
}

// Healthanzeige wird generiert
void draw_health()
{
  color_set(5, NULL);
  move(5, 65);
  printw("HEALTH: %d", health);
  color_set(1, NULL);
}

// Pointsanzeige wird generiert
void draw_points()
{
  color_set(5, NULL);
  move(7, 65);
  printw("POINTS: %d", points);
  color_set(1, NULL);
  points++;
}
