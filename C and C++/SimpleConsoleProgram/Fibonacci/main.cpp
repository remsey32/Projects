#include <stdio.h>
#include "fibo.h"

/*
Ein kleines Programm, dass den Funktionswert von fibo(n) mit einer beliebigen Zahl
für n (hier im Beispiel die 15) berechnet. Es wird zudem ausgegeben, wie häufig die
Funktion fibo(n) für n aufgerufen wird.
 
 @author Sven Remy
 */

int main()
{
  int n = 15;
  int x = fibo(n);
  printf("fibo(%d) = %d\n", n, x);

  int zaehler = getcount();
  printf("Zähler = %d\n", zaehler);

  return(zaehler);
}
