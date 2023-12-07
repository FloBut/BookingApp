package com.example.BookingApp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long reservationNo;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private Date createDateRes;
    @OneToMany
    @JsonManagedReference("roomRes - reservation")
    private List<RoomRes> roomRes1;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference("user_id - reservation")
    private User user;

    public Reservation() {
    }

    public Reservation(Long id, Long reservationNo, Date startDate, Date endDate, Date createDateRes, List<RoomRes> roomRes1, User user) {
        this.id = id;
        this.reservationNo = reservationNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.createDateRes = createDateRes;
        this.roomRes1 = roomRes1;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(Long reservationNo) {
        this.reservationNo = reservationNo;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getCreateDateRes() {
        return createDateRes;
    }

    public void setCreateDateRes(Date createDateRes) {
        this.createDateRes = createDateRes;
    }

    public List<RoomRes> getRoomRes1() {
        return roomRes1;
    }

    public void setRoomRes1(List<RoomRes> roomRes1) {
        this.roomRes1 = roomRes1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationNo=" + reservationNo +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", createDateRes=" + createDateRes +
                ", roomRes1=" + roomRes1 +
                ", user=" + user +
                '}';
    }
}
