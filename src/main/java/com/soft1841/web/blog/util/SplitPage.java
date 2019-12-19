package com.soft1841.web.blog.util;

public class SplitPage {
    //分页请求时，请求标识参数
    final public static String FIRSTPAGE = "first";//第一页
    final public static String PREVIOUSPAGE = "previous";//上一页
    final public static String NEXTPAGE = "next";//下一页
    final public static String LASTPAGE = "last";//最后一页

    private int pageRows = 10;//每页显示的记录数，默认10条，可以在页面设置
    private int totalRows = 0;//总的记录数，这个参数由NoteDAO对象提供
    private int currentPage = 1;//当前显示的页面，默认第一页
    private int totalPages = 1;//总的页面数，默认就一页
    private int firstPage = 1;//首页位置，默认第一页

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        //如果pageRows被设置为0，应当抛出异常
        if (pageRows==0){
            throw new ArithmeticException();
        }
        this.pageRows = pageRows;
        //修改每页显示记录数，将会影响总页数，所以也要修改
        this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
        //计算总的页面数（或最后的页面号）
        this.totalPages=(this.totalRows%this.pageRows==0)?this.totalRows/this.pageRows:this.totalRows/this.pageRows+1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }


    //根据请求页面的标识参数，重新计算当前要显示的页面
    //核心方法，实现分页显示功能
    public int confirmPage(String flag){
        int newPage = this.currentPage;
        if (flag!=null){
            if (flag.equals(SplitPage.FIRSTPAGE)){
                newPage=1;
            }
            else if (flag.equals(SplitPage.PREVIOUSPAGE)){
                if (this.currentPage==this.firstPage){
                    newPage=this.currentPage;
                }else {
                    newPage=this.currentPage-1;
                }
            }
            else if (flag.equals(SplitPage.NEXTPAGE)){
                if (this.totalPages==this.currentPage){
                    newPage=this.currentPage;
                }else {
                    newPage=this.currentPage+1;
                }
            }
            else if (flag.equals(SplitPage.LASTPAGE)){
                newPage=this.totalPages;
            }
            else {
                //否则就是一个数字的字符串
                int tpage=Integer.parseInt(flag.trim());
                newPage=tpage;
            }
        }else {
            newPage=this.currentPage;
        }
        this.setCurrentPage(newPage);
        return newPage;
    }
}
