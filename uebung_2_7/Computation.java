package uebung_2_7;
import javax.script.*;
public class Computation 
{

    private ScriptEngine engine;
    
    public Computation()
    {
        ScriptEngineManager manager = new ScriptEngineManager();
        engine = manager.getEngineByName("js");
    }
    
    public Object evaluate(String expression) throws ScriptException
    {
        return engine.eval(expression);
        
    }
}