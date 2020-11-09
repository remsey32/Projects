#include <stdio.h>
#include <string.h>
#include <assert.h>
#include "sort.h"

/*
 Ähnlich wie bei Search wird hier eine Person über den Vor- und Nachnamen gesucht,
 jedoch wird der Datensatz mit dem "Bubble-Sort" zunächst sortiert (wenn er
 verändert wurde). Nach der Sortierung findet eine Binärsuche statt.
 
 @author Sven Remy
 */

int main()
{
  Person personen[6] =
  {
    "Forest", "Whitaker", {15, 7, 1961},
    "Tricia", "Vessey", {8, 10, 1972},
    "Steve", "Buscemi", {13, 12, 1957},
    "Frances", "McDormand", {23, 6, 1957},
    "Jeff", "Bridges", {4, 12, 1949},
    "John", "Goodman", {20, 6, 1952}
    };

  for (int i=0; i<6; i++)
    {
      addPerson(&personen[i]);
      }

  Person me = {"Sven", "Remy", {23, 11, 1997}};
  addPerson(&me);

  bubblesort();

  binarysearchPerson("Sven");
  
  return(0);
}
