#include<stdio.h>
#include<conio.h>
void main()
{
  int a,i,j,k;

clrscr();
printf("Enter butterfly's figure");
scanf("%d",&a);
if(a%2==0)
k=a/2;
else
k=(a+1)/2;
for(i=1;i<=a;i++)
{
for(j=1;j<=a;j++)
{

if(i<=k)
{
if(j<=i || j>(a-i) )
{
printf("*");
}
else
{
printf(" ");
}
}

else
{
if(j<=(a+1-i) || (j>=i))
printf("*");
else
printf(" ");
}
}
printf("\n");
}

getch();
}