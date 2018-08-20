package com.crowdfunding.vo;

import com.crowdfunding.pojo.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class PermissionVO extends Permission {

    List<PermissionVO> children = new ArrayList<>();
    private Integer seqno = 0;
    private boolean open = true;
    private boolean checked = false;
}
