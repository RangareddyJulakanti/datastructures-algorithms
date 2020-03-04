package com.geeksforgeeks.algorithms.string.akhil;

import com.google.common.primitives.Bytes;

import java.util.ArrayList;
import java.util.List;

public class Data {
  private List<Byte> res=new ArrayList<>(0);
  private Integer lastPosition;
    Integer primayKeyPos;
    Integer secondaryKeyPos;

    public Data(List<Byte> res, Integer lastPosition) {
        this.res = res;
        this.lastPosition = lastPosition;
    }

    public List<Byte> getRes() {
        return res;
    }

    public void setRes(List<Byte> res) {
        this.res = res;
    }

    public Integer getLastPosition() {
        return lastPosition;
    }

    public void setLastPosition(Integer lastPosition) {
        this.lastPosition = lastPosition;
    }

    public Integer getPrimayKeyPos() {
        return primayKeyPos;
    }

    public void setPrimayKeyPos(Integer primayKeyPos) {
        this.primayKeyPos = primayKeyPos;
    }

    public Integer getSecondaryKeyPos() {
        return secondaryKeyPos;
    }

    public void setSecondaryKeyPos(Integer secondaryKeyPos) {
        this.secondaryKeyPos = secondaryKeyPos;
    }
}
