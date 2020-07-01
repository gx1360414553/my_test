package com.gx.cache;

public class CacheNode<K, V> {
    /**
     * 保存的键
     */
    private K key;

    /**
     * 保存的值
     */
    private V value;

    /**
     * 保存时间
     */
    private long gmtCreate;

    /**
     * 过期时间，单位为毫秒，默认永久有效
     */
    private long expireTime = Long.MAX_VALUE;
}
