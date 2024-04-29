insert into public.faculties(title) values ('Faculty of Letters');
insert into public.faculties(title) values ('Faculty of Exact');
insert into public.faculties(title) values ('Economy and Environment Sciences');
insert into public.faculties(title) values ('Sciences of Education and Psychology');
insert into public.faculties(title) values ('Faculty of Law and Social Sciences');

insert into public.groups(group_title, year_of_study, faculty_id) values ('AW11M', 1, 1);
insert into public.groups(group_title, year_of_study, faculty_id) values ('AB11A', 1, 2);
insert into public.groups(group_title, year_of_study, faculty_id) values ('AW21M', 2, 3);
insert into public.groups(group_title, year_of_study, faculty_id) values ('AD31M', 3, 1);

insert into  public.students(first_name, last_name, date_of_birth, group_id, year_of_study, faculty_id, passport_id) values ('Artiom', 'Lupu', '2015-01-10', 1, 1, 1, 'A12432356');
insert into  public.students(first_name, last_name, date_of_birth, group_id, year_of_study, faculty_id, passport_id) values ('Ion', 'Puiu', '2016-02-11', 1, 1, 1, 'A12453454');
insert into  public.students(first_name, last_name, date_of_birth, group_id, year_of_study, faculty_id, passport_id) values ('Radu', 'Dumb', '2014-02-11', 2, 2, 3, 'A98987986');
insert into  public.students(first_name, last_name, date_of_birth, group_id, year_of_study, faculty_id, passport_id) values ('Natalia', 'Balan', '2013-12-01', 2, 2, 3, 'A98987986');
insert into  public.students(first_name, last_name, date_of_birth, group_id, year_of_study, faculty_id, passport_id) values ('Vadim', 'Georgita', '2012-08-15', 3, 3, 4, 'A992929986');
