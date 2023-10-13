//Titaporn Techawathanakanok 6310451081
package ku.cs.kafe.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class OrderItem {

    @EmbeddedId
    private OrderItemKey id;

    private int quantity;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_Id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name = "menu_Id")
    private Menu menu;

    public double getSubtotal() {
        return menu.getPrice() * quantity;
    }

}
