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
@Table(name = "ms_location")
public class Location extends Model {
	@Id
	@Column(name = "location_kbn")
	private String locationKbn;

	@Column(name = "location_name")
	private String locationName;

	@CreatedTimestamp
	@Column(name = "create_date")
	private Timestamp createDate;

	@UpdatedTimestamp
	@Column(name = "update_date")
	private Timestamp updateDate;

	@Column(name = "delete_date")
	private Timestamp deleteDate;

    public void setLocationKbn(String kbn) {
        this.locationKbn = kbn;
    }

    public void setLocationName(String name) {
        this.locationName = name;
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

    public String getLocationKbn() {
        return this.locationKbn;
    }

    public String getLocationName() {
        return this.locationName;
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

    public static Find<String, Location> find = new Find<String, Location>() {
    };
}
