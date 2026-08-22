class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> combs = new ArrayList<>();
        getCombinations(1, new ArrayList<>(), combs, n, k);

        return combs;

        
    }

    public void getCombinations(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {

        if (curComb.size() == k) {

            combs.add(new ArrayList<>(curComb));

            return;

        }

        if (i > n) {
            return;

        }


        for (int j = i; j < n + 1; j++) {

            curComb.add(j);
            getCombinations(j + 1, curComb, combs, n, k);
            curComb.remove(curComb.size() - 1);

        }

    }
}