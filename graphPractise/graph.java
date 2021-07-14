import java.util.ArrayList;
import java.util.LinkedList;

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

        System.out.println(src + " -> " + psf + " @ " + wsf);

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                preOrder(graph, e.nbr, des, vis, wsf + e.wt, psf + e.nbr);

            }
        }
        vis[src] = false;

        return;
    }

    public static void postOrder(ArrayList<Edge>[] graph, int src, int des, boolean vis[], int wsf, String psf) {

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                postOrder(graph, e.nbr, des, vis, wsf + e.wt, psf + e.nbr);

            }
        }
        System.out.println(src + " -> " + psf + " @ " + wsf);
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

    public static pairPath haviestPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]) {
        if (src == des) {
            pairPath base = new pairPath();
            base.psf += src;
            return base;
        }

        pairPath myAns = new pairPath();
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                pairPath recAns = haviestPath(graph, e.nbr, des, vis);
                if (recAns.wsf + e.wt > myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;

                }
            }
        }

        vis[src] = false;
        return myAns;

    }

    public static void haviestPathCall(ArrayList<Edge>[] graph, int src, int des, boolean vis[]) {

        pairPath ans = haviestPath(graph, src, des, vis);

        System.out.println(ans.psf + " @ " + ans.wsf);

    }

    public static class pairPathS {
        String psf = "";
        int wsf = 100;
    }

    public static pairPathS lightiestPath(ArrayList<Edge>[] graph, int src, int des, boolean vis[]) {
        if (src == des) {
            pairPathS base = new pairPathS();
            base.psf += src;
            return base;
        }

        pairPathS myAns = new pairPathS();
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                pairPathS recAns = lightiestPath(graph, e.nbr, des, vis);
                if (recAns.wsf + e.wt < myAns.wsf) {
                    myAns.psf = src + recAns.psf;
                    myAns.wsf = recAns.wsf + e.wt;

                }
            }
        }

        vis[src] = false;
        return myAns;

    }

    public static void lightiestPathCall(ArrayList<Edge>[] graph, int src, int des, boolean vis[]) {

        pairPathS ans = lightiestPath(graph, src, des, vis);

        System.out.println(ans.psf + " @ " + ans.wsf);

    }

    public static void dfsG(ArrayList<Edge>[] graph, int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                dfsG(graph, e.nbr, vis);
            }
        }

    }

    public static void getconnectedComponent(ArrayList<Edge>[] graph, boolean[] vis) {
        int N = graph.length;
        int componentCount = 0;
        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                dfsG(graph, i, vis);
                componentCount++;

            }

        }
        System.out.println(componentCount);

    }

    public static int dfs(int[][] grid, int sr, int sc, int[][] dir) {
        int size = 0;
        grid[sr][sc] = 0;
        for (int d = 0; d < 4; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];

            if (sr >= 0 && sc >= 0 && sr < grid.length && sc < grid[0].length && grid[r][c] == 1) {
                size += dfs(grid, sr, sc, dir);
            }
        }
        return size + 1;
    }

    public static void numberOfIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int islandCount = 0;

        int[][] dir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, dir);
                    islandCount++;
                }
            }
        }

    }

    public static void hamiltonianPathAndCycle(ArrayList<Edge>[] graph, int osrc, int src, int edgeCount, boolean vis[],
            String psf) {
        if (edgeCount == graph.length - 1) {
            int index = findEdge(graph, src, osrc);
            if (index == -1) {
                System.out.println(psf + ".");
            } else {
                System.out.println(psf + "*");
            }
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.nbr]) {
                hamiltonianPathAndCycle(graph, osrc, e.nbr, edgeCount + 1, vis, psf + e.nbr);
            }

        }
        vis[src] = false;

    }

    public static void BFS(ArrayList<Edge>[] graph, int src) {
        LinkedList<Integer> que = new LinkedList<>();
        int N = graph.length;
        boolean[] vis = new boolean[N];
        boolean isCyclePresent = false;

        que.addLast(src);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                // for cyclic detection
                if (vis[rvtx]) {
                    isCyclePresent = true;
                    continue;
                }
                vis[rvtx] = true;
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.nbr]) {
                        que.addLast(e.nbr);
                    }

                }
            }

        }

    }

    public static boolean cyclicDetection(ArrayList<Edge>[] graph, int src, boolean vis[]) {
        LinkedList<Integer> que = new LinkedList<>();

        que.addLast(src);

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {
                int rvtx = que.removeFirst();

                if (vis[rvtx]) {

                    return true;

                }
                vis[rvtx] = true;
                for (Edge e : graph[rvtx]) {
                    if (!vis[e.nbr]) {
                        que.addLast(e.nbr);
                    }

                }
            }

        }
        return false;

    }

    public static class BFS_Pair {
        int vtx = 0;
        String psf = "";
        int wt = 0;

        BFS_Pair(int vtx, String psf, int wt) {
            this.vtx = vtx;
            this.psf = psf;
            this.wt = wt;
        }

    }

    public static void printBSFPath() {
        ArrayList<BFS_Pair> que = new ArrayList<>();

    }

    public static int spreadInfection(ArrayList<Edge>[] graph, int src, int time, boolean vis[]) {
        LinkedList<Integer> que = new LinkedList<>();
        que.add(src);
        int infectedCount = 0;
        int day = 1;

        while (que.size() != 0) {

            int size = que.size();

            if (day > time) {
                break;
            }
            while (size-- > 0) {
                int rmvtx = que.removeFirst();

                if (vis[rmvtx]) {
                    continue;
                }

                infectedCount++;
                vis[rmvtx] = true;
                for (Edge e : graph[rmvtx]) {
                    if (!vis[e.nbr]) {
                        que.addLast(e.nbr);
                    }

                }
            }

            day++;

        }
        return infectedCount;

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
        addEdge(graph, 6, 0, 10);
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
        // hamiltonianPathAndCycle(graph, 0, 0, 0, vis, "0");
        System.out.println(spreadInfection(graph, 6, 3, vis));
    }

    public static void main(String args[]) {
        constructor();
    }
}