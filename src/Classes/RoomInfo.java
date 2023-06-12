/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author heman
 */
abstract public class RoomInfo {
    private String roomno;
    private String roomType;
    private String bed;
    private String pricePerDay;
    
    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public RoomInfo() {
    }

    public RoomInfo(String roomno, String roomType, String bed, String pricePerDay) {
        this.roomno = roomno;
        this.roomType = roomType;
        this.bed = bed;
        this.pricePerDay = pricePerDay;
    }
   public abstract void allocateRoom();
}
