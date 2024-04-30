--liquibase formatted sql

--changeset maxym:init_schema

create table if not exists mark_price
(
    id                     bigserial primary key,
    symbol                 varchar(32) not null,
    mark_price             numeric     not null,
    index_price            numeric     not null,
    estimated_settle_price numeric     not null,
    last_funding_rate      numeric     not null,
    next_funding_time      bigint      not null,
    interest_rate          numeric     not null,
    time                   bigint      not null,
    created_at             timestamp   not null
);