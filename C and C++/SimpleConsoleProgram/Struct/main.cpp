#include <stdio.h>
#include "struct.h"

/*
 Das Alter a einer Person wird in Bezug auf ein bestimmtes Datum (hier der
 01.07.2019) berechnet. Dabei benutzt die Funktion Call-By-Reference.
 Das Programm gibt schlussendlich das gerundete Durchschnittsalter aller Personen im
 Strukturarray aus.
 
 @author Sven Remy
 */

int main (int argc, char *argv[])
{
  int ges = 0;
  for (int i = 0; i<6; i++) {
    Person *p = getter(i);
    ges += ager(&p->geburtstag);
  }
  int avg = ges/6;
  printf("age = %d\n", avg);
  
  return(avg);
}
