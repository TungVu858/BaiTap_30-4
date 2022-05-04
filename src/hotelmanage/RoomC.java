package hotelmanage;

public class RoomC extends Room{
    private static final String ROOM = "C";
    private static final int PRICE = 100;


    public RoomC() {
        super(ROOM, PRICE);
    }

    @Override
    public String toString() {
        return "RoomC{" +
                "category='" + ROOM + '\'' +
                ", price=" + PRICE +
                '}';
    }
}
