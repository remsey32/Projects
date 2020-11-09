#include <stdio.h>
#include <stdlib.h>
#include "search.h"

/*
 Das Programm sucht eine bestimmte Person über den Vor- und Nachnamen. Die
 gefundene person wird über einen Zeiger zurückgegeben. Wird keine passende Person
 gefunden wird der NULL-Zeiger zurückgegeben.
 
 @author Sven Remy
 */

int main(){
static Person personen[6] =
  {
    "Forest" , "Whitaker", {15, 7, 1961},
    "Tricia" , "Vessey", {8, 10, 1972},
    "Steve" , "Buscemi", {13, 12, 1957},
    "Frances" , "McDormand", {23, 6, 1957},
    "Jeff" , "Bridges", {4, 12, 1949},
    "John" , "Goodman", {20, 6, 1952},
  };

 for (int i = 0; i < 6; i++){
   addPerson(&personen[i]);
 }

 Person me = {"Sven" , "Remy" , {23, 11, 1997}};
   addPerson(&me);

   Person found = *searchPerson("Sven","Remy");
   
   return(0);
}
