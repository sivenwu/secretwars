package com.siven.datastruct.utils;

import com.siven.datastruct.models.Node;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 **/
public class NodeTool {
    public static Node<Object> getNode(Object obj) {
        Node node = new Node<>();
        node.setValue(obj);
        return node;
    }
}
