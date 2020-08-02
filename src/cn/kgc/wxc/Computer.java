package cn.kgc.wxc;

/**
 * @Author: wxc
 * @Date:Created in 22:25 2020/7/19
 */
public class Computer extends Device {
    private String type;

    public Computer() {
    }

    public Computer(int amount, int surplus, String type) {
        super(amount, surplus);
        this.type = type;
    }


    public String getType() {
        return type;
    }


    @Override
    public double calcRent(int days) {
        switch (type){
            case "联想13.9英寸超轻薄翻转笔记本":
                return 10*days;
            case "小米15.6英寸金属轻薄笔记本":
                return 8.8*days;
            case "惠普小欧14英寸笔记本":
                return 5*days;
            default:
                return 4*days;
        }
    }

    @Override
    public void showInfo() {
        System.out.println( "笔记本,型号："+this.type);
    }

    @Override
    public String toString() {
        return "Computer{" + "type='" + type + '\'' + super.toString()+ '}';
    }
}
