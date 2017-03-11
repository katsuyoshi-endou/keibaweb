package models.custom;

import java.io.Serializable;

public class SearchConditionModel implements Serializable {
	private String openStartDate;
	private String openEndDate;
	private String locationKbn;
	private String ageKbn;
	private String rankKbn;
	private String handiKbn;
	private String courseKbn;
	private String distanceKbn;
	private String weatherKbn;
	private String conditionKbn;
	private String raceType;

	public SearchConditionModel() {
		openStartDate = "2007-01-01";
		openEndDate = "2020-12-31";
		locationKbn = "'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'";
		ageKbn = "";
		rankKbn = "";
		handiKbn = "";
		courseKbn = "";
		distanceKbn = "";
		weatherKbn = "";
		conditionKbn = "";
		raceType = "";
	}

	public String getOpenStartDate() {
		return openStartDate;
	}

	public void setOpenStartDate(String openStartDate) {
		this.openStartDate = openStartDate;
	}

	public String getOpenEndDate() {
		return openEndDate;
	}

	public void setOpenEndDate(String openEndDate) {
		this.openEndDate = openEndDate;
	}

	public String getLocationKbn() {
		return locationKbn;
	}

	public void setLocationKbn(String locationKbn) {
		this.locationKbn = locationKbn;
	}

	public String getAgeKbn() {
		return ageKbn;
	}

	public void setAgeKbn(String ageKbn) {
		this.ageKbn = ageKbn;
	}

	public String getRankKbn() {
		return rankKbn;
	}

	public void setRankKbn(String rankKbn) {
		this.rankKbn = rankKbn;
	}

	public String getHandiKbn() {
		return handiKbn;
	}

	public void setHandiKbn(String handiKbn) {
		this.handiKbn = handiKbn;
	}

	public String getCourseKbn() {
		return courseKbn;
	}

	public void setCourseKbn(String courseKbn) {
		this.courseKbn = courseKbn;
	}

	public String getDistanceKbn() {
		return distanceKbn;
	}

	public void setDistanceKbn(String distanceKbn) {
		this.distanceKbn = distanceKbn;
	}

	public String getWeatherKbn() {
		return weatherKbn;
	}

	public void setWeatherKbn(String weatherKbn) {
		this.weatherKbn = weatherKbn;
	}

	public String getConditionKbn() {
		return conditionKbn;
	}

	public void setConditionKbn(String conditionKbn) {
		this.conditionKbn = conditionKbn;
	}

	public String getRaceType() {
		return raceType;
	}

	public void setRaceType(String raceType) {
		this.raceType = raceType;
	}
}
