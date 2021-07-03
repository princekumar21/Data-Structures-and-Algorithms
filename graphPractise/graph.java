import java.util.ArrayList;

public class graph {
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;

        }
    }

    public static void addEdge(ArrayList<Edge>[] graph, int u, int v, int w) {
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));
    }

    public static void display(ArrayList<Edge>[] graph, int N) {
        for (int i = 0; i < N; i++) {
            System.out.print(i + "->");
            for (Edge e : graph[i]) {
                System.out.print("(" + e.nbr + " ," + e.wt + ") ");
            }
            System.out.println();
        }

    }

    public static int findEdge(ArrayList<Edge>[] graph, int u, int v) {
        ArrayList<Edge> list = graph[u];
        for (int i = 0; i < list.size(); i++) {
            Edge e = list.get(i);
            if (e.nbr == v) {
                return i;
            }
        }
        return -1;

    }

    public static void removeEdge(ArrayList<Edge>[] graph, int u, int v) {
        int e = findEdge(graph, u, v);
        int p = findEdge(graph, v, u);

        graph[u].remove(e);
        graph[v].remove(p);

    }

    public static void removevrtx(ArrayList<Edge>[] graph, int u) {
        ArrayList<Edge> list = graph[u];
        for (int i = list.size() - 1; i >= 0; i--) {
            Edge e = list.get(i);
            removeEdge(graph, e.src, e.nbr);

        }

    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]) {
        if (src == des) {
            return true;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {

            if (vis[e.nbr] == false) {
                boolean path = hasPath(graph, e.nbr, des, vis);
                if (path) {
                    return true;
                }
            }

        }

        return false;

    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]) {
        if (src == des) {
            return true;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {

            if (vis[e.nbr] == false) {
                boolean path = hasPath(graph, e.nbr, des, vis);
                if (path) {
                    return true;
                }
            }

        }

        return false;

    }

    public static void constructor() {
        int N = 7;
        ArrayList<Edge>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
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
        // removeEdge(graph, 0, 1);
        // display(graph, N);
        // System.out.println(findEdge(graph, 1, 2));
        // removeEdge(graph, 4, 3);
        // removevrtx(graph, 1);
        display(graph, N);
        boolean vis[] = new boolean[N];
        System.out.println(hasPath(graph, 2, 5, vis));

    }

    public static void main(String args[]) {
        constructor();
    }
}