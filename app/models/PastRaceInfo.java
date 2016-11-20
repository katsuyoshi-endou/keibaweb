package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

@Entity
@Table(name = "tr_past_race_info")
public class PastRaceInfo extends Model {
    @Id
    @Column(name = "past_race_info_id")
    private Long pastRaceInfoId;

    @Column(name = "regist_horse_info_id")
    private Long registHorseInfoId;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "order_arrival")
    private Integer orderArrival;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setPastRaceInfoId(Long id) {
        this.pastRaceInfoId = id;
    }

    public void setRegistHorseInfoId(Long id) {
        this.registHorseInfoId = id;
    }

    public void serRaceId(Long id) {
        this.raceId = id;
    }

    public void setOrderArrival(Integer arrival) {
        this.orderArrival = arrival;
    }

    public void setCreateDate(Timestamp date) {
        this.createDate = date;
    }

    public void setUpdateDate(Timestamp date) {
        this.updateDate = date;
    }

    public void setDeleteDate(Timestamp date) {
        this.deleteDate = date;
    }

    public Long getPastRaceInfoId() {
        return this.pastRaceInfoId;
    }

    public Long getRegistHorseInfoId() {
        return this.registHorseInfoId;
    }

    public Long getRaceId() {
        return this.raceId;
    }

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public Timestamp getDeleteDate() {
        return this.deleteDate;
    }

    public static Find<Long, PastRaceInfo> find = new Find<Long, PastRaceInfo>(){
    };
}
