package website.okunoda.secondtokill.pojo;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author okunoda
 * @since 2023-07-18
 */
@TableName("t_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 收获地址ID
     */
    private Long deliveryAddrId;

    /**
     * 商品名字
     */
    private String goodsName;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 1 pc,2 android, 3 ios
     */
    private Integer orderChannel;

    /**
     * 订单状态，0新建未支付，1已支付，2已发货，3已收货，4已退货，5已完成
     */
    private Integer status;

    /**
     * 订单创建时间
     */
    private Date createDate;

    /**
     * 支付时间
     */
    private Date payDate;

    public Long getId() {
        return id;
    }

    public Order setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Order setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public Order setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
        return this;
    }

    public Long getDeliveryAddrId() {
        return deliveryAddrId;
    }

    public Order setDeliveryAddrId(Long deliveryAddrId) {
        this.deliveryAddrId = deliveryAddrId;
        return this;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public Order setGoodsName(String goodsName) {
        this.goodsName = goodsName;
        return this;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public Order setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
        return this;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public Order setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
        return this;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }

    public Order setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public Order setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Order setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Date getPayDate() {
        return payDate;
    }

    public Order setPayDate(Date payDate) {
        this.payDate = payDate;
        return this;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", deliveryAddrId=" + deliveryAddrId +
                ", goodsName=" + goodsName +
                ", goodsCount=" + goodsCount +
                ", goodsPrice=" + goodsPrice +
                ", orderChannel=" + orderChannel +
                ", status=" + status +
                ", createDate=" + createDate +
                ", payDate=" + payDate +
                "}";
    }
}
