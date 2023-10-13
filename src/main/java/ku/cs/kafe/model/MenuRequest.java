//Titaporn Techawathanakanok 6310451081
package ku.cs.kafe.model;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuRequest {
    private String name;
    private UUID categoryId;
    private String price;
}
