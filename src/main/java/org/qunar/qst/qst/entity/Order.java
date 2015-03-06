package org.qunar.qst.qst.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ronghaizheng on 15/2/13.
 */
@Entity
@Table(name = "mppb_order")
public class Order extends IdEntity implements Serializable {

    private static final long serialVersionUID = 9219462077138646679L;

    /**
     * 订单号
     */
    private String orderId;
    /**
     * OTA方订单号
     */
    private String otaOrderId;
    /**
     * 3w网站wrapperId,用来标识OTA
     */
    private String wrapperId;
    /**
     * 无线wrapperId，统计用
     */
    private String mWrapperId;
    /**
     * 付款方式
     */
    private int payType;
    /**
     * 酒店Id
     */
    private String hotelId;
    /**
     * 酒店序列号(3w定义 城市+酒店编号)
     */
    private String hotelSeq;
    /**
     * 房型Id
     */
    private String roomId;
    /**
     * plan id
     */
    private String planId;
    /**
     * OTA名称
     */
    private String otaName;
    /**
     * OTA方的酒店编号
     */
    private String otaHotelId;
    /**
     *
     */
    private String otaRoomId;
    /**
     * 房型名
     */
    private String roomName;
    /**
     * 登录用户名
     */
    private String userName;
    /**
     * 合作伙伴用户名
     */
    private String partnerUserName;
    /**
     * 床型 如：双人床
     */
    private String bedType;
    /**
     * 酒店名称
     */
    private String hotelName;
    /**
     * 酒店地址
     */
    private String hotelAddr;
    /**
     * 酒店电话
     */
    private String hotelPhone;
    /**
     * 离店时间
     */
    private Date checkOut;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 到达时间
     */
    private String arriveTime;
    private String contactName;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 联系人邮箱
     */
    private String email;
    /**
     * 订单金额
     */
    private double totalPrice;
    /**
     * 订单原价
     */
    private int protoPrice;
    /**
     * 房间数量
     */
    private int rooms;
    /**
     * 客户姓名
     */
    private String guestName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 酒店的备注
     */
    private String hotelRemark;
    /**
     * 入住日期
     */
    private Date checkIn;
    /**
     * 宽度上网
     */
    private String webfree;
    /**
     * 早餐信息
     */
    private String breakfast;
    /**
     * 下单状态（0-成功 1-失败）
     */
    private int status;
    /**
     * OTA方订单状态码，此状态码对于接口文档《无线酒店OTA-TTS接口需求》中 OTA订单状态码
     */
    private int otaOrderCode;
    /**
     * OTA方订单状态描述,为OTA放订单描述，此状态码对于接口文档《无线酒店OTA-TTS接口需求》中 OTA订单状态码描述，
     * 在数据库中的对应字段是ota_order_status
     */
    private String otaOrderStatus;
    /**
     * 订单状态,TTS自己的订单状态
     */
    private int orderStatus;

    /**
     * 订单类别 如：OTA_CPC、OTA_PPB、OTA_LAST
     */
    private String orderType;

    /**
     * 订单来源 如：3W的订单，无线订单
     */
    private String orderSource;
    /**
     * 用户客户端版本号
     */
    private String vid;
    /**
     * 客户端设备号
     */
    private String uid;
    /**
     * 产品号
     */
    private String pid;
    /**
     * 渠道号
     */
    private String cid;

    /**
     * 全局唯一标识
     */
    private String gid;

    /**
     * 客户端平台（如：wap平台、android平台、ios平台等）
     */
    private String platform;
    /**
     * 是否登录
     */
    private int ifLogin;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 优惠信息
     * @return
     */
    private String preference;
    /**
     * 酒店返现展示信息
     */
    private String priceOfferInfo;
    /**
     * 客户端选择的时间：Key
     */
    private String displayTime;
    /**
     * 间夜价格/展示价格
     */
    private double roomPrice;
    /**
     * 订单确认支付状态-0-及时确认（默认），1-非及时确认
     */
    private int confirmType;
    /**
     * 担保类型
     */
    private String guaraType;
    /**
     * 担保金额
     */
    private double guaraAmount;
    /**
     * 担保描述
     */
    private String guaraDesc;
    /**
     * 发票领取方式，取值 0:不支持发票  1：快递预付 2：联系客服  3：酒店前台获取 4：不需要发票 5：电子发票
     */
    private int invoiceGetType;

    /**
     * 参考订单总价
     */
    private double refTotalPrice;

    /**
     * 参考币种
     */
    private String refCurrencyCode;

    /**
     * 币种
     */
    private String currencyCode;

    /**
     * 预付类型
     */
    private int onlineType;

    /**
     * 房间入住信息
     */
    private String occupancyInfo;
    /**
     * 返现金额
     */
    private double cashBackPrice;
    /**
     * 小时房入住时长
     */
    private double hourroomDuration;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public double getRefTotalPrice() {
        return refTotalPrice;
    }

    public void setRefTotalPrice(double refTotalPrice) {
        this.refTotalPrice = refTotalPrice;
    }

    public String getRefCurrencyCode() {
        return refCurrencyCode;
    }

    public void setRefCurrencyCode(String refCurrencyCode) {
        this.refCurrencyCode = refCurrencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getGuaraType() {
        return guaraType;
    }

    public void setGuaraType(String guaraType) {
        this.guaraType = guaraType;
    }

    public double getGuaraAmount() {
        return guaraAmount;
    }

    public void setGuaraAmount(double guaraAmount) {
        this.guaraAmount = guaraAmount;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOtaOrderId() {
        return otaOrderId;
    }

    public void setOtaOrderId(String otaOrderId) {
        this.otaOrderId = otaOrderId;
    }

    public String getmWrapperId() {
        return mWrapperId;
    }

    public void setmWrapperId(String mWrapperId) {
        this.mWrapperId = mWrapperId;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public String getHotelSeq() {
        return hotelSeq;
    }

    public void setHotelSeq(String hotelSeq) {
        this.hotelSeq = hotelSeq;
    }

    public String getOtaHotelId() {
        return otaHotelId;
    }

    public void setOtaHotelId(String otaHotelId) {
        this.otaHotelId = otaHotelId;
    }

    public String getOtaRoomId() {
        return otaRoomId;
    }

    public void setOtaRoomId(String otaRoomId) {
        this.otaRoomId = otaRoomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelAddr() {
        return hotelAddr;
    }

    public void setHotelAddr(String hotelAddr) {
        this.hotelAddr = hotelAddr;
    }

    public String getHotelPhone() {
        return hotelPhone;
    }

    public void setHotelPhone(String hotelPhone) {
        this.hotelPhone = hotelPhone;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHotelRemark() {
        return hotelRemark;
    }

    public void setHotelRemark(String hotelRemark) {
        this.hotelRemark = hotelRemark;
    }

    public String getWebfree() {
        return webfree;
    }

    public void setWebfree(String webfree) {
        this.webfree = webfree;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * OTA方订单状态码，此状态码对于接口文档《无线酒店OTA-TTS接口需求》中 OTA订单状态码
     */
    public int getOtaOrderCode() {
        return otaOrderCode;
    }

    /**
     * OTA方订单状态码，此状态码对于接口文档《无线酒店OTA-TTS接口需求》中 OTA订单状态码
     */
    public void setOtaOrderCode(int otaOrderCode) {
        this.otaOrderCode = otaOrderCode;
    }

    /**
     * OTA方订单状态描述,为OTA放订单描述，此状态码对于接口文档《无线酒店OTA-TTS接口需求》中 OTA订单状态码描述，
     * 在数据库中的对应字段是ota_order_status
     */
    public String getOtaOrderStatus() {
        return otaOrderStatus;
    }

    /**
     * OTA方订单状态描述,为OTA放订单描述，此状态码对于接口文档《无线酒店OTA-TTS接口需求》中 OTA订单状态码描述，
     * 在数据库中的对应字段是ota_order_status
     */
    public void setOtaOrderStatus(String otaOrderStatus) {
        this.otaOrderStatus = otaOrderStatus;
    }

    /**
     * 订单状态,TTS自己的订单状态
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态,TTS自己的订单状态
     */
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getIfLogin() {
        return ifLogin;
    }

    public void setIfLogin(int ifLogin) {
        this.ifLogin = ifLogin;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getWrapperId() {
        return wrapperId;
    }

    public void setWrapperId(String wrapperId) {
        this.wrapperId = wrapperId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getProtoPrice() {
        return protoPrice;
    }

    public void setProtoPrice(int protoPrice) {
        this.protoPrice = protoPrice;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getOtaName() {
        return otaName;
    }

    public void setOtaName(String otaName) {
        this.otaName = otaName;
    }

    public String getPriceOfferInfo() {
        return priceOfferInfo;
    }

    public void setPriceOfferInfo(String priceOfferInfo) {
        this.priceOfferInfo = priceOfferInfo;
    }


    public String getPid() {
        return pid;
    }


    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getConfirmType() {
        return confirmType;
    }

    public void setConfirmType(int confirmType) {
        this.confirmType = confirmType;
    }

    public String getGuaraDesc() {
        return guaraDesc;
    }

    public void setGuaraDesc(String guaraDesc) {
        this.guaraDesc = guaraDesc;
    }

    public int getInvoiceGetType() {
        return invoiceGetType;
    }

    public void setInvoiceGetType(int invoiceGetType) {
        this.invoiceGetType = invoiceGetType;
    }


    public String getPartnerUserName() {
        return partnerUserName;
    }

    public void setPartnerUserName(String partnerUserName) {
        this.partnerUserName = partnerUserName;
    }

    public int getOnlineType() {
        return onlineType;
    }

    public void setOnlineType(int onlineType) {
        this.onlineType = onlineType;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getOccupancyInfo() {
        return occupancyInfo;
    }

    public void setOccupancyInfo(String occupancyInfo) {
        this.occupancyInfo = occupancyInfo;
    }

    public double getCashBackPrice() {
        return cashBackPrice;
    }

    public void setCashBackPrice(double cashBackPrice) {
        this.cashBackPrice = cashBackPrice;
    }

    public double getHourroomDuration() {
        return hourroomDuration;
    }

    public void setHourroomDuration(double hourroomDuration) {
        this.hourroomDuration = hourroomDuration;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", otaOrderId='" + otaOrderId + '\'' +
                ", wrapperID='" + wrapperId + '\'' +
                '}';
    }
}
