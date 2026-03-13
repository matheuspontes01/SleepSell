
create table tb_mattress (
                             id SERIAL PRIMARY KEY,
                             price float(53),
                             stock integer,
                             supplier_id integer,
                             name varchar(255),
                             primary key (id)
);

create table tb_order (
                          id SERIAL PRIMARY KEY,
                          order_status integer,
                          user_id integer,
                          date timestamp(6) with time zone,
                          primary key (id)
);

create table tb_orderitem (
                              mattress_id integer not null,
                              order_id integer not null,
                              price float(53),
                              quantity integer,
                              primary key (mattress_id, order_id)
);

create table tb_payment (
                            order_id integer not null,
                            payment_method integer,
                            moment timestamp(6) with time zone,
                            primary key (order_id)
);

create table tb_role (
                         id SERIAL PRIMARY KEY,
                         authority varchar(255) not null unique,
                         primary key (id)
);

create table tb_supplier (
                             id SERIAL PRIMARY KEY,
                             city varchar(255),
                             email varchar(255),
                             name varchar(255),
                             phone varchar(255),
                             uf varchar(255),
                             primary key (id)
);

create table tb_user (
                         id SERIAL PRIMARY KEY,
                         email varchar(255),
                         name varchar(255),
                         password varchar(255),
                         primary key (id)
);

create table tb_user_role (
                              role_id integer not null,
                              user_id integer not null,
                              primary key (role_id, user_id)
);

alter table  tb_mattress
    add constraint FKgkto3agegj7aj83gwmphf5cof
        foreign key (supplier_id)
            references tb_supplier;

alter table  tb_order
    add constraint FK2p4n9ciui39792tk5qdpcxq1w
        foreign key (user_id)
            references tb_user;

alter table  tb_orderitem
    add constraint FKrluepeml36ycmuld2arwojgv6
        foreign key (order_id)
            references tb_order;

alter table  tb_orderitem
    add constraint FK7co0ywwrnjr9qew5e07wb251b
        foreign key (mattress_id)
            references tb_mattress;

alter table  tb_payment
    add constraint FKokaf4il2cwit4h780c25dv04r
        foreign key (order_id)
            references tb_order;

alter table  tb_user_role
    add constraint FKea2ootw6b6bb0xt3ptl28bymv
        foreign key (role_id)
            references tb_role;

alter table  tb_user_role
    add constraint FK7vn3h53d0tqdimm8cp45gc0kl
        foreign key (user_id)
            references tb_user;