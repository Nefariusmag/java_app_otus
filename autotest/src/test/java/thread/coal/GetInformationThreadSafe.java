package thread.coal;

public class GetInformationThreadSafe {

    public void setAsFive(){
        ThreadSave.setThreadSafeVariable(5);
        System.out.println("Method sea as five: " + ThreadSave.getThreadSaveVariable());
        ThreadSave.setToDefault();
    }

    public void setAsThree(){
        ThreadSave.setThreadSafeVariable(3);
        System.out.println("Method sea as three: " + ThreadSave.getThreadSaveVariable());
        ThreadSave.setToDefault();
    }

    public void setAsFour(){
        ThreadSave.setThreadSafeVariable(4);
        System.out.println("Method sea as four: " + ThreadSave.getThreadSaveVariable());
        ThreadSave.setToDefault();
    }
}
