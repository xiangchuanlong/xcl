package day08回顾代码;

import java.util.Random;

/*
    什么是数组?
        存储多个相同类型数据的容器

    数组定义?
        int[] arr; //常用
        int arr[]; //识别

    数组初始化?
        静态初始化: int[] arr = {1, 2, 3}; //简化格式省略了new int[]的书写
        动态初始化: int[] arr = new int[5]; //创建长度为5的int数组, 元素由计算机给出默认初始化

    元素访问? 索引?
        数组名[索引];
        arr[0]; //访问arr数组中第一个元素
        arr[1]; //访问arr数组中第二个元素

        索引: 标识元素在数组中的位置, 从0开始的, 连续的逐个+1的

    常见操作?
        1.遍历数组
        2.求元素最值
        3.打乱元素

    两个异常?
        数组索引越界异常: 操作了不存在的索引
            ArrayIndexOutOfBoundsException
        空指针异常: 数组记录了null,还要去访问它的元素
            NullPointerException
 */
public class ArrayDemo {
    public static void main(String[] args) {

    }

    private static void 二位数组() {
        //二维数组: 存储一维数组的数组
        //静态
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        //动态
        int[][] brr = new int[2][3]; //二维数组中有两个一维数组,每一个长度是3

        //* 打乱二维数组元素
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int x = r.nextInt(arr.length);
                int y = r.nextInt(arr[x].length);

                int temp = arr[i][j];
                arr[i][j] = arr[x][y];
                arr[x][y] = temp;
            }
        }

        //遍历二维数组
        for (int i = 0; i < arr.length; i++) {
            //遍历每一个一维数组
            for (int j = 0; j < arr[i].length; j++) {
                //打印元素
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void 一维数组() {
        //静态初始化 -> 知道具体元素
        //int[] arr;
        //int[] arr = {1, 2, 3};
        //使用数组
        //System.out.println(arr); //由于arr是一个局部变量, 在使用之前需要初始化!

        //动态初始化 -> 不知道具体元素, 但是知道元素个数
        int[] array = new int[3];

        //获取元素并打印
        System.out.println(array[0]); //0
        System.out.println(array[1]); //0
        System.out.println(array[2]); //0

        //给元素赋值
        array[0] = 100;
        System.out.println(array[0]); //100

        System.out.println("------------------");

        //定义数组
        int[] arr = {5, 3, 2, 1, 4};
        //1.遍历数组
        for (int i = 0; i < arr.length; i++) {
            //i代表所有的索引
            //arr[i]代表所有的元素
            System.out.println(arr[i]);
        }

        System.out.println("------------------");

        //2.求元素最值
        int max = arr[0];
        int min = arr[0];
        //遍历数组
        for (int i = 0; i < arr.length; i++) {
            //如果当前元素,比max还要大,就将它赋值给max
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {//如果当前元素,比min还要小,就将它赋值给min
                min = arr[i];
            }
        }
        //打印结果
        System.out.println("max:" + max);
        System.out.println("min:" + min);

        System.out.println("------------------");

        //3.打乱元素
        int[] brr = {1, 2, 3, 4, 5};
        //创建随机数对象
        Random r = new Random();
        //遍历数组
        for (int i = 0; i < brr.length; i++) {
            //生成随机索引
            int index = r.nextInt(brr.length); //[0 - brr.length)
            //数据交换 -> 将当前元素和所及索引, 指向的元素, 进行交换
            int temp = brr[i];
            brr[i] = brr[index];
            brr[index] = temp;
        }
        //遍历数组,查看打乱的结果
        for (int i = 0; i < brr.length; i++) {
            System.out.println(brr[i]);
        }
    }
}
