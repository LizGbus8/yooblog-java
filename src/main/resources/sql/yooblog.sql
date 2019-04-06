DROP TABLE article;
CREATE TABLE article(
    a_id INT NOT NULL AUTO_INCREMENT  COMMENT '编号' ,
    title VARCHAR(128)    COMMENT '标题' ,
    tab INT    COMMENT '标签' ,
    image_url VARCHAR(32)    COMMENT '展示图' ,
    content TEXT    COMMENT '内容' ,
    read_count INT    COMMENT '阅读数' ,
    star_count INT    COMMENT '推荐数' ,
    share_count INT    COMMENT '分享数' ,
    public INT    COMMENT '公开 0隐私 1公开' ,
    author VARCHAR(32)    COMMENT '创建人' ,
    created_time TIMESTAMP default current_timestamp COMMENT '创建时间' ,
    updated_time TIMESTAMP  default current_timestamp COMMENT '更新时间' ,
    PRIMARY KEY (a_id)
) COMMENT = '文章 ';

ALTER TABLE article COMMENT '文章';
DROP TABLE tab;
CREATE TABLE tab(
    t_id INT NOT NULL AUTO_INCREMENT  COMMENT '编号' ,
    description VARCHAR(32) COMMENT '说明',
    cat_id VARCHAR(32)  COMMENT '所属分类' ,
    created_time TIMESTAMP default current_timestamp COMMENT '创建时间' ,
    updated_time TIMESTAMP  default current_timestamp COMMENT '更新时间' ,
    PRIMARY KEY (t_id)
) COMMENT = '标签 文章标签';

ALTER TABLE tab COMMENT '标签';
DROP TABLE comments_info;
CREATE TABLE comments_info(
    c_id VARCHAR(32) NOT NULL   COMMENT '编号' ,
    type INT    COMMENT '类型 0to留言 1to文章评论 2to人' ,
    owner_id VARCHAR(32)    COMMENT '被评论者编号' ,
    from_id VARCHAR(32)    COMMENT '评论者编号' ,
    from_name VARCHAR(32)    COMMENT '评论者昵称' ,
    from_avatar VARCHAR(512)    COMMENT '评论者头像' ,
    email VARCHAR(128)    COMMENT '评论者邮箱' ,
    website VARCHAR(512)    COMMENT '评论者网址' ,
    content TEXT    COMMENT '评论内容' ,
    floor INT   DEFAULT 0 COMMENT '楼层' ,
    ip VARCHAR(32)    COMMENT 'ip号来源' ,
    address VARCHAR(32)    COMMENT 'ip号所属地' ,
    valid INT   DEFAULT 1 COMMENT '是否有效 0删除' ,
    created_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (c_id)
) COMMENT = '评论主表 评论&留言';

ALTER TABLE comments_info COMMENT '评论主表';
DROP TABLE comments_reply;
CREATE TABLE comments_reply(
    r_id VARCHAR(32) NOT NULL   COMMENT '回复编号' ,
    coments_id VARCHAR(32)    COMMENT '评论编号' ,
    from_id VARCHAR(32)    COMMENT '回复者编号' ,
    from_name VARCHAR(32)    COMMENT '回复者昵称' ,
    from_email VARCHAR(128)    COMMENT '回复者邮箱' ,
    from_website VARCHAR(512)    COMMENT '回复者网址' ,
    to_name VARCHAR(32)    COMMENT '被评论者昵称' ,
    content TEXT    COMMENT '回复内容' ,
    ip VARCHAR(32)    COMMENT 'ip来源' ,
    address VARCHAR(32)    COMMENT '地址' ,
    valid INT   DEFAULT 1 COMMENT '是否有效 0为删除' ,
    created_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (r_id)
) COMMENT = '评论回复表 ';

ALTER TABLE comments_reply COMMENT '评论回复表';
DROP TABLE record;
CREATE TABLE record(
    rec_id INT NOT NULL AUTO_INCREMENT  COMMENT '归档编号' ,
    summary VARCHAR(512)    COMMENT '简说' ,
    link VARCHAR(512)    COMMENT '引用链接' ,
    link_desc VARCHAR(128)    COMMENT '引用说明' ,
    valid INT   DEFAULT 1 COMMENT '是否有效 0删除' ,
    created_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (rec_id)
) COMMENT = '归档 ';

ALTER TABLE record COMMENT '归档';
DROP TABLE category;
CREATE TABLE category(
    cat_id INT NOT NULL AUTO_INCREMENT  COMMENT '分类id' ,
    description VARCHAR(32)    COMMENT '分类描述' ,
    valid INT   DEFAULT 1 COMMENT '是否有效 0删除' ,
    created_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (cat_id)
) COMMENT = '分类 ';

ALTER TABLE category COMMENT '分类';
