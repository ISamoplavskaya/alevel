package ua.samoplavskaya.HW_hibernate;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
@Builder

@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private LocalDateTime date;
    @Column(name = "product")
    private String product;
    @Column(name = "amount")
    private int amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


}
