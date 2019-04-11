package test.msg.model;

import java.util.List;

public class Pager<E> {
    /*
    每页显示多少条
     */
    private int pageSize;
    /*
    分页的开始值
     */
    private int pageOffset;
    /*
    总共多少条记录
     */
    private int totalRecords;
    /*
    总共多少页
     */
    private int totalPages;
    /*
    放置具体数据
     */
    private List<E> dates;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getDates() {
        return dates;
    }

    public void setDates(List<E> dates) {
        this.dates = dates;
    }
}
