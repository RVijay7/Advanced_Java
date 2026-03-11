class Node {
    Node left;
    Node right;
    Meaning data;
    String color;
    Node parentNode;

    Node(Meaning data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class MyTreeSet {
    Node root;
    Node newNode;
    int length;

    void add(Meaning value) {
        if(value!=null){
            value.word = value.word.toUpperCase();
            root = insert(root, value);
            // System.out.println(root.data);
            length++;
        }
    }

    Node insert(Node root, Meaning value) {
        if (root == null) {
            root = new Node(value);
            root.color = "black";
            return root;
        } else {
            if (value.word.compareTo(root.data.word)<0) {
                if (root.left == null) {
                    // root.parentNode = root;
                    root.left = new Node(value);
                    root.left.color = "red";
                    newNode = root.left;
                    newNode.parentNode = root;
                } else {
                    // root.parentNode = root;
                    root.left = insert(root.left, value);
                }
            } else if (root.data.word.compareTo(value.word)<0) {
                if (root.right == null) {
                    // root.parentNode = root;
                    root.right = new Node(value);
                    root.right.color = "red";
                    newNode = root.right;
                    newNode.parentNode = root;
                } else {
                    // root.parentNode = root;
                    root.right = insert(root.right, value);
                }
            }
        }

       
         
        if(newNode.parentNode != root && newNode.parentNode!=null){
            // System.out.println("Recolouring...");
            if(newNode.color =="red" && newNode.parentNode.color=="red"){
                recolor(newNode);
            }
            
        }
        else{
            // try{
            //     System.out.println("New node : "+newNode.data+" Parent Node: "+newNode.parentNode.data);
            // }
            // catch(Exception e){
            //     System.out.println(e.getMessage());
            // }
        }
        return root;
    }

    boolean recolor(Node newNode) {
        Node parent = newNode.parentNode;
        Node grandparent = parent.parentNode;
        Node uncleNode = null ;

        if(grandparent.right!=null && grandparent.right!=parent){
            uncleNode = grandparent.right;
        }
        else if(grandparent.left!=null && grandparent.left!=parent){
            uncleNode = grandparent.left;
        }
        
        if(uncleNode!=null && uncleNode.color!="black"){
            if(uncleNode.color=="red" && parent.color=="red"){
                uncleNode.color="black";
                parent.color ="black";
                if(grandparent!=root){
                    grandparent.color="red";
                }
            }
        }
        else{
            // System.out.println("Rotation happening");
            rotation(newNode);
        }
        
        return false;
    }


    void rotation(Node newNode){
        Node parent = newNode.parentNode;
        Node grandparent = parent.parentNode;

        if(grandparent.right == parent && parent.right ==newNode){
           Meaning leftdata = grandparent.data;
           grandparent.data =parent.data;
           parent.data = newNode.data;
           grandparent.left = new Node(leftdata);
        }
        else if(grandparent.left == parent && parent.left ==newNode){
            Meaning rightdata = grandparent.data;
            grandparent.data = parent.data;
            parent.data = newNode.data;
            grandparent.right = new Node(rightdata);
        }
    }
    
    // Node searching(Node root, int value) {
    //     if (root != null) {
    //         if (root.data == value) {
    //             return root;
    //         } else if (root.data > value) {
    //             parentNode = searching(root.right, value);
    //         } else if (root.data < value) {
    //             parentNode = searching(root.left, value);
    //         }
    //     }
    //     return parentNode;
    // }

    boolean isEmpty(){
        if(root==null){
            return true;
        }
        else{
            return false;
        }
    }

    void print() {
        if (root != null) {
            System.out.println("\nCorrect Order: ");
            printInOrder(root);
            System.out.println("");
        } else {
            System.out.println("No element found");
        }
    }

    void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.println(root.data.word+" --> "+root.data.meaning+" Color: "+root.color);
            printInOrder(root.right);
        }
    }

    void contains(String value) {
        if (search(root, value.toUpperCase())) {
            System.out.println("Yes the element is in the tree");
        } else {
            System.out.println("No element Found");
        }
    }

    boolean search(Node root, String value) {
        if (root == null) {
            return false;
        } else if (root.data.word.equalsIgnoreCase(value)) {
            return true;
        } else if (root.data.word.compareTo(value)<0) {
            return search(root.right, value);
        } else {
            return search(root.left, value);
        }
    }

    void delete() {
        if (root != null) {
            root = null;
            length = 0;
        }
    }


    void firstElement(){
        if(root!=null){
            System.out.println("The first element in the tree is "+small(root).word+" --> "+small(root).meaning);
        }
        else{
            System.out.println("No element found");
        }
    }

    Meaning small(Node root){
        Node temp=root;
        if(temp.left==null){
            return temp.data;
        }
        else{
            return small(temp.left);
        }
    }

    void lastElement(){
        if(root!=null){
            System.out.println("The last element in the tree is "+big(root).word+" --> "+big(root).meaning);
        }
        else{
            System.out.println("No element found");
        }
    }

    Meaning big(Node root){
        Node temp=root;
        if(temp.right==null){
            return temp.data;
        }
        else{
            return big(temp.right);
        }
    } 

    void reverse(){
        if(root!=null){
            System.out.println("\nReverse Order: ");
            printinreverse(root);
            System.out.println("");
        }
        else{
            System.out.println("No element found");
        }
    }

    void printinreverse(Node root){
        if(root!=null){
            printinreverse(root.right);
            System.out.println(root.data.word+"-->"+root.data.meaning);
            printinreverse(root.left);
        }
    }
    
    void update(String value,String meaning){
        if(search(root, value)){
            Node updateNode = replace(root, value);
            updateNode.data.meaning=meaning;
        }
        else{
            System.out.println("No element found");
        }
    }

    Node replace(Node root,String value){
        if(root==null){
            return null;
        }
        if(root.data.word.equalsIgnoreCase(value)){
            return root;
        }
        else if(value.compareTo(root.data.word)<0){
            return replace(root.left, value);
        }
        else if(value.compareTo(root.data.word)>0){
            return replace(root.right, value);
        }
        else{
            return root;
        }
    }
}

public class RedBlackTree {
    public static void main(String[] args) {
        // MyTreeSet tree = new MyTreeSet();
        // tree.add("aa");
        // tree.add("b");
        // tree.add("ab");
        // tree.add("c");
        // tree.add("d");
        // tree.add("djay");
        // tree.add("ejay");
        // tree.add("fjay");
        // tree.add("gjay");
        // aa,b,ab,c,d
        //          aa  black
        //              b  red    
        //                 ab  red 
        //   
        // tree.add(4);
        // tree.add(3);
        // tree.add(28);
        // tree.add(34);
        // tree.add(5);
        // tree.add(7);
        // tree.add(1);
        // tree.add(87);
        // tree.print();
        // tree.smallest();
        // tree.biggest();
        // tree.reverse();
        
        // MyTreeSet set = MyTreeSet.arrayToTree(arr);
        // set.print();
        // set.print();
        // tree.delete();
        // tree.print();

        // MyTreeSet tree2 = new MyTreeSet();
        // tree2.add(3);
        // tree2.add(5); a
        // tree2.add(1); 
        // tree2.print();

       
    }
}

