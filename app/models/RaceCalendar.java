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
@Table(name = "tr_race_caledar")
public class RaceCalendar extends Model {
    @Id
    @Column(name = "calendar_id")
    private Long calendarId;

    @Column(name = "open_date")
    private Timestamp opendate;

    @Column(name = "location_kbn")
    private String locationKbn;

    @Column(name = "race_result_flg")
    private String raceResultFlg;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setCalendarId(Long id) {
        this.calendarId = id;
    }

    public void setOpenDate(Timestamp date) {
        this.opendate = date;
    }

    public void setLocationKbn(String kbn) {
        this.locationKbn = kbn;
    }

    public void setRaceResultFlg(String flg) {
        this.raceResultFlg = flg;
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

    public Long getCalendarId() {
        return this.calendarId;
    }

    public Timestamp getOpenDate() {
        return this.opendate;
    }

    public String getLocationKbn() {
        return this.locationKbn;
    }

    public String getRaceResultFlg() {
        return this.raceResultFlg;
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

    public static Find<Long, RaceCalendar> find = new Find<Long, RaceCalendar>(){
    };
}
