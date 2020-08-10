insert into APP_USER(username, password, first_name,last_name, role_id) values
("sanbornshane9", "abc123!", "Shane", "Sanborn", (select role_id from USER_ROLE where
    USER_ROLE.name = "PREMIUM_USER"));