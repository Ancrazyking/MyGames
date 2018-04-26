package block.model;

import java.awt.*;
import java.util.Random;

/**
 * @author Ancrazyking
 * @date 2018/4/26 15:24
 **/
public class ShapeFactory
{
    public ShapeFactory(){

    }

    public static int[][][] Shapes={
            {
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,0,0},
            },
            {
                    {0,1,0,0},
                    {0,1,0,0},
                    {0,1,1,0},
                    {0,0,0,0}
            },
            {
                    {0,0,1,0},
                    {0,0,1,0},
                    {0,1,1,0},
                    {0,0,0,0}
            },
            {
                    {0,0,0,0},
                    {0,1,1,0},
                    {0,1,1,0},
                    {0,0,0,0}
            },
            {
                    {0,0,0,0},
                    {0,1,0,0},
                    {1,1,1,0},
                    {0,0,0,0}
            },
            {
                    {0,1,0,0},
                    {0,1,1,0},
                    {0,0,1,0},
                    {0,0,0,0}
            },
            {
                    {0,0,1,0},
                    {0,1,1,0},
                    {0,1,0,0},
                    {0,0,0,0}
            }
    };


    public static Color[] colors={
            new Color(0xCC0033),
            new Color(0x0099CC),
            new Color(0xFF6600),
            new Color(0x33CC33),
            new Color(0x006600),
            new Color(0x990099),
            new Color(0x663300)
    };


    public static Shape createShape(){
        Random r=new Random();
        int index=r.nextInt(7);
        int[][] tmp=Shapes[index];
        Shape shape=new Shape();
        shape.setArray(tmp);
        shape.setColor(colors[index]);
        return  shape;
    }
}
