package controllers.dbaccess;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

public class DataAccess {
	public static List<SqlRow> getOpenYear(){
		StringBuilder sb = new StringBuilder();

		sb.append("select open_year from ");
		sb.append("( ");
		sb.append("  select to_char(open_date, 'yyyy') as open_year from tr_race ");
		sb.append(") as a ");
		sb.append("group by open_year ");
		sb.append("order by open_year desc ");

		String sql = sb.toString();

		return Ebean.createSqlQuery(sql).findList();
	}

	public static List<SqlRow> getOpenDateByYear(String year) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  x.open_date, ");
		sb.append("  x.open_fmt_date, ");
		sb.append("  x.location_kbn, ");
		sb.append("  x.location_name ");
		sb.append("from ");
		sb.append("( ");
		sb.append("  select ");
		sb.append("    to_char(a.open_date, 'yyyy') as open_year, ");
		sb.append("    to_char(a.open_date, 'yyyy-mm-dd') as open_date, ");
		sb.append("    to_char(a.open_date, 'FMyyyy年mm月dd日') as open_fmt_date, ");
		sb.append("    b.location_name, ");
		sb.append("    b.location_kbn ");
		sb.append("  from tr_race as a, ms_location as b ");
		sb.append("  where a.location_kbn = b.location_kbn ");
		sb.append("  group by a.open_date, b.location_name, b.location_kbn ");
		sb.append("  order by a.open_date desc, b.location_kbn ");
		sb.append(") as x ");
		sb.append("where x.open_year = :year");

		String sql = sb.toString();

		SqlQuery query = Ebean.createSqlQuery(sql);
		query.setParameter("year", year);

		return query.findList();
	}

	public static List<SqlRow> getRaceInfomation(String openDate, String kbn) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  a.id, ");
		sb.append("  to_char(a.open_date, 'yyyy年mm月dd日') as open_date, ");
		sb.append("  i.location_name, ");
		sb.append("  a.race_no, ");
		sb.append("  case ");
		sb.append("    when a.race_grade = '1' then 'G1' ");
		sb.append("    when a.race_grade = '2' then 'G2' ");
		sb.append("    when a.race_grade = '3' then 'G3' ");
		sb.append("    else '' ");
		sb.append("  end as race_grade, ");
		sb.append("  b.age_name, ");
		sb.append("  d.rank_name, ");
		sb.append("  a.race_name, ");
		sb.append("  e.handi_name, ");
		sb.append("  case ");
		sb.append("    when substr(a.race_type, 1,1) = '1' then '(指定)' ");
		sb.append("    else '' ");
		sb.append("  end as type_1, ");
		sb.append("  case ");
		sb.append("    when substr(a.race_type, 2,1) = '1' then '(特指)' ");
		sb.append("    else '' ");
		sb.append("  end as type_2, ");
		sb.append("  case ");
		sb.append("    when substr(a.race_type, 3,1) = '1' then '(混合)' ");
		sb.append("    else '' ");
		sb.append("  end as type_3, ");
		sb.append("  case ");
		sb.append("    when substr(a.race_type, 4,1) = '1' then '(国際)' ");
		sb.append("    else '' ");
		sb.append("  end as type_4, ");
		sb.append("  case ");
		sb.append("    when substr(a.race_type, 5,1) = '1' then '(牝)' ");
		sb.append("    else '' ");
		sb.append("  end as type_5, ");
		sb.append("  case ");
		sb.append("    when substr(a.race_type, 6,1) = '1' then '[指定]' ");
		sb.append("    else '' ");
		sb.append("  end as type_6, ");
		sb.append("  a.population, ");
		sb.append("  a.course_distance, ");
		sb.append("  substr(h.course_name, 1, 1) as course_name ");
		sb.append("from tr_race as a ");
		sb.append("  left join ms_age as b on a.age_kbn = b.age_kbn ");
		sb.append("  left join ms_rank as d on a.rank_kbn = d.rank_kbn ");
		sb.append("  left join ms_handicap as e on a.handi_kbn = e.handi_kbn ");
		sb.append("  left join ms_distance as f on a.distance_kbn = f.distance_kbn ");
		sb.append("  left join ms_course as h on a.course_kbn = h.course_kbn ");
		sb.append("  left join ms_location as i on a.location_kbn = i.location_kbn ");
		sb.append("where a.open_date = to_date(:openDate, 'yyyy-mm-dd') ");
		sb.append("and a.location_kbn = :locationKbn ");
		sb.append("order by length(a.race_no), a.race_no ");

		String sql = sb.toString();
		SqlQuery  query = Ebean.createSqlQuery(sql);

		query.setParameter("openDate", openDate);
		query.setParameter("locationKbn", kbn);

		return query.findList();
	}

	public static List<SqlRow> getRaceResultDetails(int raceId) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  to_char(a.open_date, 'yyyy年mm月dd日') as open_date, ");
		sb.append("  d.location_name, ");
		sb.append("  a.race_no, ");
		sb.append("  a.race_order, ");
		sb.append("  a.horse_number, ");
		sb.append("  a.race_border, ");
		sb.append("  a.horse_name, ");
		sb.append("  b.comp_index, ");
		sb.append("  b.index_order, ");
		sb.append("  a.age, ");
		sb.append("  case ");
		sb.append("    when a.sex = '1' then '牡' ");
		sb.append("    when a.sex = '2' then '牝' ");
		sb.append("    when a.sex = '3' then 'せ' ");
		sb.append("  end as horse_sex, ");
		sb.append("  a.basis_weight, ");
		sb.append("  a.jockey, ");
		sb.append("  a.race_time, ");
		sb.append("  a.incom, ");
		sb.append("  a.popularity, ");
		sb.append("  a.weight, ");
		sb.append("  a.preweight, ");
		sb.append("  a.stable ");
		sb.append("from  tr_race_entry as b ");
		sb.append("  left join tr_race_result as a on a.tr_race_id = b.tr_race_id and a.horse_number = b.horse_number, ");
		sb.append("  ms_location as d ");
		sb.append("where a.tr_race_id = :raceId ");
		sb.append("and a.location_kbn = d.location_kbn ");
		sb.append("order by a.race_order");

		String sql = sb.toString();

		return Ebean.createSqlQuery(sql).setParameter("raceId", raceId).findList();
	}

	public static List<SqlRow> getRaceDivident(int raceId) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  b.divident_name, ");
		sb.append("  a.win_number, ");
		sb.append("  to_char(a.payout, 'FM999,999,999') as payout, ");
		sb.append("  a.popularity ");
		sb.append("from tr_race_divident as a ");
		sb.append("  left join ms_divident as b on a.divident_kind = b.divident_kind ");
		sb.append("where tr_race_id = :raceId ");
		sb.append("order by a.divident_kind ");

		String sql = sb.toString();

		return Ebean.createSqlQuery(sql).setParameter("raceId", raceId).findList();
	}

	public static List<SqlRow> getRaceInfomationById(int id) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  to_char(a.open_date, 'yyyy年mm月dd日') as open_date, ");
		sb.append("  a.race_no, ");
		sb.append("  j.location_name, ");
		sb.append("  b.age_name, ");
		sb.append("  d.rank_name, ");
		sb.append("  a.race_name, ");
		sb.append("  e.handi_name, ");
		sb.append("  a.population, ");
		sb.append("  substr(f.course_name,1,1) as course_name, ");
		sb.append("  a.course_distance, ");
		sb.append("  h.weather_name, ");
		sb.append("  i.condition_name ");
		sb.append("from tr_race as a ");
		sb.append("  left join ms_age as b on a.age_kbn = b.age_kbn ");
		sb.append("  left join ms_rank as d on a.rank_kbn = d.rank_kbn ");
		sb.append("  left join ms_handicap as e on a.handi_kbn = e.handi_kbn ");
		sb.append("  left join ms_course as f on a.course_kbn = f.course_kbn ");
		sb.append("  left join ms_weather as h on a.weather_kbn = h.weather_kbn ");
		sb.append("  left join ms_condition as i on a.condition_kbn = i.condition_kbn ");
		sb.append("  left join ms_location as j on a.location_kbn = j.location_kbn ");
		sb.append("where a.id = :id");

		String sql = sb.toString();

		return Ebean.createSqlQuery(sql).setParameter("id", id).findList();
	}

	public static List<SqlRow> getHorseInfo(String name) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  a.tr_race_id, ");
		sb.append("  b.open_date, ");
		sb.append("  d.location_name, ");
		sb.append("  b.race_no, ");
		sb.append("  a.horse_name, ");
		sb.append("  (o.sex_name || a.age) as horse_sex_age, ");
		sb.append("  a.race_order, ");
		sb.append("  e.age_name, ");
		sb.append("  f.rank_name, ");
		sb.append("  b.race_name, ");
		sb.append("  h.handi_name, ");
		sb.append("  a.basis_weight, ");
		sb.append("  substr(i.course_name, 1, 1) as course_name, ");
		sb.append("  b.course_distance, ");
		sb.append("  j.weather_name, ");
		sb.append("  n.condition_name, ");
		sb.append("  a.stable ");
		sb.append("from tr_race_result as a, tr_race as b, ms_location as d, ms_age as e, ms_rank as f, ms_handicap as h, ms_course as i, ms_weather as j, ms_condition as n, ms_horse_sex as o ");
		sb.append("where a.tr_race_id = b.id ");
		sb.append("and a.horse_name = :name ");
		sb.append("and a.location_kbn = d.location_kbn ");
		sb.append("and b.age_kbn = e.age_kbn ");
		sb.append("and b.rank_kbn = f.rank_kbn ");
		sb.append("and b.handi_kbn = h.handi_kbn ");
		sb.append("and b.course_kbn = i.course_kbn ");
		sb.append("and b.weather_kbn = j.weather_kbn ");
		sb.append("and b.condition_kbn = n.condition_kbn ");
		sb.append("and a.sex = o.horse_sex_kbn ");
		sb.append("order by b.open_date desc");

		String sql = sb.toString();

		return Ebean.createSqlQuery(sql).setParameter("name",name).findList();
	}
}
