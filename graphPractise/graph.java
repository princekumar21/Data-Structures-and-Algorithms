import java.util.ArrayList;
public class graph {
    public static class Edge{
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;

        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w){
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void display(ArrayList<Edge>[] graph, int N){
        for(int i = 0; i < N; i++){
            for(Edge e : graph[i]){
                System.out.print(i + "->"+ e.nbr +" @"+ e.wt +" ");
            }
            System.out.println();
        }

    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v){
        for(Edge e : graph[u]){
            if(e.nbr == v){
                e.nbr = 0;
                e.wt = 0;
            }
        }
    }
    public static void removevrtx(){

    }

    public static void constructor(){
        int  N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(graph, 0, 1, 10);
        addEdge(graph, 2, 1, 10);
        addEdge(graph, 2, 3, 2);
        addEdge(graph, 3, 0, 10);
        addEdge(graph, 4, 3, 40);
        addEdge(graph, 4, 6, 5);
        addEdge(graph, 4, 5, 15);
        addEdge(graph, 5, 6, 10);
        // display(graph, N);
        removeEdge(graph, 0, 1);
        display(graph, N);
        
    }
    public static void main(String args[]){
        constructor();
    }
}