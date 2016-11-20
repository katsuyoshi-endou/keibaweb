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
@Table(name = "tr_entry_horse_info")
public class EntryHorseInfo extends Model {
    @Id
    @Column(name = "entry_horse_info_id")
    private Long entryHorseInfoId;

    @Column(name = "race_id")
    private Long raceId;

    @Column(name = "comp_index_1")
    private Integer compIndex1;

    @Column(name = "horse_number_1")
    private String horseNumber1;

    @Column(name = "horse_name_1")
    private String horseName1;

    @Column(name = "horse_weight_1")
    private Integer horseWeight1;

    @Column(name = "last_time_index_1")
    private Integer lastTimeIndex1;

    @Column(name = "comp_index_2")
    private Integer compIndex2;

    @Column(name = "horse_number_2")
    private String horseNumber2;

    @Column(name = "horse_name_2")
    private String horseName2;

    @Column(name = "horse_weight_2")
    private Integer horseWeight2;

    @Column(name = "last_time_index_2")
    private Integer lastTimeIndex2;

    @Column(name = "comp_index_3")
    private Integer compIndex3;

    @Column(name = "horse_number_3")
    private String horseNumber3;

    @Column(name = "horse_name_3")
    private String horseName3;

    @Column(name = "horse_weight_3")
    private Integer horseWeight3;

    @Column(name = "last_time_index_3")
    private Integer lastTimeIndex3;

    @Column(name = "comp_index_4")
    private Integer compIndex4;

    @Column(name = "horse_number_4")
    private String horseNumber4;

    @Column(name = "horse_name_4")
    private String horseName4;

    @Column(name = "horse_weight_4")
    private Integer horseWeight4;

    @Column(name = "last_time_index_4")
    private Integer lastTimeIndex4;

    @Column(name = "comp_index_5")
    private Integer compIndex5;

    @Column(name = "horse_number_5")
    private String horseNumber5;

    @Column(name = "horse_name_5")
    private String horseName5;

    @Column(name = "horse_weight_5")
    private Integer horseWeight5;

    @Column(name = "last_time_index_5")
    private Integer lastTimeIndex5;

    @Column(name = "comp_index_6")
    private Integer compIndex6;

    @Column(name = "horse_number_6")
    private String horseNumber6;

    @Column(name = "horse_name_6")
    private String horseName6;

    @Column(name = "horse_weight_6")
    private Integer horseWeight6;

    @Column(name = "last_time_index_6")
    private Integer lastTimeIndex6;

    @Column(name = "comp_index_7")
    private Integer compIndex7;

    @Column(name = "horse_number_7")
    private String horseNumber7;

    @Column(name = "horse_name_7")
    private String horseName7;

    @Column(name = "horse_weight_7")
    private Integer horseWeight7;

    @Column(name = "last_time_index_7")
    private Integer lastTimeIndex7;

    @Column(name = "comp_index_8")
    private Integer compIndex8;

    @Column(name = "horse_number_8")
    private String horseNumber8;

    @Column(name = "horse_name_8")
    private String horseName8;

    @Column(name = "horse_weight_8")
    private Integer horseWeight8;

    @Column(name = "last_time_index_8")
    private Integer lastTimeIndex8;

    @Column(name = "comp_index_9")
    private Integer compIndex9;

    @Column(name = "horse_number_9")
    private String horseNumber9;

    @Column(name = "horse_name_9")
    private String horseName9;

    @Column(name = "horse_weight_9")
    private Integer horseWeight9;

    @Column(name = "last_time_index_9")
    private Integer lastTimeIndex9;

    @Column(name = "comp_index_10")
    private Integer compIndex10;

    @Column(name = "horse_number_10")
    private String horseNumber10;

    @Column(name = "horse_name_10")
    private String horseName10;

    @Column(name = "horse_weight_10")
    private Integer horseWeight10;

    @Column(name = "last_time_index_10")
    private Integer lastTimeIndex10;

    @Column(name = "comp_index_11")
    private Integer compIndex11;

    @Column(name = "horse_number_11")
    private String horseNumber11;

    @Column(name = "horse_name_11")
    private String horseName11;

    @Column(name = "horse_weight_11")
    private Integer horseWeight11;

    @Column(name = "last_time_index_11")
    private Integer lastTimeIndex11;

    @Column(name = "comp_index_12")
    private Integer compIndex12;

    @Column(name = "horse_number_12")
    private String horseNumber12;

    @Column(name = "horse_name_12")
    private String horseName12;

    @Column(name = "horse_weight_12")
    private Integer horseWeight12;

    @Column(name = "last_time_index_12")
    private Integer lastTimeIndex12;

    @Column(name = "comp_index_13")
    private Integer compIndex13;

    @Column(name = "horse_number_13")
    private String horseNumber13;

    @Column(name = "horse_name_13")
    private String horseName13;

    @Column(name = "horse_weight_13")
    private Integer horseWeight13;

    @Column(name = "last_time_index_13")
    private Integer lastTimeIndex13;

    @Column(name = "comp_index_14")
    private Integer compIndex14;

    @Column(name = "horse_number_14")
    private String horseNumber14;

    @Column(name = "horse_name_14")
    private String horseName14;

    @Column(name = "horse_weight_14")
    private Integer horseWeight14;

    @Column(name = "last_time_index_14")
    private Integer lastTimeIndex14;

    @Column(name = "comp_index_15")
    private Integer compIndex15;

    @Column(name = "horse_number_15")
    private String horseNumber15;

    @Column(name = "horse_name_15")
    private String horseName15;

    @Column(name = "horse_weight_15")
    private Integer horseWeight15;

    @Column(name = "last_time_index_15")
    private Integer lastTimeIndex15;

    @Column(name = "comp_index_16")
    private Integer compIndex16;

    @Column(name = "horse_number_16")
    private String horseNumber16;

    @Column(name = "horse_name_16")
    private String horseName16;

    @Column(name = "horse_weight_16")
    private Integer horseWeight16;

    @Column(name = "last_time_index_16")
    private Integer lastTimeIndex16;

    @Column(name = "comp_index_17")
    private Integer compIndex17;

    @Column(name = "horse_number_17")
    private String horseNumber17;

    @Column(name = "horse_name_17")
    private String horseName17;

    @Column(name = "horse_weight_17")
    private Integer horseWeight17;

    @Column(name = "last_time_index_17")
    private Integer lastTimeIndex17;

    @Column(name = "comp_index_18")
    private Integer compIndex18;

    @Column(name = "horse_number_18")
    private String horseNumber18;

    @Column(name = "horse_name_18")
    private String horseName18;

    @Column(name = "horse_weight_18")
    private Integer horseWeight18;

    @Column(name = "last_time_index_18")
    private Integer lastTimeIndex18;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public  void setEntryHorseInfoId(Long id) {
        this.entryHorseInfoId = id;
    }

    public void setRaceId(Long id){
        this.raceId = id;
    }

    public void setCompIndex1(Integer index) {
        this.compIndex1 = index;
    }

    public void setHorseNumber1(String number) {
        this.horseNumber1 = number;
    }

    public void setHorseName1(String name) {
        this.horseName1 = name;
    }

    public void setHorseWeight1(Integer weight) {
        this.horseWeight1 = weight;
    }

    public void setLastTimeIndex1(Integer index) {
        this.lastTimeIndex1 = index;
    }

    public Integer getCompIndex1() {
        return this.compIndex1;
    }

    public String getHorseNumber1() {
        return this.horseNumber1;
    }

    public String getHorseName1() {
        return this.horseName1;
    }

    public Integer getHorseWeight1() {
        return this.horseWeight1;
    }

    public Integer getLastTimeIndex1() {
        return this.lastTimeIndex1;
    }

    public void setCompIndex2(Integer index) {
        this.compIndex2 = index;
    }

    public void setHorseNumber2(String number) {
        this.horseNumber2 = number;
    }

    public void setHorseName2(String name) {
        this.horseName2 = name;
    }

    public void setHorseWeight2(Integer weight) {
        this.horseWeight2 = weight;
    }

    public void setLastTimeIndex2(Integer index) {
        this.lastTimeIndex2 = index;
    }

    public Integer getCompIndex2() {
        return this.compIndex2;
    }

    public String getHorseNumber2() {
        return this.horseNumber2;
    }

    public String getHorseName2() {
        return this.horseName2;
    }

    public Integer getHorseWeight2() {
        return this.horseWeight2;
    }

    public Integer getLastTimeIndex2() {
        return this.lastTimeIndex2;
    }

    public void setCompIndex3(Integer index) {
        this.compIndex3 = index;
    }

    public void setHorseNumber3(String number) {
        this.horseNumber3 = number;
    }

    public void setHorseName3(String name) {
        this.horseName3 = name;
    }

    public void setHorseWeight3(Integer weight) {
        this.horseWeight3 = weight;
    }

    public void setLastTimeIndex3(Integer index) {
        this.lastTimeIndex3 = index;
    }

    public Integer getCompIndex3() {
        return this.compIndex3;
    }

    public String getHorseNumber3() {
        return this.horseNumber3;
    }

    public String getHorseName3() {
        return this.horseName3;
    }

    public Integer getHorseWeight3() {
        return this.horseWeight3;
    }

    public Integer getLastTimeIndex3() {
        return this.lastTimeIndex3;
    }

    public void setCompIndex4(Integer index) {
        this.compIndex4 = index;
    }

    public void setHorseNumber4(String number) {
        this.horseNumber4 = number;
    }

    public void setHorseName4(String name) {
        this.horseName4 = name;
    }

    public void setHorseWeight4(Integer weight) {
        this.horseWeight4 = weight;
    }

    public void setLastTimeIndex4(Integer index) {
        this.lastTimeIndex4 = index;
    }

    public Integer getCompIndex4() {
        return this.compIndex4;
    }

    public String getHorseNumber4() {
        return this.horseNumber4;
    }

    public String getHorseName4() {
        return this.horseName4;
    }

    public Integer getHorseWeight4() {
        return this.horseWeight4;
    }

    public Integer getLastTimeIndex4() {
        return this.lastTimeIndex4;
    }

    public void setCompIndex5(Integer index) {
        this.compIndex5 = index;
    }

    public void setHorseNumber5(String number) {
        this.horseNumber5 = number;
    }

    public void setHorseName5(String name) {
        this.horseName5 = name;
    }

    public void setHorseWeight5(Integer weight) {
        this.horseWeight5 = weight;
    }

    public void setLastTimeIndex5(Integer index) {
        this.lastTimeIndex5 = index;
    }

    public Integer getCompIndex5() {
        return this.compIndex5;
    }

    public String getHorseNumber5() {
        return this.horseNumber5;
    }

    public String getHorseName5() {
        return this.horseName5;
    }

    public Integer getHorseWeight5() {
        return this.horseWeight5;
    }

    public Integer getLastTimeIndex5() {
        return this.lastTimeIndex5;
    }

    public void setCompIndex6(Integer index) {
        this.compIndex6 = index;
    }

    public void setHorseNumber6(String number) {
        this.horseNumber6 = number;
    }

    public void setHorseName6(String name) {
        this.horseName6 = name;
    }

    public void setHorseWeight6(Integer weight) {
        this.horseWeight6 = weight;
    }

    public void setLastTimeIndex6(Integer index) {
        this.lastTimeIndex6 = index;
    }

    public Integer getCompIndex6() {
        return this.compIndex6;
    }

    public String getHorseNumber6() {
        return this.horseNumber6;
    }

    public String getHorseName6() {
        return this.horseName6;
    }

    public Integer getHorseWeight6() {
        return this.horseWeight6;
    }

    public Integer getLastTimeIndex6() {
        return this.lastTimeIndex6;
    }

    public void setCompIndex7(Integer index) {
        this.compIndex7 = index;
    }

    public void setHorseNumber7(String number) {
        this.horseNumber7 = number;
    }

    public void setHorseName7(String name) {
        this.horseName7 = name;
    }

    public void setHorseWeight7(Integer weight) {
        this.horseWeight7 = weight;
    }

    public void setLastTimeIndex7(Integer index) {
        this.lastTimeIndex7 = index;
    }

    public Integer getCompIndex7() {
        return this.compIndex7;
    }

    public String getHorseNumber7() {
        return this.horseNumber7;
    }

    public String getHorseName7() {
        return this.horseName7;
    }

    public Integer getHorseWeight7() {
        return this.horseWeight7;
    }

    public Integer getLastTimeIndex7() {
        return this.lastTimeIndex7;
    }

    public void setCompIndex8(Integer index) {
        this.compIndex8 = index;
    }

    public void setHorseNumber8(String number) {
        this.horseNumber8 = number;
    }

    public void setHorseName8(String name) {
        this.horseName8 = name;
    }

    public void setHorseWeight8(Integer weight) {
        this.horseWeight8 = weight;
    }

    public void setLastTimeIndex8(Integer index) {
        this.lastTimeIndex8 = index;
    }

    public Integer getCompIndex8() {
        return this.compIndex8;
    }

    public String getHorseNumber8() {
        return this.horseNumber8;
    }

    public String getHorseName8() {
        return this.horseName8;
    }

    public Integer getHorseWeight8() {
        return this.horseWeight8;
    }

    public Integer getLastTimeIndex8() {
        return this.lastTimeIndex8;
    }

    public void setCompIndex9(Integer index) {
        this.compIndex9 = index;
    }

    public void setHorseNumber9(String number) {
        this.horseNumber9 = number;
    }

    public void setHorseName9(String name) {
        this.horseName9 = name;
    }

    public void setHorseWeight9(Integer weight) {
        this.horseWeight9 = weight;
    }

    public void setLastTimeIndex9(Integer index) {
        this.lastTimeIndex9 = index;
    }

    public Integer getCompIndex9() {
        return this.compIndex9;
    }

    public String getHorseNumber9() {
        return this.horseNumber9;
    }

    public String getHorseName9() {
        return this.horseName9;
    }

    public Integer getHorseWeight9() {
        return this.horseWeight9;
    }

    public Integer getLastTimeIndex9() {
        return this.lastTimeIndex9;
    }

    public void setCompIndex10(Integer index) {
        this.compIndex10 = index;
    }

    public void setHorseNumber10(String number) {
        this.horseNumber10 = number;
    }

    public void setHorseName10(String name) {
        this.horseName10 = name;
    }

    public void setHorseWeight10(Integer weight) {
        this.horseWeight10 = weight;
    }

    public void setLastTimeIndex10(Integer index) {
        this.lastTimeIndex10 = index;
    }

    public Integer getCompIndex10() {
        return this.compIndex10;
    }

    public String getHorseNumber10() {
        return this.horseNumber10;
    }

    public String getHorseName10() {
        return this.horseName10;
    }

    public Integer getHorseWeight10() {
        return this.horseWeight10;
    }

    public Integer getLastTimeIndex10() {
        return this.lastTimeIndex10;
    }

    public void setCompIndex11(Integer index) {
        this.compIndex11 = index;
    }

    public void setHorseNumber11(String number) {
        this.horseNumber11 = number;
    }

    public void setHorseName11(String name) {
        this.horseName11 = name;
    }

    public void setHorseWeight11(Integer weight) {
        this.horseWeight11 = weight;
    }

    public void setLastTimeIndex11(Integer index) {
        this.lastTimeIndex11 = index;
    }

    public Integer getCompIndex11() {
        return this.compIndex11;
    }

    public String getHorseNumber11() {
        return this.horseNumber11;
    }

    public String getHorseName11() {
        return this.horseName11;
    }

    public Integer getHorseWeight11() {
        return this.horseWeight11;
    }

    public Integer getLastTimeIndex11() {
        return this.lastTimeIndex11;
    }

    public void setCompIndex12(Integer index) {
        this.compIndex12 = index;
    }

    public void setHorseNumber12(String number) {
        this.horseNumber12 = number;
    }

    public void setHorseName12(String name) {
        this.horseName12 = name;
    }

    public void setHorseWeight12(Integer weight) {
        this.horseWeight12 = weight;
    }

    public void setLastTimeIndex12(Integer index) {
        this.lastTimeIndex12 = index;
    }

    public Integer getCompIndex12() {
        return this.compIndex12;
    }

    public String getHorseNumber12() {
        return this.horseNumber12;
    }

    public String getHorseName12() {
        return this.horseName12;
    }

    public Integer getHorseWeight12() {
        return this.horseWeight12;
    }

    public Integer getLastTimeIndex12() {
        return this.lastTimeIndex12;
    }

    public void setCompIndex13(Integer index) {
        this.compIndex13 = index;
    }

    public void setHorseNumber13(String number) {
        this.horseNumber13 = number;
    }

    public void setHorseName13(String name) {
        this.horseName13 = name;
    }

    public void setHorseWeight13(Integer weight) {
        this.horseWeight13 = weight;
    }

    public void setLastTimeIndex13(Integer index) {
        this.lastTimeIndex13 = index;
    }

    public Integer getCompIndex13() {
        return this.compIndex13;
    }

    public String getHorseNumber13() {
        return this.horseNumber13;
    }

    public String getHorseName13() {
        return this.horseName13;
    }

    public Integer getHorseWeight13() {
        return this.horseWeight13;
    }

    public Integer getLastTimeIndex13() {
        return this.lastTimeIndex13;
    }

    public void setCompIndex14(Integer index) {
        this.compIndex14 = index;
    }

    public void setHorseNumber14(String number) {
        this.horseNumber14 = number;
    }

    public void setHorseName14(String name) {
        this.horseName14 = name;
    }

    public void setHorseWeight14(Integer weight) {
        this.horseWeight14 = weight;
    }

    public void setLastTimeIndex14(Integer index) {
        this.lastTimeIndex14 = index;
    }

    public Integer getCompIndex14() {
        return this.compIndex14;
    }

    public String getHorseNumber14() {
        return this.horseNumber14;
    }

    public String getHorseName14() {
        return this.horseName14;
    }

    public Integer getHorseWeight14() {
        return this.horseWeight14;
    }

    public Integer getLastTimeIndex14() {
        return this.lastTimeIndex14;
    }

    public void setCompIndex15(Integer index) {
        this.compIndex15 = index;
    }

    public void setHorseNumber15(String number) {
        this.horseNumber15 = number;
    }

    public void setHorseName15(String name) {
        this.horseName15 = name;
    }

    public void setHorseWeight15(Integer weight) {
        this.horseWeight15 = weight;
    }

    public void setLastTimeIndex15(Integer index) {
        this.lastTimeIndex15 = index;
    }

    public Integer getCompIndex15() {
        return this.compIndex15;
    }

    public String getHorseNumber15() {
        return this.horseNumber15;
    }

    public String getHorseName15() {
        return this.horseName15;
    }

    public Integer getHorseWeight15() {
        return this.horseWeight15;
    }

    public Integer getLastTimeIndex15() {
        return this.lastTimeIndex15;
    }

    public void setCompIndex16(Integer index) {
        this.compIndex16 = index;
    }

    public void setHorseNumber16(String number) {
        this.horseNumber16 = number;
    }

    public void setHorseName16(String name) {
        this.horseName16 = name;
    }

    public void setHorseWeight16(Integer weight) {
        this.horseWeight16 = weight;
    }

    public void setLastTimeIndex16(Integer index) {
        this.lastTimeIndex16 = index;
    }

    public Integer getCompIndex16() {
        return this.compIndex16;
    }

    public String getHorseNumber16() {
        return this.horseNumber16;
    }

    public String getHorseName16() {
        return this.horseName16;
    }

    public Integer getHorseWeight16() {
        return this.horseWeight16;
    }

    public Integer getLastTimeIndex16() {
        return this.lastTimeIndex16;
    }


    public void setCompIndex17(Integer index) {
        this.compIndex17 = index;
    }

    public void setHorseNumber17(String number) {
        this.horseNumber17 = number;
    }

    public void setHorseName17(String name) {
        this.horseName17 = name;
    }

    public void setHorseWeight17(Integer weight) {
        this.horseWeight17 = weight;
    }

    public void setLastTimeIndex17(Integer index) {
        this.lastTimeIndex17 = index;
    }

    public Integer getCompIndex17() {
        return this.compIndex17;
    }

    public String getHorseNumber17() {
        return this.horseNumber17;
    }

    public String getHorseName17() {
        return this.horseName17;
    }

    public Integer getHorseWeight17() {
        return this.horseWeight17;
    }

    public Integer getLastTimeIndex17() {
        return this.lastTimeIndex17;
    }

    public void setCompIndex18(Integer index) {
        this.compIndex18 = index;
    }

    public void setHorseNumber18(String number) {
        this.horseNumber18 = number;
    }

    public void setHorseName18(String name) {
        this.horseName18 = name;
    }

    public void setHorseWeight18(Integer weight) {
        this.horseWeight18 = weight;
    }

    public void setLastTimeIndex18(Integer index) {
        this.lastTimeIndex18 = index;
    }

    public Integer getCompIndex18() {
        return this.compIndex18;
    }

    public String getHorseNumber18() {
        return this.horseNumber18;
    }

    public String getHorseName18() {
        return this.horseName18;
    }

    public Integer getHorseWeight18() {
        return this.horseWeight16;
    }

    public Integer getLastTimeIndex18() {
        return this.lastTimeIndex16;
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

    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    public Timestamp getDeleteDate() {
        return this.deleteDate;
    }

    public static Find<Long, EntryHorseInfo> find = new Find<Long, EntryHorseInfo>(){
    };
}
