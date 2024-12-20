CREATE SCHEMA orders;

CREATE TYPE orders.order_status AS ENUM ('PENDING', 'CONFIRMED', 'SHIPPED', 'DELIVERED', 'CANCELLED');

CREATE TABLE IF NOT EXISTS orders.orders (
    id          UUID PRIMARY KEY,
    customer_id UUID           NOT NULL,
    total       NUMERIC(10, 2) NOT NULL CHECK (total >= 0),
    status      orders.order_status   NOT NULL
);

CREATE TABLE IF NOT EXISTS orders.product_orders (
    id         UUID PRIMARY KEY,
    order_id   UUID           NOT NULL REFERENCES orders.orders (id) ON DELETE CASCADE,
    product_id UUID           NOT NULL,
    quantity   INTEGER        NOT NULL CHECK (quantity > 0),
    price      NUMERIC(10, 2) NOT NULL CHECK (price >= 0)
);