package ra.ss1_stringboot.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer proId;

    @Column(name = "product_name", length = 100)
    private String proName;

    @Column(name = "producer", length = 100)
    private String producer;

    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "expire_date")
    private Date expireDate;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;
}