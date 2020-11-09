#pragma once
#include <stdlib.h>

struct Datum{
  char tag;
  char monat;
  int jahr;
}; 

struct Person{
  char vorname[50];
  char nachname[50];
  Datum geburtstag;
};

struct Knoten {
  Person p;
  Knoten *link;
};

Person *binarysearchPerson(char const vorname[]);
void bubblesort();
void addPerson(Person *p);
Person showPerson(const Person *p);
