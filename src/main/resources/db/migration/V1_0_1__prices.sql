create table PRICES(
   ID                bigserial primary key,
   BRAND_ID          bigint           not null,
   PRODUCT_ID        bigint           not null,
   PRICE_LIST     bigint           not null,
   PRIORITY          bigint              not null default 0,
   PRICE             decimal(14, 2)   not null,
   CURR              varchar(3)   not null,
   START_DATE        datetime         not null,
   END_DATE          datetime         not null
);