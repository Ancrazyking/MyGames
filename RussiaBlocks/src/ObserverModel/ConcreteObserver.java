package ObserverModel;

/**
 * @author Ancrazyking
 * @date 2018/4/26 14:43
 **/
public class ConcreteObserver extends Observer
{
    public ConcreteObserver(String name,Subject subject){
        super(name,subject);
    }



    @Override
    public void update(){

        System.out.println(super.getName()+"收到"+super.getSubject().getName()+"的通知");

    }

}
