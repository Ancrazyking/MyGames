package ObserverModel;

import sun.java2d.opengl.OGLContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 通知者类
 * @author Ancrazyking
 * @date 2018/4/26 14:18
 * 抽象通知者类
 **/
public abstract class  Subject
{
    private List<Observer> observers=new ArrayList<>();

    private String name;

    public Subject(String name){
        this.name=name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //新增观察者
    public void attach(Observer observer){
        observers.add(observer);
    }


    //移除观察者
    public void detach(Observer observer){
        observers.remove(observer);
    }

    //通知观察者
    public void notifyObservers(){
        for(Observer observer:observers){
            observer.update();
        }
    }


}
