
class Solution{
    int index = 0;


Node constructTree(int n, int pre[], char preLN[]){
    // code here
       if (index >= n) {
        return null;
    }

    Node newNode = new Node(pre[index]);
    index++;

    if (preLN[index - 1] == 'N') {
        newNode.left = constructTree(n, pre, preLN);
        newNode.right = constructTree(n, pre, preLN);
    }

    return newNode;
}
}