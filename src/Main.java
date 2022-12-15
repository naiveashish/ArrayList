import java.util.ArrayList;

public class Main {
    /*ArrayList dynamic array ~ can grow and shrink
    it is used for list implementation it increases
    by 1.5 times or n/2 times
     */
    public static void main(String[] args) {
        //syntax
        ArrayList<Integer> al = new ArrayList<>();
        /*ArrayList<Integer> al = new ArrayList<>(10);
       we can provide capacity of arraylist its act as normal array
        */
        // add ele at end
        al.add(10);
        al.add(20);
        al.add(60);
        al.add(70);
        // size / length of array
        System.out.println(al.size());
        // get(index) get ele at index
        System.out.println(al.get(1));
        //add (i,e) add ele at desired index
        // ele at 0 index will be shifted to right
        al.add(0,5);
        // set(i,e) update ele e at index i
        al.set(2,40);
        al.set(4,100);
        // remove(i) delete el at i and shift eles to left.
        al.remove(1);
        // remove(o) it removes object
//        Integer i = 60;
//        al.remove(i);
        // question on array list
        // q. remove consecutive duplicates
        // solution...
        int ip [] = {10,10,20,20,20,30,30,40,10};
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(ip[0]);
        for(int j = 1; j < ip.length;j++){
            if(ip[j-1]!=ip[j]){
                ans.add(ip[j]);
            }
        }
        System.out.println(ans);
        System.out.println("===========================");
    }
}