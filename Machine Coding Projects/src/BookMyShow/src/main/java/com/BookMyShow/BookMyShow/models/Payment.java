package BookMyShow.src.main.java.com.BookMyShow.BookMyShow.models;

import ParkingLot.models.constants.PaymentStatus;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private int refNo;
    private int amount;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.ORDINAL)
    private PaymentType paymentType;
}
