package com.bytedance.week4.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName("advertisement")
public class Advertisement {
    @TableId(type = IdType.AUTO)
    private Long advId;
    @NotNull(message = "广告名不能为空")
    private String title;
    @NotNull(message = "广告内容不能为空")
    private String content;
    @NotNull(message = "广告类型不能为空")
    private String category;
    private String imageUrl;
    @NotNull(message = "推送位置不能为空")
    private String pushPosition;
    @NotNull(message = "推送方不能为空")
    private String pushParty;
    @NotNull(message = "到期日不能为空")
    private Date expireDate;
    private Integer clickQuantity;
    private Integer pushQuantity;
    private Float pushWeight;

    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPushPosition() {
        return pushPosition;
    }

    public void setPushPosition(String pushPosition) {
        this.pushPosition = pushPosition;
    }

    public String getPushParty() {
        return pushParty;
    }

    public void setPushParty(String pushParty) {
        this.pushParty = pushParty;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getClickQuantity() {
        return clickQuantity;
    }

    public void setClickQuantity(Integer clickQuantity) {
        this.clickQuantity = clickQuantity;
    }

    public Integer getPushQuantity() {
        return pushQuantity;
    }

    public void setPushQuantity(Integer pushQuantity) {
        this.pushQuantity = pushQuantity;
    }

    public Float getPushWeight() {
        return pushWeight;
    }

    public void setPushWeight(Float pushWeight) {
        this.pushWeight = pushWeight;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "advId=" + advId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", pushPosition='" + pushPosition + '\'' +
                ", pushParty='" + pushParty + '\'' +
                ", expireDate=" + expireDate +
                ", clickQuantity=" + clickQuantity +
                ", pushQuantity=" + pushQuantity +
                ", pushWeight=" + pushWeight +
                '}';
    }
}
