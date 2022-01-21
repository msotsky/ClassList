/**
*This class is the driver to test Student and Class list
*@author Maxime Sotsky 3637964
*/
import java.util.NoSuchElementException;

public class Driver {

    public static void main(String[] args) {

        //Add a number of (unsorted) items to the list.
        Student s1 = new Student("Maxime", "Sotsky", 3637964);
        Student s2 = new Student("John", "Velasquez", 3537964);
        Student s3 = new Student("Tanya", "Sotsky", 3437964);
        Student s4 = new Student("Shea", "Allain", 3337964);
        Student s5 = new Student("Cameron", "Touchie", 3237964);
        ClassList list = new ClassList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        System.out.println();

        //print the list (you should see that they are sorted)
        System.out.println(list.toString());
        System.out.println();

        //Remove a few items from the list that are currently in the list
        //(choose items in different positions to test different scenarios)
        //removing front
        System.out.println("removing front element");
        try{
            list.remove(s4);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        System.out.println(list.toString());
        System.out.println();

        //removing mid
        System.out.println("removing end element");
        try{
            list.remove(s2);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        System.out.println(list.toString());
        System.out.println();

        //removing middle
        System.out.println("removing mid element");
        try{
            list.remove(s3);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        System.out.println(list.toString());
        System.out.println();

        //Print the list again
        System.out.println("printing the list again");
        System.out.println(list.toString());
        System.out.println();

        //Add a few more items to the list
        System.out.println("Adding new elements to the list");
        Student s6 = new Student("Kris", "Moreau", 2899998);
        Student s7 = new Student("John", "Coates", 3630000);
        Student s8 = new Student("Gabe", "Chacon", 3637994);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        System.out.println(list.toString());
        System.out.println();

        //Print the contents of the list in reverse order by getting the reversed
        //contents of the list as an array and loop through it to print it out.
        System.out.println("Printing reversed order array");
        Student[] arr = list.getReverseList();
        for(Student x : arr){
            System.out.println(x.toString());
        }

        System.out.println();
        //Attempt to remove an item from the list that isn't there; catch the exception
        //Exception that is thrown & display its message
        System.out.println("Attemping to remove an element that is not in the list");
        try{
            list.remove(s2);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        //Get the number or items in the list & display it.
        System.out.println("The current list");
        System.out.println(list.toString());
        System.out.println("Getting number of items in the list");
        System.out.println(list.getNumStudents());

    }
} 
