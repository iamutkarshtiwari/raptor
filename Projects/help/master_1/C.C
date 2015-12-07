#include<stdio.h>
#include<conio.h>
void main()
{
int i,j,k,t,c;
clrscr();
for(i=5;i>=1;i--)
{      t=0,c=0;
for(j=1;j<i;j++)
{
printf(" ");
c+=1;
}
while(c!=5)
{
   t+=1;
  printf("%d",t);

  c+=1;
}
while(t!=1)
{
--t;
printf("%d",t) ;
}
printf("\n");
}
getch();
}