#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
int i,j,k,n=9;
clrscr();
for(i=1;i<=5;i++)
{

for(j=1;j<=(i-1);j++)
printf(" ");

for(k=1;k<=n;k++)
printf("*");
n-=2;
printf("\n");
}
getch();
}
