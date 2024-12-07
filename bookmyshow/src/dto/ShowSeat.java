package dto;

import enums.SEAT_STATUS;

public class ShowSeat {
    //PK
    private String showSeatId;
    //FK - show table
    private String showId;
    //FK- seat table
    private String seatId;
    private int price;
    private SEAT_STATUS seatStatus;

    public String getShowSeatId() {
        return showSeatId;
    }

    public void setShowSeatId(String showSeatId) {
        this.showSeatId = showSeatId;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SEAT_STATUS getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SEAT_STATUS seatStatus) {
        this.seatStatus = seatStatus;
    }
}
