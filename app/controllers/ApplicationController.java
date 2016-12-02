package controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import models.Course;
import models.Distance;
import models.Location;
import models.Rank;
import models.custom.RaceForecastInfo;
import models.custom.RaceResultInfo;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.forecast;
import views.html.input;
import views.html.keibaweb;
import views.html.result;

public class ApplicationController extends Controller {
    public Result showKeibaweb() {
        String sql = "select to_char(a.open_date, 'YYYY/MM/DD') as open_date, b.location_name from tr_race_calendar as a, ms_location as b where a.location_kbn = b.location_kbn and (a.open_date >= current_timestamp and a.open_date <= (current_timestamp + interval '7 days')) order by a.open_date";

        List<SqlRow> information = Ebean.createSqlQuery(sql).findList();

        return ok(keibaweb.render(information));
    }

    public Result showInputPage() {
        List<Location> location = Location.find.findList();
        List<Rank> rank = Rank.find.findList();
        List<Course> course = Course.find.findList();
        List<Distance> distance = Distance.find.findList();

        return ok(input.render(location, rank, course, distance));
	}

    public Result getRaceCompIndex() {
        StringBuilder sb = new StringBuilder();

        sb.append("select b.race_id,a.horse_number_1, a.comp_index_1,a.horse_number_2, a.comp_index_2,a.horse_number_3, a.comp_index_3,a.horse_number_4, a.comp_index_4,a.horse_number_5, a.comp_index_5, ");
        sb.append("a.horse_number_6, a.comp_index_6,a.horse_number_7, a.comp_index_7,a.horse_number_8, a.comp_index_8,a.horse_number_9, a.comp_index_9,a.horse_number_10, a.comp_index_10, ");
        sb.append("a.horse_number_11, a.comp_index_11,a.horse_number_12, a.comp_index_12,a.horse_number_13, a.comp_index_13,a.horse_number_14, a.comp_index_14,a.horse_number_15, a.comp_index_15, ");
        sb.append("a.horse_number_16, a.comp_index_16,a.horse_number_17, a.comp_index_17,a.horse_number_18, a.comp_index_18 ");
        sb.append("from tr_entry_horse_info as a, tr_race as b ");
        sb.append("where b.open_date = to_date(:openDate,'YYYY-MM-DD') and b.location_kbn = :locationKbn and a.race_id = b.race_id order by b.race_number");

        String sql = sb.toString();

        SqlQuery query = Ebean.createSqlQuery(sql);
        query.setParameter("openDate", "2015-12-20");
        query.setParameter("locationKbn", "5");
        List<SqlRow> result = query.findList();

        List<RaceForecastInfo> items = new ArrayList<RaceForecastInfo>();
        for(int i = 0; i < result.size(); i++) {
            RaceForecastInfo rfi = new RaceForecastInfo();
            rfi.setRaceForecastInfo(result.get(i));

            items.add(rfi);
        }
        return ok(Json.toJson(items));
    }

    public Result showForecastPage() {
        return ok(forecast.render(null));
    }

    public Result getRaceResult() {
    	StringBuilder sb = new StringBuilder();

    	sb.append("select b.open_date, c.location_name, b.race_number, d.rank_name, e.course_name, f.distance_name, b.race_population, ");
    	sb.append("a.* ");
//    	sb.append("a.arriving_1_horse_number, a.comp_index_1,a.arriving_2_horse_number, a.comp_index_2,a.arriving_3_horse_number, a.comp_index_3,a.arriving_4_horse_number, a.comp_index_4, ");
//    	sb.append("a.arriving_5_horse_number, a.comp_index_5,a.arriving_6_horse_number, a.comp_index_6,a.arriving_7_horse_number, a.comp_index_7,a.arriving_8_horse_number, a.comp_index_8, ");
//    	sb.append("a.arriving_9_horse_number, a.comp_index_9,a.arriving_10_horse_number, a.comp_index_10,a.arriving_11_horse_number, a.comp_index_11,a.arriving_12_horse_number, a.comp_index_12, ");
//    	sb.append("a.arriving_13_horse_number, a.comp_index_13,a.arriving_14_horse_number, a.comp_index_14,a.arriving_15_horse_number, a.comp_index_15,a.arriving_16_horse_number, a.comp_index_16, ");
//    	sb.append("a.arriving_17_horse_number, a.comp_index_17,a.arriving_18_horse_number, a.comp_index_18 ");
    	sb.append("from tr_race_result as a, tr_race as b, ms_location as c, ms_rank as d, ms_course as e, ms_distance as f ");
    	sb.append("where a.race_id = b.race_id and b.location_kbn = c.location_kbn and b.rank_kbn = d.rank_kbn and b.course_kbn = e.course_kbn and b.distance_kbn = f.distance_kbn ");
    	sb.append("and open_date > '2015/7/19' ");
    	sb.append("order by b.open_date, b.location_kbn, b.race_number");

    	String sql = sb.toString();

    	List<SqlRow> results = Ebean.createSqlQuery(sql).findList();

    	List<RaceResultInfo> rri = new ArrayList<RaceResultInfo>();
    	for(SqlRow result : results) {
    		RaceResultInfo info = new RaceResultInfo();

    		info.setRaceRsultInfo(result);

    		rri.add(info);
    	}
    	return ok(Json.toJson(rri));
    }

    public Result showResultPage() {
    	return ok(result.render(null));
	}
}
