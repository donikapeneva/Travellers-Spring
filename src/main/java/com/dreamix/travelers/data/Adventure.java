package com.dreamix.travelers.data;

import org.hibernate.annotations.Fetch;
import org.hibernate.validator.internal.metadata.facets.Validatable;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity (name = "adventure")
public class Adventure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer user_id;
    private Integer city_id;
    private LocalDateTime time;
    private String tip;
    private LocalDateTime last_updated;
    private Boolean is_deleted;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false, insertable=false, updatable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="city_id", nullable=false, insertable=false, updatable=false)
    private City city;


    public Adventure() {}

    public Adventure(String name, Integer user_id, Integer city_id, LocalDateTime time,
                     String tip,  LocalDateTime last_updated, Boolean is_deleted) {
        this.name = name;
        this.user_id = user_id;
        this.city_id = city_id;
        this.time = time;
        this.tip = tip;
        this.last_updated = last_updated;
        this.is_deleted = is_deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCity_id() {
        return city_id;
    }

    public void setCity_id(Integer city_id) {
        this.city_id = city_id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public LocalDateTime getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(LocalDateTime last_updated) {
        this.last_updated = last_updated;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
