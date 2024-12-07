package dto;

import enums.BOOKING_STATUS;

import java.util.List;

public class Booking {

    private String bookingId;
    //FK-show table
    private String showId;
    private List<ShowSeat> showSeatList;
    private BOOKING_STATUS bookingStatus;
    private int amount;

}
