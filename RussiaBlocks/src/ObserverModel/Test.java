package ObserverModel;

/**
 * @author Ancrazyking
 * @date 2018/4/26 14:46
 **/
public class Test
{
    public static void main(String[] args){
        ConcreteSubject concreteSubject=new ConcreteSubject("通知者");
        ConcreteObserver concreteObserver=new ConcreteObserver("订阅者",concreteSubject);

        concreteSubject.attach(concreteObserver);
        concreteSubject.notifyObservers();


    }



}
