create sequence hibernate_sequence start 1 increment 1;

    create table Security (
       id int8 not null,
        ask numeric(19, 2),
        bid numeric(19, 2),
        lastprice numeric(19, 2),
        name varchar(255) not null,
        ticker varchar(8),
        primary key (id)
    );

    alter table if exists Security 
       add constraint UK_9pe9jgiwgv70rmoade9emaita unique (ticker);
INSERT INTO security(id,ticker,name,bid,ask,lastprice)   VALUES (nextval('hibernate_sequence'),'AAPL','Apple (dev mode)',99,100,99.5);
INSERT INTO security(id,ticker,name,bid,ask,lastprice)     VALUES (nextval('hibernate_sequence'),'IBM','IBM (dev mode)',49,50,49.5);
INSERT INTO security(id,ticker,name,bid,ask,lastprice)     VALUES (nextval('hibernate_sequence'),'LSPD','Lightspeed (dev mode)',39,40,39.5);
