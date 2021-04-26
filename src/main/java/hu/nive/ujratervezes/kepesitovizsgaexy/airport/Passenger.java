package hu.nive.ujratervezes.kepesitovizsgaexy.airport;

public class Passenger extends Person {
    private String seat;


    public Passenger(String name, int age, String seat) {
        super(name, age, Type.PASSENGER);
        this.seat = seat;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void changeSeat() {
        String seatLetter = seat.substring(seat.length() - 1);
        seat = seat.replace(seatLetter, replaceSeat(seatLetter));
    }

    private String replaceSeat(String letter) {
        switch (letter) {
            case "A" -> {
                return "C";
            }
            case "D" -> {
                return "F";
            }
            case "C" -> {
                return "A";
            }
            case "F" -> {
                return "D";
            }
            default -> {
                return letter;
            }
        }
    }
}