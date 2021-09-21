package com.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 这里是购物车的模型
 *
 * @author ycc
 */
public class Cart {

    /**
     * key是商品编号
     * value是商品信息
     */
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Cart() {
    }

    /**
     * 增加商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem) {
        //先查找商品的id
        CartItem item = items.get(cartItem.getId());
        if (item == null) {
            //如果不存在那么就添加到购物车中
            items.put(cartItem.getId(), cartItem);
        } else {
            //如果存在就然让总数加添加数量
            item.setCount(item.getCount() + cartItem.getCount());
        }
    }

    /**
     * 删除商品
     */
    public void delete(Integer id){
        //根据id直接【删除】购物车中的信息
        items.remove(id);
    }
    /**
     * 清空购物车
     */
    public void clear(){
        //将map中的数据删除
        items.clear();
    }

    /**
     * 修改商品数量
     * @param id
     * @param count
     */
    public void update(Integer id,int count){
        //根据id找到要修改数量的商品
        CartItem item = items.get(id);
        if (item != null) {
            //修改商品数量
            item.setCount(count);
            //修改商品总金额
            //item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }

    }


    /**
     * @return 购物车中商品的数量
     */
    public int getTotalCount() {
        //将总商品数量初始化为0
        int totalCount = 0;
        //将map中的数量添加到count中
        for (CartItem item : items.values()) {
            totalCount += item.getCount();
        }
        return totalCount;
    }

    /**
     * @return 购物车中的总金额
     */
    public BigDecimal getTotalPrice() {
        //将总商品金额初始化为0
        BigDecimal totalPrice = new BigDecimal(0);
        //算出map中商品的总价格
        for (CartItem item : items.values()) {
            //totalPrice.add()只是返回值并没有真的在totalPrice基础上增加，所以还需要totalPrice接受改变的数值
            totalPrice = totalPrice.add(item.getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;

    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
