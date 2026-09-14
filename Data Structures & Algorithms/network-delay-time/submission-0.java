class Solution {

    record Edge(int to, int w) {}

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Edge>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] t : times) g.get(t[0]).add(new Edge(t[1], t[2]));

        int[] dist = dijkstra(g, k);

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
        
    }

    public int[] dijkstra(List<List<Edge>> graph, int src) {

        int n = graph.size();
        int [] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];

            if (d > dist[u]) continue;

            for (Edge e : graph.get(u)) {

                int nd = d + e.w();
                if (nd < dist[e.to()]) {
                    dist[e.to()] = nd;
                    pq.offer(new int[]{nd, e.to()});
                }

            }

        }

        return dist;
    }

}