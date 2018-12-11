package ch.epfl.sweng.interpreter;

import ch.epfl.sweng.TealFunction;
import ch.epfl.sweng.TealLibrary;
import ch.epfl.sweng.nodes.*;
import ch.epfl.sweng.parser.TealParseException;
import ch.epfl.sweng.parser.TealParser;

import java.util.HashMap;

/**
 * Factory that creates Teal interpreters for specific purposes.
 */
public final class TealInterpreterFactory {
    /**
     * Creates a basic interpreter for the given library.
     * The interpreter should simply invoke functions from the library as is.
     *
     * @param library The library.
     * @return The interpreter.
     */
    public static TealInterpreter basicInterpreter(final TealLibrary library) {
        return (functionName, argument) -> {
            TealFunction function = library.functions.get(functionName);
            TealNode body = function.body;
            //null or parameter name
            String parameter = function.parameter;
            if(parameter != null){
                return visit(library, body, parameter, argument);
            }
            else{
                if(body.getClass() == TealPrimitiveNode.class){
                    TealPrimitiveNodeVisitor v = new TealPrimitiveNodeVisitor();
                    return body.acceptVisitor(v);
                }
                else{
                    throw new TealInterpretationException("Invalid");
                }
            }
        };
    }

    public static int visit(TealLibrary library, TealNode node, String parameter, int argument){
        if(parameter == null){
            if(node.getClass() == TealPrimitiveNode.class){
                TealPrimitiveNodeVisitor v = new TealPrimitiveNodeVisitor();
                return node.acceptVisitor(v);
            }
            else{
                throw new TealInterpretationException("Invalid");
            }
        }

        if(node.getClass() == TealPrimitiveNode.class){
            TealPrimitiveNodeVisitor v = new TealPrimitiveNodeVisitor();
            return node.acceptVisitor(v);
        }

        else if(node.getClass() == TealVariableNode.class){
            TealVariableNodeVisitor v = new TealVariableNodeVisitor();
            String variableName = node.acceptVisitor(v);
            if(parameter.equals(variableName)){
                return argument;
            }
            else{
                throw new IllegalArgumentException();
            }
        }

        else if(node.getClass() == TealAdditionNode.class){
            TealAdditionNodeVisitor v = new TealAdditionNodeVisitor();
            TealNode[] nodes = node.acceptVisitor(v);
            return visit(library, nodes[0], parameter, argument) + visit(library, nodes[1], parameter, argument);
        }

        else if(node.getClass() == TealFunctionCallNode.class){
            TealFunctionCallNodeVisitor v = new TealFunctionCallNodeVisitor();
            TealFunctionNodeComponent component = node.acceptVisitor(v);

            TealFunction subFunction = library.functions.get(component.getFunctionName());
            String subFunctParam = subFunction.parameter;
            TealNode subFunctBody = subFunction.body;

            if(subFunctParam != null){
                TealNode subNode = component.getArgument();
                int subArgument = visit(library, subNode, parameter, argument);

                return visit(library, subFunctBody, subFunctParam, subArgument);
            }
            else{
                return visit(library, subFunctBody, subFunctParam, argument);
            }
        }

        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * Creates a cached interpreter for the given library.
     * The interpreter should return cached results from previous invocations if possible.
     *
     * @param library The library.
     * @return The interpreter.
     */
    public static TealInterpreter cachedInterpreter(final TealLibrary library) {
        HashMap<String, CacheNode> cache = new HashMap<>();
        for(String functName : library.functions.keySet()){
            CacheNode cacheNode = new CacheNode(functName, new HashMap<>());
            cache.put(functName, cacheNode);
        }
        return (functionName, argument) -> {
            CacheNode cur = cache.get(functionName);
            HashMap<Integer,Integer> cachedData =  cur.getCachedData();
            if(cachedData.get(argument) != null){
                return cachedData.get(argument);
            }
            else{
                TealFunction function = library.functions.get(functionName);
                TealNode body = function.body;
                //null or parameter name
                String parameter = function.parameter;
                int result = visit(library, body, parameter, argument);
                cachedData.put(argument, result);
                return result;
            }
        };
    }


    /**
     * Prevents this class from being instantiated.
     */
    private TealInterpreterFactory() {
        // Nothing.
    }

    public static void main(String[] args) throws TealParseException{
        TealLibrary testLib = TealParser.parse("f(n): n + 1\n"
                + "g(n): !f(2 + n) + 1\n"
                + "answer(): 42\n"
                + "answerPlusN(n): n + !answer()");
        TealInterpreter testBasic = cachedInterpreter(testLib);
        System.out.println(testBasic.invoke("answerPlusN", 2));
        System.out.println(testBasic.invoke("answerPlusN", 2));
        System.out.println(testBasic.invoke("answerPlusN", 3));
        System.out.println(testBasic.invoke("answerPlusN", 2));
    }
}
