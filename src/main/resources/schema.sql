CREATE TABLE credit_card_details (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_name VARCHAR(20) NOT NULL,
    card_number VARCHAR(19) NOT NULL,
    balance_amount NUMERIC NOT NULL,
    limit_amount NUMERIC NOT NULL
);

ALTER TABLE CREDIT_CARD_DETAILS
ADD CONSTRAINT unique_card UNIQUE ( card_number );

