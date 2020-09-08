package pl.camp.it.ApartHouseRegistration.model;

import javax.persistence.*;

@Entity(name = "tapartments")
public class Apartments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private int number;
    @Column(nullable = false)
    private int roomCount;
    @Column(nullable = false, length = 3)
    private int bedCount;
    @Column(nullable = false )
    private int priceForDay;
    @Enumerated(EnumType.STRING)
    private Kitchenette kitchenette;
    @Enumerated(EnumType.STRING)
    private PetFriendly petFriendly;
    @Enumerated(EnumType.STRING)
    private ReadyToRent readyToRent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public Kitchenette getKitchenette() {
        return kitchenette;
    }

    public void setKitchenette(Kitchenette kitchenette) {
        this.kitchenette = kitchenette;
    }

    public PetFriendly getPetFriendly() {
        return petFriendly;
    }

    public void setPetFriendly(PetFriendly petFriendly) {
        this.petFriendly = petFriendly;
    }

    public ReadyToRent getReadyToRent() {
        return readyToRent;
    }

    public void setReadyToRent(ReadyToRent readyToRent) {
        this.readyToRent = readyToRent;
    }

    public int getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(int priceForDay) {
        this.priceForDay = priceForDay;
    }

    @Override
    public String toString() {
        return "Apartments{" +
                "id=" + id +
                ", number=" + number +
                ", roomCount=" + roomCount +
                ", bedCount=" + bedCount +
                ", priceForDay=" + priceForDay +
                ", kitchenette=" + kitchenette +
                ", petFriendly=" + petFriendly +
                ", readyToRent=" + readyToRent +
                '}';
    }

    public enum Kitchenette {
        YES,
        NO
    }
    public enum PetFriendly{
        Yes,
        NO
    }
    public enum ReadyToRent{
        Yes,
        NO
    }

}
