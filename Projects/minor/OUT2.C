#include<stdio.h>
#include<conio.h>
void main()
{
int i;
clrscr();

for(i=2;i<=10;i++)
{
switch(i)
{
case 2:
printf("O");
continue;
case 3:
break;
case 4:
 case 5:
 printf("H");
 break;
 default:
 printf("!");
 }

 }getch();
 }
