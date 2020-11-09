#pragma once // guard

struct Datum {
  char tag; // komponente
  char monat; // komponente
  int jahr;
};

struct Person { // verschachtelte Struktur
  char vornamen[50];
  char nachnamen[50];
  Datum geburtstag; // Struktur in einer Struktur
};

Person *getter(int index);
int ager(const Datum *datum);
