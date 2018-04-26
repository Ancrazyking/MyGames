package ObserverModel;




/**
 * 抽象观察者
 * @author Ancrazyking
 * @date 2018/4/26 14:17
 **/
public abstract class Observer
{
    private String name;
    private Subject subject;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
    }

    public Observer(String name,Subject subject){
        this.name=name;
        this.subject=subject;
    }

    public abstract void update();

}
