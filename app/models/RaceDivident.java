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
@Table(name = "tr_race_divident")
public class RaceDivident extends Model {
    @Id
    @Column(name = "divident_id")
    private Long dividentId;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "divident_kind")
    private String dividentKind;

    @Column(name = "horse_combination")
    private String horseCombination;

    @Column(name = "payout")
    private Integer payout;

    @Column(name = "popularity")
    private Integer popularity;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setDividentId(Long id) {
        this.dividentId = id;
    }

    public void setRaceId(Long id) {
        this.raceId = id;
    }

    public void setDividentKind(String kind) {
        this.dividentKind = kind;
    }

    public void sethorseCombination(String combination) {
        this.horseCombination = combination;
    }

    public void setPayout(Integer payout) {
        this.payout = payout;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
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

    public Long getDividentId() {
        return this.dividentId;
    }

    public Long getRaceId() {
        return this.raceId;
    }

    public String getDividentKind() {
        return this.dividentKind;
    }

    public String getHorseCombination() {
        return this.horseCombination;
    }

    public Integer getPayout() {
        return this.payout;
    }

    public Integer getPopularity() {
        return this.popularity;
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

    public static Find<Long, RaceDivident> find = new Find<Long, RaceDivident>(){
    };
}
