package ch.epfl.sweng;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class Graph<D> implements IGraphElement<D>{
    /** Implementation detail, not part of the graph. */
    private final GraphNode<D> root;

    /** Creates a new, empty graph. */
    public Graph() {
        root = new GraphNode<>(null);
    }

    /**
     * Returns the node that contains the given data. 
     * If no such node exists, it will be created.
     */
    public GraphNode<D> getNode(D data) {
        for (GraphEdge<D> edge : root.getForwardEdges()) {
            if (edge.getDestination().getData().equals(data)) {
                return edge.getDestination();
            }
        }

        GraphNode<D> newNode = new GraphNode<>(data);
        root.addSuccessor(newNode);
        return newNode;
    }

    /**
     * Lists all nodes in the graph. 
     * The order in which nodes are returned is not specified.
     */
    public List<GraphNode<D>> getAllNodes() {
        Iterator iterator = new GraphEdgeIterator();

        List<GraphNode<D>> nodes = new ArrayList<>();

        while(iterator.hasNext()) {
            GraphEdge<D> edge = (GraphEdge<D>) iterator.next();
            nodes.add(edge.getDestination());
        }

        /*
        for (GraphEdge<D> edge : root.getForwardEdges()) {
            nodes.add(edge.getDestination());
        }
        */

        return nodes;
    }

    @Override
    public void accept(IGraphElementVisitor visitor) {
        visitor.visit(this);
    }

    public class GraphEdgeIterator implements Iterator<GraphEdge>{

        private int position = 0;

        @Override
        public boolean hasNext() {
            if(position < root.getForwardEdges().size()){
                return true;
            }
            return false;
        }

        @Override
        public GraphEdge<D> next() {
            if(this.hasNext()){
                return root.getForwardEdges().get(position++);
            }
            else{
                throw new NoSuchElementException();
            }
        }
    }
}
