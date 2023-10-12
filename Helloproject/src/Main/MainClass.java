package Main;

public class MainClass {
	public static void main(String[] args) {
        System.out.println("Hello World!");
        char a = 'A';
        float b = 12.21f;
        boolean c = true;
        double d = 4.3d;
        int e = 0x12;
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
        System.out.println(d);
        System.out.println((char) e);
        long f = (long)123.999;
        System.out.println(f);
        char g = 't';
        int h = g; 
        //short i = g; 
        short j = (short) g; 
        System.out.println(g);
        System.out.println(h);
        //System.out.println(i);
        System.out.println(j);
    }
}
