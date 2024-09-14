package game5;
/*
    为什么要记录0号图片索引?
        游戏是让0号图片,和四周图片,进行交换
        所以要知道0号图片的位置
 */

import javax.swing.*;
import java.util.Random;

//定义类PictureFrame,继承JFrame
public class PictureFrame extends JFrame {
    //成员变量,图片编号数组
    private int[][] datas = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    /*
        成员变量, 用于记录0号图片的位置
            x0 :在哪个一维数组
            y0 :在一维数组的位置
     */
    private int x0;
    private int y0;

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
        //窗口组件1
        //标题图片
        JLabel titleLabel = new JLabel(new ImageIcon("day09\\images\\title.png"));
        titleLabel.setBounds(254, 27, 232, 57);
        this.add(titleLabel);
        //二维数组+JPanel面板,实现图片打乱
        //二维数组: 移动到成员位置
//        int[][] datas = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12},
//                {13, 14, 15, 16}
//        };
        //JPanel面板,设置大小
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
        //将面板添加到窗体
        this.add(imagePanel);

        //窗口组件2
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
                int x = r.nextInt(datas.length);
                int y = r.nextInt(datas[i].length);
                //交换元素
                int temp = datas[i][j];
                datas[i][j] = datas[x][y];
                datas[x][y] = temp;
            }
        }
        /*
            遍历打乱后的数组, 定位0号图片的位置
            循环标号: 给循环起名字, 然后使用break 名字; 结束该循环
         */
        lo:
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                //如果二维数组元素为0, 代表就是0号图片
                if(datas[i][j] == 0){
                    //记录索引
                    x0 = i;
                    y0 = j;
                    //循环标号,结束外层循环
                    break lo;
                }
            }
        }
        System.out.println(x0+","+y0); //打印坐标检查, 这个代码后面注释掉即可
    }
}
