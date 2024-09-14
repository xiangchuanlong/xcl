package game2;
/*
    窗口组件1
 */
import javax.swing.*;

//定义类PictureFrame,继承JFrame
public class PictureFrame extends JFrame {
    //在PictureFrame类中编写空参构造
    public PictureFrame() {
        //initFrame(); 窗体基本设置
        initFrame();
        //paintView(); 绘制基本组件
        paintView();
        //setVisible(true); 窗体可见
        setVisible(true);
    }

    //绘制基本组件
    private void paintView() {
        //标题图片
        JLabel titleLabel = new JLabel(new ImageIcon("day09\\images\\title.png"));
        titleLabel.setBounds(254, 27, 232, 57);
        this.add(titleLabel);
        //二维数组,存储图片编号
        int[][] datas = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        //JPanel面板
        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(150, 114, 360, 360);
        //取消JPanel默认布局
        imagePanel.setLayout(null);
        //遍历二维数组,得到图片编号
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                //通过JLabel加载图片
                JLabel imageLabel = new JLabel(new ImageIcon("day09\\images\\" + datas[i][j] + ".png"));
                //根据规律,调整图片位置
                imageLabel.setBounds(j * 90, i * 90, 90, 90);
                //将JLabel图片添加到JPanel面板
                imagePanel.add(imageLabel);
            }
        }
        //将JPanel面板添加到窗体
        this.add(imagePanel);
    }

    //窗体基本设置
    private void initFrame() {
        //设置大小
        this.setSize(960, 565);
        //设置标题
        this.setTitle("动漫拼图");
        //窗体居中
        this.setLocationRelativeTo(null);
        //窗体关闭时停止程序(控制台)
        this.setDefaultCloseOperation(3);
        //窗体置顶
        this.setAlwaysOnTop(true);
        //取消窗体默认布局
        this.setLayout(null);
    }
}
