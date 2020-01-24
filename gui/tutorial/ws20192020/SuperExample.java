package gui.tutorial.ws20192020;

import java.util.*;

class ElemA {public void a() {}}
class ElemB extends ElemA {public void b() {}}
class ElemC extends ElemB {public void c() {}}

interface Executor<T>
{
    public void execute(T t);
}

class ExecutorCImpl implements Executor<ElemC>
{
    public void execute(ElemC elem)
    {
        elem.c();
    }    
}

class ExecutorAImpl implements Executor<ElemA>
{
    public void execute(ElemA elem)
    {
        elem.a();
    }    
}

class ExecutorObjectImpl implements Executor<Object>
{
    public void execute(Object elem)
    {
        System.out.println(elem);
    }    
}


public class SuperExample
{
    private static void workOnAllElements(List<? extends ElemB> list,
                                          Executor<? super ElemB> exe)
    {
        for(ElemB elem: list)
        {
            exe.execute(elem);
        }
    }
    
    public static void main(String[] args)
    {
        List<ElemB> list = new ArrayList<ElemB>();
        list.add(new ElemB());
        list.add(new ElemC());
        list.add(new ElemB());
        workOnAllElements(list, new ExecutorObjectImpl());
    }
}
