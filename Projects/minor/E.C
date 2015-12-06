#include<stdio.h>
#include<conio.h>
void main()
{
int i,j,k;
clrscr();
for(i=6;i>=1;i--)
{
for(j=1;j<=(i-1);j++)
{
printf(" ");
}
for(k=6;k>=i;k--)
{
printf("*");
}
printf("\n");

}
getch();
}

