package gui.tutorial.ws20192020;

interface Operation
{
    public int op(int operand1, int operand2); }

class Addition implements Operation
{
    public int op(int operand1, int operand2)
    {
        return operand1 + operand2;
    }
}

class Multiplication implements Operation
{
    public int op(int operand1, int operand2)
    {
        return operand1 * operand2;
    }
}

public class Lambda
{
    private static void execute(Operation operation, int param1, int param2)
    {
        System.out.println("param1 = " + param1 + ", param2 = " + param2);
        int result = operation.op(param1, param2);
        System.out.println("Ergebnis = " + result);
    }
    
    public static void main(String[] args)
    {
        //alte Art (ohne Lambda):
        //Klasse schreiben, die Interface implementiert
        //davon Objekt erzeugen
        
        execute(new Addition(), 3, 6);
        execute(new Multiplication(), 3, 6);
        System.out.println("========================");
        
        //neue Art (mit Lambda):
        //keine Klasse explizit, keine Objekterzuegung
        //sondern Lambda-Ausdruck
        execute((int operand1, int operand2)->operand1 + operand2, 3, 6);
        execute((operand1, operand2)->operand1 - operand2, 3, 6);
        execute((int operand1, int operand2)->{return operand1 * operand2;}, 3, 6);

        Operation subtraction = (operand1, operand2)->operand1 - operand2;
        int result = subtraction.op(20, 14);
        System.out.println(result);
    }
}
