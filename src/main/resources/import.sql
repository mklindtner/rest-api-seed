Insert Into Role(role_name) VALUES ("admin");
Insert Into Role(role_name) VALUES ("user");
Insert Into User(user_name, user_pass) VALUES ("user", "test");
Insert Into User(user_name, user_pass) VALUES ("admin", "test");
Insert Into User(user_name, user_pass) VALUES ("user_admin", "test");
Insert Into user_roles(user_name, role_name) VALUES ("user", "user");
Insert Into user_roles(user_name, role_name) VALUES ("admin", "admin");
Insert Into user_roles(user_name, role_name) VALUES ("user_admin", "user");
Insert Into user_roles(user_name, role_name) VALUES ("user_admin", "admin");
Insert Into AnyObject(id, nameString) VALUES (1, 'anyObject1');
Insert Into AnyObject(id, nameString) VALUES (2, 'anyObject2');
Insert Into AnyObject(id, nameString) VALUES (3, 'anyObject3');