package org.example;
import java.util.Scanner;
import java.util.Vector;

public class ArithmeticApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // take the base value
        System.out.println("Enter base (2/8/10/16):");
        String S_base = input.nextLine();
        while(!(S_base.equals("2") || S_base.equals("8") || S_base.equals("10") || S_base.equals("16"))){
            System.out.println("Error – this base isn’t supported. Please enter a base (2/8/10/16):");
            S_base = input.nextLine();
        }
        int base = Integer.parseInt(S_base);
        System.out.println("Enter expression:");
//        input.nextLine();
        String expression = input.nextLine();
        String new_expression = expression.replaceAll("\\s", "");
        String[] tokens = new_expression.split("(?<=\\+|-|\\*|/)|(?=\\+|-|\\*|/)");

        if (!valid_exp(tokens,expression,base)) {
            System.out.println("Error: invalid expression: \"\"");
            return;
        }
        Vector<String> vec = new Vector<String>();
        for (int i = 0; i < tokens.length; i++) {
            vec.add(tokens[i]);
        }
        // calculate the * and / first
        for (int i = 0; i < vec.size() - 1; i++) {
            if (vec.get(i).equals("*") || vec.get(i).equals("/")) {
                int res = -1;
                switch (vec.get(i)) {
                    case "*":
                        res = Integer.parseInt(vec.get(i - 1), base) * Integer.parseInt(vec.get(i + 1), base);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.add(i - 1, Integer.toString(res, base));
                        i--;
                        break;
                    case "/":
                        int denominator = Integer.parseInt(vec.get(i + 1), base);
                        if (denominator == 0) {
                            System.out.println("Error: trying to divide by 0 (evaluated: \"0\")");
                            return;
                        }
                        res = Integer.parseInt(vec.get(i - 1), base) / denominator;
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.add(i - 1, Integer.toString(res, base));
                        i--;
                        break;
                }

            }

        }

        // taking the results of the calculation of * / and just now after we did
        // all the * / calculation we will calculate the + -.
        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).equals("+") || vec.get(i).equals("-")) {
                int res = -1;
                switch (vec.get(i)) {
                    case "+":
                        int a= Integer.parseInt(vec.get(i - 1), base);
                        int b= Integer.parseInt(vec.get(i + 1), base);
                        res = Integer.parseInt(vec.get(i - 1), base) + Integer.parseInt(vec.get(i + 1), base);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.add(i - 1, Integer.toString(res, base));
                        i--;
                        break;
                    case "-":
                        res = Integer.parseInt(vec.get(i - 1), base) - Integer.parseInt(vec.get(i + 1), base);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.removeElementAt(i - 1);
                        vec.add(i - 1, Integer.toString(res, base));
                        i--;
                        break;
                }
            }

        }

        System.out.println("The value of expression " + expression + " is : " + vec.get(0).toUpperCase());
    }

    // this func checks if the expression is a valid
    // if valid retval true
    // else false
    public static boolean valid_exp(String[] tokens,String exp, int base) {
        boolean small_let = false;
        for(int i=0; i<exp.length(); i++){
            if(Character.isLowerCase(exp.charAt(i))){
                small_let = true;
            }
        }
        if (small_let){
            return false;
        }
        // case were we have a sign at the end or the start
        if((tokens[0].equals("+") || tokens[0].equals("-") || tokens[0].equals("*") || tokens[0].equals("/"))
                || (tokens[tokens.length - 1].equals("+") || tokens[tokens.length - 1].equals("-") || tokens[tokens.length - 1].equals("*") || tokens[tokens.length - 1].equals("/")))
        {
            return false;
        }
        for (int i = 0; i <= tokens.length - 1; i++) {

            if (!(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))) {
                try {
                    int num = Integer.parseInt(tokens[i], base);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            if ((i +1 !=tokens.length) && (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) &&
                    (tokens[i + 1].equals("+") || tokens[i + 1].equals("-") || tokens[i + 1].equals("*") || tokens[i + 1].equals("/"))) {
                return false;
            }
        }

        // check for 1 1 case
        boolean space = false;
        boolean reset =false;
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i)==' '){
                space = true;
            }
            else if(exp.charAt(i)=='+' || exp.charAt(i)=='-' || exp.charAt(i)=='*' || exp.charAt(i)=='/'){
                space = false;
                reset = true;
            }
            else {
                if(space && exp.charAt(i)!=' '){
                    if(!reset)
                    {
                        return false;
                    }
                    reset = false;
                    space = false;
                }
            }
        }
        return true;
    }

}
