public class Test21 {

    static {
        System.out.println("我是父类的静态代码块");
    }

    {
        System.out.println("我是父类的构造代码块");
    }

    public Test21() {
        System.out.println("我是父类的构造方法");
    }

    public static void method() {
        System.out.println("被static修饰的静态方法");
    }
    public void add(){
        System.out.println("父类的普通方法");
    }

    public static void main(String[] args) {
        Test21 parentClass = new Test21();
        parentClass.add();
    }

}
