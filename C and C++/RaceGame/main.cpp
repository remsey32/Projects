#include <ncurses.h>
#include <unistd.h>
#include <string.h>
#include <ctype.h>

#include "race.h"

int main()
{
  screen_setup();
  startscreen();
  
  endwin();
  
  return(0);
}
