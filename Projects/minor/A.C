#include<stdio.h>
#include<conio.h>
void main()

{
int j=4,n=1,b=9,i,c=4,k;
  clrscr();
for(i=1;i<=5;i++)
{
for(j=c;j>=0;j--)
{
printf(" ");
}
c-=1;
for(k=1;k<=n;k++)
{
printf("*");
}
b-=2;
n+=2;
printf("\n");
}  getch();  }