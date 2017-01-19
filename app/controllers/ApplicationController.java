package controllers;

import java.net.URLDecoder;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;
import controllers.dbaccess.DataAccess;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.keibaweb;
import views.html.calendar;
import views.html.raceinfo;
import views.html.raceresult;
import views.html.horseinfo;

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
			String param = URLDecoder.decode(value);

			result = DataAccess.getHorseInfo(param);
		}
		return ok(horseinfo.render(result));
	}
}
