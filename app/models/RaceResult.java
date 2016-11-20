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
@Table(name = "tr_race_result")
public class RaceResult extends Model {
    @Id
    @Column(name = "race_rasult_id")
    private Long raceResultId;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "arriving_1_horse_number")
    private String arrivingHorseNumber1;

    @Column(name = "comp_index_1")
    private Integer compIndex1;

    @Column(name = "arriving_2_horse_number")
    private String arrivingHorseNumber2;

    @Column(name = "comp_index_2")
    private Integer compIndex2;

    @Column(name = "arriving_3_horse_number")
    private String arrivingHorseNumber3;

    @Column(name = "comp_index_3")
    private Integer compIndex3;

    @Column(name = "arriving_4_horse_number")
    private String arrivingHorseNumber4;

    @Column(name = "comp_index_4")
    private Integer compIndex4;

    @Column(name = "arriving_5_horse_number")
    private String arrivingHorseNumber5;

    @Column(name = "comp_index_5")
    private Integer compIndex5;

    @Column(name = "arriving_6_horse_number")
    private String arrivingHorseNumber6;

    @Column(name = "comp_index_6")
    private Integer compIndex6;

    @Column(name = "arriving_7_horse_number")
    private String arrivingHorseNumber7;

    @Column(name = "comp_index_7")
    private Integer compIndex7;

    @Column(name = "arriving_8_horse_number")
    private String arrivingHorseNumber8;

    @Column(name = "comp_index_8")
    private Integer compIndex8;

    @Column(name = "arriving_9_horse_number")
    private String arrivingHorseNumber9;

    @Column(name = "comp_index_9")
    private Integer compIndex9;

    @Column(name = "arriving_10_horse_number")
    private String arrivingHorseNumber10;

    @Column(name = "comp_index_10")
    private Integer compIndex10;

    @Column(name = "arriving_11_horse_number")
    private String arrivingHorseNumber11;

    @Column(name = "comp_index_11")
    private Integer compIndex11;

    @Column(name = "arriving_12_horse_number")
    private String arrivingHorseNumber12;

    @Column(name = "comp_index_12")
    private Integer compIndex12;

    @Column(name = "arriving_13_horse_number")
    private String arrivingHorseNumber13;

    @Column(name = "comp_index_13")
    private Integer compIndex13;

    @Column(name = "arriving_14_horse_number")
    private String arrivingHorseNumber14;

    @Column(name = "comp_index_14")
    private Integer compIndex14;

    @Column(name = "arriving_15_horse_number")
    private String arrivingHorseNumber15;

    @Column(name = "comp_index_15")
    private Integer compIndex15;

    @Column(name = "arriving_16_horse_number")
    private String arrivingHorseNumber16;

    @Column(name = "comp_index_16")
    private Integer compIndex16;

    @Column(name = "arriving_17_horse_number")
    private String arrivingHorseNumber17;

    @Column(name = "comp_index_17")
    private Integer compIndex17;

    @Column(name = "arriving_18_horse_number")
    private String arrivingHorseNumber18;

    @Column(name = "comp_index_18")
    private Integer compIndex18;

    @Column(name = "analyze_flg")
    private String analyzeFlg;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setRaceResultId(Long id) {
        this.raceResultId = id;
    }

    public void setRaceId(Long id) {
        this.raceId = id;
    }

    public void setArrvingHorseNumber1(String number) {
        this.arrivingHorseNumber1 = number;
    }

    public void setCompIndex1(Integer index) {
        this.compIndex1 = index;
    }

    public void setArrvingHorseNumber2(String number) {
        this.arrivingHorseNumber2 = number;
    }

    public void setCompIndex2(Integer index) {
        this.compIndex2 = index;
    }

    public void setArrvingHorseNumber3(String number) {
        this.arrivingHorseNumber3 = number;
    }

    public void setCompIndex3(Integer index) {
        this.compIndex3 = index;
    }

    public void setArrvingHorseNumber4(String number) {
        this.arrivingHorseNumber4 = number;
    }

    public void setCompIndex4(Integer index) {
        this.compIndex4 = index;
    }

    public void setArrvingHorseNumber5(String number) {
        this.arrivingHorseNumber5 = number;
    }

    public void setCompIndex5(Integer index) {
        this.compIndex5 = index;
    }

    public void setArrvingHorseNumber6(String number) {
        this.arrivingHorseNumber6 = number;
    }

    public void setCompIndex6(Integer index) {
        this.compIndex6 = index;
    }

    public void setArrvingHorseNumber7(String number) {
        this.arrivingHorseNumber7 = number;
    }

    public void setCompIndex7(Integer index) {
        this.compIndex7 = index;
    }

    public void setArrvingHorseNumber8(String number) {
        this.arrivingHorseNumber8 = number;
    }

    public void setCompIndex8(Integer index) {
        this.compIndex8 = index;
    }

    public void setArrvingHorseNumber9(String number) {
        this.arrivingHorseNumber9 = number;
    }

    public void setCompIndex9(Integer index) {
        this.compIndex9 = index;
    }

    public void setArrvingHorseNumber10(String number) {
        this.arrivingHorseNumber10 = number;
    }

    public void setCompIndex10(Integer index) {
        this.compIndex10 = index;
    }

    public void setArrvingHorseNumber11(String number) {
        this.arrivingHorseNumber11 = number;
    }

    public void setCompIndex11(Integer index) {
        this.compIndex11 = index;
    }

    public void setArrvingHorseNumber12(String number) {
        this.arrivingHorseNumber12 = number;
    }

    public void setCompIndex12(Integer index) {
        this.compIndex12 = index;
    }

    public void setArrvingHorseNumber13(String number) {
        this.arrivingHorseNumber13 = number;
    }

    public void setCompIndex13(Integer index) {
        this.compIndex13 = index;
    }

    public void setArrvingHorseNumber14(String number) {
        this.arrivingHorseNumber14 = number;
    }

    public void setCompIndex14(Integer index) {
        this.compIndex14 = index;
    }

    public void setArrvingHorseNumber15(String number) {
        this.arrivingHorseNumber15 = number;
    }

    public void setCompIndex15(Integer index) {
        this.compIndex15 = index;
    }

    public void setArrvingHorseNumber16(String number) {
        this.arrivingHorseNumber16 = number;
    }

    public void setCompIndex16(Integer index) {
        this.compIndex16 = index;
    }

    public void setArrvingHorseNumber17(String number) {
        this.arrivingHorseNumber17 = number;
    }

    public void setCompIndex17(Integer index) {
        this.compIndex17 = index;
    }

    public void setArrvingHorseNumber18(String number) {
        this.arrivingHorseNumber18 = number;
    }

    public void setCompIndex18(Integer index) {
        this.compIndex18 = index;
    }

    public void setAnalyzeFlg(String flg) {
        this.analyzeFlg = flg;
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

    public String getArrvingHorseNumber1() {
        return this.arrivingHorseNumber1;
    }

    public Integer getCompIndex1() {
        return this.compIndex1;
    }

    public String getArrvingHorseNumber2() {
        return this.arrivingHorseNumber2;
    }

    public Integer getCompIndex2() {
        return this.compIndex2;
    }

    public String getArrvingHorseNumber3() {
        return this.arrivingHorseNumber3;
    }

    public Integer getCompIndex3() {
        return this.compIndex3;
    }

    public String getArrvingHorseNumber4() {
        return this.arrivingHorseNumber4;
    }

    public Integer getCompIndex4() {
        return this.compIndex4;
    }

    public String getArrvingHorseNumber5() {
        return this.arrivingHorseNumber5;
    }

    public Integer getCompIndex5() {
        return this.compIndex5;
    }

    public String getArrvingHorseNumber6() {
        return this.arrivingHorseNumber6;
    }

    public Integer getCompIndex6() {
        return this.compIndex6;
    }

    public String getArrvingHorseNumber7() {
        return this.arrivingHorseNumber7;
    }

    public Integer getCompIndex7() {
        return this.compIndex7;
    }

    public String getArrvingHorseNumber8() {
        return this.arrivingHorseNumber8;
    }

    public Integer getCompIndex8() {
        return this.compIndex8;
    }

    public String getArrvingHorseNumber9() {
        return this.arrivingHorseNumber9;
    }

    public Integer getCompIndex9() {
        return this.compIndex9;
    }

    public String getArrvingHorseNumber10() {
        return this.arrivingHorseNumber10;
    }

    public Integer getCompIndex10() {
        return this.compIndex10;
    }

    public String getArrvingHorseNumber11() {
        return this.arrivingHorseNumber11;
    }

    public Integer getCompIndex11() {
        return this.compIndex11;
    }

    public String getArrvingHorseNumber12() {
        return this.arrivingHorseNumber12;
    }

    public Integer getCompIndex12() {
        return this.compIndex12;
    }

    public String getArrvingHorseNumber13() {
        return this.arrivingHorseNumber13;
    }

    public Integer getCompIndex13() {
        return this.compIndex13;
    }

    public String getArrvingHorseNumber14() {
        return this.arrivingHorseNumber14;
    }

    public Integer getCompIndex14() {
        return this.compIndex14;
    }

    public String getArrvingHorseNumber15() {
        return this.arrivingHorseNumber15;
    }

    public Integer getCompIndex15() {
        return this.compIndex15;
    }

    public String getArrvingHorseNumber16() {
        return this.arrivingHorseNumber16;
    }

    public Integer getCompIndex16() {
        return this.compIndex16;
    }

    public String getArrvingHorseNumber17() {
        return this.arrivingHorseNumber17;
    }

    public Integer getCompIndex17() {
        return this.compIndex17;
    }

    public String getArrvingHorseNumber18() {
        return this.arrivingHorseNumber18;
    }

    public Integer getCompIndex18() {
        return this.compIndex18;
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

    public String getAnalyzeFlg() {
        return this.analyzeFlg;
    }

    public static Find<Long, RaceResult> find = new Find<Long, RaceResult>() {
    };
}
