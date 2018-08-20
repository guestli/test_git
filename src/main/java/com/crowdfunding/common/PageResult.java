package com.crowdfunding.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> implements Serializable {

    @Getter @Setter
    private List<T> datas;
    @Getter @Setter
    private Integer pageSize;
    @Getter @Setter
    private Integer pageNo;
    @Getter @Setter
    private Integer resultNum;
    @Setter @Getter
    private String queryTest;
    private Integer startIndex;
    private Integer pageNum;

    public PageResult() {
    }

    public PageResult(Integer pageSize, Integer pageNo) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public PageResult(Integer pageSize, Integer pageNo, String queryTest) {
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.queryTest = queryTest;
    }

    public Integer getPageNum() {
        return this.resultNum%pageSize==0 ? this.resultNum/pageSize : this.resultNum/pageSize + 1;
    }

    public Integer getResultNum() {
        return resultNum;
    }

    public void setResultNum(Integer resultNum) {
        this.resultNum = resultNum;
    }

    public Integer getStartIndex() {
        return (this.pageNo - 1) * this.pageSize;
    }


}
