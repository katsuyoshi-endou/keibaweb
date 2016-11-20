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
@Table(name = "tr_win_pattern")
public class WinPattern extends Model {
    @Id
    @Column(name = "win_pattern_id")
    private Long winPatternId;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "comp_index_1")
    private Integer compIndex1;

    @Column(name = "comp_index_2")
    private Integer compIndex2;

    @Column(name = "comp_index_3")
    private Integer compIndex3;

    @Column(name = "comp_index_4")
    private Integer compIndex4;

    @Column(name = "comp_index_5")
    private Integer compIndex5;

    @Column(name = "standard_deviation")
    private Double standardDeviation;

    @Column(name = "win_1_index_rank")
    private Integer winIndexRank1;

    @Column(name = "win_2_index_rank")
    private Integer winIndexRank2;

    @Column(name = "combination")
    private String combination;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setWinPatternId(Long id) {
        this.winPatternId = id;
    }

    public void setRaceId(Long id) {
        this.raceId = id;
    }

    public void setCompIndex1(Integer index) {
        this.compIndex1 = index;
    }

    public void setCompIndex2(Integer index) {
        this.compIndex2 = index;
    }

    public void setCompIndex3(Integer index) {
        this.compIndex3 = index;
    }

    public void setCompIndex4(Integer index) {
        this.compIndex4 = index;
    }

    public void setCompIndex5(Integer index) {
        this.compIndex5 = index;
    }

    public void setStandardDeviation(Double std) {
        this.standardDeviation = std;
    }

    public void setWinIndexRank1(Integer rank) {
        this.winIndexRank1 = rank;
    }

    public void setWinIndexRank2(Integer rank) {
        this.winIndexRank2 = rank;
    }

    public void setCombination(String combination) {
        this.combination = combination;
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

    public Long getWinPatternId() {
        return this.winPatternId;
    }

    public Long getRaceId() {
        return this.raceId;
    }

    public Integer getCompIndex1() {
        return this.compIndex1;
    }

    public Integer getCompIndex2() {
        return this.compIndex2;
    }

    public Integer getCompIndex3() {
        return this.compIndex3;
    }

    public Integer getCompIndex4() {
        return this.compIndex4;
    }

    public Integer getCompIndex5() {
        return this.compIndex5;
    }

    public Double getStandardDeviation() {
        return this.standardDeviation;
    }

    public Integer getWinIndexRank1() {
        return this.winIndexRank1;
    }

    public Integer getWinIndexRank2() {
        return this.winIndexRank2;
    }

    public String getCombination() {
        return this.combination;
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

    public static Find<Long, WinPattern> find = new Find<Long, WinPattern>(){
    };
}
