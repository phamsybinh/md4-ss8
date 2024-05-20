package ra.orm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 50)
    private String name;
    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private Integer stock;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private Date createdAt;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('MALE', 'FEMALE')")
    private ProductType productType;
    private Boolean isDeleted;
}
