// import java.io.*;
import java.util.Scanner;
class stack
{
   char stack1[]=new char[20];
   int top;
   void push(char ch)
   {  System.out.println(ch +" ch");
      top++;
      // System.out.println(top);
      stack1[top]=ch;
      System.out.println(stack1[top]);
   }
   char pop()
   {
      char ch;
      ch=stack1[top];
      // System.out.println(ch +  "   pop");
      top--;
      return ch;
   }
   int pre(char ch)
   {
      switch(ch)
      {
         case '-':return 1;
         case '+':return 1;
         case '*':return 2;
         case '/':return 2;
      }
         // System.out.println("hiiiiiii");
      return 0;
   }
   boolean operator(char ch)
   {
      if(ch=='/'||ch=='*'||ch=='+'||ch=='-')
         return true;
      else
         return false;
   }
   boolean isAlpha(char ch)
   {
      if(ch>='a'&&ch<='z'||ch>='0'&&ch=='9')
         return true;
      else
         return false;
   }
   void postfix(String str)
   {
      char[] output=new char[str.length()];
      char ch;
      int p=0,i;
      for(i=0;i<str.length();i++)
      {
         ch=str.charAt(i); 
         if(ch=='(')
         {
            push(ch);
         }
         else if(isAlpha(ch))
         {
            output[p++]=ch;
         }
         else if(operator(ch))
         {
            if(stack1[top]==0||(pre(ch)>pre(stack1[top]))||stack1[top]=='(')
         {
            push(ch);
         }
         }
         else if(pre(ch)<=pre(stack1[top]))
         {
            output[p++]=pop();
            push(ch);
         }
         else if(ch=='(')
         {
            while((ch=pop())!='(')
            {
               output[p++]=ch;
            }
         }
      }
      while(top!=0)
      {
         output[p++]=pop();
      }
      for(int j=0;j<str.length();j++)
      {
         System.out.print(output[j]);  
      }
   }
}
class Test
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      // String temp = sc.nextLine();
      String s =sc.nextLine();;
      stack b=new stack();
      // System.out.println("Enter input string");
      // System.out.println("Input String:"+s);
      // System.out.println("Output String:");
      b.postfix(s);
   }
}