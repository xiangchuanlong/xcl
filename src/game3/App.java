package game3;

//如果有导包 -> 导, 有可能是其他包下的pictureFrame类, 导致错误
//            情况1, 你导入了之前的pictureFrame类 -> 之前的逻辑, 不显示图片
//            情况2, 你导入了之后的pictureFrame类 -> 把之后的逻辑都显示了

public class App {
    public static void main(String[] args) {
        PictureFrame p = new PictureFrame();
    }
}
