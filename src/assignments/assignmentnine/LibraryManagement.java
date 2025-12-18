package assignments.assignmentnine;

public class LibraryManagement{
    int bookscount =20;

    public static void main(String[] args) {

        LibraryManagement l1 = new LibraryManagement();

        Student s1 = new Student("Ragul",2);
        Student s2 = new Student("Prince",3);
        Student s3 = new Student("Abi",2);
        Student s4 = new Student("Sree",2);
        Student s5 = new Student("Shanmuga",3);
        Student s6 = new Student("kumar",2);
        Student s7 = new Student("bala",3);
        Student s8 = new Student("majith",2);
        Student s9 = new Student("aathesh",2);
        Student s10 = new Student("namashivaya",3);

        LibraryDesk library1 = new LibraryDesk(l1,s1);
        library1.start();

        LibraryDesk library2 = new LibraryDesk(l1,s2);
        library2.start();

        LibraryDesk library3 = new LibraryDesk(l1,s3);
        System.out.println("hi");
        library3.start();

        LibraryDesk library4 = new LibraryDesk(l1,s4);
        library4.start();

        LibraryDesk library5 = new LibraryDesk(l1,s5);
        library5.start();

        LibraryDesk library6 = new LibraryDesk(l1,s6);
        library6.start();

        LibraryDesk library7 = new LibraryDesk(l1,s7);
        library7.start();

        LibraryDesk library8 = new LibraryDesk(l1,s8);
        library8.start();

        LibraryDesk library9 = new LibraryDesk(l1,s9);
        library9.start();

        LibraryDesk library10 = new LibraryDesk(l1,s10);

        library10.start();
    }

}

class Student{
    String name;
    int noOfBooks;

    Student(String name,int books){
        this.name = name;
        this.noOfBooks = books;
    }
}

class LibraryDesk extends Thread{
    LibraryManagement library;
    Student student;

    LibraryDesk(LibraryManagement l1,Student s1){
        this.library = l1;
        this.student = s1;
    }

    public void run(){
        synchronized (library){
            library.bookscount = library.bookscount - student.noOfBooks;
            System.out.println(student.name+" bought "+student.noOfBooks+"  books");
            System.out.println("Remaining Books: "+library.bookscount+"\n");
        }
    }
}