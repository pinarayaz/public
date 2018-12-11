package ch.epfl.sweng.interpreter;

import ch.epfl.sweng.nodes.TealNode;

public class TealFunctionNodeComponent {
    private String functionName;
    private TealNode argument;

    public TealFunctionNodeComponent(String functionName, TealNode argument){
        this.functionName = functionName;
        this.argument = argument;
    }

    public String getFunctionName() {
        return functionName;
    }

    public TealNode getArgument() {
        return argument;
    }
}
