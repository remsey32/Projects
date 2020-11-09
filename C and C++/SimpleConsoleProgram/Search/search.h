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

struct Knoten{
  Person p;
  Knoten *link;
};

void addPerson(const Person *p);
Person *searchPerson(const char firstName[] , const char lastName[] );
void showPerson();
void deletePerson();
