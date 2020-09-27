package com.example.reserv_rooms;

public class roomDet {

    String roomId;
    String type;
    String no;
    String des;
    String price;
    String sp;
    String sports;
    String ref;
    String boat;
    String sight;


    public roomDet(){

    }


    public roomDet(String roomId, String type, String no, String des, String price, String sp, String sports, String ref, String boat, String sight) {
        this.roomId = roomId;
        this.type = type;
        this.no = no;
        this.des = des;
        this.price = price;
        this.sp = sp;
        this.sports = sports;
        this.ref = ref;
        this.boat = boat;
        this.sight = sight;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setBoat(String boat) {
        this.boat = boat;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getType() {
        return type;
    }

    public String getNo() {
        return no;
    }

    public String getDes() {
        return des;
    }

    public String getPrice() {
        return price;
    }

    public String getSp() {
        return sp;
    }

    public String getSports() {
        return sports;
    }

    public String getRef() {
        return ref;
    }

    public String getBoat() {
        return boat;
    }

    public String getSight() {
        return sight;
    }

}
