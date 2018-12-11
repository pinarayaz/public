package ch.epfl.sweng.interpreter;

import ch.epfl.sweng.nodes.*;

public class TealPrimitiveNodeVisitor implements TealNodeVisitor<Integer> {
    /**
     * Visits the given primitive node.
     *
     * @param node The primitive node.
     * @return The returned value.
     */
    public Integer visit(TealPrimitiveNode node){
        return node.value;
    }

    /**
     * Visits the given variable node.
     *
     * @param node The variable node.
     * @return The returned value.
     */
    public Integer visit(TealVariableNode node){
        return null;
    }

    /**
     * Visits the given addition node.
     *
     * @param node The addition node.
     * @return The returned value.
     */
    public Integer visit(TealAdditionNode node){
        return null;
    }

    /**
     * Visits the given function call node.
     *
     * @param node The function call node.
     * @return The returned value.
     */
    public Integer visit(TealFunctionCallNode node){
        return null;
    }
}
