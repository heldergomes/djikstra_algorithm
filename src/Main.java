import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Graph.Arcs> arcs0 = new ArrayList<>();
        arcs0.add(new Graph.Arcs(1,5));
        arcs0.add(new Graph.Arcs(2,2));

        List<Graph.Arcs> arcs1 = new ArrayList<>();
        arcs1.add(new Graph.Arcs(3,2));
        arcs1.add(new Graph.Arcs(4,1));

        List<Graph.Arcs> arcs2 = new ArrayList<>();
        arcs2.add(new Graph.Arcs(4,5));

        List<Graph.Arcs> arcs3 = new ArrayList<>();
        arcs3.add(new Graph.Arcs(5,2));

        List<Graph.Arcs> arcs4 = new ArrayList<>();
        arcs4.add(new Graph.Arcs(5,1));

        Graph graph = new Graph();
        graph.addArcs(0, arcs0)
             .addArcs(1, arcs1)
             .addArcs(2, arcs2)
             .addArcs(3, arcs3)
             .addArcs(4, arcs4)
             .addArcs(5, new ArrayList<>());

        Djikstra djikstra = new Djikstra();
        StringBuilder sb = djikstra.algorithm(graph, 0, 2);
        System.out.println(sb);

    }

}
