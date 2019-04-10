package test.msg.model;

public class SystemContext {
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer>();

    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<Integer>();

    private static ThreadLocal<Integer> PageOffset = new ThreadLocal<Integer>();

    public static void setPageSize(int _pageSize){
        pageSize.set(_pageSize);
    }

    public static int getPageSize(){
        return pageSize.get();
    }

    public static void removePageSize(){
        pageSize.remove();
    }

    public static void setPageIndex(int _pageSize){
        pageIndex.set(_pageSize);
    }

    public static int getPageIndex(){
        return pageIndex.get();
    }

    public static void removePageIndex(){
        pageIndex.remove();
    }

    public static void setPageOffset(int _pageOffset){
        PageOffset.set(_pageOffset);
    }

    public static int getPageOffset(){
        return PageOffset.get();
    }

    public static void removePageOffset(){
        PageOffset.remove();
    }
}
