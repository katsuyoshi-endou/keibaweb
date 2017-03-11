package models.custom;

import java.io.Serializable;

import com.avaje.ebean.SqlRow;

public class AnalyzeResult implements Serializable {
	private String openDate;
	private String ageName;
	private String rankName;
	private String handiCapName;
	private int population;
	private String raceDistance;
	private String courseName;
	private String weatherName;
	private String conditionName;
	private String grade;
	private int raceId;
	private int win1IndexRank;
	private int popularity1;
	private int win2IndexRank;
	private int popularity2;
	private double stdDeviation;

	public AnalyzeResult() {
		openDate = "";
		ageName = "";
		rankName = "";
		handiCapName = "";
		population = 0;
		raceDistance = "";
		courseName = "";
		weatherName = "";
		conditionName = "";
		grade = "";
		raceId = 0;
		win1IndexRank = 0;
		popularity1 = 0;
		win2IndexRank = 0;
		popularity2 = 0;
		stdDeviation = 0.0;
	}

	public String getOpenDate() {
		return openDate;
	}
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	public String getAgeName() {
		return ageName;
	}
	public void setAgeName(String ageName) {
		this.ageName = ageName;
	}
	public String getRankName() {
		return rankName;
	}
	public void setRankName(String rankName) {
		this.rankName = rankName;
	}
	public String getHandiCapName() {
		return handiCapName;
	}
	public void setHandiCapName(String handiCapName) {
		this.handiCapName = handiCapName;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public String getRaceDistance() {
		return raceDistance;
	}
	public void setRaceDistance(String raceDistance) {
		this.raceDistance = raceDistance;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getWeatherName() {
		return weatherName;
	}
	public void setWeatherName(String weatherName) {
		this.weatherName = weatherName;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getRaceId() {
		return raceId;
	}
	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}
	public int getWin1IndexRank() {
		return win1IndexRank;
	}
	public void setWin1IndexRank(int win1IndexRank) {
		this.win1IndexRank = win1IndexRank;
	}
	public int getPopularity1() {
		return popularity1;
	}
	public void setPopularity1(int popularity1) {
		this.popularity1 = popularity1;
	}
	public int getWin2IndexRank() {
		return win2IndexRank;
	}
	public void setWin2IndexRank(int win2IndexRank) {
		this.win2IndexRank = win2IndexRank;
	}
	public int getPopularity2() {
		return popularity2;
	}
	public void setPopularity2(int popularity2) {
		this.popularity2 = popularity2;
	}
	public double getStdDeviation() {
		return stdDeviation;
	}
	public void setStdDeviation(double stdDeviation) {
		this.stdDeviation = stdDeviation;
	}

	public void setRowData(SqlRow row) {
		openDate = row.getString("open_date");
		ageName = row.getString("age_name");
		rankName = row.getString("rank_name");
		handiCapName = row.getString("handi_name");
		population = row.getInteger("population");
		raceDistance = row.getString("race_distance");
		courseName = row.getString("course_name");
		weatherName = row.getString("weather_name");
		conditionName = row.getString("condition_name");
		grade = row.getString("grade");
		raceId = row.getInteger("tr_race_id");
		win1IndexRank = row.getInteger("win_1_index_rank");
		popularity1 = row.getInteger("popularity_1");
		win2IndexRank = row.getInteger("win_2_index_rank");
		popularity2 = row.getInteger("popularity_2");
		stdDeviation = row.getDouble("standard_deviation");
	}
}
