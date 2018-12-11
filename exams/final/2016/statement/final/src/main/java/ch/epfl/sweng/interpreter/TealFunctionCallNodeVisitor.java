package ch.epfl.sweng.interpreter;

import ch.epfl.sweng.nodes.*;

public class TealFunctionCallNodeVisitor implements TealNodeVisitor<TealFunctionNodeComponent> {
    /**
     * Visits the given primitive node.
     *
     * @param node The primitive node.
     * @return The returned value.
     */
    public TealFunctionNodeComponent visit(TealPrimitiveNode node){
        return null;
    }

    /**
     * Visits the given variable node.
     *
     * @param node The variable node.
     * @return The returned value.
     */
    public TealFunctionNodeComponent visit(TealVariableNode node){
        return null;
    }

    /**
     * Visits the given addition node.
     *
     * @param node The addition node.
     * @return The returned value.
     */
    public TealFunctionNodeComponent visit(TealAdditionNode node){
        return null;
    }

    /**
     * Visits the given function call node.
     *
     * @param node The function call node.
     * @return The returned value.
     */
    public TealFunctionNodeComponent visit(TealFunctionCallNode node){
        String functionName = node.functionName;
        TealNode argument = node.argument;
        return new TealFunctionNodeComponent(functionName, argument);
    }
}
