class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int start, int n, int k,
                   List<Integer> current, List<List<Integer>> ans) {

        if (current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {

            current.add(i);

            // i + 1 because number cannot be reused
            backtrack(i + 1, n, k, current, ans);

            current.remove(current.size() - 1);
        }
    }
}