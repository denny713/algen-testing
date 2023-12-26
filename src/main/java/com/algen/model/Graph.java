package com.algen.model;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Node> nodes = new ArrayList<>();
    private List<Edge> edges = new ArrayList<>();

    public void newNode(int lineNumber) {
        nodes.add(new Node(lineNumber));
    }

    public Node getNode(int index) {
        return nodes.get(index-1);
    }

    public void addEdge(Node from, Node to) {
        edges.add(new Edge(from, to));
    }

    public Edge getEdge(Node from, Node to) {
        int index = edges.indexOf(new Edge(from, to));
        return index != -1 ? edges.get(index) : null;
    }
}
