package block.Test;

import block.model.Shape;
import block.model.ShapeFactory;

/**
 * @author Ancrazyking
 * @date 2018/4/26 15:33
 **/
public class test
{
    public static void main(String[] args)
    {

        for (int i = 0; i < 10; i++)
        {
            Shape shape = ShapeFactory.createShape();
            shape.show();
            System.out.println("===============");
        }

    }


}
