package ch.epfl.sweng.interpreter;

import ch.epfl.sweng.nodes.*;

public class TealVariableNodeVisitor implements TealNodeVisitor<String> {
    /**
     * Visits the given primitive node.
     *
     * @param node The primitive node.
     * @return The returned value.
     */
    public String visit(TealPrimitiveNode node){
        return null;
    }

    /**
     * Visits the given variable node.
     *
     * @param node The variable node.
     * @return The returned value.
     */
    public String visit(TealVariableNode node){
        return node.name;
    }

    /**
     * Visits the given addition node.
     *
     * @param node The addition node.
     * @return The returned value.
     */
    public String visit(TealAdditionNode node){
        return null;
    }

    /**
     * Visits the given function call node.
     *
     * @param node The function call node.
     * @return The returned value.
     */
    public String visit(TealFunctionCallNode node){
        return null;
    }
}
