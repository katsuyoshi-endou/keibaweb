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
@Table(name = "tr_regist_horse_info")
public class RegistHorseInfo extends Model {
    @Id
    @Column(name = "regist_horse_info_id")
    private Long registHorseInfoId;

    @Column(name = "horse_name")
    private String horseName;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setRegistHorseInfoId(Long id) {
        this.registHorseInfoId = id;
    }

    public void setHorseName(String name) {
        this.horseName = name;
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

    public Long getRegistHorseInfoId() {
        return this.registHorseInfoId;
    }

    public String getHorseName() {
        return this.horseName;
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

    public static Find<Long, RegistHorseInfo> find = new Find<Long, RegistHorseInfo>(){
    };
}
