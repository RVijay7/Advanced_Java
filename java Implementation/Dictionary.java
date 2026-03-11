public class Dictionary {
    public static void main(String[] args) {
        System.out.println("\n================================");
        System.out.println("========== Dictionary ==========");
        System.out.println("================================\n");
        Meaning m1 = new Meaning("Apple", "The Fruit with red color");
        Meaning m2 = new Meaning("Ball", "A thing that will bounce"); 
        Meaning m3 = new Meaning("Bat", "A thing that will hit");    
        MyTreeSet dictionary = new MyTreeSet();
        dictionary.add(m2);
        dictionary.add(m1);
        dictionary.add(m3);
        dictionary.print();
        dictionary.reverse();
        dictionary.contains("apple");
        System.out.println(dictionary.isEmpty());
        dictionary.update("BAt","Batsman used this to hit the ball");
        dictionary.print();
        dictionary.firstElement();
        dictionary.lastElement();
        dictionary.delete();
        System.out.println(dictionary.isEmpty());
    }
}

