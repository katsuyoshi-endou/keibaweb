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
@Table(name = "ms_distance")
public class Distance extends Model {
    @Id
    @Column(name = "distance_kbn")
    private String distanceKbn;

    @Column(name = "distance_name")
    private String distanceName;

    @CreatedTimestamp
    @Column(name = "create_date")
    private Timestamp createDate;

    @UpdatedTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    @Column(name = "delete_date")
    private Timestamp deleteDate;

    public void setDistanceKbn(String kbn) {
        this.distanceKbn = kbn;
    }

    public void setDistanceName(String name) {
        this.distanceName = name;
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

    public String getDistanceKbn() {
        return this.distanceKbn;
    }

    public String getDistanceName() {
        return this.distanceName;
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

    public static Find<String, Distance> find = new Find<String, Distance>(){
    };
}
