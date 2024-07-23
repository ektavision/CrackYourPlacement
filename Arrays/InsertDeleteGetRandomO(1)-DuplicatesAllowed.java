class RandomizedCollection {
         Map<Integer, Set<Integer>> map;
         List<Integer> list;
    public RandomizedCollection() {
         map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
         map.computeIfAbsent(val, k -> new LinkedHashSet<>()).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }
    
    public boolean remove(int val) {
         if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
         }
           int idxToRemove = map.get(val).iterator().next();
        map.get(val).remove(idxToRemove);
        int lastVal = list.get(list.size() - 1);
        list.set(idxToRemove, lastVal);
        map.get(lastVal).add(idxToRemove);
        map.get(lastVal).remove(list.size() - 1);
        list.remove(list.size() - 1);
        
        return true;
    }
    
    public int getRandom() {
        return list.get(new java.util.Random().nextInt(list.size()));

    }
}

