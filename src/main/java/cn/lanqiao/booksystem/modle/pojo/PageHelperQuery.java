package cn.lanqiao.booksystem.modle.pojo;

import lombok.Data;

@Data
public class PageHelperQuery {
    private String name;
    private Integer page;
    private Integer pageSize;
}
