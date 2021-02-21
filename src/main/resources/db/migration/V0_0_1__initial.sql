CREATE TABLE IF NOT EXISTS products
(
    id          INT(20) UNSIGNED AUTO_INCREMENT,
    name        CHAR                                           NOT NULL,
    price       DECIMAL                                        NOT NULL,
    currency    CHAR                                           NOT NULL,
    origin      CHAR                                           NOT NULL,
    PRIMARY KEY (id)
);