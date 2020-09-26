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
