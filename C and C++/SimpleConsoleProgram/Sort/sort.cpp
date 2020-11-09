#include "sort.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

static Person *array[7];
static int n = 0;
static Knoten *z = NULL;

Person *binarysearchPerson(char const vorname[])
{
  int l = 0;
  int r = n - 1;

  while (l <= r)
  {
    int m = l + ((r-l)/2);
    
    if (strcasecmp(vorname, array[m]->vorname) == 0)
      {
          printf("%s %s\n",array[m]->vorname, array[m]->nachname);
          printf("%d.%d.%d\n", array[m]->geburtstag.tag,
		 array[m]->geburtstag.monat,array[m]->geburtstag.jahr);
	  return(array[m]);
      }
    else
      {
	if(strcasecmp(vorname, array[m]->vorname)<0)
	  {
	    r = m - 1;
	  }
	else
	  {
	    l = m + 1;
	  }
      }
  }
  return(NULL);
}

void bubblesort()
{
  int i;
  int j;
  Person *temp;
  
  for(int i = 1; i < n; i++)
    {
      for(int j = 0; j < n - i; j++)
	{
	  if(strcasecmp(array[j]->vorname, array[j+1]->vorname)>0)
	    {
	      temp = array[j];
	      array[j] = array[j + 1];
	      array[j + 1]= temp;
	    }
	}
    }
}

void addPerson(Person *p)
{
  array[n] = p;
  n++;
}

void showPerson()
{
  for (int i = 0; i < n; i++)
    {
      printf("%s %s\n", array[i]->vorname, array[i]->nachname);
    }
}
