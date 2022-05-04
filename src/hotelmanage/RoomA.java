package hotelmanage;

public class RoomA extends Room {
    private static final String ROOM = "A";
    private static final int PRICE = 500;

    public RoomA() {
        super(ROOM, PRICE);
    }

    @Override
    public String toString() {
        return "RoomA{" +
                "category='" + ROOM + '\'' +
                ", price=" + PRICE +
                '}';
    }
}
