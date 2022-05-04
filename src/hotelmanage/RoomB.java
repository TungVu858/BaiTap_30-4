package hotelmanage;

public class RoomB extends Room{
    private static final String ROOM = "B";
    private static final int PRICE = 300;


    public RoomB() {
        super(ROOM, PRICE);
    }

    @Override
    public String toString() {
        return "RoomB{" +
                "category='" + ROOM + '\'' +
                ", price=" + PRICE +
                '}';
    }
}
