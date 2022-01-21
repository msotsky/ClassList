/**
 * @author Maxime Sotksy (3637964)
 * This class represents a list of students represented in a doubly linked list
 */
import java.util.NoSuchElementException;
public class ClassList extends java.lang.Object {
    /**
     * Represents a doubly-linked list made up of students.
     * NOTE: You may NOT use the java.util.LinkedList class
     */
    
    private class StudentNode extends java.lang.Object{
        /**
         * An inner class that represents a node in the class.list;
         * the public variables are accressed by the ClassList class.
         */

        /** The student referenced by this node */
        public Student data;
        /**The next node in the list*/
        public ClassList.StudentNode next;
        /**The previous node in the list*/
        public ClassList.StudentNode prev;


        /**Constructs a node containing the given studen 
         * @param dataIn - The student reference by this node
        */
        StudentNode(Student dataIn){
            this.data = dataIn;
            this.next = null;
            this.prev = null;
        }
    }

    /**The last node in the list*/
    private ClassList.StudentNode end;
    /**The first node in the list */
    private ClassList.StudentNode front;
    /**The current size of the list */
    private int size;

    /**
     * Returns a textual string of the contents of the list in order
     * @return -string of the contents of the list in order
     * @Override
     */
    public String toString(){
        StudentNode curr = this.front;
        String res = "";
        while(curr != null){
            res = res + curr.data.toString();
            curr = curr.next;
        }
        return res;
    }

    /**Add a new node representing a specified student at the appropriate position
     * in the list; proper ordering of the students must be maitained
     * @param studentIn -The student object to be inserted
     */
    public void add(Student studentIn){
        StudentNode toAdd = new StudentNode(studentIn);
        if(this.front == null){
            this.front = toAdd;
            this.end = toAdd;
            this.size++;
        }
        else if(this.front.data.compareTo(toAdd.data) >= 0){
            toAdd.next = this.front;
            toAdd.next.prev = toAdd;
            this.front = toAdd;
            this.size++;
        }
        else{
            StudentNode curr = this.front;
            while(curr.next != null && curr.next.data.compareTo(toAdd.data) < 0){
                curr = curr.next;
            }
            toAdd.next = curr.next;
            if(curr.next != null){
                toAdd.next.prev = toAdd;
            }
            if(curr.next == null){
                this.end = toAdd;
            }
            curr.next = toAdd;
            toAdd.prev = curr;

            this.size++;
        }
    }
    /**
     * Returns the number of students currently in the list
     * @return -integer value representing the number of students currently in the list
     */
    public int getNumStudents(){
        return this.size;
    }

    /**Creates and returns an array containing all of the students
     * in this list, stored in reverse order in the array
     * (ie: index 0 contains the first student the last element in the list)
     * @return -Student array containing all of the students in reverse order
     */
    public Student[] getReverseList(){
        Student[] stuArr = new Student[this.size];
        StudentNode curr = this.end;
        for(int i = 0; i < this.size;i++){
            stuArr[i] = curr.data;
            curr = curr.prev;
        }
        return stuArr;
    }
    /**
     * Removes from this list the node containing the specified student
     * @param studentOut - The student object to be removed from the list
     */
    public void remove(Student studentOut)throws NoSuchElementException{

        if(studentOut == null){
            throw new NoSuchElementException("Student must not be null");
        }

        else if(this.front == null){
            return;
        }
        else if(this.front.data.compareTo(studentOut) == 0){
            this.front = this.front.next;
            this.size--;
        }
        
        else if(this.end.data.compareTo(studentOut) == 0){
            this.end = this.end.prev;
            this.end.next = null;
            this.size--;
        }
        else{
            StudentNode curr = this.front;
            while(curr.next != null && curr.data.compareTo(studentOut) != 0){
                curr = curr.next;
            }
            if(curr.next != null){
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                this.size--;
                }
            else{
                throw new NoSuchElementException("Student not found.");
            }
        }
    }
}
