package cn.kgc.wxc;

/**
 * @Author: wxc
 * @Date:Created in 22:22 2020/7/19
 */
public abstract class Device {
    //总数
    private  int amount;
    //剩余
    private  int surplus;

    public Device() {
    }

    public Device(int amount, int surplus) {
        this.amount = amount;
        this.surplus = surplus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSurplus() {
        return surplus;
    }

    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }

    public abstract double calcRent(int days);

    public abstract void showInfo();

    @Override
    public String toString() {
        return   "总数量=" + amount +", 剩余=" + surplus ;
    }
}
