/*
 * Sample seed data for testing application
 */

INSERT INTO shopping_list(list_name,owner,last_updated_by,last_updated_at)
VALUES('House renovation','husband','husband', CURRENT_TIMESTAMP );

INSERT INTO shopping_list(list_name,owner,last_updated_by,last_updated_at)
VALUES('Shopping list2','husband', 'husband',CURRENT_TIMESTAMP);

INSERT INTO shopping_list(list_name,owner,last_updated_by,last_updated_at)
VALUES ('Groceries','husband', 'wife',CURRENT_TIMESTAMP);

INSERT INTO shopping_list(list_name,owner,last_updated_by,last_updated_at)
VALUES ('Shopping list4','wife', 'wife',CURRENT_TIMESTAMP);

INSERT INTO shopping_list_item(item_name,quantity_description,shopping_list_id)
VALUES('Power drill','one',1);
INSERT INTO shopping_list_item(item_name,quantity_description,shopping_list_id)
VALUES('Fischer screws','10 packs',1);
INSERT INTO shopping_list_item(item_name,quantity_description,shopping_list_id)
VALUES('Masking tape','2 rolls',1);

INSERT INTO shopping_list_item(item_name,quantity_description,shopping_list_id)
VALUES('Vegetables','5 kg',3);
INSERT INTO shopping_list_item(item_name,quantity_description,shopping_list_id)
VALUES('Milk','2 lt',3);



INSERT INTO shopping_list_collaborator(username, shopping_list_id) VALUES('husband',1);
INSERT INTO shopping_list_collaborator(username, shopping_list_id) VALUES('husband',2);
INSERT INTO shopping_list_collaborator(username, shopping_list_id) VALUES('wife',2);
INSERT INTO shopping_list_collaborator(username, shopping_list_id) VALUES('husband',3);
INSERT INTO shopping_list_collaborator(username, shopping_list_id) VALUES('wife',3);
INSERT INTO shopping_list_collaborator(username, shopping_list_id) VALUES('wife',4);
