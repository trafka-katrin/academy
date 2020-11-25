package by.academy.test;

public class Class_A {
    private String sA;
    public void setA(){
        Class_B b = new Class_B();
        b.m1();
        b.m2();
    }
    public Class_B crB(){
        Class_B bb = new Class_B();
        return bb;
    }

    public class Class_B{
        private String sB;
        public void m1(){
            System.out.println(1);
        }
        public void m2(){
            System.out.println(2);
        }
        public void m3(){
            System.out.println(1);
        }
    }
}
