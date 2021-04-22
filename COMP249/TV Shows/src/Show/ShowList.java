// -----------------------------------------------------
// Part: 2C
// Written by: Chloe Hei Yu Law - 40173275
// -----------------------------------------------------
package Show;
import java.util.NoSuchElementException;

/**
 * Have an inner class
 */
public class ShowList {

    /**
     * the inner class
     */
    public static class ShowNode{
        private TVShow tvShow;
        private ShowNode nextNode;

        /**
         * default constructor, which assigns both attributes to null
         */
        public ShowNode(){
            tvShow = null;
            nextNode = null;
        }

        /**
         * parameterized constructor
         * @param tvShow object
         * @param showNode object
         */
        public ShowNode(TVShow tvShow, ShowNode showNode){
            this.tvShow = tvShow;
            this.nextNode = showNode;
        }

        /**
         * Copy constructor
         * @param sn object
         */
        ShowNode(ShowNode sn){
            this.tvShow = sn.tvShow;
            this.nextNode = sn.nextNode;
        }

        /**
         * clone() method
         * @return cloned object
         */
        public ShowNode clone(){
            return new ShowNode(this);
        }

        /**
         * get TVShow
         * @return tvshow
         */
        public TVShow getTvShow() {
            return tvShow;
        }

        /**
         * set TV show
         * @param tvShow show
         */
        public void setTvShow(TVShow tvShow) {
            this.tvShow = tvShow;
        }

        /**
         * get next node
         * @return next node
         */
        public ShowNode getNextNode() {
            return nextNode;
        }

        /**
         * set next node
         * @param nextNode next node
         */
        public void setNextNode(ShowNode nextNode) {
            this.nextNode = nextNode;
        }

    }
    //end inner class

    private ShowNode head;
    private ShowNode currentNode;
    private ShowNode previousNode;
    private int size;


    /**
     * default constructor
     * creates an empty list
     */
    public ShowList(){
        head = null;
        size = 0;
    }

    /**
     * copy constructor
     * which accepts a ShowList object and creates a copy of it.
     * @param sl object
     */
    public ShowList(ShowList sl){
        if(sl.head ==null){
            head = null;
        }else{
            ShowNode s1 = sl.head;
            ShowNode s2 = null;
            ShowNode s3 = null;

            while(s1 != null){
                s3 = new ShowNode(s1.tvShow, null);
                if(s2 == null){
                    head = s2 = s3;
                }else{
                    s2.nextNode = s3;
                    s2 = s2.nextNode;
                }
                s1 = s1.nextNode;
            }
            s2 = s3 = null;
        }
        size = sl.size;
    }

    /**
     * toString() method
     * @return message
     */
    public String toString(){
        if(head == null)
            return "The list is empty.";
        else{
            ShowNode showNode = head;
            while(showNode != null){
                System.out.println(showNode.tvShow.toString());
                showNode = showNode.nextNode;
            }
            return "";
        }
    }

    /**
     * creates a node with that passed object and inserts this node at the head of the list
     * @param s object
     */
    public void addToStart(TVShow s){
        head = new ShowNode(s, head);
        size++;
    }

    /**
     * If the index is not valid (a valid index must have a value between 0 and size1)
     * the method must throw a NoSuchElementException and terminate the program.
     * If the index is valid,then the method creates a node with the passed Show.
     * TVShow object and inserts this node at the given index.
     * @param s object
     * @param index int
     */
    public void insertAtIndex(TVShow s, int index){
        if(index == 0)
            addToStart(s);
        else{
            try{
                if(index < 0 || index > size-1)
                    throw new NoSuchElementException();
                else{
                    ShowNode showNode = head;
                    for(int i = 0; i < index -1; i++)
                        showNode = showNode.nextNode;
                    showNode.nextNode = new ShowNode(s, showNode.nextNode);
                }
            }catch (NoSuchElementException e){
                String m = e.getMessage();
                System.out.println(m + "\nProgram will now terminate.");
                System.exit(0);
            }
        }
        size++;
    }

    /**
     * if the index is not valid, the method must throw a NoSuchElementException and terminate the program.
     *     Otherwise, the node pointed by that index is deleted from the list.
     * @param index int
     */
    public void deleteFromIndex(int index){
        if(head == null) {
            System.out.println("Could not delete because the list is empty.");
            return;
        }
        try{
            if(index < 1 || index > size-1)
                throw new NoSuchElementException();
            else{
                ShowNode showNode = head;
                for(int i = 0; i < index-1; i++){
                    showNode = showNode.nextNode;
                }
                showNode.nextNode = showNode.nextNode.nextNode;
                size--;
            }
        }catch (NoSuchElementException e){
            String m = e.getMessage();
            System.out.println(m + "\nProgram will not terminate.");
            System.exit(0);
        }
    }

    /**
     * deletes head node
     * @return true if complete
     */
    public boolean deleteFromStart(){
        if(head == null)
            return false;
        head = head.nextNode;
        size--;
        return true;
    }



    /**
     * If the index is not valid, the method simply returns;
     * otherwise, the object in the node at the passed index is to be replaced by the passed object.
     * @param s object
     * @param index int
     */
    public void replaceAtIndex(TVShow s, int index){
        if(head == null){
            System.out.println("Empty list. Could not replace");
            return;
        }
        if(index < 0 || index > size-1){
            System.out.println("Index is out of bounds.");
        }else{
            ShowNode t = head;
            if(index == 0){
                head = new ShowNode(s, head.nextNode);
            }else{
                for(int i = 0; i < index-1; i++){
                    t = t.nextNode;
                }
                t.nextNode = new ShowNode(s,t.nextNode.nextNode);
            }
        }
    }

    /**
     * privacy leak. This returns a pointer to a node that can be accessed and
     * modified and accessed without using getters and setters
     * searches the list for a ShowNode with that showID
     * @param showID string
     * @return If such an object is found, then the method returns a pointer to that ShowNode; otherwise, the method returns null.
     *          keep track of how many iterations were made before the search finally finds the course or concludes that it is not in the list
     */
    public ShowNode find(String showID){
        ShowNode t = head;
        int ctr = 0;
        while(t != null){
            if(t.tvShow.getShowID().equals(showID)){
                System.out.println("("+ctr+" iterations)");
                return t;
            }
            t = t.nextNode;
            ctr++;
        }
        return null;
    }


    /**
     * Because ths returns , there are potential privacy leaks here
     * @param newID string
     * @return a pointer to a TVShow object
     */
    public TVShow findShow(String newID){

        ShowNode current = head;
        int loopCounter = 1;

        while (current != null) {
            if (current.tvShow.getShowID().equalsIgnoreCase(newID)) {
                System.out.println("("+loopCounter + " iterations)");
                return current.getTvShow();
            }
            current = current.nextNode;
            loopCounter++;

        }
        return null;
    }

    /**
     * if contains
     * @param showID string
     * @return true if a course with that showID is in the list;
     *     // otherwise, the method returns false.
     */
    public boolean contains(String showID){
        ShowNode showNode = find(showID);
        return showNode != null;
    }

    /**
     * displays show list
     */
    public void displayShowList(){
        ShowNode pointer = head;
        while(pointer != null){
            System.out.println(pointer.getTvShow() + "\n");
            pointer = pointer.nextNode;
        }
    }

    /**
     * equals() method
     * @param other object
     * @return true of equals, else false
     */
    public boolean equals(ShowList other){
        if(this.size != other.size){
            System.out.println("False");
            return false;
        }
        else{
            boolean same = true;
            ShowNode t1 = other.head;
            ShowNode t2 = this.head;
            while(t1 != null && t2 != null){
                if(!t1.tvShow.equals(t2.tvShow)){
                    same = false;
                }
                t1 = t1.nextNode;
                t2 = t2.nextNode;
            }
            return same;
        }
    }

    /**
     * get head
     * @return head
     */
    public ShowNode getHead() {
        return head;
    }

    /**
     * set head
     * @param head head
     */
    public void setHead(ShowNode head) {
        this.head = head;
    }

    /**
     * get size
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * set size
     * @param size size
     */
    public void setSize(int size) {
        this.size = size;
    }
}
