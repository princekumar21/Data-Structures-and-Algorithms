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
        boolean path = false;
        for (Edge e : graph[src]) {

            if (vis[e.nbr] == false) {
                return path || hasPath(graph, e.nbr, des, vis);

            }

        }
        return path;
    }

    public static void preOrder(ArrayList<Edge>[] graph, int src, int des, boolean vis[], int wsf, String psf) {
        
        System.out.println(src + " -> " + psf +  " @ " + wsf);

        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                preOrder(graph, e.nbr, des, vis, wsf + e.wt, psf + e.nbr  );

            }
        }
        vis[src] = false;

        return;
    }

    public static void postOrder(ArrayList<Edge>[] graph, int src, int des, boolean vis[], int wsf, String psf) {
        
        

        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                postOrder(graph, e.nbr, des, vis, wsf + e.wt, psf + e.nbr  );

            }
        }
        System.out.println(src + " -> " + psf +  " @ " + wsf);
        vis[src] = false;

        return;
    }

    public static void printAllPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[], String psf) {
        if (src == des) {
            System.out.print(psf + src);
            System.out.println();
            return;
        }

        vis[src] = true;
        for (Edge e : graph[src]) {

            if (vis[e.nbr] == false) {

                printAllPath(graph, e.nbr, des, vis, psf + src);
                

            }

        }
        vis[src] = false;

    }

    public static class pairPath {
        String psf = "";
        int wsf = 0;
    }

    public static pairPath haviestPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]){
        if(src == des){
            pairPath base = new pairPath();
            base.psf += src;
            return base; 
        }

        pairPath myAns = new pairPath();
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                pairPath recAns = haviestPath(graph, e.nbr, des, vis);
                if(recAns.wsf + e.wt > myAns.wsf){
                    myAns.psf = src  + recAns.psf;
                    myAns.wsf =  recAns.wsf + e.wt;

                }
            }
        }

        vis[src] = false;
        return myAns;

    }

    public static void haviestPathCall(ArrayList<Edge>[] graph, int src, int des, boolean vis[]){

        pairPath ans = haviestPath(graph, src, des, vis);

        System.out.println(ans.psf + " @ " + ans.wsf);


    }

    public static class pairPathS {
        String psf = "";
        int wsf = 100;
    }

    public static pairPathS lightiestPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]){
        if(src == des){
            pairPathS base = new pairPathS();
            base.psf += src;
            return base; 
        }

        pairPathS myAns = new pairPathS();
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                pairPathS recAns = lightiestPath(graph, e.nbr, des, vis);
                if(recAns.wsf + e.wt < myAns.wsf){
                    myAns.psf = src  + recAns.psf;
                    myAns.wsf =  recAns.wsf + e.wt;

                }
            }
        }

        vis[src] = false;
        return myAns;

    }

    public static void lightiestPathCall(ArrayList<Edge>[] graph, int src, int des, boolean vis[]){

        pairPathS ans = lightiestPath(graph, src, des, vis);

        System.out.println(ans.psf + " @ " + ans.wsf);


    }

    public static void dfsG(ArrayList<Edge>[] graph, int src, boolean[] vis){
        vis[src]  = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                dfsG(graph, e.nbr, vis);
            }
        }

    }

    public static void getconnectedComponent(ArrayList<Edge>[] graph, boolean[] vis){
        int N = graph.length; int componentCount = 0;
        for(int i = 0; i < N; i++){
            if(!vis[i]){
                dfsG(graph, i, vis);
                componentCount++;

            }

        }
        System.out.println(componentCount);

    }
    public static void dfs(int[][] grid, int sr, int sc, int[][] dir){
        grid[sr][sc] = 0;
        for(int d = 0; d  < 4; d++){
            sr = sr + dir[d][0];
            sc = sc + dir[d][1];

            if(sr >= 0 && sc >= 0 && sr < grid.length && sc < grid[0].length && grid[sr][sc] == 1){
                dfs(grid, sr, sc, dir);
            }
        }
    }

    public static void numberOfIslands(int[][] grid){
        int n = grid.length; int m = grid[0].length; 

        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, dir);
                }
            }
        }

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
        addEdge(graph, 4, 5, 15);
        addEdge(graph, 4, 6, 5);
        addEdge(graph, 5, 6, 10);
        // display(graph, N);
        // removeEdge(graph, 0, 1);
        // display(graph, N);
        // System.out.println(findEdge(graph, 1, 2));
        // removeEdge(graph, 4, 3);
        // removevrtx(graph, 1);
        // display(graph, N);
        boolean vis[] = new boolean[N];
        // System.out.println(hasPath(graph, 0, 6, vis));
        // printAllPath(graph, 0, 6, vis, "");
        // preOrder(graph, 0, 6, vis, 0, "0");
        // postOrder(graph, 0, 6, vis, 0, "0");
        // haviestPathCall(graph, 0, 6, vis);
        // lightiestPathCall(graph, 0, 6, vis);
        getconnectedComponent(graph, vis);
    }

    public static void main(String args[]) {
        constructor();
    }
}