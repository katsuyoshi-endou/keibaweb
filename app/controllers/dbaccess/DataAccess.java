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
		sb.append("  a.race_no, ");
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
		sb.append("  f.distance_from, ");
		sb.append("  substr(h.course_name, 1, 1) as course_name ");
		sb.append("from tr_race as a ");
		sb.append("  left join ms_age as b on a.age_kbn = b.age_kbn ");
		sb.append("  left join ms_rank as d on a.rank_kbn = d.rank_kbn ");
		sb.append("  left join ms_handicap as e on a.handi_kbn = e.handi_kbn ");
		sb.append("  left join ms_distance as f on a.distance_kbn = f.distance_kbn ");
		sb.append("  left join ms_course as h on a.course_kbn = h.course_kbn ");
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
}
