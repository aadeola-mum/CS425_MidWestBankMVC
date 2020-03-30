INSERT IGNORE INTO account_types (account_type_id, account_type_name) VALUES
(1, "Checking"), /* id: 1 */
(2, "Loan"),
(3, "Savings");

INSERT IGNORE INTO customers (contact_phone_number, email_address, date_of_birth, last_name, first_name, middle_name, customer_number) VALUES
("641-646-7744", "asmith@gmail.net", "1978-05-21", "Smith", "Anna", "", "10001"), /* id: 1 */
("641-646-7844", "e.jones@earthlink.org", "1964-12-07", "Jones",  "Bob", "Earl",  "10002");


INSERT IGNORE INTO accounts (acc_num, balance, cust_id, acc_type) VALUES
(100001, 190590.34,1,3), (100002, 60000.00,1,2), (100003, 354005.26,2,1); 

