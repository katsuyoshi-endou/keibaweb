# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table ms_course (
  course_kbn                    varchar(255) not null,
  course_name                   varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_ms_course primary key (course_kbn)
);

create table ms_distance (
  distance_kbn                  varchar(255) not null,
  distance_name                 varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_ms_distance primary key (distance_kbn)
);

create table tr_entry_horse_info (
  entry_horse_info_id           bigserial not null,
  race_id                       bigint,
  comp_index_1                  integer,
  horse_number_1                varchar(255),
  horse_name_1                  varchar(255),
  horse_weight_1                integer,
  last_time_index_1             integer,
  comp_index_2                  integer,
  horse_number_2                varchar(255),
  horse_name_2                  varchar(255),
  horse_weight_2                integer,
  last_time_index_2             integer,
  comp_index_3                  integer,
  horse_number_3                varchar(255),
  horse_name_3                  varchar(255),
  horse_weight_3                integer,
  last_time_index_3             integer,
  comp_index_4                  integer,
  horse_number_4                varchar(255),
  horse_name_4                  varchar(255),
  horse_weight_4                integer,
  last_time_index_4             integer,
  comp_index_5                  integer,
  horse_number_5                varchar(255),
  horse_name_5                  varchar(255),
  horse_weight_5                integer,
  last_time_index_5             integer,
  comp_index_6                  integer,
  horse_number_6                varchar(255),
  horse_name_6                  varchar(255),
  horse_weight_6                integer,
  last_time_index_6             integer,
  comp_index_7                  integer,
  horse_number_7                varchar(255),
  horse_name_7                  varchar(255),
  horse_weight_7                integer,
  last_time_index_7             integer,
  comp_index_8                  integer,
  horse_number_8                varchar(255),
  horse_name_8                  varchar(255),
  horse_weight_8                integer,
  last_time_index_8             integer,
  comp_index_9                  integer,
  horse_number_9                varchar(255),
  horse_name_9                  varchar(255),
  horse_weight_9                integer,
  last_time_index_9             integer,
  comp_index_10                 integer,
  horse_number_10               varchar(255),
  horse_name_10                 varchar(255),
  horse_weight_10               integer,
  last_time_index_10            integer,
  comp_index_11                 integer,
  horse_number_11               varchar(255),
  horse_name_11                 varchar(255),
  horse_weight_11               integer,
  last_time_index_11            integer,
  comp_index_12                 integer,
  horse_number_12               varchar(255),
  horse_name_12                 varchar(255),
  horse_weight_12               integer,
  last_time_index_12            integer,
  comp_index_13                 integer,
  horse_number_13               varchar(255),
  horse_name_13                 varchar(255),
  horse_weight_13               integer,
  last_time_index_13            integer,
  comp_index_14                 integer,
  horse_number_14               varchar(255),
  horse_name_14                 varchar(255),
  horse_weight_14               integer,
  last_time_index_14            integer,
  comp_index_15                 integer,
  horse_number_15               varchar(255),
  horse_name_15                 varchar(255),
  horse_weight_15               integer,
  last_time_index_15            integer,
  comp_index_16                 integer,
  horse_number_16               varchar(255),
  horse_name_16                 varchar(255),
  horse_weight_16               integer,
  last_time_index_16            integer,
  comp_index_17                 integer,
  horse_number_17               varchar(255),
  horse_name_17                 varchar(255),
  horse_weight_17               integer,
  last_time_index_17            integer,
  comp_index_18                 integer,
  horse_number_18               varchar(255),
  horse_name_18                 varchar(255),
  horse_weight_18               integer,
  last_time_index_18            integer,
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_entry_horse_info primary key (entry_horse_info_id)
);

create table ms_location (
  location_kbn                  varchar(255) not null,
  location_name                 varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_ms_location primary key (location_kbn)
);

create table tr_past_race_info (
  past_race_info_id             bigserial not null,
  regist_horse_info_id          bigint,
  race_id                       bigint,
  order_arrival                 integer,
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_past_race_info primary key (past_race_info_id)
);

create table tr_race (
  race_id                       bigserial not null,
  open_date                     timestamp,
  location_kbn                  varchar(255),
  race_number                   integer,
  rank_kbn                      varchar(255),
  course_kbn                    varchar(255),
  distance_kbn                  varchar(255),
  race_population               integer,
  race_result_flg               varchar(255),
  divident_reg_flg              varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_race primary key (race_id)
);

create table tr_race_caledar (
  calendar_id                   bigserial not null,
  open_date                     timestamp,
  location_kbn                  varchar(255),
  race_result_flg               varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_race_caledar primary key (calendar_id)
);

create table tr_race_divident (
  divident_id                   bigserial not null,
  race_id                       bigint,
  divident_kind                 varchar(255),
  horse_combination             varchar(255),
  payout                        integer,
  popularity                    integer,
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_race_divident primary key (divident_id)
);

create table tr_race_result (
  race_rasult_id                bigserial not null,
  race_id                       bigint,
  arriving_1_horse_number       varchar(255),
  comp_index_1                  integer,
  arriving_2_horse_number       varchar(255),
  comp_index_2                  integer,
  arriving_3_horse_number       varchar(255),
  comp_index_3                  integer,
  arriving_4_horse_number       varchar(255),
  comp_index_4                  integer,
  arriving_5_horse_number       varchar(255),
  comp_index_5                  integer,
  arriving_6_horse_number       varchar(255),
  comp_index_6                  integer,
  arriving_7_horse_number       varchar(255),
  comp_index_7                  integer,
  arriving_8_horse_number       varchar(255),
  comp_index_8                  integer,
  arriving_9_horse_number       varchar(255),
  comp_index_9                  integer,
  arriving_10_horse_number      varchar(255),
  comp_index_10                 integer,
  arriving_11_horse_number      varchar(255),
  comp_index_11                 integer,
  arriving_12_horse_number      varchar(255),
  comp_index_12                 integer,
  arriving_13_horse_number      varchar(255),
  comp_index_13                 integer,
  arriving_14_horse_number      varchar(255),
  comp_index_14                 integer,
  arriving_15_horse_number      varchar(255),
  comp_index_15                 integer,
  arriving_16_horse_number      varchar(255),
  comp_index_16                 integer,
  arriving_17_horse_number      varchar(255),
  comp_index_17                 integer,
  arriving_18_horse_number      varchar(255),
  comp_index_18                 integer,
  analyze_flg                   varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_race_result primary key (race_rasult_id)
);

create table ms_rank (
  rank_kbn                      varchar(255) not null,
  rank_name                     varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_ms_rank primary key (rank_kbn)
);

create table tr_regist_horse_info (
  regist_horse_info_id          bigserial not null,
  horse_name                    varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_regist_horse_info primary key (regist_horse_info_id)
);

create table tr_win_pattern (
  win_pattern_id                bigserial not null,
  race_id                       bigint,
  comp_index_1                  integer,
  comp_index_2                  integer,
  comp_index_3                  integer,
  comp_index_4                  integer,
  comp_index_5                  integer,
  standard_deviation            float,
  win_1_index_rank              integer,
  win_2_index_rank              integer,
  combination                   varchar(255),
  delete_date                   timestamp,
  create_date                   timestamp not null,
  update_date                   timestamp not null,
  constraint pk_tr_win_pattern primary key (win_pattern_id)
);


# --- !Downs

drop table if exists ms_course cascade;

drop table if exists ms_distance cascade;

drop table if exists tr_entry_horse_info cascade;

drop table if exists ms_location cascade;

drop table if exists tr_past_race_info cascade;

drop table if exists tr_race cascade;

drop table if exists tr_race_caledar cascade;

drop table if exists tr_race_divident cascade;

drop table if exists tr_race_result cascade;

drop table if exists ms_rank cascade;

drop table if exists tr_regist_horse_info cascade;

drop table if exists tr_win_pattern cascade;

