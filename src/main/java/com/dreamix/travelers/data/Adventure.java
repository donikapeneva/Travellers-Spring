package com.dreamix.travelers.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity (name = "adventure")
public class Adventure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="city_id")
    private Integer cityId;
    private LocalDateTime time;
    private String tip;
    @Column(name="last_updated")
    private LocalDateTime lastUpdated;
    @Column(name="is_deleted")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="city_id", nullable=false, insertable=false, updatable=false)
    private City city;


}
