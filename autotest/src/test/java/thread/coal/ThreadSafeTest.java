package thread.coal;

import org.testng.annotations.Test;

public class ThreadSafeTest {

    @Test
    public void test1(){
        System.out.println("1");
        GetInformationThreadSafe gits = new GetInformationThreadSafe();
        gits.setAsThree();
    }

    @Test
    public void test2(){
        System.out.println("2");
        GetInformationThreadSafe gits = new GetInformationThreadSafe();
        gits.setAsFour();
    }

    @Test
    public void test3(){
        System.out.println("3");
        GetInformationThreadSafe gits = new GetInformationThreadSafe();
        gits.setAsFive();
    }


}
