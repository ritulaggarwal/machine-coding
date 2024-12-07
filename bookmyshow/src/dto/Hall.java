package dto;

import java.util.List;

public class Hall {

    private String hallId;
    private List<Seat> seatList;
    private String name;
    //FK - cinema table
    private String cinemaId;

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public List<Seat> getTotalSeats() {
        return seatList;
    }

    public void setTotalSeats(List<Seat> seatList) {
        this.seatList = seatList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }
}
