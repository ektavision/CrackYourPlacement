
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
         stack = new Stack<>();
        int n = nestedList.size();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
         NestedInteger curr = stack.pop();
        return curr.getInteger();
    }

    @Override
    public boolean hasNext() {
         while (!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }

            stack.pop();
            List<NestedInteger> list = curr.getList();
            int n = list.size();
            for (int i = n - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return false;
    }}