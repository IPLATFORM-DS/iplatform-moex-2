create table IF NOT EXISTS board
(
    id             integer PRIMARY KEY,
    engines        varchar(45),
    markets        varchar(45),
    session        varchar(36),
    board_group_id integer,
    boardid        varchar(12),
    is_traded      smallint,
    title          varchar(318));

GO