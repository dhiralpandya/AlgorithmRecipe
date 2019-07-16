package AlgorithmRecipe.tree.util;

public class TreeNode {
    public String stringValue;
    public Integer integerValue;
    public TreeNode left;
    public TreeNode right;
    public Integer currentIndex;

    public TreeNode(){

    }

    public String getNodeName(){
        return (stringValue == null?"":stringValue)+""+(integerValue==null?"":integerValue);
    }
    
    public TreeNode(Integer integerValue){
        this.integerValue = integerValue;
    }
}
