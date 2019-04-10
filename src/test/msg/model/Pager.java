package test.msg.model;

import java.util.List;

public class Pager<E> {
    /*
    第几页
     */
    private int pageIndex;
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
    private int totalRecord;
    /*
    总共多少页
     */
    private int totalPage;
    /*
    放置具体数据
     */
    private List<E> dates;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<E> getDates() {
        return dates;
    }

    public void setDates(List<E> dates) {
        this.dates = dates;
    }

    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }
}
