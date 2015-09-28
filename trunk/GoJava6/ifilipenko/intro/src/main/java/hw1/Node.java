package hw1;

public class Node {
    int i, j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public int hashCode() {

        return this.i*1001+this.j;
    }

    @Override
    public boolean equals(Object o) {

        if(o == null){
            return false;
        }
        if(o == this){
            return true;
        }
        Node node =(Node) o;
        if(this.i == node.i && this.j == node.j){

            return true;
        }
        return false;
    }
}
