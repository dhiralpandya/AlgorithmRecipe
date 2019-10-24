package com.omtlab.algorithmrecipe.common.graph;

public class Edge implements Comparable<Edge> {

    private Node from;
    private Node to;
    private int weight = 0;

    public Edge(Node from, Node to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public int hashCode() {
        return from.hashCode() + to.hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        Edge oe = (Edge) obj;

        if ((oe.from == this.from || oe.to == this.from) && (oe.from == this.to || oe.to == this.to)) {
            return true;
        }

        return false;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight == 0 || o.weight == 0) {
            return this.hashCode() - o.hashCode();
        }
        return this.weight - o.weight;
    }

}