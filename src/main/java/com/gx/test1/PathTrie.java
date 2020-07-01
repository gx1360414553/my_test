//package com.gx.test1;
//
//import com.google.common.base.Splitter;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
///**
// * @author Arthur.Zhang (zhangya@imlizhi.com)
// * 用于匹配 /a/b/c, *, ** 这种格式的前缀匹配
// * 参考了 ZooKeeper 和 lucene 的 trie 实现
// */
//public class PathTrie {
//    private Node root = new Node(emptyList(), null);
//
//    public PathTrie() {
//    }
//
//    public void insert(String path, String obj) {
//        List<String> parts = getPathSegments(path);
//        insert(parts, obj);
//    }
//
//    public void insert(List<String> parts, String o) {
//        if (parts.isEmpty()) {
//            root.obj = o;
//            return;
//        }
//        root.insert(parts, o);
//    }
//
//    private static List<String> getPathSegments(String path) {
//        return Splitter.on('/').splitToList(path).stream().filter(it -> !it.isEmpty()).collect(Collectors.toList());
//    }
//
//    public boolean existsPath(String path) {
//        return root.exists(getPathSegments(path), 0);
//    }
//
//    public void dump() {
//        if (root != null) root.dump();
//    }
//
//    private static class Node {
//        String name;
//        Map<String, Node> children;
//        String obj; // 标识是否是叶子节点
//
//        Node(List<String> path, String obj) {
//            if (path.isEmpty()) {
//                this.obj = obj;
//                return;
//            }
//            name = path.get(0);
//        }
//
//        private synchronized void insert(List<String> parts, String o) {
//            String part = parts.get(0);
//            Node matchedChild;
//
//            // 如果是 **，后面的路径节点不用再插入了
//            if ("**".equals(name)) {
//                return;
//            }
//            if (children == null) children = new ConcurrentHashMap<>();
//
//            matchedChild = children.get(part);
//            if (matchedChild == null) {
//                matchedChild = new Node(parts, o);
//                children.put(part, matchedChild);
//            }
//
//            // 移除已处理的
//            parts.remove(0);
//            if (parts.isEmpty()) { // 如果已经到底，将最后一个 child 的 obj 赋值
//                matchedChild.obj = o;
//            } else {
//                matchedChild.insert(parts, o); //还没有到底，继续递归插入
//            }
//
//        }
//
//        /**
//         * @param pathSegments 路径分割以后的 word 列表，比如 /a/b/c -> 'a' , 'b' , 'c'
//         * @param level        当前路径遍历的 level 深度，比如 /a/b/c -> 0='a' 1='b' 2='c'
//         */
//        public boolean exists(List<String> pathSegments, int level) {
//            // 如果已经把传入的 path 遍历完了
//            if (pathSegments.size() < level + 1) {
//                // 如果当前 trie 树不是叶子节点
//                if (obj == null) {
//                    // 获取叶子节点是否包含 **，如果包含的话，则匹配到
//                    Node n = children.get("**");
//                    if (n != null) {
//                        return true;
//                    }
//                }
//                return obj != null;
//            }
//            if (children == null) {
//                return false;
//            }
//            String pathSegment = pathSegments.get(level);
//
//            // 1、首先找绝对匹配的
//            Node n = children.get(pathSegment);
//            // 2、如果不存在，则找是否包含 * 的
//            if (n == null) {
//                n = children.get("*");
//            }
//            // 3、如果还不存在，则找是否包含 ** 的
//            if (n == null) {
//                n = children.get("**");
//                if (n != null) {
//                    return true;
//                }
//            }
//            // 4、如果这些都没有找到，则返回 false
//            if (n == null) {
//                return false;
//            }
//            // 5、如果找到了一个 node，则继续递归查找
//            return n.exists(pathSegments, level + 1);
//        }
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "name='" + name + '\'' +
//                    ", children=" + children +
//                    '}';
//        }
//
//        /**
//         * 使用类似 tree 命令的输出格式打印这棵前缀数
//         * .
//         * └──api
//         * 	└──*
//         * 		└──login
//         * └──v2
//         * 	└──hello
//         * 	└──user
//         * 		└──feed
//         * 		└──feed2
//         * 		└──info
//         * └──wildcard
//         * 	    └──**
//         */
//        public void dump() {
//            dump(0);
//        }
//
//        public void dump(int level) {
//            if (level == 0) {
//                System.out.println(".");
//            } else {
//                StringBuilder sb = new StringBuilder();
//                for (int i = 0; i < level - 1; i++) {
//                    sb.append("\t");
//                }
//                sb.append("└──").append(name);
//                System.out.println(sb.toString());
//            }
//            if (children != null && !children.isEmpty()) {
//                for (Map.Entry<String, Node> item : children.entrySet()) {
//                    item.getValue().dump(level + 1);
//                }
//            }
//        }
//    }
//}
