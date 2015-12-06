#include<stdio.h>
#include<conio.h>
void  main()
{
int j,x=0;
for(j=0;j<=5;j++)
{
switch(j-1)
{
case 0:
case -1:
x+=1;
break;
case 1:
case 2:
case 3:
x+=2;
break;
default:
x+=3;
}
printf("%d",x);
}getch();
}
