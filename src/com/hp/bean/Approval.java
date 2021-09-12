package com.hp.bean;



public class Approval {
    private int paID;
    private int pId;
    private String paDate;
    private String paState;

    public Approval() {
    }

    public Approval(int paID, int pId, String paDate, String paState) {
        this.paID = paID;
        this.pId = pId;
        this.paDate = paDate;
        this.paState = paState;
    }

    @Override
    public String toString() {
        return "Approval{" +
                "paID=" + paID +
                ", pId=" + pId +
                ", paDate=" + paDate +
                ", paState='" + paState + '\'' +
                '}';
    }

    public int getPaID() {
        return paID;
    }

    public void setPaID(int paID) {
        this.paID = paID;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getPaDate() {
        return paDate;
    }

    public void setPaDate(String paDate) {
        this.paDate = paDate;
    }

    public String getPaState() {
        return paState;
    }

    public void setPaState(String paState) {
        this.paState = paState;
    }
}
