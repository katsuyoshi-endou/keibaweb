package controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import controllers.dbaccess.DataAccess;
import models.custom.SearchConditionModel;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.keibaweb;
import views.html.calendar;
import views.html.raceinfo;
import views.html.raceresult;
import views.html.horseinfo;
import views.html.search;
import views.html.analyze;

public class ApplicationController extends Controller {
    public Result showKeibaweb() {
		StringBuilder sb = new StringBuilder();
		sb.append("select to_char(a.open_date, 'YYYY/MM/DD') as open_date, ");
		sb.append("b.location_name ");
		sb.append("from tr_race_calendar as a, ms_location as b ");
		sb.append("where a.location_kbn = b.location_kbn ");
		sb.append("and (a.open_date >= current_timestamp and a.open_date <= (current_timestamp + interval '7 days')) ");
		sb.append("order by a.open_date");

//    	String sql = "select to_char(a.open_date, 'YYYY/MM/DD') as open_date, b.location_name from tr_race_calendar as a, ms_location as b where a.location_kbn = b.location_kbn and (a.open_date >= current_timestamp and a.open_date <= (current_timestamp + interval '7 days')) order by a.open_date";
		String sql = sb.toString();

        List<SqlRow> information = Ebean.createSqlQuery(sql).findList();

        return ok(keibaweb.render(information));
    }

	public Result showRaceCalendar(String year) {
		if(year == null || "".equals(year)) {
			Calendar cal = Calendar.getInstance();

			year = String.valueOf(cal.get(Calendar.YEAR) - 1);
		}

		List<SqlRow> result = DataAccess.getOpenYear();
		List<SqlRow> opendates = DataAccess.getOpenDateByYear(year);

		return ok(calendar.render(result, opendates));
	}

	public Result postRaceCalendar() {
		String method = request().method();

		String year = "";
		Calendar cal = Calendar.getInstance();

		year = String.valueOf(cal.get(Calendar.YEAR) - 1);
		if("GET".equals(method)) {
		} else {
			Map<String, String[]> form = request().body().asFormUrlEncoded();

			year = form.get("year")[0];
		}
		List<SqlRow> result = DataAccess.getOpenYear();
		List<SqlRow> opendates = DataAccess.getOpenDateByYear(year);

		return ok(calendar.render(result, opendates));
	}

	public Result showRaceInformation(String openDate, String kbn) {
		List<SqlRow> result = DataAccess.getRaceInfomation(openDate, kbn);

		return ok(raceinfo.render(result));
	}

	public Result showRaceResult(String id) {
		List<SqlRow> result = DataAccess.getRaceResultDetails(Integer.valueOf(id));
		List<SqlRow> payout = DataAccess.getRaceDivident(Integer.valueOf(id));
		List<SqlRow> info = DataAccess.getRaceInfomationById(Integer.valueOf(id));

		return ok(raceresult.render(info, result, payout));
	}

	public Result showHorseInfo(String name) {
		String method = request().method();

		List<SqlRow> result = null;
		if("GET".equals(method)) {
			Map<String, String[]> req = request().queryString();

			String value = req.get("name")[0];
			String param = "";
			try {
				param = URLDecoder.decode(value, StandardCharsets.UTF_8.name());
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			result = DataAccess.getHorseInfo(param);
		}
		return ok(horseinfo.render(result));
	}

	public Result showSearch() {
		return ok(search.render(null));
	}

	public Result postSearch() {
		String method = request().method();

		List<SqlRow> result = null;
		if("POST".equals(method)) {
			Map<String, String[]> form = request().body().asFormUrlEncoded();

			SearchConditionModel scm = new SearchConditionModel();

			for(String key: form.keySet()){
				String value = form.get(key)[0];

				switch (key) {
				case "startdate" :
					scm.setOpenStartDate(value);
					break;
				case "enddate" :
					scm.setOpenEndDate(value);
					break;
				case "ageKbn" :
					scm.setAgeKbn(value);
					break;
				case "rankKbn" :
					scm.setRankKbn(value);
					break;
				case "handiKbn" :
					scm.setHandiKbn(value);
					break;
				case "couseKbn" :
					scm.setCourseKbn(value);
					break;
				case "distanceKbn" :
					scm.setDistanceKbn(value);
					break;
				case "weatherKbn" :
					scm.setWeatherKbn(value);
					break;
				case "conditionKbn" :
					scm.setConditionKbn(value);
					break;
				case "raceType" :
					scm.setRaceType("1");
					break;
				}
			}
			result = DataAccess.getRaceInformationByCondition(scm);
		}
		return ok(search.render(result));
	}

	public Result showAnalyze() {
		List<SqlRow> result = new ArrayList<SqlRow>();

		return ok(analyze.render(result, 0));
	}

	public Result postAnalyze() {
		String method = request().method();
		List<SqlRow> rows = new ArrayList<SqlRow>();

		if("POST".equals(method)) {
			Map<String, String[]> form = request().body().asFormUrlEncoded();

			rows = getAnalyzeRows(form);
		}
		return ok(analyze.render(rows, rows.size()));
	}

	public Result downloadCSV() {
		String csv = "";
		String filename = "analyze.txt";

		String method = request().method();
		List<SqlRow> rows = new ArrayList<SqlRow>();

		if("POST".equals(method)) {
			Map<String, String[]> form = request().body().asFormUrlEncoded();

			StringBuilder sb = new StringBuilder();

			sb.append("\"1着馬【指数】\",\"1着馬【人気】\",\"2着馬【指数】\",\"2着馬【人気】\",\"標準偏差\",\"馬齢\",\"ランク\",\"ハンデ\",\"頭数\",\"距離\",\"コース\",\"天候\",\"馬場状態\",\"グレード\"" + "\r\n");

			rows = getAnalyzeRows(form);
			for(SqlRow row : rows) {
				sb.append("\"" + row.getString("win_1_index_rank") + "\",");
				sb.append("\"" + row.getString("popularity_1") + "\",");
				sb.append("\"" + row.getString("win_2_index_rank") + "\",");
				sb.append("\"" + row.getString("popularity_2") + "\",");
				sb.append("\"" + row.getDouble("standard_deviation") + "\",");
				sb.append("\"" + row.getString("age_name") + "\",");
				sb.append("\"" + row.getString("rank_name") + "\",");
				sb.append("\"" + row.getString("handi_name") + "\",");
				sb.append("\"" + row.getString("population") + "\",");
				sb.append("\"" + row.getString("race_distance") + "\",");
				sb.append("\"" + row.getString("course_name") + "\",");
				sb.append("\"" + row.getString("weather_name") + "\",");
				sb.append("\"" + row.getString("condition_name") + "\",");
				sb.append("\"" + row.getString("grade") + "\"");
				sb.append("\r\n");
			}
			csv = sb.toString();
		}

		response().setHeader("Content-Disposition", "attachment; filename=" + filename);
		return ok(csv).as("text/csv charset=Shift_JIS");
	}

	public List<SqlRow> getAnalyzeRows(Map<String, String[]> form) {
		List<SqlRow> rows = new ArrayList<SqlRow>();

		if(form != null) {
			int index1 = 0;
			int index2 = 0;
			int index3 = 0;
			int index4 = 0;
			int index5 = 0;
			double index_start = 0.0;
			double index_end = 99.9;

			for(String key : form.keySet()) {
				String value = form.get(key)[0];

				switch(key) {
				case "index_1" :
					index1 = Integer.valueOf(value);
					break;
				case "index_2" :
					index2 = Integer.valueOf(value);
					break;
				case "index_3" :
					index3 = Integer.valueOf(value);
					break;
				case "index_4" :
					index4 = Integer.valueOf(value);
					break;
				case "index_5" :
					index5 = Integer.valueOf(value);
					break;
				case "index_start" :
					index_start = Double.valueOf(value);
					break;
				case "index_end" :
					index_end = Double.valueOf(value);
					break;
				}
			}
			rows = DataAccess.getWinPattern(index1, index2, index3, index4, index5, index_start, index_end);
		}
		return rows;
	}
}
