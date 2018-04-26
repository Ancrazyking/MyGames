package ObserverModel;

/**
 * @author Ancrazyking
 * @date 2018/4/26 14:42
 * 具体通知者
 **/
public class ConcreteSubject extends Subject
{
    public ConcreteSubject(String name){
        super(name);
    }

    private String action;

    public String getAction()
    {
        return action;
    }

    public void setAction(String action)
    {
        this.action = action;
    }
}
