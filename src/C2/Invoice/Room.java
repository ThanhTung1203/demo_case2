package C2.Invoice;

public class Room {
    private int id_room;
    private String name_room;
    private double price;
    private boolean status_room;

    @Override
    public String toString() {
        return "Room{" +
                "id_room=" + id_room +
                ", name_room='" + name_room + '\'' +
                ", price=" + price +
                ", status_room=" + status_room +
                '}';
    }

    public Room(int id_room, String name_room, double price) {
        this.id_room = id_room;
        this.name_room = name_room;
        this.price = price;
        this.status_room = true;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public void setName_room(String name_room) {
        this.name_room = name_room;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus_room(boolean status_room) {
        this.status_room = status_room;
    }

    public int getId_room() {
        return id_room;
    }

    public String getName_room() {
        return name_room;
    }

    public double getPrice() {
        return price;
    }

    public boolean isStatus_room() {
        return status_room;
    }

}

