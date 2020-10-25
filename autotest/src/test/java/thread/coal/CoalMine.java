package thread.coal;

public class CoalMine {

    private static Integer capacity = 1000;

    public static synchronized Integer getCapacityAndDecreaseByTen(){
        return capacity-=10;
    }

//    public static Integer getCapacityAndDecreaseByTen(){
//        return capacity-=10;
//    }

}
