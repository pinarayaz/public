package ch.epfl.sweng.interpreter;

import ch.epfl.sweng.nodes.*;

public class TealAdditionNodeVisitor implements TealNodeVisitor<TealNode[]> {
    /**
     * Visits the given primitive node.
     *
     * @param node The primitive node.
     * @return The returned value.
     */
    public TealNode[] visit(TealPrimitiveNode node){
        return null;
    }

    /**
     * Visits the given variable node.
     *
     * @param node The variable node.
     * @return The returned value.
     */
    public TealNode[] visit(TealVariableNode node){
        return null;
    }

    /**
     * Visits the given addition node.
     *
     * @param node The addition node.
     * @return The returned value.
     */
    public TealNode[] visit(TealAdditionNode node){
        TealNode left = node.left;
        TealNode right = node.right;

        TealNode[] nodes = {node.left, node.right};
        return nodes;
    }

    /**
     * Visits the given function call node.
     *
     * @param node The function call node.
     * @return The returned value.
     */
    public TealNode[] visit(TealFunctionCallNode node){
        return null;
    }
}
