package avlTree;

public class AVLMain {
    public static void main(String[] args) {

        AVL<Integer, String> st = new AVL<>();
        st.put(75, "Apple"); st.put(80, "Grape"); st.put(85, "Lime");
        st.put(20, "Mango"); st.put(10, "Strawberry"); st.put(50, "Banana");
        st.put(30, "Cherry"); st.put(40, "Watermelon"); st.put(70, "Melon");
        st.put(90, "fruit");
        st.print(st.getRoot());

        System.out.println("\n\n");
        System.out.println("75와 85 삭제 후 : \n");
        st.delete(75);
        st.delete(85);
        st.print(st.getRoot());

    }

}
