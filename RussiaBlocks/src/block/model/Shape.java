package block.model;

import block.listener.ShapeListener;

import java.awt.*;
import java.util.Observable;

/**
 * @author Ancrazyking
 * @date 2018/4/26 14:59
 **/
public class Shape extends Observable
{
    private int[][] array;
    private int top = 0;
    private int left = 7;
    private Color color;
    private boolean canDown = true;//设置形状是否触底,flase为未触底
    private boolean isPause = false;//暂停,默认为flase

    public int[][] getArray()
    {
        return array;
    }

    public void setArray(int[][] array)
    {
        this.array = array;
    }

    public int getTop()
    {
        return top;
    }

    public void setTop(int top)
    {
        this.top = top;
    }

    public int getLeft()
    {
        return left;
    }

    public void setLeft(int left)
    {
        this.left = left;
    }

    public Color getColor()
    {
        return color;
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

    public boolean isPause()
    {
        return isPause;
    }

    public void setPause(boolean pause)
    {
        isPause = pause;
    }


    public void setCanDown(ShapeListener shapeListener)
    {
        this.canDown = shapeListener.canDown();
    }


    /**
     * 创建向下移动的线程,当CanDown为false时终止线程
     */
    public void move()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while (canDown)
                {
                    System.out.println("==>" + isPause);
                    if (isPause) continue;//判断是否停止,如果isPause为真则停止,continue以下的语句不在执行
                    top++;
                    setChanged();
                    notifyObservers();
                    try
                    {
                        Thread.sleep(500);
                    } catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    //旋转方法
    public void rotate(){
        int t;
        t=array[0][0];array[0][0]=array[0][3];array[0][3]=array[3][3];array[3][3]=array[3][0];array[3][0]=t;
        t=array[0][1];array[0][1]=array[1][3];array[1][3]=array[3][2];array[3][2]=array[2][0];array[2][0]=t;
        t=array[0][2];array[0][2]=array[2][3];array[2][3]=array[3][1];array[3][1]=array[1][0];array[1][0]=t;
        t=array[1][1];array[1][1]=array[1][2];array[1][2]=array[2][2];array[2][2]=array[2][1];array[2][1]=t;
        setChanged();
        notifyObservers();
    }

    //向左移动
    public void removeLeft(){
        left--;
        setChanged();
        notifyObservers();
    }

    //向右移动
     public void removeRight(){
        setChanged();
        notifyObservers();
     }

     //向下移动
     public void removeDown(){
        top++;
        setChanged();
        notifyObservers();
     }



     public void show(){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                System.out.print(array[i][j]+"\t");
            }
            System.out.println();
        }
     }
}
