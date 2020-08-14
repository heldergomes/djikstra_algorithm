import java.util.*;

public class Graph {

    List<LinkedList<Arcs>> adjacencyList;

    public Graph(){
        adjacencyList = new ArrayList<LinkedList<Arcs>>();
    }

    public Graph addArcs(Integer vertice, List<Arcs> arcs){

        LinkedList<Arcs> linkedList = new LinkedList<>();
        arcs.stream().forEach( arc -> linkedList.add(arc));

        adjacencyList.add(
                vertice,
                linkedList
        );

        return this;
    }

    public static class Arcs {

        public Arcs(Integer node, Integer cost){
            this.node = node;
            this.cost = cost;
        }

        public Integer node;
        public Integer cost;

    }
}
