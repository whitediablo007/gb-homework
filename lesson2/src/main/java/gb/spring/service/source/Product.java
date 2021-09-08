package gb.spring.service.source;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Product {
    private int id;
    private String name;
    private BigDecimal cost;

    public Product(int id, String name, BigDecimal cost) {
        this.id = id;
        this.name = name;
        this.cost = new BigDecimal(String.valueOf(cost)).setScale(2, RoundingMode.UP);
    }
}
