package ch.epfl.sweng;

import java.util.List;

public class GraphElementVisitor<D> implements IGraphElementVisitor<D> {
    List<GraphEdge<D>> forwardEdges;

    @Override
    public void visit(Graph<D> graph) {

    }

    @Override
    public void visit(GraphEdge<D> edge) {

    }

    @Override
    public void visit(GraphNode<D> node) {
        forwardEdges = node.getForwardEdges();
    }
}
