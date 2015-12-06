#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
int a,b,c;
float d;
clrscr();
printf("Enter 1st no.");
scanf("%d",&b);
printf("Enter 2nd no.");
scanf("%d",&c);
printf("Enter choice to be performed");
printf("1:- Addition \n 2:- Substraction \n 3:- Multiplication \n 4:- Division \n 5:- Modular Division ");
scanf("%d",&a);
if(a==1)
d=b+c;
else if(a==2)
d=abs(b-c);
else if(a==3)
d=b*c;
else if(a==4)
{
if(b<c)
d=b/c;
if(c>b)
d=c/b;
}
else if(a==5)
{
if(b>c)
d=b%c;
if(c>b)
d=c%b;
}
else
{
printf("Invalid choice");
exit();
}
printf("The output is=%f",d);
getch();
}



