#include <stdlib.h>
#include "struct.h" // eigene header file includieren

static Person personen[6] =
  {
    "Forest", "Whitaker", {15, 7, 1961},
    "Tricia", "Vessey", {8, 10, 1972},
    "Steve", "Buscemi", {13, 12, 1957},
    "Frances", "McDormand", {23, 6, 1957},
    "Jeff", "Bridges", {4, 12, 1949},
    "John", "Goodman", {20, 6, 1952}
  };

Person *getter(int index)
{
  return(&personen[index]);
}

int ager(const Datum *datum)
{
  Datum d = {1, 7, 2019};
  int a;
  
  if (d.monat > datum->monat || (d.monat == datum->monat &&
				 d.tag >= datum->tag))
    
    a = d.jahr - datum->jahr;
  else 
    a = d.jahr - datum->jahr - 1;
  
  return(a);
}
