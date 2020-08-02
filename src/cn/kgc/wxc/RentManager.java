package cn.kgc.wxc;

import java.util.Scanner;

/**
 * @Author: wxc
 * @Date:Created in 22:33 2020/7/19
 */
public class RentManager {
    //所有设备数组
    private Device[] devices = new Device[100];
    //出租设备数组
    private RentDevice[] rentDevices = new RentDevice[100];

    Scanner scanner  = new Scanner(System.in);
    public void init(){
        //电脑
        devices[0] = new Computer(100,98,"联想13.9英寸超轻薄翻转笔记本");
        devices[1] = new Computer(100,99,"小米15.6英寸金属轻薄笔记本");
        devices[2] = new Computer(100,99,"惠普小欧14英寸笔记本");
        devices[3] = new Computer(100,100,"其他类");
        //硬盘
        devices[4] = new USBDisk(100,100,128);
        devices[5] = new USBDisk(100,100,256);
        devices[6] = new USBDisk(100,100,1024);
        devices[7] = new USBDisk(100,100,512);

        rentDevices[0] = new RentDevice("stu000", devices[0]);
        rentDevices[1] = new RentDevice("stu001", devices[0]);
        rentDevices[2] = new RentDevice("stu002", devices[2]);
        rentDevices[3] = new RentDevice("stu003", devices[1]);
    }


    public void printMenu(){
        System.out.println("***欢迎访问唐城物品租赁系统***");
        System.out.println("目前只提供笔记本和U盘两种物品租赁服务，租金计算方式：\n 归还物品时，按实际租用的天数计算租金。\n  具体每日租金如下：");
        System.out.println("  >>>笔记本共有四类：\n联想13.9英寸超轻薄翻转笔记本，每日租金10元\n小米15.6英寸金属轻薄笔记本，每日租金8.8元\n惠普小欧14英寸笔记本，每日租金5元\n其他型号笔记本，每日租金4元");
        System.out.println(">>>U盘根据大小计算每日租金：\n容量1T，每日租金1.48元\n容量512G，每日租金1元\n容量256G，每日租金0.88元\n容量低于256G，每日租金0.5元");
    }

    public void menu(){
        System.out.println("系统功能列表\n" +
                "1、查看所有物品\n" +
                "2、查看物品租用情况\n" +
                "3、出租物品4、归还物品\n" +
                "0、退出系统\n" +
                "请选择>>>");
    }

    //问题1
    public void showAllShop(){
        Computer c =null;
        USBDisk u =null;
        for ( int i =0;i<devices.length;i++){
           if (devices[i]!=null){
               if (devices[i] instanceof Computer){
                   c = (Computer)devices[i];
                   System.out.println("序号："+(i+1)+"," + c.toString());;
               }else {
                    u = (USBDisk) devices[i];
                   System.out.println("序号："+(i+1)+"," +u.toString());;
               }
           }
        }
    }



    //问题2
    public void showZuJie(){
        for (RentDevice r: rentDevices) {
            if (r != null){
                r.showInfo();
                System.out.println("------------------------------------------------------------------");
            }
        }
    }

    //问题3
    public  void zujie(){
        System.out.print("请输入想要租借的物品序号>>>");
        int index = scanner.nextInt();
        System.out.print("请输入租用人的学号>>>");
        String sid = scanner.next();
        RentDevice rd = null;
        Device d = devices[index-1];
        boolean flag = false;
        if (devices[index-1].getSurplus()-1>0){
            for (int j = 0 ; j <rentDevices.length ; j++){
                if (rentDevices[j]==null){
                    rentDevices[j]=new RentDevice(sid,d);
                    //租借后数量-1
                    devices[index-1].setSurplus(devices[index-1].getSurplus()-1);
                    flag = true;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("租借成功");
        }else{
            System.out.println("租借失败");
        }

    }

    public void guihuan(){
        System.out.print("请输入想要归还的物品序号>>>");
        int index = scanner.nextInt();
        System.out.print("请输入租用人的学号>>>");
        String sid = scanner.next();
        for (int i = 0 ; i <rentDevices.length ;i++){
            if (rentDevices[i]!=null && sid.equals(rentDevices[i])){
                rentDevices[i] = null;
                //归还后数量+1
                devices[index-1].setSurplus(devices[index-1].getSurplus()+1);
            }
        }
    }


    public void guihuan1(){
        System.out.print("请输入想要归还的物品序号>>>");
        int index = scanner.nextInt();
        Computer cwp =null;
        USBDisk uwp =null;
        if (devices[index-1] instanceof Computer){
            cwp=(Computer) devices[index-1] ;
        }else{
            uwp=(USBDisk) devices[index-1] ;
        }
        System.out.print("请输入租用人的学号>>>");
        String sid = scanner.next();
        boolean flag  = false;
        for (int i = 0 ; i < rentDevices.length ; i++){
            if (rentDevices[i]!=null && rentDevices[i].getSid().equals(sid)){
                if (rentDevices[i].getEquipment() instanceof Computer){
                    Computer c = ((Computer)(rentDevices[i].getEquipment()));
                    if (c.getType().equals(cwp.getType())){
                        rentDevices[i]=null;

                    }
                }else {
                    USBDisk u = (USBDisk) rentDevices[i].getEquipment();
                    if (u.getCapacity()==u.getCapacity()){
                        rentDevices[i]=null;
                    };
                }
                devices[index-1].setSurplus(devices[index-1].getSurplus()+1);
                flag  = true;
            }
        }
        if (flag){
            System.out.println("ok");
        }else {
            System.out.println("no");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RentManager r = new RentManager();
        r.init();
        r.printMenu();
        while (true){
            r.menu();
            int i =  s.nextInt();
            switch (i){
                case 1:
                    r.showAllShop();
                    break;
                case 2:
                    r.showZuJie();
                    break;
                case 3:
                    r.showAllShop();
                    r.zujie();
                    break;
                case 4:
                    r.showAllShop();
                    r.guihuan1();
                    break;
                case 0:
                    String  str = "";
                    do {
                        System.out.println("是否退出？Y：退出|N：继续");
                        str=s.next();
                        if ("Y".equals(str.toUpperCase())){
                            System.out.println("系统结束");
                            System.exit(0);
                        }else if("N".equals(str.toUpperCase())){
                            System.out.println("系统继续");
                            break;
                        }else {
                            System.out.println("请输入Y|N");
                            continue;
                        }
                    }while (true);
                    break;
                default:
                    System.out.println("功能暂未开通，敬请期待");
                    break;
            }
        }
    }

}
