package models;

import java.util.Date;

public class RaceInfo {
    private Long    raceId;
    private Date    openDate;
    private String  locationName;
    private Integer raceNumber;
    private String  rankName;
    private String  courseName;
    private String  distanceName;
    private Integer racePopulation;

    public RaceInfo() {
        setRaceId(0L);
        setLocationName("");
        setRaceNumber(0);
        setRankName("");
        setCourseName("");
        setDistanceName("");
        setRacePopulation(0);
    }

    public Long getRaceId() {
        return raceId;
    }

    public void setRaceId(Long id) {
        this.raceId = id;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date date) {
        this.openDate = date;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String name) {
        this.locationName = name;
    }

    public Integer getRaceNumber() {
        return raceNumber;
    }

    public void setRaceNumber(Integer number) {
        this.raceNumber = number;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String name) {
        this.rankName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public String getDistanceName() {
        return distanceName;
    }

    public void setDistanceName(String name) {
        this.distanceName = name;
    }

    public Integer getRacePopulation() {
        return racePopulation;
    }

    public void setRacePopulation(Integer population) {
        this.racePopulation = population;
    }

}
