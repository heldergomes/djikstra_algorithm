import java.util.*;

public class Djikstra {

    List<Integer> weight;
    List<Integer> parents;
    boolean[] visited;

    StringBuilder algorithm(Graph graph, int init, int end){

         weight = new ArrayList<Integer>();
         parents = new ArrayList<Integer>();
         visited = new boolean[graph.adjacencyList.size()];

         for (int i = 0; i < graph.adjacencyList.size(); i++){
             weight.add(i, Integer.MAX_VALUE);
             parents.add(i, 0);
             visited[i] = false;
         }

         weight.remove(0);
         weight.add(0, init);

         Optional<Integer> lowerValue = getLowerValue(graph, weight);

         while (lowerValue.isPresent()){
             while (!graph.adjacencyList.get(lowerValue.get()).isEmpty()){
                 Graph.Arcs arc = graph.adjacencyList.get(lowerValue.get()).remove();
                 Integer costSelected = weight.get(lowerValue.get()) + arc.cost;
                 if (costSelected < weight.get(arc.node)){
                     int node = arc.node;
                     weight.remove(node);
                     weight.add(node, costSelected);
                     parents.remove(node);
                     parents.add(node, lowerValue.get());
                 }
             }
             visited[lowerValue.get()] = true;
             lowerValue = getLowerValue(graph, weight);
             if (lowerValue.get() == end){
                 StringBuilder sb = new StringBuilder();
                 sb.append("vertice: " + lowerValue.get() + " cost: " + weight.get(lowerValue.get()) + "\n\n");

                 Integer path = lowerValue.get();
                 sb.append("path: " + path + " <- ");
                 while (path != init){
                     sb.append(parents.get(path) + " <- ");
                     path = parents.get(path);
                 }
                 sb.append("init");

                 return sb;
             }
         }
         StringBuilder sb = new StringBuilder();
         sb.append("The node doesn't exist !");
         return sb;
    }

    private Optional<Integer> getLowerValue(Graph graph, List<Integer> weight) {

        Optional<Integer> lowerValue = Optional.empty();
        Integer lowerCost = Integer.MAX_VALUE;

        for (int i = 0; i < graph.adjacencyList.size(); i++){
            Integer weightSelected = weight.get(i);
            if (weightSelected < lowerCost && visited[i] != true){
                lowerCost = weightSelected;
                lowerValue = Optional.of(i);
            }
        }
        return lowerValue;
    }
}
