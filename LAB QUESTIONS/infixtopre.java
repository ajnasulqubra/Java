import java.util.Scanner;
import java.util.Stack;


public class infixtopre {
    static int order(char c)
    {
    switch( c)
    {
        case '+':
        case '-':
        return 1;
        case '*':
        case '/':
        return 2;
        case '^':
        return 3;
    }
    
    return -1;
}
static String rev(String exp)
{
    String reverse="";
    Stack<Character> a= new Stack<Character>();
    
    for(int i=0;i<exp.length();i++)
    {
        char c=exp.charAt(i);
        a.push(c);
    }
    while(!a.empty())
    {
        
        reverse+=a.pop();
    }
    return reverse;

}
static String intopost(String exp)
{
    String result = new String("");
    Stack<Character> s= new Stack<Character>();
    for(int i=0;i<exp.length();i++)
    {
        char c=exp.charAt(i);
        if(Character.isLetterOrDigit(c))
        {
            result+=c;
           
        }
        else if(c=='(')
        {
            s.push(c);
        }
        else if (c==')')
        {
            while(!s.empty()&& s.peek()!='(')
            {
                result+=s.peek();
               
                s.pop();
            }
            s.pop();
        }
        else{
            while(!s.empty()&&order(c)<=order(s.peek()))
            {
                
                    result+=s.peek();
                    
                    s.pop();
                
            }
            s.push(c);

            
        }
        
        
        }
        
        while(!s.isEmpty())
        {
         if (s.peek() == '(')
            return "Invalid Expression";
        result += s.peek();
        
        s.pop();
    }
    return result;
}
public static void main(String[] args) {
    String exp,reverse;
    Scanner input =new Scanner(System.in);
    System.out.println("Enter the expression:");
    exp=input.nextLine();
    reverse=rev(exp);
    
    System.out.println("Prefix is "+ rev(intopost(reverse)) );
}
}
