package cn.kgc.wxc;

/**
 * @Author: wxc
 * @Date:Created in 22:25 2020/7/19
 */
public class USBDisk extends Device{

    //容量
    private int capacity;

    public USBDisk() {
    }

    public USBDisk(int amount, int surplus, int capacity) {
        super(amount, surplus);
        this.capacity = capacity;
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public double calcRent(int days) {
        if(capacity>=1024){
            return 1.48*days;
        }else if(capacity>=512){
            return 1*days;
        }else if(capacity>=256){
            return 0.88*days;
        } else {
            return 0.5*days;
        }
    }

    @Override
    public void showInfo() {
        System.out.println("U盘——容量："+this.capacity);
    }

    @Override
    public String toString() {
        return "USBDisk{" +
                "capacity=" + capacity +","+ super.toString() +
                '}';
    }
}
