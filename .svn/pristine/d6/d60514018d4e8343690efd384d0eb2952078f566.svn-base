package com.rw.finance.common.utils;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 排序帮助
 */
public class SortUtils {
    /**
     * 生成排序集合
     *
     * @param orderby
     * @return
     */
    public static List<Sort.Order> toSortOrder(String orderby) {
        List<Sort.Order> listOrder = new ArrayList();
        if (orderby != null && !orderby.isEmpty()) {
            // 排序集合
            String[] orders = orderby.split(",");
            for (String order : orders) {
                if (order.startsWith("!")) {
                    listOrder.add(new Sort.Order(Sort.Direction.DESC, order.substring(1)));
                } else {
                    listOrder.add(new Sort.Order(Sort.Direction.ASC, order));
                }
            }
        } else {
            listOrder.add(new Sort.Order(Sort.Direction.DESC, "createtime"));
        }

        return listOrder;
    }
}
