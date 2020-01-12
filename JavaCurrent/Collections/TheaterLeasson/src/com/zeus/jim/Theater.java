package com.zeus.jim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theater {
    private final String theaterName;
    private List<Seat> seats = new ArrayList<>();

    public Theater(String theaterName, int rowNumber, int seatsPerRow) {
        this.theaterName = theaterName;

        int lastRow = 'A' + (rowNumber-1);
        for (char row = 'A'; row <= lastRow; row++){
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++){
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheaterName() {
        return theaterName;
    }

    public boolean reserveSeat(String seatNumber){
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestSeat,null);
        if(foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        }else{
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
//        for (Seat seat: seats) {
//            if(seat.getSeatNumber().equals(seatNumber)){
//                requestSeat = seat;
//                break;
//            }
//        }
//        if(requestSeat == null){
//            System.out.println("There is no seat " + seatNumber);
//            return false;
//        }
//        return requestSeat.reserve();
    }

    public void getSeats(){
        for (Seat seat: seats) {
            System.out.println(seat.seatNumber);
        }
    }

    private class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve(){
            if(!this.reserved){
                this.reserved = true;
                System.out.println("Successfully reserved seat" + seatNumber);
                return true;
            }else{
                return false;
            }
        }

        public boolean cancel(){
            if(this.reserved){
                this.reserved = false;
                System.out.println("Successfully cancel seat" + seatNumber);
                return true;
            }else{
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }
    }
}
