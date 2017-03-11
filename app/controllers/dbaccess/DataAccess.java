package controllers.dbaccess;

import java.util.List;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlQuery;
import com.avaje.ebean.SqlRow;

import models.custom.SearchConditionModel;

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

	public static List<SqlRow> getRaceInformationByCondition(SearchConditionModel model) {
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
		sb.append("    when substr(a.race_type, 5,1) = '1' then '牝' ");
		sb.append("    else '' ");
		sb.append("  end as type_5, ");
		sb.append("  a.population, ");
		sb.append("  a.course_distance, ");
		sb.append("  substr(h.course_name,1,1) as course_name, ");
		sb.append("  j.weather_name, ");
		sb.append("  n.condition_name ");
		sb.append("from tr_race as a ");
		sb.append("  left join ms_age as b on a.age_kbn = b.age_kbn ");
		sb.append("  left join ms_rank as d on a.rank_kbn = d.rank_kbn ");
		sb.append("  left join ms_handicap as e on a.handi_kbn = e.handi_kbn ");
		sb.append("  left join ms_distance as f on a.distance_kbn = f.distance_kbn ");
		sb.append("  left join ms_course as h on a.course_kbn = h.course_kbn ");
		sb.append("  left join ms_location as i on a.location_kbn = i.location_kbn ");
		sb.append("  left join ms_weather as j on a.weather_kbn = j.weather_kbn ");
		sb.append("  left join ms_condition as n on a.condition_kbn = n.condition_kbn ");
		sb.append("where 1 = 1 ");
		sb.append("and (a.open_date >= to_date(:startDate, 'yyyy-mm-dd') and a.open_date <= to_date(:endDate, 'yyyy-mm-dd')) ");

		if(!"".equals(model.getLocationKbn())) {
			sb.append("and a.location_kbn in (" + model.getLocationKbn() + ") ");
		}

		if(!"".equals(model.getAgeKbn()) && !"99".equals(model.getAgeKbn())) {
			sb.append("and a.age_kbn = :ageKbn ");
		}

		if(!"".equals(model.getRankKbn()) && !"99".equals(model.getRankKbn())) {
			sb.append("and a.rank_kbn = :rankKbn ");
		}

		if(!"".equals(model.getHandiKbn()) && !"99".equals(model.getHandiKbn())) {
			sb.append("and a.handi_kbn = :handiKbn ");
		}

		if(!"".equals(model.getCourseKbn()) && !"99".equals(model.getCourseKbn())) {
			sb.append("and a.course_kbn = :courseKbn ");
		}

		if(!"".equals(model.getDistanceKbn()) && !"999".equals(model.getDistanceKbn())) {
			sb.append("and a.distance_kbn = :distanceKbn ");
		}

		if(!"".equals(model.getRaceType())) {
			sb.append("and substr(a.race_type, 5,1) = :raceType ");
		}

		if(!"".equals(model.getWeatherKbn()) && !"99".equals(model.getWeatherKbn())) {
			sb.append("and a.weather_kbn = :weatherKbn ");
		}

		if(!"".equals(model.getConditionKbn()) && !"99".equals(model.getConditionKbn())) {
			sb.append("and a.condition_kbn = :conditionKbn ");
		}

		sb.append("order by a.open_date asc, a.location_kbn, length(a.race_no), a.race_no asc ");

		String sql = sb.toString();

		SqlQuery query = Ebean.createSqlQuery(sql);

		query.setParameter("startDate", model.getOpenStartDate());
		query.setParameter("endDate", model.getOpenEndDate());
		query.setParameter("ageKbn", model.getAgeKbn());
		query.setParameter("rankKbn", model.getRankKbn());
		query.setParameter("handiKbn", model.getHandiKbn());
		query.setParameter("courseKbn", model.getCourseKbn());
		query.setParameter("distanceKbn", model.getDistanceKbn());
		query.setParameter("raceType", model.getRaceType());
		query.setParameter("weatherKbn", model.getWeatherKbn());
		query.setParameter("conditionKbn", model.getConditionKbn());

		return query.findList();
	}

	public static List<SqlRow> getWinPattern(int index1, int index2, int index3, int index4, int index5, double indexStart, double indexEnd) {
		StringBuilder sb = new StringBuilder();

		sb.append("select ");
		sb.append("  race.open_date, ");
		sb.append("  age.age_name, ");
		sb.append("  rank.rank_name, ");
		sb.append("  handi.handi_name, ");
		sb.append("  race.population, ");
		sb.append("  (distance.distance_from || '-' || distance.distance_to) as race_distance, ");
		sb.append("  course.course_name, ");
		sb.append("  weather.weather_name, ");
		sb.append("  condition.condition_name, ");
		sb.append("  case ");
		sb.append("    when race.race_grade = '1' then 'G1' ");
		sb.append("    when race.race_grade = '2' then 'G2' ");
		sb.append("    when race.race_grade = '3' then 'G3' ");
		sb.append("    else '' ");
		sb.append("  end as grade, ");
		sb.append("  n.tr_race_id, ");
		sb.append("  n.win_1_index_rank, ");
		sb.append("  n.popularity_1, ");
		sb.append("  n.win_2_index_rank, ");
		sb.append("  n.popularity_2, ");
		sb.append("  n.standard_deviation ");
		sb.append("from tr_race as race ");
		sb.append("  left join ms_age as age on race.age_kbn = age.age_kbn ");
		sb.append("  left join ms_rank as rank on race.rank_kbn = rank.rank_kbn ");
		sb.append("  left join ms_handicap as handi on race.handi_kbn = handi.handi_kbn ");
		sb.append("  left join ms_distance as distance on race.distance_kbn = distance.distance_kbn ");
		sb.append("  left join ms_course as course on race.course_kbn = course.course_kbn ");
		sb.append("  left join ms_weather as weather on race.weather_kbn = weather.weather_kbn ");
		sb.append("  left join ms_condition as condition on race.condition_kbn = condition.condition_kbn, ");
		sb.append("( ");
		sb.append("  select e.tr_race_id, e.win_1_index_rank, e.popularity as popularity_1, j.win_2_index_rank, j.popularity as popularity_2, e.standard_deviation from ");
		sb.append("  ( ");
		sb.append("    select b.tr_race_id, d.win_1_index_rank, d.standard_deviation, b.popularity ");
		sb.append("    from tr_race_result as b, ");
		sb.append("    ( ");
		sb.append("      select a.tr_race_id, a.standard_deviation, a.win_1_index_rank from tr_win_pattern as a ");
		sb.append("      where a.adjusted_comp_index_1 = :index1 ");
		sb.append("      and a.adjusted_comp_index_2 = :index2 ");
		sb.append("      and a.adjusted_comp_index_3 = :index3 ");

		if(index4 != 0) {
			sb.append("      and a.adjusted_comp_index_4 = :index4 ");
		}

		if(index5 != 0) {
			sb.append("      and a.adjusted_comp_index_5 = :index5 ");
		}

		sb.append("    ) as d ");
		sb.append("    where b.tr_race_id = d.tr_race_id ");
		sb.append("    and b.race_order = 1 ");
		sb.append("  ) as e, ");
		sb.append("  ( ");
		sb.append("    select f.tr_race_id, h.win_2_index_rank, h.standard_deviation, f.popularity ");
		sb.append("    from tr_race_result as f, ");
		sb.append("    ( ");
		sb.append("      select i.tr_race_id, i.standard_deviation, i.win_2_index_rank from tr_win_pattern as i ");
		sb.append("      where i.adjusted_comp_index_1 = :index1 ");
		sb.append("      and i.adjusted_comp_index_2 = :index2 ");
		sb.append("      and i.adjusted_comp_index_3 = :index3 ");

		if(index4 != 0) {
			sb.append("      and i.adjusted_comp_index_4 = :index4 ");
		}

		if(index5 != 0) {
			sb.append("      and i.adjusted_comp_index_5 = :index5 ");
		}

		sb.append("    ) as h ");
		sb.append("    where f.tr_race_id = h.tr_race_id ");
		sb.append("    and f.race_order = 2 ");
		sb.append("  ) as j ");
		sb.append("  where e.tr_race_id = j.tr_race_id ");
		sb.append("  order by e.tr_race_id ");
		sb.append(") as n ");
		sb.append("where race.id = n.tr_race_id ");
		sb.append("and (n.standard_deviation >= :index_start and n.standard_deviation <= :index_end) ");
		sb.append("order by win_1_index_rank asc, win_2_index_rank asc ");

		String sql = sb.toString();
		SqlQuery query = Ebean.createSqlQuery(sql);

		query.setParameter("index1", index1);
		query.setParameter("index2", index2);
		query.setParameter("index3", index3);
		query.setParameter("index4", index4);
		query.setParameter("index5", index5);
		query.setParameter("index_start", indexStart);
		query.setParameter("index_end", indexEnd);

		return query.findList();
	}
}
