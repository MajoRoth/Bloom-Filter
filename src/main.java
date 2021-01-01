public class main {
    public static void main(String args[]){
        int m = 100;
        int k = 3;
        BelongTable t = new BelongTable(m, k);
        t.add_element("hey");
        t.add_element("cow");
        t.add_element("milk");
        System.out.println(t.is_belong("hey"));

    }
}
