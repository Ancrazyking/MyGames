package block.view;

import block.model.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Ancrazyking
 * @date 2018/4/26 15:49
 * 实现观察者接口
 **/
public class GamePanel extends JPanel implements Observer
{
    public static final int SHAPESIZE = 30;
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 450;
    private static final int HEIGHT = 720;
    private Shape shape;
    private int[][] container;
    private RightPanel rightPanel;
    private Integer score;
    private JButton start;//开始状态

    //GamePanel的构造方法
    public GamePanel(JButton start)
    {
        this.start = start;
        setBackground(Color.darkGray);//设置游戏区的背景颜色
        //当container满的时候点击开始游戏,container里的形状消失
        container = new int[HEIGHT / SHAPESIZE][WIDTH / SHAPESIZE];
        setFocusable(true);
        addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyPressed(KeyEvent e)
            {
                super.keyPressed(e);
                switch (e.getKeyCode())
                {
                    case KeyEvent.VK_LEFT:
                        if (canLeft())
                            shape.removeLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (canRight())
                            shape.removeRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        if (canDownFast())
                            shape.removeDown();
                        break;
                    case KeyEvent.VK_UP:
                        if (canRotate())
                            shape.rotate();
                        break;
                    case KeyEvent.VK_SPACE:
                        boolean pause = shape.isPause() ? false : true;
                        shape.setPause(pause);
                        break;
                }
            }

            //判断能否向左移动
            private boolean canLeft()
            {
                int top = shape.getTop();
                int left = shape.getLeft();
                int[][] arr = shape.getArray();
                for (int i = 0; i < arr.length; i++)
                {
                    for (int j = 0; j < arr[i].length; j++)
                    {
                        if (arr[i][j] == 1)
                        {
                            if (left + j < 0 || container[top + i][left + j - 1] != 0)
                            {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }


            //判断能否向右移动
            public boolean canRight()
            {
                int top = shape.getTop();
                int left = shape.getLeft();
                int[][] arr = shape.getArray();
                for (int i = 0; i < arr.length; i++)
                {
                    for (int j = 0; j < arr[i].length; j++)
                    {
                        if (arr[i][j] == 1)
                        {
                            if (left + j > 13 || container[top + i][left + j + 1] != 0)
                            {
                                return false;
                            }
                        }
                    }
                }
                return true;

            }


            //判断能否向下加速移动
            private boolean canDownFast()
            {
                int[][] arr = shape.getArray();
                int top = shape.getTop();
                int left = shape.getLeft();
                for (int i = 0; i < arr.length; i++)
                {
                    for (int j = 0; j < arr[i].length; j++)
                    {
                        if (arr[i][j] == 1)
                        {
                            if (left + j > 14 || container[top + i][left + j] != 0)
                            {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }

            //判断形状在边界的时候是否能够旋转
            private boolean canRotate()
            {
                int top = shape.getTop(), left = shape.getLeft();
                int[][] array = new int[4][4];
                for (int i = 0; i < 4; i++)//克隆形状到array
                    array[i] = shape.getArray()[i].clone();//数组克隆
                //旋转array
                int t;
                t = array[0][0];
                array[0][0] = array[0][3];
                array[0][3] = array[3][3];
                array[3][3] = array[3][0];
                array[3][0] = t;
                t = array[0][1];
                array[0][1] = array[1][3];
                array[1][3] = array[3][2];
                array[3][2] = array[2][0];
                array[2][0] = t;
                t = array[0][2];
                array[0][2] = array[2][3];
                array[2][3] = array[3][1];
                array[3][1] = array[1][0];
                array[1][0] = t;
                t = array[1][1];
                array[1][1] = array[1][2];
                array[1][2] = array[2][2];
                array[2][2] = array[2][1];
                array[2][1] = t;

                //判断旋转后的形状是否和容器（container）中的1重合或是否超出容器边界
                for (int i = 0; i < array.length; i++)
                    for (int j = 0; j < array[i].length; j++)
                    {
                        if (array[i][j] == 1)
                        {
                            if (left + j <= 0 || left + j >= 15 || container[top + i][left + j] != 0)
                                return false;
                        }
                    }
                return true;
            }

        });
    }

    public void setRightPanel(RightPanel rightPanel)
    {
        this.rightPanel = rightPanel;
    }

    public JButton getStart()
    {
        return start;
    }

    public void setStart(JButton start)
    {
        this.start = start;
    }

    //当container满的时候点击开始游戏,container里的形状消失
    public void reset()
    {
        for (int i = 0; i < container.length; i++)
        {
            for (int j = 0; j < container[i].length; j++)
            {
                container[i][j] = 0;
                repaint();
            }
        }
    }

    @Override
    public void update(Observable o, Object arg)
    {

    }
}
