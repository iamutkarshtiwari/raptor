#include<stdio.h>
#include<conio.h>
void main()
{
int i,j,a,c,n;
float s;
 clrscr();

  printf("Enter a number");
  scanf("%d",&a);
  printf("Enter a choice to be performed \n");

  printf("1: Factorial \n 2: Prime or not \n 3: Odd/Even \n 4: N/-Nth power \n");

scanf("%d%",&c);
switch(c)
{
case 1:
{ i=1;
while(a!=0)
{
i=i*a;
a--;
}
printf("Factorial is= %d",i );
break;
}

case 2:
{
j=0;
for(i=1;i<=a;i++)
{
if(a%i==0)
j=j+1;
 }
if(j==2)
printf("Number is Prime");
else
printf("Number is Non-Prime");
break;
}

case 3:
{
if(a%2==0)
printf("Number is Even");
else
printf("Number is Odd");
break;
}

case 4:
{    s=1.0;
printf("Enter the intergral power");
scanf("%d",&n);
if(n>0)
{
for(i=1;i<=n;i++)
s=s*a;
}

if(n<0)
{
for(i=1;i<=(-n);i++)
{
s=s*a;
}
s=1.0/s;
}

if(n==0)
s=1.0;

printf("The %dth power of %dis= %f",n,a,s);
break;
}

default:
{
printf("Invalid Choice");
}
}
getch();
}