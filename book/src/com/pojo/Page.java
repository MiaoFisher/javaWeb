package com.pojo;

import java.util.List;

//分页模型
public class Page<T> {
    //每页显示数据量
    public static final Integer PAGE_SIZE = 4;
    //当前页码
    public Integer pageNo;
    //总页码
    public Integer pageTotal;
    //当前页面显示数量
    public Integer pageSize;
    //总记录数
    public Integer pageTotalCount;
    //当前页面数据
    public List<T> items;
    //设置当前页面地址（用于分页）
    public String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        /**
         * 对页码进行校验，验证是否越界
         *
         */
        this.pageNo = pageNo;
        if (pageNo<1){
            this.pageNo = 1;
        }
        if (pageNo>pageTotal){
            this.pageNo = pageTotal;
        }

    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }
}
