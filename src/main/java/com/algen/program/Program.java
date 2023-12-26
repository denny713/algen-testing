package com.algen.program;

import com.algen.model.Graph;
import com.algen.model.Kromosom;
import com.algen.model.Node;
import com.algen.model.Paths;

import java.util.List;

public abstract class Program {

    public int complexity;
    public int numberOfInputVariables;
    public int range;

    public Graph controlFlowGraph;
    public Node controlFlowGraphRoot;
    public Node controlFlowGraphEndNode;

    public Graph decisionTree;
    public Node decisionTreeRoot;
    public Paths decisionTreePaths;
    public List<Node> leaves;

    public abstract int program(Paths paths, List<Integer> variables);
    public abstract int getLeafByEvaluation(Kromosom kromosom);
}
