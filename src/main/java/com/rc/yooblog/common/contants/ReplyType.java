package com.rc.yooblog.common.contants;

/**
 * 作者：flandre on 2019/4/6 12:26
 * 描述：回复类型
 */
public interface ReplyType {
    /** 留言 */
    Integer TO_TALK = 0;
    /** 文章评论 */
    Integer TO_ARTICLE = 1;
    /** 评论回复 */
    Integer TO_USER = 2;
}
