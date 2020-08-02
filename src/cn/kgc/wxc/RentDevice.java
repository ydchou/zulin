package cn.kgc.wxc;

/**
 * @Author: wxc
 * @Date:Created in 22:29 2020/7/19
 */
public class RentDevice {

    private String sid;
    private Device equipment;



    public RentDevice() {
    }

    public RentDevice(String sid, Device equipment) {
        this.sid = sid;
        this.equipment = equipment;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Device getEquipment() {
        return equipment;
    }

    public void setEquipment(Device equipment) {
        this.equipment = equipment;
    }

    public  void  showInfo(){
        System.out.println("租用人学号："+sid);
        equipment.showInfo();
    }


}
