package J11_OOPS.O5_Access;

import com.sun.corba.se.impl.ior.OldJIDLObjectKeyTemplate;

public class ObjectDemo {
    int num;
    Float gpa;
    public ObjectDemo(int num, float gpa){
        this.num = num;
        this.gpa = gpa;
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
    }
    //hashmap lecture
    @Override
    public int hashCode(){
        return super.hashCode();  //return num;
    }
    @Override
    public boolean equals(Object obj){
        return this.num == ((ObjectDemo)obj).num;  //super.equals(obj)
    }
    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public static void main(String[] args) {
        ObjectDemo obj1 = new ObjectDemo(34,56.8f);
        ObjectDemo obj2 = obj1;
        ObjectDemo obj3 = new ObjectDemo(34,78.9f);
//        System.out.println(obj1.hashCode());  //it's not a address it's just random unique numbers
//        System.out.println(obj2.hashCode());
//        System.out.println(obj3.hashCode());
        if (obj1 == obj3){
            System.out.println("obj1 is equal to obj3");
        }
        if (obj1.equals(obj3)){
            System.out.println("obj1   is equal to obj3");
        }
        System.out.println(obj3.getClass()); //(store in heap)it is final that's why we can't override this
        System.out.println(obj3.getClass().getName());
    }
}
