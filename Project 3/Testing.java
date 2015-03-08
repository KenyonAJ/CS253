import java.util.Random;

public class Testing
{
    public static void main(String[] args)
    {
        /**
         * Postfix form: AB*C/D+
         * ((2*5)/3)+7# --> 25*3/7+
         */
        NodeQueue<Character> testMe = infixToPostfix();
        System.out.println(postfixEvaluation(testMe));
    }

    public static void stackTest()
    {
        Random rand = new Random();

        NodeStack stack = new NodeStack();

        for (int i = 0; i < 10; i++)
        {
            stack.push(rand.nextInt(20));
        }

        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }

    }

    public static void queueTest()
    {
        Random rand = new Random();

        NodeQueue queue = new NodeQueue();

        for (int i = 0; i < 10; i++)
        {
            queue.enqueue(rand.nextInt(20));
        }

        while (!queue.isEmpty())
        {
            System.out.println(queue.dequeue());
        }
    }

    public static NodeQueue infixToPostfix()
    {
        /**
         * From the example on Lecture 5 slide 12
         *
         * Infix forms: A*B/C+D = (A*B)/C+D = ((A*B)/C)+D
         * Postfix form: AB*C/D+
         * Prefix form: +/*ABCD
         *
         * Nice to have:  infixToPostfix() takes a string parameter
         * from keyboard or form input (JavaFX)
         */

        // Critically important to remember the '#' token at the end!
        String s = "((A*B)/C)+D#";  // For testing: let A = 2, B = 5, C = 7, D = 11
        String numTokens = "((2*5)/3)+7#";
        String easy = "((A*B)/C)+D#"; // Start with A*B, then add more tokens to test with
        char[] c = numTokens.toCharArray();
        NodeQueue<Character> infix = new NodeQueue<Character>();
        NodeStack<Character> opStack = new NodeStack<Character>();
        NodeQueue<Character> postfix = new NodeQueue<Character>();

        // populate infix queue.
        for (Character x : c)
                infix.enqueue(x);

        // Verify infix population was successful
        // verifyInfix(infix);

        // prime the operator stack
        opStack.push('#');

        do
        {
            char temp = infix.front();
            if (infixPriority(temp) < 0)
            {
                //System.out.println("Postfix enqueue: " + temp);
                postfix.enqueue(infix.dequeue());
            }
            else if (temp == '#')
            {
                while (!opStack.isEmpty())
                {
                    //System.out.println("Postfix enqueue: opStack.pop()");
                    postfix.enqueue(opStack.pop());
                }
            }
            else if (temp == ')')
            {
                char opTempA = opStack.top();
                while (infixPriority(opTempA) != 3)
                {
                    //System.out.println("Postfix enqueue: " + opTempA);
                    postfix.enqueue(opStack.pop());
                    opTempA = opStack.top();
                }
                opStack.pop();
                infix.dequeue();
            }
            else
            {
                char opTempB = opStack.top();
                if (stackPriority(opTempB) >= infixPriority(temp) && temp != '(')
                {
                    //System.out.println("Postfix enqueue: " + opTempB);
                    //postfix.enqueue(opStack.pop());
                    opStack.push(infix.dequeue());
                }
                //System.out.println("OpStack push: " + temp);
                opStack.push(infix.dequeue());
            }
        }
        while(!opStack.isEmpty());

        // Verify postfix conversion
        // verifyPostfix(postfix);

        return postfix;
    }

    public static int infixPriority(char c)
    {
        switch(c)
        {
            case('*'):
            {
               return 2;
            }
            case('/'):
            {
                return 2;
            }
            case('+'):
            {
                return 1;
            }
            case('-'):
            {
                return 1;
            }
            case('('):
            {
                return 3;
            }
            case(')'):
            {
                return 0;
            }
            case('#'):
            {
                return 0;
            }
            default:
            {
                return -1;
            }
        }
    }

    public static int stackPriority(char c)
    {
        switch(c)
        {
            case('*'):
            {
                return 2;
            }
            case('/'):
            {
                return 2;
            }
            case('+'):
            {
                return 1;
            }
            case('-'):
            {
                return 1;
            }
            case('('):
            {
                return 3;
            }
            case(')'):
            {
                return 0;
            }
            case('#'):
            {
                return 0;
            }
            default:
            {
                return -1;
            }
        }
    }

    public static void verifyInfix(NodeQueue n)
    {
        // Verify infix queue is populated
        System.out.println("Verifying infix population:");
        while (!n.isEmpty())
        {
            System.out.println(n.dequeue());
        }

    }

    public static void verifyPostfix(NodeQueue<Character> p)
    {
        // verify postfix queue
        System.out.println("Verifying postfix:");
        while (!p.isEmpty())
        {
            char temp = p.dequeue();
            if(temp != '#')
                System.out.print(temp);
        }

    }

    public static double postfixEvaluation(NodeQueue<Character> postfix)
    {
        /**
         * Postfix example: AB*C/D+
         * use integers or doubles for actual testing
         */

        NodeStack<Double> valStack = new NodeStack<Double>();

        do
        {
            /**
             * Notes on division and subtraction.  Neither is
             * commutative, so the order in which operands
             * pop off the stack will cause division and subtraction
             * operations to produce unexpected results.  The fix for
             * this is to treat division as multiplication by the
             * reciprocal of the dividend, and subtraction as the
             * addition of the additive inverse of the first term.
             */

            char temp = postfix.front();
            if(stackPriority(temp) < 0)
            {
                //System.out.println("valStack push: " + temp);
                valStack.push(Double.parseDouble(Character.toString(postfix.dequeue())));
            }
            else if(temp == '#')
            {
                // infixToPostfix() returns a queue with '#' at the end.
                postfix.dequeue();
            }
            else if(temp == '*')
            {
                postfix.dequeue();
                valStack.push(valStack.pop() * valStack.pop());
            }
            else if(temp == '/')
            {
                // A / B = 1/A * B
                postfix.dequeue();
                valStack.push((1/valStack.pop()) * valStack.pop()); // HA! fucker...
            }
            else if(temp == '+')
            {
                postfix.dequeue();
                valStack.push(valStack.pop() + valStack.pop());
            }
            else if(temp == '-')
            {
                // A - B = -A + B
                postfix.dequeue();
                valStack.push((-1*valStack.pop()) + valStack.pop()); // Also, this one
            }
        } while(!postfix.isEmpty());

        return valStack.pop();
    }
}
