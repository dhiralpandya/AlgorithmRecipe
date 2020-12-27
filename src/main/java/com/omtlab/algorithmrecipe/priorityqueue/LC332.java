package com.omtlab.algorithmrecipe.priorityqueue;

import java.util.*;

/**
 * 332. Reconstruct Itinerary
 * <p>
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order.
 * All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 * But it is larger in lexical order.
 */
public class LC332 {
    private static final String SOURCE = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> sourceToDestinations = new HashMap<>();

        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            PriorityQueue<String> priorityQueue = sourceToDestinations.getOrDefault(from, new PriorityQueue());
            priorityQueue.add(to);
            sourceToDestinations.put(from, priorityQueue);
        }

        List<String> output = new ArrayList<>();
        dfs(sourceToDestinations, output);
        return output;
    }

    private void dfs(Map<String, PriorityQueue<String>> graph, List<String> output) {
        Stack<String> dfs = new Stack<>();
        dfs.add(SOURCE);

        while (!dfs.isEmpty()) {
            String from = dfs.pop();
            output.add(from);

            if (!graph.containsKey(from) || graph.get(from).isEmpty()) {
                break;
            }

            String to = graph.get(from).poll();
            dfs.add(to);
        }
    }


}
