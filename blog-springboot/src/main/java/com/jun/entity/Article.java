package com.jun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * <p>
 * 文章
 * </p>
 *加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
 * 我们通过@Field注解来进行详细的指定，如果没有特殊需求，那么只需要添加@Document即可。
 * @author jun
 * @since 2020-06-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Article对象", description="文章")
@Document(indexName = "article",type = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_smart", analyzer = "ik_max_word")
    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章描述")
    private String description;

    @ApiModelProperty(value = "文章作者")
    private String author;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "阅读量")
    private Integer readNum;

    @ApiModelProperty(value = "评论量")
    private Integer commentNum;

    @ApiModelProperty(value = "点赞量")
    private Integer likeNum;

    @ApiModelProperty(value = "是否推荐文章")
    private Boolean recommend;

    @ApiModelProperty(value = "文章类型")
    private String typeId;

    @ApiModelProperty(value = "发布状态")
    private Integer publish;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;

    public Article(int id, String title) {
        this.id=id;
        this.title=title;
    }
}
