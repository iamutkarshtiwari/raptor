#include<stdio.h>
#include<conio.h>
void main()
{
int c;
float area,l,b,r,h,base;
 clrscr();
printf("What do you wanna do? \n Enter your choice \n");
printf("1:-Rectangle \n 2:-Circle \n 3:-Triangle \n");
scanf("%d",&c);
switch(c)
{
case 1:
{
printf("Enter length \n");
scanf("%f",&l);
printf("Enter breadth \n");
scanf("%f",&b);
area=l*b;
break;
}
case 2:
{
printf("Enter circle's radius");
scanf("%f",&r);
area=(22.0/7.0)*r*r;
break;
}
case 3:
{
printf("Enter triangle's heigth");
scanf("%f",&h);
printf("Enter triangle's base");
scanf("%f",&base);
area=(1.0/2.0)*(base*h);
break;
}
default:
{
printf("Invalid choice");
} }
printf("The area is=%f",area);
getch();
}



