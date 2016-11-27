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
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.input;
import views.html.keibaweb;

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
}
