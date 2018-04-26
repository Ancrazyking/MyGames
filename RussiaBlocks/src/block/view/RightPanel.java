package block.view;

import block.model.Shape;

import java.awt.*;

import javax.swing.*;

/**
 * @author Ancrazyking
 * @date 2018/4/26 15:53
 **/
public class RightPanel extends JPanel
{

    private static final long serialVersionUID = 1L;
    private Shape shape;
    private Integer score;

    public RightPanel()
    {
        setLayout(null);
        setBackground(Color.gray);
        JLabel nextShape = new JLabel("下一个...");
        nextShape.setFont(new Font("宋体", Font.PLAIN, 25));
        nextShape.setForeground(Color.BLUE);
        nextShape.setBounds(50, 10, 100, 25);
        add(nextShape);

        JLabel fs=new JLabel("分数");
        fs.setFont(new Font("宋体",Font.PLAIN,25));
        JTextField showFs=new JTextField();
        setVisible(true);
        showFs.setFont(new Font("宋体",Font.PLAIN,36));
        //String count="0";
        //setText(count);
        showFs.setEditable(false);//设置文本框不可输入
        fs.setForeground(Color.blue);
        showFs.setBackground(Color.LIGHT_GRAY);
        fs.setBounds(70, 200, 60, 30);
        showFs.setBounds(42, 230, 100, 30);
        add(fs);
        add(showFs);

        JLabel star=new JLabel("提示:按空格键可以停止/开始哦");
        star.setForeground(Color.GREEN);
        setVisible(true);
        // star.setBorder(BorderFactory.createRaisedBevelBorder());
        star.setBounds(10, 650, 180, 30);
        add(star);


    }

    public Integer getScore()
    {
        return score;
    }

    public void setScore(Integer score)
    {
        this.score = score;
    }

    public Shape getShape()
    {
        return shape;
    }

    public void setShape(Shape shape)
    {
        this.shape = shape;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        drawShape(g);
        g.setColor(Color.red);
        g.drawString(score+"",45,250);

    }

    /**
     * 画出形状
     * @param g
     */
    private void drawShape(Graphics g)
    {
        if(shape==null)return;
        int[][] arr=shape.getArray();
        int top=60;
        int left=30;
        Color color=shape.getColor();
        g.setColor(color);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    g.fill3DRect(left+j*GamePanel.SHAPESIZE,top+i*GamePanel.SHAPESIZE,GamePanel.SHAPESIZE,GamePanel.SHAPESIZE,true);
                }
            }
        }

    }


    @Override
    public void update(Graphics g){

    }

    public  static void main(String[] args){
        new RightPanel();
    }
}
