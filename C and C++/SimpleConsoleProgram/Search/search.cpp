#include "search.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

static Person *array = NULL;
static int n = 0;
static Knoten *z = NULL;

void addPerson(const Person *p)
{
  if (n == 0)
  {
        array  = new Person[n+1];
      array[n] = *p;
      n++;
  }
  else
  {
      Person *tmpArray = array;
      array  = new Person[n+1];
      for (int i =0; i<n; i++){
          array[i] = tmpArray[i];
      }
      array[n] = *p;
      delete tmpArray;
      n++;

  }
}

Person *searchPerson(const char firstName[] , const char lastName[] )
{
   for (int i = 0; i<n; i++)
     {
       if (( strcasecmp(firstName, array[i].vorname) == 0) && ( strcasecmp(lastName, array[i].nachname) == 0))
	 {
	   printf("%s %s\n",array[i].vorname, array[i].nachname);
	   printf("%d.%d.%d\n",array[i].geburtstag.tag,array[i].geburtstag.monat,array[i].geburtstag.jahr);
          return &array[i];
	 }

     }
  return NULL;
}

void showPerson()
{
  Knoten *i = z;
  while (i != NULL)
    {
      printf("%s %s\n", i->p.vorname, i->p.nachname);
      i = i->link;
    }
}

void deletePerson(void showPerson())
{
  Knoten *k = z;
  z = z->link;
  delete k;
}
