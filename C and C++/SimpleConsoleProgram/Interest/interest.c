#include <stdio.h>
#include <math.h>

/*
 Es wird die Zeit berechnet, bis zu der sich ein Geldbetrag durch Zins und
 Zinseszins verdoppelt. Die Ergebnisse werden in einer Tabelle angezeigt.
 
 @author Sven Remy
 */

int verdoppelung(float sk, float z);
void tabelle(float z, int y);

int main()
{
  printf("|  Interest  | Year |\n");

  float sk = 1000;
  float z = 0.1;
  for (int i = 0; i < 10; i++)
    { 
      int y = verdoppelung(sk,z);
      tabelle(z,y);
      z = z + 0.1;
    }
  
  return(0);
}

int verdoppelung (float sk, float z)
{
  int endCapital = sk * 2;
  sk = sk;
  int y = 1;
  
  while (sk < endCapital)
    {
      float step1 = 1 + z / 100;
      float step2 = pow(step1,1);
      sk = sk * step2;
      y = y + 1;
    }
  return(y);
}

void tabelle(float z, int y)
{
  printf("|  %f  |  %d  |\n",z,y);
}
