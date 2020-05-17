package com.omtlab.algorithmrecipe.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class LC430Test {

    @Test
    public void flatten() {
        LC430.Node output = new LC430().flatten(getLinkedList());
        while (output != null) {
            System.out.print(output.value + " > ");
            output = output.next;
        }
    }

    private LC430.Node getLinkedList() {
        LC430.Node n1 = new LC430.Node(1);
        LC430.Node n2 = new LC430.Node(2);
        LC430.Node n3 = new LC430.Node(3);
        LC430.Node n4 = new LC430.Node(4);
        LC430.Node n5 = new LC430.Node(5);
        LC430.Node n6 = new LC430.Node(6);
        LC430.Node n7 = new LC430.Node(7);

        n1.next = n5;
        n5.next = n6;
        n6.child = n7;

        n1.child = n2;
        n2.next = n3;
        n2.child = n4;
        return n1;
    }
}