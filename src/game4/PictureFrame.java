package game4;
/*
    图片打乱
        将图片编号数组移动到成员位置,使用0将16替换
        定义方法randomDate打乱图片
        在绘制窗口组件之前,调用randomDate方法
 */

import javax.swing.*;
import java.util.Random;

//定义类PictureFrame,继承JFrame
public class PictureFrame extends JFrame {
    //将二维数组提取到成员位置
    private int[][] datas = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    //在PictureFrame类中编写空参构造
    public PictureFrame() {
        //initFrame(); 窗体基本设置
        initFrame();
        //图片打乱要在绘制窗口组件之前
        randomDate();
        //paintView(); 窗口组件
        paintView();
        //setVisible(true); 窗体可见
        setVisible(true);
    }

    //窗口组件
    private void paintView() {
        //标题图片
        JLabel titleLabel = new JLabel(new ImageIcon("day09\\images\\title.png"));
        titleLabel.setBounds(254, 27, 232, 57);
        this.add(titleLabel);
//        int[][] datas = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 0}
//        };
        //JPanel面板
        JPanel imagePanel = new JPanel();
        imagePanel.setBounds(150, 114, 360, 360);
        //取消JPanel面板默认布局
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

        //参照图
        JLabel canZhaoTuLabel = new JLabel(new ImageIcon("day09\\images\\canZhaoTu.png"));
        canZhaoTuLabel.setBounds(574, 114, 122, 121);
        this.add(canZhaoTuLabel);
        //上按钮
        JButton shangButton = new JButton(new ImageIcon("day09\\images\\shang.png"));
        shangButton.setBounds(732, 265, 57, 57);
        this.add(shangButton);
        //左按钮
        JButton zuoButton = new JButton(new ImageIcon("day09\\images\\zuo.png"));
        zuoButton.setBounds(650, 347, 57, 57);
        this.add(zuoButton);
        //下按钮
        JButton xiaButton = new JButton(new ImageIcon("day09\\images\\xia.png"));
        xiaButton.setBounds(732, 347, 57, 57);
        this.add(xiaButton);
        //右按钮
        JButton youButton = new JButton(new ImageIcon("day09\\images\\you.png"));
        youButton.setBounds(813, 347, 57, 57);
        this.add(youButton);
        //求助按钮
        JButton qiuZhuButton = new JButton(new ImageIcon("day09\\images\\qiuzhu.png"));
        qiuZhuButton.setBounds(626, 444, 108, 45);
        this.add(qiuZhuButton);
        //重置按钮
        JButton chongZhiButton = new JButton(new ImageIcon("day09\\images\\chongzhi.png"));
        chongZhiButton.setBounds(786, 444, 108, 45);
        this.add(chongZhiButton);
        //背景图
        JLabel backgroundLabel = new JLabel(new ImageIcon("day09\\images\\background.png"));
        backgroundLabel.setBounds(0, 0, 968, 530);
        this.add(backgroundLabel);
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

    //图片打乱
    public void randomDate() {
        Random r = new Random();
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                int x = r.nextInt(datas.length); //随机的一维数组
                int y = r.nextInt(datas[x].length);  //一维长度中,找随机的元素
                //交换元素
                int temp = datas[i][j];
                datas[i][j] = datas[x][y];
                datas[x][y] = temp;
            }
        }
    }
}
