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
@Table(name = "tr_race")
public class Race extends Model {
    @Id
    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "open_date")
    private Timestamp openDate;

    @Column(name = "location_kbn")
    private String locationKbn;

    @Column(name = "race_number")
    private Integer raceNumber;

    @Column(name = "rank_kbn")
    private String rankKbn;

    @Column(name = "course_kbn")
    private String courseKbn;

    @Column(name = "distance_kbn")
    private String distanceKbn;

    @Column(name = "race_population")
    private Integer racePopulation;

    @Column(name = "race_result_flg")
    private String raceResultFlg;

    @Column(name = "divident_reg_flg")
    private String dividentRegFlg;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setRaceId(Long id) {
        this.raceId = id;
    }

    public void setOpenDate(Timestamp date){
        this.openDate = date;
    }

    public void setLocationKbn(String kbn) {
        this.locationKbn = kbn;
    }

    public void setRaceNumber(Integer number) {
        this.raceNumber = number;
    }

    public void setRankKbn(String kbn) {
        this.rankKbn = kbn;
    }

    public void setCourseKbn(String kbn) {
        this.courseKbn = kbn;
    }

    public void setDistanceKbn(String kbn) {
        this.distanceKbn = kbn;
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

    public Long getRaceId() {
        return this.raceId;
    }

    public Timestamp getOpenDate() {
        return this.openDate;
    }

    public String getLocationKbn() {
        return this.locationKbn;
    }

    public Integer getRaceNumber() {
        return this.raceNumber;
    }

    public String getRankKbn() {
        return this.rankKbn;
    }

    public String getCourseKbn() {
        return this.courseKbn;
    }

    public String getDistanceKbn() {
        return this.distanceKbn;
    }

    public Integer getRacePopulation() {
        return this.racePopulation;
    }

    public String getRaceResultFlg() {
        return this.raceResultFlg;
    }

    public String getDividentRegFlg() {
        return this.dividentRegFlg;
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

    public static Find<Long, Race> find = new Find<Long, Race>(){
    };
}
