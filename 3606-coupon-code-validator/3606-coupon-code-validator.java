class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
         List<Integer> validIndexes = new ArrayList<>();
        List<String> Bline = Arrays.asList("electronics", "grocery", "pharmacy", "restaurant");

        Map<String, Integer> priority = new HashMap<>();
        for (int i = 0; i < Bline.size(); i++) {
            priority.put(Bline.get(i), i);
        }

        for (int i = 0; i < code.length; i++) {
            if (Bline.contains(businessLine[i]) && isActive[i]) {
                String s = code[i];
                if (s != null && !s.isEmpty() && s.matches("[A-Za-z0-9_]+")) {
                    validIndexes.add(i);
                }
            }
        }

        Collections.sort(validIndexes, (i, j) -> {
            int cmp = Integer.compare(priority.get(businessLine[i]), priority.get(businessLine[j]));
            if (cmp != 0) return cmp;
            return code[i].compareTo(code[j]);
        });

        List<String> ans = new ArrayList<>();
        for (int idx : validIndexes) {
            ans.add(code[idx]);
        }

        return ans;
        
    }
}