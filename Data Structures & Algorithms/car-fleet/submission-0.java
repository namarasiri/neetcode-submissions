class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        TreeMap<Integer, Double> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {

            double time = (double) (target - position[i])/speed[i];
            map.put(position[i], time);

        }

        Stack<Double> stack = new Stack<>();

        for (double time : map.descendingMap().values()) {
            if (stack.isEmpty() || time > stack.peek()) {
                 stack.push(time);
             }
        }

        return stack.size();
    }
}
