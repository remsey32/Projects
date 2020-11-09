static int zaehler = 0; // modullokale variable

int fibo(int n)
{
  zaehler++;
  if (n <= 2)
    {
      return(1);
    }
  int f1 = fibo(n-1);
  int f2 = fibo(n-2);
  int f3 = f1 + f2;
  return(f3);
}

int getcount() // zugriffsfunktion
{
  return(zaehler);
}
